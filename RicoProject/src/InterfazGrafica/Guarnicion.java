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
	private Venta venta;
	/**
	 * Create the panel.
	 */
	public Guarnicion(Comercio comercio,Venta venta) {
		rico = comercio;
		this.venta = venta;
		initComponents();
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
	/**
	 * Agrego un ActionListener al boton
	 */
	public void accionBoton(JButton b) {
		b.addActionListener(this);
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
			Producto producto = rico.leerProducto("Guarnicion",boton.getText());
			observacionProducto obs = new observacionProducto(producto,venta);
			obs.setNombre(producto.getNombre(), producto.getPrecio());
			obs.setVisible(true);
			}
	}
	
	

}
