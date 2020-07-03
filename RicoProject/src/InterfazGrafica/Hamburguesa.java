package InterfazGrafica;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionComercio.Comercio;
import claseProductos.Producto;

public class Hamburguesa extends JPanel implements ActionListener{
	private JButton button,button2,button3,button4,button5,button6;
	private Comercio rico;
	private Venta venta;
	/**
	 * Create the panel.
	 */
	public Hamburguesa(Comercio comercio,Venta venta) {
		rico = comercio;
		this.venta=venta;
		initComponents();
	}
	
	/**
	 * @param e ActionEvent
	 * Metodo que se utiliza para el manejo de las interacciones de la interfaz
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton;
		if(e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			Producto producto = rico.leerProducto("Hamburguesa",boton.getText());
			observacionProducto obs = new observacionProducto(producto,venta);
			obs.setNombre(producto.getNombre(), producto.getPrecio());
			obs.setVisible(true);
			}
	}
	/**
	 * Inicio los componentes
	 */
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(48, 40, 501, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(false);
		
		button = new JButton("Jeremy");
		button.setBounds(12, 13, 100, 44);
		button.addActionListener(this);
		add(button);
		
		button2 = new JButton("Kelly");
		button2.setBounds(12, 70, 100, 44);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("Doble queso");
		button3.setBounds(12, 127, 123, 44);
		button3.addActionListener(this);
		add(button3);
		
		button4 = new JButton("Doble carne Doble queso");
		button4.setBounds(12, 187, 175, 44);
		button4.addActionListener(this);
		add(button4);
		
		button5 = new JButton("Big Wave");
		button5.setBounds(12, 244, 100, 44);
		button5.addActionListener(this);
		add(button5);
		
		button6 = new JButton("Veggie");
		button6.setBounds(12, 301, 100, 44);
		button6.addActionListener(this);
		add(button6);
	}	

}
