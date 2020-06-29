package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class FrameCerrarVenta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton tarjeta,efectivo,cancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCerrarVenta frame = new FrameCerrarVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public FrameCerrarVenta() {
		initComponents();
	}
	
	public void initComponents() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ingreso Producto");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(241,98,63));
		
		efectivo = new JButton();
		efectivo.setBounds(90, 121, 244, 67);
		getContentPane().add(efectivo);
		efectivo.setIcon(new ImageIcon(FrameCerrarVenta.class.getResource("/InterfazGrafica/efectivo.png")));
		efectivo.addActionListener(this);
		
		tarjeta = new JButton();
		tarjeta.setBounds(90, 41, 244, 67);
		tarjeta.addActionListener(this);
		tarjeta.setIcon(new ImageIcon(FrameCerrarVenta.class.getResource("/InterfazGrafica/tarjeta.png")));
		getContentPane().add(tarjeta);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(316, 221, 116, 31);
		getContentPane().add(cancelar);
		cancelar.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelar) {
			this.setVisible(false);
		}
		
	}

}
