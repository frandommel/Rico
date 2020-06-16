package InterfazGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Guarnicion extends JPanel implements ActionListener{
	private JButton button,button2,button3;
	/**
	 * Create the panel.
	 */
	public Guarnicion() {
		initComponents();
	}
	
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(48, 40, 501, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(false);
		
		button = new JButton("Clasicas");
		button.setBounds(12, 13, 123, 67);
		accionBoton(button);
		add(button);
		
		button2 = new JButton("Nuggets");
		button2.setBounds(12, 93, 123, 67);
		accionBoton(button2);
		add(button2);
		
		button3 = new JButton("Rico");
		button3.setBounds(12, 173, 123, 67);
		accionBoton(button3);
		add(button3);
	}
	
	public void añadirFrameObservacion() {
		observacionProducto obs = new observacionProducto();
		obs.setVisible(true);
	}
	
	public void accionBoton(JButton b) {
		b.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			añadirFrameObservacion();
		}
		
	}

}
