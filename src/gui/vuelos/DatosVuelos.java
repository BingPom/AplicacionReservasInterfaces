package gui.vuelos;

import java.awt.Color;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import gui.login.Login;
import model.Profile;

import javax.swing.event.ChangeEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.beans.PropertyChangeListener;
import java.security.PublicKey;
import java.beans.PropertyChangeEvent;

public class DatosVuelos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField JTextNumHabitaciones;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldHoraSalida;
	private JTextField textFieldHoraLlegada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosVuelos frame = new DatosVuelos("", "", false, 0);
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
	public DatosVuelos(String hora_salida, String hora_llegada, boolean vueloSelected, int destinoIndex) {
		setTitle("Operaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(234, 227, 89, 23);
		contentPane.add(btnAceptar);
		
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
					JTextNumHabitaciones.setText("");
					btnAceptar.setEnabled(false);
				} else {
					JTextNumHabitaciones.setEnabled(false);
					JTextNumHabitaciones.setText("");
					btnAceptar.setEnabled(true);
				}
			}
		});
		rdbtnHabitacionMultiple.setBounds(232, 89, 65, 23);
		contentPane.add(rdbtnHabitacionMultiple);
		
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
					btnAceptar.setEnabled(true);
				}
			}
		});
		chckbxReservarHabitacion.setBounds(197, 7, 126, 23);
		contentPane.add(chckbxReservarHabitacion);

		JTextNumHabitaciones = new JTextField();
		JTextNumHabitaciones.setEnabled(false);
		JTextNumHabitaciones.setToolTipText("Núm. habitaciones");
		JTextNumHabitaciones.setBounds(303, 90, 86, 20);
		contentPane.add(JTextNumHabitaciones);
		JTextNumHabitaciones.setColumns(10);
		JTextNumHabitaciones.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkNumHabitaciones(btnAceptar, rdbtnHabitacionMultiple, chckbxReservarHabitacion);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				checkNumHabitaciones(btnAceptar, rdbtnHabitacionMultiple, chckbxReservarHabitacion);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				checkNumHabitaciones(btnAceptar, rdbtnHabitacionMultiple, chckbxReservarHabitacion);
			}

			private void checkNumHabitaciones(JButton btnAceptar, JRadioButton rdbtnHabitacionMultiple,
					JCheckBox chckbxReservarHabitacion) {
				if (!rdbtnHabitacionMultiple.isSelected()) {
					btnAceptar.setEnabled(true);
				}else if (!chckbxReservarHabitacion.isEnabled()) {
					btnAceptar.setEnabled(true);
				} else if (checkIsValidCost() && chckbxReservarHabitacion.isEnabled()) {
					btnAceptar.setEnabled(true);
				} else {
					btnAceptar.setEnabled(false);
				}
			}

			private boolean checkIsValidCost() {
				try {
					Double.parseDouble(JTextNumHabitaciones.getText());
					JTextNumHabitaciones.setForeground(Color.BLACK);
					return true;
				} catch (NumberFormatException f) {
					JTextNumHabitaciones.setForeground(Color.RED);
				}
				return false;
			}
		});

		JComboBox comboBoxDestinoVuelo = new JComboBox();
		comboBoxDestinoVuelo.setEnabled(false);
		comboBoxDestinoVuelo.setModel(new DefaultComboBoxModel(resources.VuelosResources.getDestinos()));
		comboBoxDestinoVuelo.setBounds(64, 37, 73, 22);
		comboBoxDestinoVuelo.setSelectedIndex(destinoIndex);
		contentPane.add(comboBoxDestinoVuelo);

		JButton btnSeleccionarVuelo = new JButton("Seleccionar vuelo");
		btnSeleccionarVuelo.setEnabled(false);
		btnSeleccionarVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				Abrimos el PopUp
				try {
					TablaVuelos dialog = new TablaVuelos(comboBoxDestinoVuelo.getSelectedItem().toString());
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					setVisible(false);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnSeleccionarVuelo.setBounds(10, 227, 182, 23);

		JCheckBox chckbxReservaVuelo = new JCheckBox("Reservar Vuelo");
		chckbxReservaVuelo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (chckbxReservaVuelo.isSelected()) {
					comboBoxDestinoVuelo.setEnabled(true);
					btnSeleccionarVuelo.setEnabled(true);
				} else {
					comboBoxDestinoVuelo.setEnabled(false);
					btnSeleccionarVuelo.setEnabled(false);
				}
			}
		});
		chckbxReservaVuelo.setBounds(6, 7, 99, 23);
		chckbxReservaVuelo.setSelected(vueloSelected);
		contentPane.add(chckbxReservaVuelo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Login login_frame = new Login();
					login_frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
				dispose();
			}
		});
		btnCancelar.setBounds(335, 227, 89, 23);
		contentPane.add(btnCancelar);

		JButton btnAddVuelo = new JButton("Añadir Vuelo");
		btnAddVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AddVuelo frame = new AddVuelo();
					frame.setVisible(true);
				} catch (Exception f) {
					f.printStackTrace();
				}
			}
		});
		btnAddVuelo.setBounds(6, 193, 186, 23);
		contentPane.add(btnAddVuelo);
//		Check if the user is an admin
		if (!(Login.user.getProfile() == Profile.ADMIN)) {
			btnAddVuelo.setVisible(false);
		}

		JLabel lblHoraLlegada = new JLabel("Hora Llegada: ");
		lblHoraLlegada.setBounds(31, 137, 89, 14);
		contentPane.add(lblHoraLlegada);

		JLabel lblHoraSalida = new JLabel("Hora Salida: ");
		lblHoraSalida.setBounds(31, 93, 89, 14);

		comboBoxDestinoVuelo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				textFieldHoraSalida.setText("");
				textFieldHoraLlegada.setText("");
			}
		});
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(getOwner(), getMessage(), "Resumen reserva", JOptionPane.INFORMATION_MESSAGE);
			}

			private String getMessage() {
				String message = "Has reservado ";
//				If destination is checked
				if (chckbxReservaVuelo.isSelected()) {
//					Check if a time has been selected
					if (!textFieldHoraSalida.getText().toString().equals("")) {
						message += "un vuelo desde " + comboBoxDestinoVuelo.getSelectedItem().toString() + " a las " + textFieldHoraSalida.getText();
						if (!chckbxReservarHabitacion.isSelected()) {
							return message += ".";
						}
//					If ReservaHabitacion is not checked
					} else if (!chckbxReservarHabitacion.isSelected()) {
						return "Nada ha sido reservado.";
					}
				}
//				If ReservaHabitacion is checked
				if (chckbxReservarHabitacion.isSelected()) {
//					If no radio button is checked
					if (!(rdbtnHabitacionIndividual.isSelected() || 
							rdbtnHabitacionDoble.isSelected() || 
							rdbtnHabitacionMultiple.isSelected())) {
//						If there is a destination
						if (chckbxReservaVuelo.isSelected()) {
//							Message except " y "
							return message;
						} else {
							return "Nada ha sido reservado.";
						}
					}
//					Both are checked
					if (chckbxReservaVuelo.isSelected() && chckbxReservarHabitacion.isSelected()) {
						message += " y una habitación ";
					}
					if (rdbtnHabitacionIndividual.isSelected()) {
						message += "individual.";
					} else if (rdbtnHabitacionDoble.isSelected()) {
						message += "doble.";
					} else if (rdbtnHabitacionMultiple.isSelected()) {
						message += "para " + JTextNumHabitaciones.getText() + " personas.";
					}
				}
//				If no checkbox is checked
				if (!(chckbxReservaVuelo.isSelected() || chckbxReservarHabitacion.isSelected())) {
					return "Nada ha sido reservado.";
				}
				return message;
			}
			
			
		});

		textFieldHoraSalida = new JTextField();
		textFieldHoraSalida.setText(hora_salida != null ? hora_salida : "");
		textFieldHoraSalida.setEditable(false);
		textFieldHoraSalida.setColumns(10);
		textFieldHoraSalida.setBounds(130, 90, 42, 20);
		textFieldHoraLlegada = new JTextField();
		textFieldHoraLlegada.setText(hora_llegada != null ? hora_llegada : "");
		textFieldHoraLlegada.setEditable(false);
		textFieldHoraLlegada.setColumns(10);
		textFieldHoraLlegada.setBounds(130, 134, 42, 20);
		
		contentPane.add(textFieldHoraLlegada);
		contentPane.add(btnSeleccionarVuelo);
		contentPane.add(lblHoraSalida);
		contentPane.add(textFieldHoraSalida);
	}
}