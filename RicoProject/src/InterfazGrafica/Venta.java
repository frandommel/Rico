package InterfazGrafica;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import GestionComercio.Comercio;
import GestionComercio.Pedido;
import claseProductos.Producto;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Venta extends JPanel implements ActionListener {
	private JLabel label,totalLabel;
	private JPanel panel;
	private JButton botonPedido,prueba,prueba2,boton, botonVip;
	private ArrayList<JButton>botones;
	private int monto;
	private Comercio rico;
	private ArrayList<Producto> listado;
	private JTextField montoField,textNumero;
	private PedidosActivos activos;
	private JCheckBox checkbox;
	private static int numeroPedido=1;
	
	/**
	 * 
	 */
	public Venta(Comercio comercio,PedidosActivos pedidosActivos) {
		
		rico = comercio;
		activos = pedidosActivos;
		botones = new ArrayList<JButton>();
		setInicioNumPedido();
		listado = new ArrayList<Producto>();
		initComponents();
		
	
		
	}
	
	private void initComponents() 
	{
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(594, 40, 470, 385);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(true);
		
		label = new JLabel("Pedido Nro: ");
		label.setBounds(12,12,113,40);
		label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));   //l ("tipo de letra",negrita/no negrita/cursiva),tamanio)
		label.setForeground(new Color(255,255,255));  //para asignarle color
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		
		panel = new JPanel();
		panel.setBounds(12, 52, 446, 280);
		panel.setBackground(new Color(241,98,63));
		panel.setLayout(new GridLayout(10,10));
		this.add(panel);
		panel.updateUI();
		
		totalLabel=new JLabel("Total:");
		totalLabel.setBounds(220,337,200,40);
		totalLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));   //l ("tipo de letra",negrita/no negrita/cursiva),tamanio)
		totalLabel.setForeground(new Color(255,255,255));  //para asignarle color
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(totalLabel);
		
		montoField=new JTextField();
		montoField.setBounds(345,342,90,30);
		montoField.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		montoField.setHorizontalAlignment(SwingConstants.RIGHT);
		montoField.setText("$ 0");
		montoField.setEditable(false);
		add(montoField);
		
		
		
		botonPedido=new JButton("Confirmar");
		botonPedido.setBounds(32,345,101,27);
		botonPedido.addActionListener(this);
		botonPedido.setEnabled(false);
		botonPedido.updateUI();
		add(botonPedido);
		
		prueba2=new JButton("Cancelar");
		prueba2.setBounds(145,345,101,27);
		prueba2.addActionListener(this);
		botonPedido.updateUI();
		add(prueba2);
		
		checkbox = new JCheckBox("Cliente Vip");
		checkbox.setBounds(361, 19, 90, 27);
		checkbox.addActionListener(this);
		add(checkbox);
		
		textNumero = new JTextField();
		textNumero.setBounds(124, 19, 75, 27);
		textNumero.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		textNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textNumero.setEditable(false);
		add(textNumero);
		textNumero.setColumns(10);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==checkbox)
		{
			if(checkbox.isSelected()==true)
			{
				String stringMonto = String.valueOf(setMontoVenta(0.85));
				montoField.setText("$ "+stringMonto);
			}
			else
			{
				String stringMonto = String.valueOf(setMontoVenta());
				montoField.setText("$ "+stringMonto);
			}
			
		}
		if(e.getSource()==botonPedido) 
		{
			confirmarPedido(checkbox);
			try
			{
				Thread.sleep(800);
				limpiarPanel();
			}catch (InterruptedException w) {
			w.printStackTrace();
			}
			
		}
		if(e.getSource()==prueba2) {
			limpiarPanel();
		}
	}
	
	public void confirmarPedido(JCheckBox checkbox)
	{
		int valor = JOptionPane.showConfirmDialog(this, "Confirma Pedido?",	"Pedido", JOptionPane.YES_NO_OPTION);
		if(valor== JOptionPane.YES_OPTION) {
			boolean vip = false;
			if(checkbox.isSelected()==true)
			{
				vip=true;
				monto = (int)0.85*monto;
				textNumero.setText(String.valueOf(monto));
				panel.updateUI();
			}
			ArrayList<Producto> listaPedido = new ArrayList<Producto>();
			bucleLimpiezaListado(listado, listaPedido);
			Pedido pedido = new Pedido(getNumeroPedido(), "", listaPedido, vip, monto);
			listado.clear();
			numeroPedidoIncremen();
			activos.addVenta(pedido);
			
		}
	}	
	
	
	private void bucleLimpiezaListado(ArrayList<Producto> origen,ArrayList<Producto> destino)
	{
		for(int i=0;i<origen.size();i++)
		{ 
			Producto productoI = origen.get(i);
			if((productoI instanceof claseProductos.Pancho)||(productoI instanceof claseProductos.Bebida)||
					(productoI instanceof claseProductos.Combo)||(productoI instanceof claseProductos.Guarnicion)||
					(productoI instanceof claseProductos.Hamburguesa)||(productoI instanceof claseProductos.Guarnicion))
			{
				destino.add(productoI);
			}
		}
	}
	
	public void limpiarPanel() {
		if(!botones.isEmpty()) {
		
			botones.clear();
			panel.removeAll();
			montoField.setText("$ 0");
			textNumero.setText("");
			botonPedido.setEnabled(false);
			panel.updateUI();
		}
	}
	
	public void addVenta(Producto producto)
	{
		textNumero.setText(String.valueOf(getNumeroPedido()));
		listado.add(producto);
		botonPedido.setEnabled(true);
		listadoToButton();
		monto = setMontoVenta();
		checkbox.setSelected(false);
		String montoString = String.valueOf(monto);
		montoField.setText("$ "+montoString);
		panel.updateUI();
	}
	
	public void listadoToButton()
	{
		for(int i=0;i<listado.size();i++)
		{
			boton = new JButton(listado.get(i).getNombre());
			boton.setBorder(null);
			boton.setBackground(new Color(241,98,63));
			boton.setForeground(new Color(255,255,255));
			boton.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
			boton.setHorizontalAlignment(JButton.LEFT);
			botones.add(boton);			
		}
		panel.add(boton);
	
		
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
	

	private int getNumeroPedido()
	{
		return numeroPedido;
	}
	
	private void numeroPedidoIncremen()
	{
		numeroPedido++;
	}
	
	private void setInicioNumPedido()
	{
		HashMap<String, ArrayList<Pedido>>  mapaPedidos = rico.getPedidos().getListaPedidosContenedorMap();		
		ArrayList<Pedido> pedidos =null;
		try
		{
			pedidos = mapaPedidos.get(definirFecha());
			numeroPedido=pedidos.size()+1;
			
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public int setMontoVenta() {
		
		int montoVenta = 0;
		if(listado!=null)
		{
			for(int i=0;i<listado.size();i++)
			{
				montoVenta=montoVenta+listado.get(i).getPrecio();
			}
		}else
		{
			return 0;
		}
		return montoVenta;
	}
	
public int setMontoVenta(double d) {
		

		int montoVenta = 0;
		if(listado!=null)
		{
			for(int i=0;i<listado.size();i++)
			{
				montoVenta=montoVenta+listado.get(i).getPrecio();
			}
		}else
		{
			return 0;
		}
		
		montoVenta = (int) (montoVenta*d);
		return montoVenta;
	}



	
}
