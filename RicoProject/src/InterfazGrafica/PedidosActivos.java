package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import GestionComercio.Comercio;
import GestionComercio.Pedido;
import claseProductos.Producto;

public class PedidosActivos extends JPanel implements ActionListener{
	private JButton boton,boton2,botonLista;
	private JPanel panel;
	private ArrayList<JButton>buttons;
	private ArrayList<Pedido> pedidos;

	private int indice;
	private Comercio rico;
	private Date fechaDiaria;
	
	
	/**
	 * Create the panel.
	 */
	public PedidosActivos(Comercio comercio) {
		rico = comercio;
		
		
		pedidos = new ArrayList<Pedido>();
		buttons = new ArrayList<JButton>();
		initComponents();
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
	
	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		JButton boton;
		if(e.getSource() instanceof JButton) {
			boton = (JButton) e.getSource();
			int numeroPedido=Integer.parseInt(boton.getText());
			numeroPedido=numeroPedido-1;
			FrameCerrarVenta cerrar = new FrameCerrarVenta(pedidos.get(numeroPedido),rico);
			cerrar.setVisible(true);
			}
		
		
	}
	
	public void addVenta(Pedido pedido) {
		
		pedidos.add(pedido);
		
		listadoToButton();

		panel.updateUI();
	}
	
	public void listadoToButton()
	{
		for(int i=0;i<pedidos.size();i++)
		{
			String strButton = String.valueOf(pedidos.get(i).getId());
			botonLista = new JButton(strButton);
			botonLista.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
			botonLista.addActionListener(this);
			buttons.add(botonLista);	
			
		}
		panel.add(botonLista);
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
	
	public String definirFecha()
	{
		Date fechaOrigen = new Date();
		int dia,mes,anio;
		String strFecha;
		dia=fechaOrigen.getDate();
		mes=fechaOrigen.getMonth()+1;
		anio=fechaOrigen.getYear()+1900;
		strFecha = dia+"/"+mes+"/"+anio;
		
		return strFecha;
	}
	
	
	
}
