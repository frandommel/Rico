package InterfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Archivos.ArchivoProducto;
import GestionComercio.Comercio;
import claseProductos.Producto;

public class Combos extends JPanel implements ActionListener{
	private JButton button,button2,button3,button4,button5,button6,button7,button8,button9,button10;
	private Comercio rico;
	private Venta venta;
	/**
	 * Create the panel.
	 */
	public Combos(Comercio comercio,Venta venta) {
		rico = comercio;
		this.venta=venta;
		initComponents();
	}
	
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(48, 40, 501, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(false);
		
		button = new JButton("Salsas");
		button.setBounds(203, 70, 100, 44);
		button.addActionListener(this);
		add(button);
		
		button2 = new JButton("Rico");
		button2.setBounds(203, 13, 100, 44);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("Rookie");
		button3.setBounds(203, 184, 100, 44);
		button3.addActionListener(this);
		add(button3);
		
		button4 = new JButton("Pancho Veggie");
		button4.setBounds(203, 127, 123, 44);
		button4.addActionListener(this);
		add(button4);
		
		button5 = new JButton("Doble queso");
		button5.setBounds(12, 127, 123, 44);
		button5.addActionListener(this);
		add(button5);
		
		button6 = new JButton("Big Wave");
		button6.setBounds(12, 184, 100, 44);
		button6.addActionListener(this);
		add(button6);
		
		button7 = new JButton("Veggie");
		button7.setBounds(12, 298, 100, 44);
		button7.addActionListener(this);
		add(button7);
		
		button8 = new JButton("Doble carne Doble queso");
		button8.setBounds(12, 241, 175, 44);
		button8.addActionListener(this);
		add(button8);
		
		button9 = new JButton("Jeremy");
		button9.setBounds(12, 13, 100, 44);
		button9.addActionListener(this);
		add(button9);
		
		button10 = new JButton("Kelly");
		button10.setBounds(12, 70, 100, 44);
		button10.addActionListener(this);
		add(button10);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton;
		if(e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			Producto producto = rico.leerProducto("Combo", ("Combo "+boton.getText()));
			observacionProducto obs = new observacionProducto(producto,venta);
			obs.setNombre(producto.getNombre(),producto.getPrecio());
			obs.setVisible(true);
			}
	}
	
	
}
