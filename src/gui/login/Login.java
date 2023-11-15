package gui.login;

import java.awt.EventQueue;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import gui.vuelos.DatosVuelos;
import utils.DataVerification;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordFieldPassword;
	private JFormattedTextField formattedTextFieldUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login login_frame = new Login();
					login_frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setMinimumSize(new Dimension(400, 250));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("########U");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		formattedTextFieldUsername = new JFormattedTextField(mask);
		formattedTextFieldUsername.setFocusLostBehavior(JFormattedTextField.COMMIT);
		formattedTextFieldUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				formattedTextFieldUsername.setText(formattedTextFieldUsername.getText().trim());
			}
		});
		formattedTextFieldUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				formattedTextFieldUsername.setText(formattedTextFieldUsername.getText().trim());
			}
		});
		
		
		
		JLabel lblUsername = new JLabel("Username: ");
		
		JLabel lblPassword = new JLabel("Password: ");
		
		passwordFieldPassword = new JPasswordField();
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addContainerListener(new ContainerAdapter() {
			@Override
			public void componentRemoved(ContainerEvent e) {
				setVisible(true);
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (utils.DataVerification.verifyUser(formattedTextFieldUsername.getText().toString(), new String(passwordFieldPassword.getPassword()))) {
//					Comprobamos si debemos mostrar el perfil de administrador o el usuario standard
					if (DataVerification.isAdmin(formattedTextFieldUsername.getText().toString())) {
//						Perfil de admin
						
					} else {
//						Perfil standard
						try {
							setVisible(false);
							DatosVuelos frame = new DatosVuelos();
							frame.setVisible(true);
						} catch (Exception f) {
							f.printStackTrace();
						}
					}
				} else
				JOptionPane.showMessageDialog(getOwner(), "No valido", "Error de credenciales", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordFieldPassword, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
						.addComponent(formattedTextFieldUsername, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
					.addGap(75))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(259, Short.MAX_VALUE)
					.addComponent(btnAceptar)
					.addGap(18)
					.addComponent(btnCancelar)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(formattedTextFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
