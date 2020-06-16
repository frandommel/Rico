package InterfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Archivos.ArchivoProducto;
import claseProductos.Producto;

public class Ensaladas extends JPanel implements ActionListener{
	private JButton button,button2,button3;
	/**
	 * Create the panel.
	 */
	public Ensaladas() {
		initComponents();
	}
	
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(48, 40, 501, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(false);
		
		button = new JButton("Ukelele");
		button.setBounds(12, 13, 123, 67);
		button.addActionListener(this);
		add(button);
		
		button2 = new JButton("Aloha");
		button2.setBounds(12, 93, 123, 67);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("Hula Hula");
		button3.setBounds(12, 173, 123, 67);
		button3.addActionListener(this);
		add(button3);
	}
	
	public void añadirFrameObservacion() {
		observacionProducto obs = new observacionProducto();
		obs.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton;
		if(e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			observacionProducto obs = new observacionProducto();
			ArrayList<Producto> h = traerEnsalada();
			for (int i = 0; i < h.size(); i++) {
				if(h.get(i).getNombre().equalsIgnoreCase(boton.getText())){
					obs.setNombre(h.get(i).getNombre(), h.get(i).getPrecio());
					obs.setVisible(true);
				}
			}
		}
	}
	
	public ArrayList<Producto> traerEnsalada(){
		ArchivoProducto bebidas = new ArchivoProducto();
		ArrayList<Producto> p = bebidas.leerEnsalada();
		return p;
	}

}
