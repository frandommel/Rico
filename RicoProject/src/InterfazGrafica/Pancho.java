package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Archivos.ArchivoProducto;
import claseProductos.Producto;

public class Pancho extends JPanel implements ActionListener {
	private JButton button,button2,button3,button4;
	/**
	 * Create the panel.
	 */
	public Pancho() {
		initComponents();
		
	}
	
	
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(48, 40, 501, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(false);
		
		button = new JButton("Pancho");
		button.setBounds(12, 253, 123, 67);
		button.addActionListener(this);
		add(button);
		
		button2 = new JButton("Rico");
		button2.setBounds(12, 173, 123, 67);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("Rookie");
		button3.setBounds(12, 93, 123, 67);
		button3.addActionListener(this);
		add(button3);
		
		button4 = new JButton("Veggie");
		button4.setBounds(12, 13, 123, 67);
		button4.addActionListener(this);
		add(button4);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton;
		if(e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			observacionProducto obs = new observacionProducto();
			ArrayList<Producto> h = traerPancho();
			for (int i = 0; i < h.size(); i++) {
				if(h.get(i).getNombre().equalsIgnoreCase(boton.getText())){
					obs.setNombre(h.get(i).getNombre(), h.get(i).getPrecio());
					obs.setVisible(true);
				}
			}
		}
	}
	
	public void añadirFrameObservacion() {
		observacionProducto obs = new observacionProducto();
		obs.setVisible(true);
	}
	
	public ArrayList<Producto> traerPancho(){
		ArchivoProducto bebidas = new ArchivoProducto();
		ArrayList<Producto> p = bebidas.leerPancho();
		return p;
	}

}
