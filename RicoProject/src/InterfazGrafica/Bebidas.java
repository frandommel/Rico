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
import GestionComercio.Comercio;
import claseProductos.Bebida;
import claseProductos.Producto;

public class Bebidas extends JPanel implements ActionListener{
	private JButton button,button2,button3,button4,button5, button6;
	private Comercio rico;
	/**
	 * Create the panel.
	 */
	public Bebidas(Comercio comercio) {
		rico = comercio;
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
			observacionProducto obs = new observacionProducto(rico);
			Producto producto =null;
			Bebida bebida = null;
			if(boton.getText().equalsIgnoreCase("Corona") || boton.getText().equalsIgnoreCase("Patagonia")|| boton.getText().equalsIgnoreCase("Stella Artois") )
			{
				producto =rico.leerCerveza("Bebida", boton.getText());
				bebida = (Bebida) producto;
				if(bebida.getMarca().equalsIgnoreCase(boton.getText()))
				{
					obs.setNombre(bebida.getMarca(), bebida.getPrecio());
					obs.setVisible(true);
				}
			}else {
				producto = rico.leerProducto("Bebida", boton.getText());
				if(producto.getNombre().equalsIgnoreCase(boton.getText())){
					obs.setNombre(producto.getNombre(), producto.getPrecio());
					obs.setVisible(true);
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
