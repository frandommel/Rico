import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(306, 30, 160, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Adicion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Adicion adicion = new Adicion();
				adicion.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(211, 86, 291, 25);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Caja");
		button.setBounds(211, 124, 291, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Clientes");
		button_1.setBounds(211, 162, 291, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Personal");
		button_2.setBounds(211, 200, 291, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Informes");
		button_3.setBounds(211, 238, 291, 25);
		contentPane.add(button_3);
	}
}
