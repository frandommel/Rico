package InterfazGrafica;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.PasswordView;

import org.json.JSONException;

import Archivos.ManejadordeArchivos;
import Exceptions.LoginException;
import GestionComercio.Comercio;
import GestionComercio.Empleado;
import GestionComercio.Pedido;

import java.lang.Package;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Inicio extends JFrame implements KeyListener,ActionListener{

	private JPanel contentPane;
	private JLabel label1, label2, label3, label4, label5;
	private JTextField textfield1;
	private JPasswordField textfield2;
	private Comercio rico;
	private JButton boton1;
	private static VentanaPedido pedido;
	
	
	
	public static void main(String[] args) {
		
	}
	
	public Inicio(Comercio comercio) {
		rico = comercio;
		initComponents();
	}
	
	public void initComponents() {
		cerrar();
		setBounds(0, 0, 698,409);
		setTitle("Rico Management");
		this.setResizable(false); //Inhabilita el cambio de tamaño
		this.setLocationRelativeTo(null);      //la ventana se abre en el medio
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(201,80,27)); //para agregarle color al fondo
		setContentPane(contentPane);
		setIconImage(new ImageIcon(getClass().getResource("descarga1.jpg")).getImage());
				  
		  
		  label3 = new JLabel ("Usuario:");
		  label3.setBounds(309,114,80,16);
		  label3.setFont(new Font("Andale Mono",1,18));
		  label3.setForeground(new Color(255,255,255));  
		  getContentPane().add(label3);
		  
		  textfield1 = new JTextField();
		  textfield1.setBounds(251,143,200,25);
		  textfield1.setBackground(new Color(224,224,224));
		  textfield1.setFont(new Font("Andale Mono",1,14));
		  getContentPane().add(textfield1);
		  
		  label4 = new JLabel ("Password:");
		  label4.setBounds(308,180,93,16);
		  label4.setFont(new Font("Andale Mono",1,18));
		  label4.setForeground(new Color(255,255,255));  
		  getContentPane().add(label4);
		  
		  textfield2 = new JPasswordField();//textfield que encripta el texto ingresado
		  textfield2.setBounds(251,209,200,25);
		  textfield2.setBackground(new Color(224,224,224));
		  textfield2.setFont(new Font("Andale Mono",1,14));
		  textfield2.addKeyListener(this);
		  getContentPane().add(textfield2);
		  
		  boton1 = new JButton ("Ingresar");
		  boton1.addActionListener(this);
		  boton1.setBounds(301,259,100,30);
		  boton1.setBackground(new Color(255,255,255));
		  boton1.setFont(new Font("Andale Mono",1,14)); 
		  getContentPane().add(boton1);
		  
		  label5 = new JLabel ("©2020 DVD.");
		  label5.setBounds(8,350,100,30);
		  label5.setFont(new Font("Andale Mono",1,12));
		  label5.setForeground(new Color(255,255,255));
		  getContentPane().add(label5);
		  
		  ImageIcon imagen =  new ImageIcon(getClass().getResource("fondo.jpeg"));  //para obtener una imagen en un label
		  label1 = new JLabel(imagen);  //para asignarle una imagen a un label.
		  label1.setBounds(0,0,692,374);
		  getContentPane().add(label1);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==boton1)
		{
				String usuario = textfield1.getText().trim();
				String password= textfield2.getText();
				try {
					boolean flag= validarPersona(usuario, password);
					if(flag==true)
					{
						pedido = new VentanaPedido(rico);
						pedido.setVisible(true);
						this.setVisible(false);
					}
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch(LoginException e2)
				{
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
					
				/*if(usuario.equals(user)&&password.equals(pass)) {
					pedido = new Pedido();
					pedido.setVisible(true);
					dispose();
				}else if(usuario.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null, "Debes ingresar usuario y contraseña");   //Para enviar un mensaje por pantalla
				}else {
					 
				}*/
		  }
		}
		
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	
	 //para entrar con enter
	@Override
	public void keyReleased(KeyEvent e) { 
  		String usuario = textfield1.getText().trim();
		String password= textfield2.getText();
		if(e.getKeyCode() == 10) 
		{
			boolean flag;
			try {
				flag = validarPersona(usuario, password);
				if(flag==true)
				{
					pedido = new VentanaPedido(rico);
					pedido.setVisible(true);
					this.setVisible(false);
				}
			} catch (LoginException | JSONException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
				
	 
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//Cerramos la aplicacion con la cruz
	public void cerrar() 
	{
		try {
			this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					confirmarSalida();
				}
			});
			//this.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void confirmarSalida()
	{
		int valor = JOptionPane.showConfirmDialog(this, "Estas seguro de cerrar la aplicacion","ADVERTENCIA"
													,JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	/*public void iniciar(Comercio comercio) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio(comercio);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	
	public boolean validarPersona(String nombre, String password) throws LoginException, JSONException  
	{
		ManejadordeArchivos manejador = new ManejadordeArchivos();
		HashMap<String, Empleado> listadoBusqueda;
		boolean flag=false;
			listadoBusqueda = manejador.getListadoEmpleados();
			if(listadoBusqueda.containsKey(nombre))
			{
				if(listadoBusqueda.get(nombre).getPassword().equals(password))
				{
					flag=true;
				}else
				{
					throw new LoginException("Contraseña invalida");
				}
			}else
			{
				throw new LoginException("Usuario inexistente");
			}
		return flag;
	}
	
}


