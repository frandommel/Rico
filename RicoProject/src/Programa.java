import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;
import java.awt.Component;

public class Programa extends JFrame {

	private JPanel inicioPass;
	private JTextField inicioUser;
	private JPasswordField passwordField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Programa frame = new Programa();
					frame.setVisible(true);
					//frame.setLocation(700,400);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Programa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 330);
		//this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		inicioPass = new JPanel();
		inicioPass.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(inicioPass);
		inicioPass.setLayout(null);
		
				
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.setBackground(SystemColor.inactiveCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) ///Accion que realiza el boton ingresar
			{
				String user="juan";
				String pass="1234";
				String usuario = inicioUser.getText();
				String password=passwordField.getText();
				if(usuario.equals(user)&&password.equals(pass)) {
					MenuPrincipal mp = new MenuPrincipal();
					mp.setVisible(true);
					dispose();
				}
				
			}
		});
		btnNewButton.setBounds(170, 174, 109, 25);
		inicioPass.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(102, 78, 56, 16);
		inicioPass.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(74, 122, 84, 25);
		inicioPass.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bienvenido!");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(170, 13, 116, 25);
		inicioPass.add(lblNewLabel_2);
		
		inicioUser = new JTextField();
		inicioUser.setHorizontalAlignment(SwingConstants.CENTER);
		inicioUser.setBounds(170, 75, 116, 25);
		inicioPass.add(inicioUser);
		inicioUser.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(170, 123, 116, 24);
		inicioPass.add(passwordField);
		
		
	}
}
