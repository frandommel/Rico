package InterfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
		
		button = new JButton("Gaseosa 237ml");
		button.setBounds(12, 93, 123, 67);
		accionBoton(button);
		add(button);
		
		button2 = new JButton("Gaseosa 500ml");
		button2.setBounds(12, 13, 123, 67);
		accionBoton(button2);
		add(button2);
		
		button3 = new JButton("Limonada");
		button3.setBounds(12, 173, 123, 67);
		accionBoton(button3);
		add(button3);
		
		button4 = new JButton("Stella Artois");
		button4.setBounds(158, 13, 123, 67);
		accionBoton(button4);
		add(button4);
		
		button5 = new JButton("Corona");
		button5.setBounds(158, 93, 123, 67);
		accionBoton(button5);
		add(button5);
		
		button6=new JButton("Patagonia");
		button6.setBounds(158, 173, 123, 67);
		accionBoton(button6);
		add(button6);
	}
	
	public void añadirFrameObservacion() {
		observacionProducto obs = new observacionProducto();
		obs.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			añadirFrameObservacion();
		}
	}
	
	public void accionBoton(JButton b) {
		b.addActionListener(this);
	}

}
