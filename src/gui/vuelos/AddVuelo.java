package gui.vuelos;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import model.Tarifa;
import model.Vuelo;

import java.awt.Component;

import resources.VuelosResources;

public class AddVuelo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblHoraSalida;
	private JLabel lblHoraLlegada;
	private JLabel lblTarifa;
	private JLabel lblCoste;
	private JTextField textFieldCoste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddVuelo frame = new AddVuelo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddVuelo() {
		setResizable(false);
		setTitle("Añadir Vuelo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblDestino = new JLabel("Destination: ");
		lblDestino.setBounds(59, 40, 72, 14);
		
		lblHoraSalida = new JLabel("Departure: ");
		lblHoraSalida.setBounds(59, 89, 72, 14);
		
		lblHoraLlegada = new JLabel("Arrival: ");
		lblHoraLlegada.setBounds(59, 138, 73, 14);
		
		lblTarifa = new JLabel("Class: ");
		lblTarifa.setBounds(58, 183, 57, 14);
		
		lblCoste = new JLabel("Cost: ");
		lblCoste.setBounds(58, 226, 48, 14);		
		
		JComboBox comboBoxDestino = new JComboBox();
		comboBoxDestino.setModel(new DefaultComboBoxModel(resources.VuelosResources.getDestinos()));
		comboBoxDestino.setBounds(135, 36, 108, 22);
		
		JComboBox comboBoxSalidaHora = new JComboBox();
		comboBoxSalidaHora.setBounds(135, 89, 46, 20);
		comboBoxSalidaHora.setModel(new DefaultComboBoxModel(utils.TimeLists.getHours()));
		
		JLabel lbl2Puntos_1 = new JLabel(" :");
		lbl2Puntos_1.setBounds(181, 89, 16, 17);
		lbl2Puntos_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBoxSalidaMinutos = new JComboBox();
		comboBoxSalidaMinutos.setBounds(197, 89, 46, 20);
		comboBoxSalidaMinutos.setModel(new DefaultComboBoxModel(utils.TimeLists.getMinutes()));
		
		JComboBox comboBoxLlegadaHora = new JComboBox();
		comboBoxLlegadaHora.setModel(new DefaultComboBoxModel(utils.TimeLists.getHours()));
		comboBoxLlegadaHora.setBounds(135, 135, 46, 20);
		
		JComboBox comboBoxLlegadaMinutos = new JComboBox();
		comboBoxLlegadaMinutos.setModel(new DefaultComboBoxModel(utils.TimeLists.getMinutes()));
		comboBoxLlegadaMinutos.setBounds(197, 135, 46, 20);
		
		JLabel lbl2Puntos_2 = new JLabel(" :");
		lbl2Puntos_2.setBounds(181, 135, 16, 17);
		lbl2Puntos_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBoxTarifa = new JComboBox();
		comboBoxTarifa.setModel(new DefaultComboBoxModel(new String[] {"Turista", "Business"}));
		comboBoxTarifa.setBounds(135, 179, 108, 22);
		contentPane.add(comboBoxTarifa);
		
		
		
		JLabel lblSimboloEuro = new JLabel("€");
		lblSimboloEuro.setBounds(231, 226, 16, 14);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VuelosResources.addVuelo(new Vuelo(comboBoxDestino.getSelectedItem().toString(), 
													toTime(comboBoxSalidaHora, comboBoxSalidaMinutos), 
													toTime(comboBoxLlegadaHora, comboBoxLlegadaMinutos), 
													toTarifa(comboBoxTarifa.getSelectedItem().toString()),
													Double.parseDouble(textFieldCoste.getText())));
//				Close window
				try {
					DatosVuelos dialog = new DatosVuelos(null, null, false, 0);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
				dispose();
			}
			
			private String toTime(JComboBox hora, JComboBox minuto) {
				return hora.getSelectedItem().toString() + ":" + minuto.getSelectedItem().toString();
			}
			
			private Tarifa toTarifa(String tarifa) {
				switch(tarifa) {
				case "Turista":
					return Tarifa.TURISTA;
				case "Business":
					return Tarifa.BUSINESS;
				default:
					return Tarifa.TURISTA;
				}
			}
		});
		btnAdd.setBounds(310, 183, 114, 23);
		
		textFieldCoste = new JTextField();
		textFieldCoste.setBounds(135, 223, 93, 20);
		contentPane.add(textFieldCoste);
		textFieldCoste.setColumns(10);
		textFieldCoste.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				if (checkIsValidCost()) {
					btnAdd.setEnabled(true);
				} else {
					btnAdd.setEnabled(false);
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (checkIsValidCost()) {
					btnAdd.setEnabled(true);
				} else {
					btnAdd.setEnabled(false);
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				if (checkIsValidCost()) {
					btnAdd.setEnabled(true);
				} else {
					btnAdd.setEnabled(false);
				}
			}

			private boolean checkIsValidCost() {
				try {
					Double.parseDouble(textFieldCoste.getText());
					textFieldCoste.setForeground(Color.BLACK);
					return true;
				} catch (NumberFormatException f) {
					textFieldCoste.setForeground(Color.RED);
				}
				return false;
			}
		});
		
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatosVuelos dialog = new DatosVuelos(null, null, false, 0);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
				dispose();
			}
		});
		btnClose.setBounds(310, 222, 114, 23);
		
		contentPane.setLayout(null);
		contentPane.add(lblDestino);
		contentPane.add(lblHoraSalida);
		contentPane.add(lblHoraLlegada);
		contentPane.add(lblCoste);
		contentPane.add(lblTarifa);
		contentPane.add(comboBoxDestino);
		contentPane.add(comboBoxLlegadaHora);
		contentPane.add(lbl2Puntos_2);
		contentPane.add(comboBoxLlegadaMinutos);
		contentPane.add(comboBoxSalidaHora);
		contentPane.add(lbl2Puntos_1);
		contentPane.add(comboBoxSalidaMinutos);
		contentPane.add(btnAdd);
		contentPane.add(btnClose);
		contentPane.add(lblSimboloEuro);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblDestino, comboBoxDestino, lblHoraSalida, comboBoxSalidaHora, lbl2Puntos_1, comboBoxSalidaMinutos, lblHoraLlegada, comboBoxLlegadaHora, lbl2Puntos_2, comboBoxLlegadaMinutos, lblTarifa, comboBoxTarifa, lblCoste, textFieldCoste, lblSimboloEuro, btnAdd, btnClose}));
	}
	
	
}
