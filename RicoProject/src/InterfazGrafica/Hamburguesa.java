package InterfazGrafica;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Hamburguesa extends JPanel implements ActionListener{
	private JButton button,button2,button3,button4,button5,button6;
	/**
	 * Create the panel.
	 */
	public Hamburguesa() {
		initComponents();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton) {
			a�adirFrameObservacion();
		}
		
	}
	
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
	
	public void a�adirFrameObservacion() {
		observacionProducto obs = new observacionProducto();
		obs.setVisible(true);
	}

}
