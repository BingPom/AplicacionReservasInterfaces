package gui.vuelos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;

public class TablaVuelos extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldDestino;
	private JTable tableVuelos;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona un vuelo desde: ");
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
		
		resources.VuelosResources.toObjectMatrix();
		
		tableVuelos = new JTable();
//		tableVuelos.setRowSorter(RowFilter.regexFilter("A", 1));
		tableVuelos.setModel(new DefaultTableModel(
			resources.VuelosResources.toObjectMatrix(),
			new String[] {
				"Destino", "Hora salida", "Hora llegada", "Tarifa", "Eur"
			}
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
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}