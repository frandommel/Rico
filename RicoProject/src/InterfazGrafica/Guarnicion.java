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

public class Guarnicion extends JPanel implements ActionListener{
	private JButton button,button2,button3;
	private Comercio rico;
	/**
	 * Create the panel.
	 */
	public Guarnicion(Comercio comercio) {
		rico = comercio;
		initComponents();
	}
	
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(48, 40, 501, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(false);
		
		button = new JButton("Papas Fritas");
		button.setBounds(12, 13, 123, 67);
		accionBoton(button);
		add(button);
		
		button2 = new JButton("Nuggets");
		button2.setBounds(12, 93, 123, 67);
		accionBoton(button2);
		add(button2);
		
		button3 = new JButton("Papas Rico");
		button3.setBounds(12, 173, 123, 67);
		accionBoton(button3);
		add(button3);
	}
	
	public void accionBoton(JButton b) {
		b.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton;
		if(e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			observacionProducto obs = new observacionProducto(rico);
			obs.setNombre(rico.leerProducto("Guarnicion",boton.getText()).getNombre(), rico.leerProducto("Guarnicion",boton.getText()).getPrecio());
			obs.setVisible(true);
			}
	}
	
	public ArrayList<Producto> traerGuarnicion(){
		ArchivoProducto bebidas = new ArchivoProducto();
		ArrayList<Producto> g = bebidas.leerGuarnicion();
		return g;
	}

}
