package InterfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
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

public class Venta extends JPanel implements ActionListener {
	private JLabel label,totalLabel;
	private JPanel panel;
	private JButton botonPedido,prueba,prueba2,boton;
	private ArrayList<JButton>botones;
	private int indice,monto;
	private Comercio rico;
	private ArrayList<Producto> listado;
	private JTextField montoField;
	private PedidosActivos activos;
	/**
	 * Create the panel.
	 */
	public Venta(Comercio comercio,PedidosActivos pedidosActivos) {
		rico = comercio;
		activos = pedidosActivos;
		botones = new ArrayList<JButton>();
		indice = 0;
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
		label.setBounds(12,13,146,40);
		label.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 18));   //l ("tipo de letra",negrita/no negrita/cursiva),tamanio)
		label.setForeground(new Color(255,255,255));  //para asignarle color
		label.setHorizontalAlignment(SwingConstants.CENTER);
		add(label);
		
		panel = new JPanel();
		panel.setBounds(12, 52, 446, 280);
		panel.setBackground(new Color(241,98,63));
		panel.setLayout(new GridLayout(10,10));
		this.add(panel);
		
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
		add(botonPedido);
		
		/*prueba=new JButton("Agregar");
		prueba.setBounds(182,13,101,27);
		prueba.addActionListener(this);
		prueba.setVisible(false);
		add(prueba);*/
		
		prueba2=new JButton("Cancelar");
		prueba2.setBounds(145,345,101,27);
		prueba2.addActionListener(this);
		add(prueba2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==botonPedido) 
		{
			confirmarPedido();
		}
		if(e.getSource()==prueba2) {
			quitarBoton();
		}
	}
	public void confirmarPedido()
	{
		int valor = JOptionPane.showConfirmDialog(this, "Confirma Pedido?",	"Pedido", JOptionPane.YES_NO_OPTION);
		if(valor== JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Pedido Confirmado");
			Pedido pedido = new Pedido(0, "Efectivo", listado, false, monto);
			activos.addVenta(pedido);
			quitarBoton();
			
			}
	}	
	
	
	public void quitarBoton() {
		
		if(!botones.isEmpty()) {
			listado.clear();
			botones.clear();
			panel.removeAll();
			montoField.setText("$ 0");
			panel.updateUI();
		}
	}
	
	public void addVenta(Producto producto)
	{
		listado.add(producto);
		listadoToButton();
		monto = setMontoVenta();
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
}
