package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

//import Exceptions.CobroException;
import GestionComercio.Comercio;
import GestionComercio.Pedido;

public class FrameCerrarVenta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton tarjeta,efectivo,cancelar,boton;
	private Pedido pedido;
	private Comercio rico;
	private JLabel demoraText;
	private PedidosActivos panelAnterior;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameCerrarVenta frame = new FrameCerrarVenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 * @param pedidosActivos
	 * @param Comercio 
	 * @param Pedido 
	 * @param  JButton
	 */
	public FrameCerrarVenta(Pedido pedido2,Comercio comercioRico, PedidosActivos pedidosActivos,JButton boton) {
		this.pedido=pedido2;
		rico = comercioRico;
		this.boton=boton;
		panelAnterior = pedidosActivos;
		initComponents();
	}
	/**
	 * Inicio los componentes
	 */
	public void initComponents() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Ingreso Producto");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(241,98,63));
		
		efectivo = new JButton();
		efectivo.setBounds(90, 121, 244, 67);
		getContentPane().add(efectivo);
		efectivo.setIcon(new ImageIcon(FrameCerrarVenta.class.getResource("/InterfazGrafica/efectivo.png")));
		efectivo.addActionListener(this);
		
		tarjeta = new JButton();
		tarjeta.setBounds(90, 41, 244, 67);
		tarjeta.addActionListener(this);
		tarjeta.setIcon(new ImageIcon(FrameCerrarVenta.class.getResource("/InterfazGrafica/tarjeta.png")));
		getContentPane().add(tarjeta);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBounds(316, 221, 116, 31);
		getContentPane().add(cancelar);
		cancelar.addActionListener(this);
		
		
		
		
	}
	/**
	 * @param AtionEvent
	 * Metodo que se utiliza para el manejo de las interacciones de la interfaz
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelar) {
			this.setVisible(false);			
		}
		if(e.getSource()==tarjeta)
		{
			
			pedido.setCobrado(true);
			pedido.setCondicion("Tarjeta");
			rico.setPedidos(pedido);
			this.setVisible(false);
			rico.getArchivos().actualizarArchivoPedidos(rico.getPedidos());
			
			panelAnterior.quitarBoton(boton);
		
		}
		if(e.getSource()==efectivo)
		{
			pedido.setCobrado(true);
			pedido.setCondicion("Efectivo");
			rico.setPedidos(pedido);
			this.setVisible(false);
			rico.getArchivos().actualizarArchivoPedidos(rico.getPedidos());

			panelAnterior.quitarBoton(boton);
		}
	
		
	}
	
	
	/**
	 * 
	 * @return String
	 * Defino fecha y vuelvo un string
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
