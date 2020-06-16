package InterfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class AltaCliente extends JPanel implements ActionListener {
	private JLabel label1,label,label2,label3,label4;
	private JTextField textField,textField2,textField3,textField4;
	private JButton button,button2,modificar,buscar,borrar;
	/**
	 * Create the panel.
	 */
	public AltaCliente() {
		initComponents();
	}
		
	public void initComponents() {
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setBounds(0, 0, 689, 378);
		this.setBackground(new Color(241,98,63));
		this.setLayout(null);
		this.setVisible(true);
		
		label=new JLabel("Nombre");
		  label.setBounds(102,80,80,16);
		  label.setFont(new Font("Andale Mono",1,18));
		  label.setForeground(new Color(255,255,255));  
		  add(label);
			
		  textField = new JTextField();
		  textField.setBounds(204, 76, 177, 24);
		  textField.setFont(new Font("Andale Mono",1,18));
		  add(textField);
			
			label3 = new JLabel("Direccion");
			label3.setBounds(102,126,84,16);
			label3.setFont(new Font("Andale Mono",1,18));
			label3.setForeground(new Color(255,255,255));  
			add(label3);
			
			textField3 = new JTextField();
			textField3.setBounds(204, 122, 177, 24);
			textField3.setFont(new Font("Andale Mono",1,18));
			add(textField3);
			
			label4 = new JLabel("Telefono");
			label4.setBounds(102,172,80,16);
			label4.setFont(new Font("Andale Mono",1,18));
			label4.setForeground(new Color(255,255,255));  
			add(label4);
			
			textField4 = new JTextField();
			textField4.setBounds(204, 168, 177, 24);
			textField4.setFont(new Font("Andale Mono",1,18));
			add(textField4);
		
			button=new JButton("Aceptar");
			button.setBounds(485,78,110,24);
			button.setFont(new Font("Arial", Font.BOLD, 12));
			button.setForeground(Color.BLACK);  
			add(button);
			
			buscar = new JButton("Buscar");
			buscar.setBounds(485,124,110,24);
			buscar.setFont(new Font("Arial", Font.BOLD, 12));
			buscar.setForeground(Color.BLACK); 
			buscar.addActionListener(this);
			add(buscar);
			
			modificar = new JButton("Modificar");
			modificar.setBounds(485,170,110,24);
			modificar.setEnabled(false);
			modificar.setFont(new Font("Arial", Font.BOLD, 12));
			modificar.setForeground(Color.BLACK);  
			modificar.addActionListener(this);
			add(modificar);
			
			borrar = new JButton("Borrar");
			borrar.setBounds(485,216,110,24);
			borrar.setEnabled(false);
			borrar.setFont(new Font("Arial", Font.BOLD, 12));
			borrar.setForeground(Color.BLACK);
			borrar.addActionListener(this);
			add(borrar);
			
			button2=new JButton("Volver");
			button2.setBounds(12,341,110,24);
			button2.setFont(new Font("Arial", Font.BOLD, 12));
			button2.setForeground(Color.BLACK);  
			button2.addActionListener(this);
			add(button2);
			
			ImageIcon imagen =  new ImageIcon(getClass().getResource("fondo resto.jpeg"));  //para obtener una imagen en un label
			label1 = new JLabel(imagen);  //para asignnarle una imagen a un label.
			label1.setBounds(0,0,692,378);
			add(label1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button2) 
		{
			Pedido pedido = new Pedido();
			pedido.setVisible(true);
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);///cambiar a otra ventana desde otro jpanel
			frame.dispose();
		}
	}

}
