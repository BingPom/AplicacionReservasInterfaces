package gui.vuelos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblDestino = new JLabel("Destiny: ");
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
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(310, 222, 114, 23);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(310, 183, 114, 23);
		
		JComboBox comboBoxSalidaHora = new JComboBox();
		comboBoxSalidaHora.setBounds(135, 89, 46, 20);
		comboBoxSalidaHora.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		
		JLabel lbl2Puntos_1 = new JLabel(" :");
		lbl2Puntos_1.setBounds(181, 89, 16, 17);
		lbl2Puntos_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBoxSalidaMinutos = new JComboBox();
		comboBoxSalidaMinutos.setBounds(197, 89, 46, 20);
		comboBoxSalidaMinutos.setModel(new DefaultComboBoxModel(new String[] {"15", "30", "45", "00"}));
		
		JComboBox comboBoxLlegadaHora = new JComboBox();
		comboBoxLlegadaHora.setModel(new DefaultComboBoxModel(new String[] {"werwe"}));
		comboBoxLlegadaHora.setBounds(135, 135, 46, 20);
		
		JLabel lbl2Puntos_2 = new JLabel(" :");
		lbl2Puntos_2.setBounds(181, 135, 16, 17);
		lbl2Puntos_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox comboBoxLlegadaMinutos = new JComboBox();
		comboBoxLlegadaMinutos.setModel(new DefaultComboBoxModel(new String[] {"fsd"}));
		comboBoxLlegadaMinutos.setBounds(197, 135, 46, 20);
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
		
		JComboBox comboBoxTarifa = new JComboBox();
		comboBoxTarifa.setModel(new DefaultComboBoxModel(new String[] {"Turista", "Business"}));
		comboBoxTarifa.setBounds(135, 179, 108, 22);
		contentPane.add(comboBoxTarifa);
		
		textFieldCoste = new JTextField();
		textFieldCoste.setBounds(135, 223, 93, 20);
		contentPane.add(textFieldCoste);
		textFieldCoste.setColumns(10);
		
		JLabel lblSimboloEuro = new JLabel("€");
		lblSimboloEuro.setBounds(231, 226, 16, 14);
		contentPane.add(lblSimboloEuro);
	}
}
