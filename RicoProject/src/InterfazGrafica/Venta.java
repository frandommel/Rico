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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import GestionComercio.Comercio;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Venta extends JPanel implements ActionListener {
	private JLabel label,totalLabel;
	private JPanel panel;
	private JButton botonPedido,prueba,prueba2,boton;
	private ArrayList<JButton>botones;
	private int indice;
	private Comercio rico;
	/**
	 * Create the panel.
	 */
	public Venta(Comercio comercio) {
		rico = comercio;
		initComponents();
		botones = new ArrayList<JButton>();
		indice = 0;
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
		
		totalLabel=new JLabel("Total $1550");//TODO concatenar total pedido
		totalLabel.setBounds(258,337,200,40);
		totalLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));   //l ("tipo de letra",negrita/no negrita/cursiva),tamanio)
		totalLabel.setForeground(new Color(255,255,255));  //para asignarle color
		totalLabel.updateUI();
		totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(totalLabel);
		
		botonPedido=new JButton("Confirmar");
		botonPedido.setBounds(32,345,101,27);
		botonPedido.addActionListener(this);
		add(botonPedido);
		
		/*prueba=new JButton("Agregar");
		prueba.setBounds(182,13,101,27);
		prueba.addActionListener(this);
		prueba.setVisible(false);
		add(prueba);*/
		
		prueba2=new JButton("Quitar");
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
		if(e.getSource()==prueba) {///TODO Funcion agregar boton en panel pedido desde producto
			insertarBoton();
			
		}else if(e.getSource()==prueba2) {
			quitarBoton();
		}
	}
	public void confirmarPedido()
	{
		int valor = JOptionPane.showConfirmDialog(this, "Confirma Pedido?",	"Pedido", JOptionPane.YES_NO_OPTION);
		if(valor== JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "Pedido Confirmado");
		}
	}	
	public void insertarBoton() {
		boton = new JButton("Boton");
		boton.setBorder(null);
		boton.setBackground(new Color(241,98,63));
		boton.setForeground(new Color(255,255,255));
		boton.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 20));
		boton.setHorizontalAlignment(JButton.LEFT);
		panel.add(boton);
		botones.add(boton);
		indice++;
		panel.updateUI();
	}
	public void quitarBoton() {
		int i= botones.size()-1;
		if(!botones.isEmpty()) {
			botones.remove(i);
			panel.remove(i);
			panel.updateUI();
		}
	}
}
