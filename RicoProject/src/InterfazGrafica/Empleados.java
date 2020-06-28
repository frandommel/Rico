package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import org.json.JSONObject;

import GestionComercio.Comercio;
import GestionComercio.Empleado;
import GestionComercio.Persona;

public class Empleados extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label1,label,label2,label3,label4,label5;
	private JTextField textField,textField2,textField3,textField4,textField5;
	private JButton button,button2,modificar,buscar,borrar;
	private Inicio inicio;
	private Comercio rico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Empleados frame = new Empleados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
	}

	/**
	 * Create the frame.
	 */
	public Empleados(Comercio comercio) {
		rico=comercio;
		initComponents();
	}
	
	public void initComponents() {
		cerrar();
		setBounds(0, 0, 698, 409);
		setTitle("Empleados");
		this.setResizable(false);
		this.setLocationRelativeTo(null);//la ventana se abre en el medio
		iniciarJpanel();
		setIconImage(new ImageIcon(getClass().getResource("descarga.jpg")).getImage());	
	}
	
	public void iniciarJpanel() {
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 689, 378);
		contentPane.setBackground(new Color(241,98,63));
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		setContentPane(contentPane);
		
		label=new JLabel("Nombre");
		  label.setBounds(87,79,80,16);
		  label.setFont(new Font("Andale Mono",1,18));
		  label.setForeground(new Color(255,255,255));  
		  getContentPane().add(label);
			
		  textField = new JTextField();
		  textField.setBounds(204, 76, 177, 24);
		  textField.setFont(new Font("Andale Mono",1,14));
		  getContentPane().add(textField);
			
		  label2 = new JLabel("Puesto");
		  label2.setBounds(87,125,80,16);
		  label2.setFont(new Font("Andale Mono",1,18));
		  label2.setForeground(new Color(255,255,255));  
		  getContentPane().add(label2);
			
		  textField2 = new JTextField();
		  textField2.setBounds(204, 122, 177, 24);
		  textField2.setFont(new Font("Andale Mono",1,14));
		  textField2.setEnabled(false);
		  getContentPane().add(textField2);
			
		  label3 = new JLabel("Direccion");
		  label3.setBounds(87,171,84,16);
		  label3.setFont(new Font("Andale Mono",1,18));
		  label3.setForeground(new Color(255,255,255));  
		  getContentPane().add(label3);
			
		  textField3 = new JTextField();
		  textField3.setBounds(204, 168, 177, 24);
		  textField3.setFont(new Font("Andale Mono",1,14));
		  textField3.setEnabled(false);
		  getContentPane().add(textField3);
			
		  label4 = new JLabel("Telefono");
		  label4.setBounds(87,218,80,16);
		  label4.setFont(new Font("Andale Mono",1,18));
		  label4.setForeground(new Color(255,255,255));  
		  getContentPane().add(label4);
			
		  textField4 = new JTextField();
		  textField4.setBounds(204, 215, 177, 24);
		  textField4.setFont(new Font("Andale Mono",1,14));
		  textField4.setEnabled(false);
		  getContentPane().add(textField4);
		  
		  label5 = new JLabel("Contraseña");
		  label5.setBounds(82,263,100,20);
		  label5.setFont(new Font("Andale Mono",1,18));
		  label5.setForeground(new Color(255,255,255)); 
		  label5.setVisible(false);
		  getContentPane().add(label5);
			
		  textField5 = new JTextField();
		  textField5.setBounds(204, 262, 177, 24);
		  textField5.setFont(new Font("Andale Mono",1,14));
		  textField5.setVisible(false);
		  getContentPane().add(textField5);
		
			button=new JButton("Nuevo");
			button.setBounds(485,78,110,24);
			button.setFont(new Font("Arial", Font.BOLD, 12));
			button.setForeground(Color.BLACK); 
			button.setEnabled(false);
			button.addActionListener(this);
			getContentPane().add(button);
			
			buscar = new JButton("Buscar");
			buscar.setBounds(485,124,110,24);
			buscar.setFont(new Font("Arial", Font.BOLD, 12));
			buscar.setForeground(Color.BLACK); 
			buscar.addActionListener(this);
			getContentPane().add(buscar);
			
			modificar = new JButton("Modificar");
			modificar.setBounds(485,170,110,24);
			modificar.setEnabled(false);
			modificar.setFont(new Font("Arial", Font.BOLD, 12));
			modificar.setForeground(Color.BLACK);  
			modificar.addActionListener(this);
			getContentPane().add(modificar);
			
			borrar = new JButton("Borrar");
			borrar.setBounds(485,216,110,24);
			borrar.setEnabled(false);
			borrar.setFont(new Font("Arial", Font.BOLD, 12));
			borrar.setForeground(Color.BLACK);
			borrar.addActionListener(this);
			getContentPane().add(borrar);
			
			button2=new JButton("Volver");
			button2.setBounds(12,341,110,24);
			button2.setFont(new Font("Arial", Font.BOLD, 12));
			button2.setForeground(Color.BLACK);  
			button2.addActionListener(this);
			getContentPane().add(button2);
			
			ImageIcon imagen =  new ImageIcon(getClass().getResource("fondo resto.jpeg"));  //para obtener una imagen en un label
			label1 = new JLabel(imagen);  //para asignnarle una imagen a un label.
			label1.setBounds(0,0,692,378);
			getContentPane().add(label1);
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
				this.setVisible(true);
				
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

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == button2) 
			{
				VentanaPedido pedido = new VentanaPedido(rico);
				pedido.setVisible(true);
				//JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);///cambiar a otra ventana desde otro jpanel
				this.setVisible(false);
			}
			if(e.getSource() == buscar)
			{
					String usuario = textField.getText();
					Empleado buscado = rico.buscarEmpleado(usuario);
					if(buscado.getNombre().equalsIgnoreCase(usuario)) {
					textField2.setText(buscado.getPosicion());
					textField3.setText(buscado.getDireccion());
					textField4.setText(buscado.getTelefono().toString());
					activarTextfields();
					modificar.setEnabled(true);
					borrar.setEnabled(true);
						}else {
							JOptionPane.showMessageDialog(null, "El empleado no existe");
							int valor = JOptionPane.showConfirmDialog(this, "Desea Crear uno nuevo?","ADVERTENCIA"
									,JOptionPane.YES_NO_OPTION);
							if(valor == JOptionPane.YES_OPTION) {
								activarTextfields();
								button.setEnabled(true);
								label5.setVisible(true);
								textField5.setVisible(true);
							}
					} 
			}
			if(e.getSource()== modificar)
			{
				String usuario = textField.getText();
				Comercio rico;
					int valor = JOptionPane.showConfirmDialog(this, "Desea modificar?","ADVERTENCIA"
							,JOptionPane.YES_NO_OPTION);
					if(valor == JOptionPane.YES_OPTION) {
						rico = new Comercio();
						Empleado buscado = rico.buscarEmpleado(usuario);
						String nuevaPosicion,nuevaDireccion,nuevoTel;
						nuevaPosicion = textField2.getText();
						nuevaDireccion = textField3.getText();
						nuevoTel = textField4.getText();
						if(!buscado.getPosicion().equalsIgnoreCase(nuevaPosicion))
						{
							nuevaPosicion = textField2.getText();
							buscado.setPosicion(nuevaPosicion);
						}
						if(!buscado.getDireccion().equalsIgnoreCase(nuevaDireccion))
						{
							nuevaDireccion = textField3.getText();
							buscado.setDireccion(nuevaDireccion);
						}
						if(!buscado.getTelefono().equalsIgnoreCase(nuevoTel))
						{
							nuevoTel = textField4.getText();
							buscado.setTelefono(nuevoTel);
						}
						rico.modificarPersona(buscado, "empleados");  //TODO HAY QUE HACER METODO MODIFICAR
						JOptionPane.showMessageDialog(null, "Empleado Modificado");
						VentanaPedido pedido = new VentanaPedido(rico);
						pedido.setVisible(true);
						//JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);///cambiar a otra ventana desde otro jpanel
						this.setVisible(false);
					}
			}
			if(e.getSource()==borrar)
			{
				String usuario = textField.getText();
				Comercio rico;
				try {
					int valor = JOptionPane.showConfirmDialog(this, "Desea modificar?","ADVERTENCIA"
							,JOptionPane.YES_NO_OPTION);
					if(valor == JOptionPane.YES_OPTION) {
						rico = new Comercio();
						JSONObject buscado = rico.buscarPersona(usuario,"empleados");
						rico.removePersonas(buscado, "empleados");
						JOptionPane.showMessageDialog(null, "Empleado Borrado");
						VentanaPedido pedido = new VentanaPedido(rico);
						pedido.setVisible(true);
						//JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);///cambiar a otra ventana desde otro jpanel
						this.setVisible(false);
					}
				}catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
			if(e.getSource()==button)
			{
				String nombre,direccion,telefono,posicion,password;
				nombre = textField.getText();
				posicion = textField2.getText();
				direccion = textField3.getText();
				telefono = textField4.getText();
				password = textField5.getText();
				Persona nuevo = new Empleado(nombre, direccion, telefono, password, posicion);
				try {
					Comercio rico = new Comercio();
					rico.addPersonas(nuevo);
					JOptionPane.showMessageDialog(null,"Agregado con Exito");
					VentanaPedido pedido = new VentanaPedido(rico);
					pedido.setVisible(true);
					//JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);///cambiar a otra ventana desde otro jpanel
					this.setVisible(false);
				} catch (JSONException e1) {
					e1.printStackTrace();
				}
			}
		}	
		
		public void activarTextfields()
		{
			textField2.setEnabled(true);
			textField3.setEnabled(true);
			textField4.setEnabled(true);	
		}

}
