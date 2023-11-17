package gui.vuelos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.Vuelo;
import gui.login.Login;
import resources.VuelosResources;
import resources.messages.Messages;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;

public class TablaVuelos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDestino;
	private JTable tableVuelos;
	private int selectedRow = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TablaVuelos dialog = new TablaVuelos("");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TablaVuelos(String destinoVuelo) {
		setTitle(Messages.getMessage(Login.user.getLanguage(), "Vuelos Disponibles"));
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(Messages.getMessage(Login.user.getLanguage(), "Selecciona un vuelo desde: "));
		lblNewLabel.setBounds(49, 11, 218, 14);
		contentPanel.add(lblNewLabel);
		
		textFieldDestino = new JTextField();
		textFieldDestino.setText(destinoVuelo);
		textFieldDestino.setEditable(false);
		textFieldDestino.setBounds(285, 8, 86, 20);
		contentPanel.add(textFieldDestino);
		textFieldDestino.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 68, 357, 105);
		contentPanel.add(scrollPane);
		
		tableVuelos = new JTable();
		tableVuelos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					if (tableVuelos.getSelectedRow() == selectedRow) {
//						if (tableVuelos.getSelectedRow()) {
//							
//						}
						tableVuelos.getSelectionModel().clearSelection();
					} else {
						selectedRow = tableVuelos.getSelectedRow();
					}
				}
				if (e.getClickCount() == 2) {
					sendVueloInfo();
				}
			}
		});
		tableVuelos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableVuelos.setModel(new DefaultTableModel(
			resources.VuelosResources.toObjectMatrix(),
			Vuelo.getFields(Login.user.getLanguage())
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		TableRowSorter<TableModel> filtro = new TableRowSorter<TableModel>(tableVuelos.getModel());
		tableVuelos.setRowSorter(filtro);
		filtro.setRowFilter(RowFilter.regexFilter(destinoVuelo, 0));
		
		scrollPane.setViewportView(tableVuelos);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(Messages.getMessage(Login.user.getLanguage(), "Aceptar"));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sendVueloInfo();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			{
				JButton cancelButton = new JButton(Messages.getMessage(Login.user.getLanguage(), "Cancelar"));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
	private void sendVueloInfo() {
		if (tableVuelos.getSelectedRow() >= 0) {
			String hora_salida = tableVuelos.getValueAt(tableVuelos.getSelectedRow(), 1).toString(); //Hora de salida
			String hora_llegada = tableVuelos.getValueAt(tableVuelos.getSelectedRow(), 2).toString(); //Hora de llegada
			try {
				DatosVuelos frame = new DatosVuelos(hora_salida, hora_llegada, true, 
						getIndexDestino(tableVuelos.getValueAt(tableVuelos.getSelectedRow(), 0).toString()));
				frame.setVisible(true);
			} catch (Exception f) {
				f.printStackTrace();
			}
			dispose();
		}
	}
	
	private int getIndexDestino(String destino){
		Object[] destinos = VuelosResources.getDestinos();
		ArrayList<String> destinos_array = new ArrayList<String>();
		for (int i = 0; i < destinos.length; i++) {
			destinos_array.add(destinos[i].toString());
		}
		return destinos_array.indexOf(destino);
	}
}