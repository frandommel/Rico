package InterfazGrafica;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;

import GestionComercio.Comercio;
import claseProductos.Producto;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class observacionProducto extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private JButton button,button2;
	private Producto producto;
	private Venta ventanaVenta;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					observacionProducto frame = new observacionProducto();
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
	public observacionProducto(Producto producto,Venta venta) {
		this.producto=producto;
		this.ventanaVenta=venta;
		initComponents();
	}
	
	/**
	 * Inicio los componentes
	 */
	public void initComponents() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ingreso Producto");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(241,98,63));
		
		textField = new JTextField();
		textField.setBounds(12, 164, 420, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Observaciones");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(12, 120, 135, 31);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(316, 32, 116, 31);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(12, 32, 292, 31);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		button2 = new JButton("Aceptar");
		button2.setBounds(12, 221, 116, 31);
		getContentPane().add(button2);
		button2.addActionListener(this);
		
		button = new JButton("Cancelar");
		button.setBounds(316, 221, 116, 31);
		button.addActionListener(this);
		getContentPane().add(button);
	}
	/**
	 * @param AtionEvent
	 * Metodo que se utiliza para el manejo de las interacciones de la interfaz
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			this.setVisible(false);
		}
		if(e.getSource()==button2)
		{
			ventanaVenta.addVenta(producto);
			this.setVisible(false);
		}
	}
	/**
	 * 
	 * @param String
	 * @param int
	 */
	public void setNombre(String nombre,int precio)
	{
		String p = Integer.toString(precio);
		textField_2.setText(nombre);
		textField_1.setText(p);
	}
}
