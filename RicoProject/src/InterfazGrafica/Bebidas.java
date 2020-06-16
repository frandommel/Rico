package InterfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Archivos.ArchivoPedidos;
import Archivos.ArchivoProducto;
import claseProductos.Bebida;
import claseProductos.Producto;

public class Bebidas extends JPanel implements ActionListener{
	private JButton button,button2,button3,button4,button5, button6;
	/**
	 * Create the panel.
	 */
	public Bebidas() {
		initComponents();
	}
	
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(48, 40, 501, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(false);
		
		button = new JButton("Gaseosa 237cc");
		button.setBounds(12, 93, 123, 67);
		button.addActionListener(this);
		add(button);
		
		button2 = new JButton("Gaseosa 500cc");
		button2.setBounds(12, 13, 123, 67);
		button2.addActionListener(this);
		add(button2);
		
		button3 = new JButton("Limonada");
		button3.setBounds(12, 173, 123, 67);
		button3.addActionListener(this);
		add(button3);
		
		button4 = new JButton("Stella Artois");
		button4.setBounds(158, 13, 123, 67);
		button4.addActionListener(this);
		add(button4);
		
		button5 = new JButton("Corona");
		button5.setBounds(158, 93, 123, 67);
		button5.addActionListener(this);
		add(button5);
		
		button6=new JButton("Patagonia");
		button6.setBounds(158, 173, 123, 67);
		button6.addActionListener(this);
		add(button6);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton;
		if(e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			observacionProducto obs = new observacionProducto();
			ArrayList<Producto> h = traerBebidas();
			for (int i = 0; i < h.size(); i++) {
				if(h.get(i).getNombre().equalsIgnoreCase(boton.getText())){
					obs.setNombre(h.get(i).getNombre(), h.get(i).getPrecio());
					obs.setVisible(true);
				}
				if(h.get(i).getNombre().equalsIgnoreCase("Cerveza")) {
					Bebida b = (Bebida) h.get(i);
					if(b.getMarca().equalsIgnoreCase(boton.getText()))
					{
						obs.setNombre(b.getMarca(), h.get(i).getPrecio());
						obs.setVisible(true);
					}
				}
			}
		}
	}
	
	public ArrayList<Producto> traerBebidas(){
		ArchivoProducto bebidas = new ArchivoProducto();
		ArrayList<Producto> h = bebidas.leerBebida();
		return h;
	}

}
