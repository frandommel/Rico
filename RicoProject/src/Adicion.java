import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Closeable;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;
import javax.swing.border.CompoundBorder;

public class Adicion extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adicion frame = new Adicion();
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
	public Adicion() {
		setUndecorated(true);
		setBounds(100, 100, 826, 514);
		this.setLocationRelativeTo(null);
		//this.setExtendedState(state);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		JButton button_1 = new JButton("1");
		button_1.setBounds(46, 148, 70, 71);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Uno uno = new Uno();
				uno.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setBounds(128, 148, 70, 71);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setBounds(210, 148, 70, 71);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.setBounds(296, 148, 70, 71);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setBounds(378, 148, 70, 71);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setBounds(460, 148, 70, 71);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.setBounds(542, 148, 70, 71);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setBounds(624, 148, 70, 71);
		contentPane.add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setBounds(706, 148, 70, 71);
		contentPane.add(button_9);
		
		JLabel lblNewLabel = new JLabel("Adicion");
		lblNewLabel.setBounds(353, 13, 95, 71);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(46, 429, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp =new MenuPrincipal();
				mp.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton);
	}
}
