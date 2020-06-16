package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PedidosActivos extends JPanel implements ActionListener{
	private JButton boton,boton2,botonLista;
	private JPanel panel;
	private ArrayList<JButton>buttons;
	private int indice;
	/**
	 * Create the panel.
	 */
	public PedidosActivos() {
		initComponents();
		buttons = new ArrayList<JButton>();
		indice = 1;
	}
	
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(594, 457, 470, 199);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(true);
		
		panel = new JPanel();
		panel.setBounds(12, 13, 446, 135);
		panel.setBackground(new Color(241,98,63));
		panel.setLayout(new GridLayout(0, 5));
		this.add(panel);
		
		boton = new JButton("new");
		boton.setBounds(12, 161, 97, 25);
		boton.addActionListener(this);
		add(boton);
		
		boton2 = new JButton("quit");
		boton2.setBounds(147, 161, 97, 25);
		boton2.addActionListener(this);
		add(boton2);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton) {
			insertarBoton();
			
		}else if(e.getSource()==boton2) {
			quitarBoton();
		}
	}
	
	public void insertarBoton() {
		botonLista = new JButton(""+indice);
		botonLista.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		panel.add(botonLista);
		buttons.add(botonLista);
		indice++;
		panel.updateUI();
	}
	public void quitarBoton() {
		int i= 0;
		if(!buttons.isEmpty()) {
			buttons.remove(i);
			panel.remove(i);
			i++;
			panel.updateUI();
		}
	}

	
}
