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

//import Exceptions.CobroException;
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
		
		
		pedidos = new ArrayList<Pedido>(rico.getPedidos().getListaPedidosContenedorMap().get(definirFecha()));
		buttons = new ArrayList<JButton>();
		initComponents();
	}
	/**
	 * Inicio componentes
	 */
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
	/**
	 * @param e ActionEvent
	 * Metodo que se utiliza para el manejo de las interacciones de la interfaz
	 */
	@Override
	public void actionPerformed(ActionEvent e) {	
		JButton boton;	
		if(e.getSource() instanceof JButton) {
				boton = (JButton) e.getSource();
				int numeroPedido=Integer.parseInt(boton.getText());
				numeroPedido=numeroPedido-1;
				FrameCerrarVenta cerrar = new FrameCerrarVenta(pedidos.get(numeroPedido),rico,this,boton);
				cerrar.setVisible(true);
				//quitarBoton(boton);
				}
		
		}
	/**
	 * 
	 * @param Pedido
	 */
	public void addVenta(Pedido pedido) {
		
		pedidos.add(pedido);
		
		listadoToButton();

		panel.updateUI();
	}
	
	/**
	 * Creo listado de botones
	 */
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
	
	/**
	 * 
	 * @param boton Jbutton 
	 */
	public void quitarBoton(JButton boton) {
		buttons.remove(boton);
		panel.remove(boton);
		panel.updateUI();
	}
	
	/**
	 * 
	 * @return String
	 * Defino fecha a partir del objeto Date
	 */
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
