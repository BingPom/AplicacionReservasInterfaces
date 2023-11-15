package gui.vuelos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DatosVuelos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField JTextNumHabitaciones;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosVuelos frame = new DatosVuelos();
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
	public DatosVuelos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextNumHabitaciones = new JTextField();
		JTextNumHabitaciones.setEnabled(false);
		JTextNumHabitaciones.setToolTipText("Núm. habitaciones");
		JTextNumHabitaciones.setBounds(303, 90, 86, 20);
		contentPane.add(JTextNumHabitaciones);
		JTextNumHabitaciones.setColumns(10);
		
		JComboBox comboBoxDestinoVuelo = new JComboBox();
		comboBoxDestinoVuelo.setEnabled(false);
		comboBoxDestinoVuelo.setModel(new DefaultComboBoxModel(resources.VuelosResources.getDestinos()));
		comboBoxDestinoVuelo.setBounds(64, 37, 73, 22);
		contentPane.add(comboBoxDestinoVuelo);
		
		JRadioButton rdbtnHabitacionIndividual = new JRadioButton("Individual");
		rdbtnHabitacionIndividual.setEnabled(false);
		buttonGroup.add(rdbtnHabitacionIndividual);
		rdbtnHabitacionIndividual.setBounds(232, 37, 78, 23);
		contentPane.add(rdbtnHabitacionIndividual);
		
		JRadioButton rdbtnHabitacionDoble = new JRadioButton("Doble");
		rdbtnHabitacionDoble.setEnabled(false);
		buttonGroup.add(rdbtnHabitacionDoble);
		rdbtnHabitacionDoble.setBounds(232, 63, 65, 23);
		contentPane.add(rdbtnHabitacionDoble);
		
		JRadioButton rdbtnHabitacionMultiple = new JRadioButton("Múltiple");
		rdbtnHabitacionMultiple.setEnabled(false);
		buttonGroup.add(rdbtnHabitacionMultiple);
		rdbtnHabitacionMultiple.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (rdbtnHabitacionMultiple.isSelected()) {
					JTextNumHabitaciones.setEnabled(true);
				} else {
					JTextNumHabitaciones.setEnabled(false);
				}
			}
		});
		rdbtnHabitacionMultiple.setBounds(232, 89, 65, 23);
		contentPane.add(rdbtnHabitacionMultiple);

		JCheckBox chckbxReservaVuelo = new JCheckBox("Reservar Vuelo");
		chckbxReservaVuelo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (chckbxReservaVuelo.isSelected()) {
					comboBoxDestinoVuelo.setEnabled(true);
				} else {
					comboBoxDestinoVuelo.setEnabled(false);
				}
			}
		});
		chckbxReservaVuelo.setBounds(6, 7, 99, 23);
		contentPane.add(chckbxReservaVuelo);
		
		JCheckBox chckbxReservarHabitacion = new JCheckBox("Reservar habitación");
		chckbxReservarHabitacion.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (chckbxReservarHabitacion.isSelected()) {
					rdbtnHabitacionIndividual.setEnabled(true);
					rdbtnHabitacionDoble.setEnabled(true);
					rdbtnHabitacionMultiple.setEnabled(true);
				} else {
					rdbtnHabitacionIndividual.setEnabled(false);
					rdbtnHabitacionDoble.setEnabled(false);
					rdbtnHabitacionMultiple.setEnabled(false);
				}
			}
		});
		chckbxReservarHabitacion.setBounds(197, 7, 126, 23);
		contentPane.add(chckbxReservarHabitacion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(234, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnSeleccionarVuelo = new JButton("Seleccionar vuelo");
		btnSeleccionarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Abrimos el PopUp
				try {
					TablaVuelos dialog = new TablaVuelos(comboBoxDestinoVuelo.getSelectedItem().toString());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnSeleccionarVuelo.setBounds(10, 227, 126, 23);
		contentPane.add(btnSeleccionarVuelo);
	}
}