package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import GestionComercio.Comercio;

import java.awt.GridLayout;
import java.awt.FlowLayout;

public class Cliente extends JFrame {

	private JPanel contentPane, panelAlta;
	private JButton alta,baja, modificacion;
	private JLabel label1,label,label2,label3,label4;
	private JTextField textField,textField2,textField3,textField4;
	private JButton button,button2;
	private Comercio rico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente frame = new Cliente();
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
	public Cliente(Comercio comercio) {
		rico = comercio;
		initComponents();
	}
	
	public void initComponents() {
		cerrar();
		setBounds(0, 0, 698, 409);
		setTitle("Cliente");
		this.setResizable(false);
		this.setLocationRelativeTo(null);//la ventana se abre en el medio
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(924, 40, 689, 378);
		getContentPane().setLayout(null);
		agregarPaneles();
		setIconImage(new ImageIcon(getClass().getResource("descarga.jpg")).getImage());	
	}
	
	public void agregarPaneles() {
		panelAlta = new AltaCliente(rico);
		panelAlta.setSize(692, 378);
		panelAlta.setLocation(0, 0);
		panelAlta.setVisible(true);
		getContentPane().add(panelAlta);
		
	}
	
	//Cerramos la aplicacion con la cruz
	public void cerrar() 
	{
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					confirmarSalida();
				}
			});
			this.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirmarSalida()
	{
		int valor = JOptionPane.showConfirmDialog(this, "Estas seguro de cerrar la aplicacion","ADVERTENCIA"
													,JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}		
	
	

}
