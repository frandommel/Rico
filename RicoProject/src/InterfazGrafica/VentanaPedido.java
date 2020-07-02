package InterfazGrafica;


import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Archivos.ArchivoProducto;
import Archivos.ManejadordeArchivos;
import GestionComercio.ClienteVip;
import GestionComercio.Empleado;
import GestionComercio.ListadoPedidos;
import GestionComercio.Comercio;
import GestionComercio.Pedido;

import javax.swing.JButton;

public class VentanaPedido extends JFrame implements ActionListener{

	private JPanel contentPane, h,p,combo,ensaladas,bebidas,guarnicion;
	private JLabel label1, label2;
	private JButton hamButton, panchButton, guarnButton, bebButton, comboButton, ensaladaButton;
	private JMenuBar menuBar;
	private JMenuItem registroItem,menuEmpleado,menuProducto,menuCliente,pedidosItem, menuPedido;
	private JMenu menuRegistro,menu;
	private Inicio inicio;
	private String nombre;
	private Comercio rico;
	private Venta ventas;
	private PedidosActivos pedidosActivos;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedido frame = new Pedido(rico);
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
	public VentanaPedido(Comercio comercio) {
		rico = comercio;
		pedidosActivos = new PedidosActivos(rico);
		ventas = new Venta(rico,pedidosActivos);
		initComponents();
	}		
	
	/**
	 * Metodo para iniciar los componentes de la ventana.
	 */
	public void initComponents() {
		
		cerrar();
		inicio = new Inicio(rico);
		setBounds(0, 0, 1125, 743);
		setTitle("Pedido");
		this.setResizable(false);
		this.setLocationRelativeTo(null);      //la ventana se abre en el medio
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(201,80,27));
		contentPane.setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(new ImageIcon(getClass().getResource("descarga.jpg")).getImage());
		ingresarPaneles();
		crearMenuBar();
		
		hamButton = new JButton("HAMBURGUESA");
		hamButton.setBounds(275,442,205,67);
		hamButton.setIcon(new ImageIcon(VentanaPedido.class.getResource("/InterfazGrafica/iconoHamb.png")));
		hamButton.addActionListener(this);
		getContentPane().add(hamButton);
		
		panchButton = new JButton("PANCHO");
		panchButton.setBounds(58,602,205,67);
		panchButton.setIcon(new ImageIcon(VentanaPedido.class.getResource("/InterfazGrafica/iconoPancho.png")));
		panchButton.addActionListener(this);
		getContentPane().add(panchButton);
		
		guarnButton = new JButton("GUARNICION");
		guarnButton.setBounds(275,522,205,67);
		guarnButton.setIcon(new ImageIcon(VentanaPedido.class.getResource("/InterfazGrafica/iconoGuarnicion.png")));
		guarnButton.addActionListener(this);
		getContentPane().add(guarnButton);
		
		bebButton = new JButton("BEBIDA");
		bebButton.setBounds(58,442,205,67);
		bebButton.setIcon(new ImageIcon(VentanaPedido.class.getResource("iconoBebida.png")));
		bebButton.addActionListener(this);
		getContentPane().add(bebButton);
		
		comboButton = new JButton("COMBO");
		comboButton.setBounds(58,522,205,67);
		comboButton.setIcon(new ImageIcon(VentanaPedido.class.getResource("/InterfazGrafica/iconoCombo.png")));
		comboButton.addActionListener(this);
		getContentPane().add(comboButton);
		
		ensaladaButton = new JButton("ENSALADA");
		ensaladaButton.setBounds(275,602,205,67);
		ensaladaButton.setIcon(new ImageIcon(VentanaPedido.class.getResource("iconoEnsalada.png")));
		ensaladaButton.addActionListener(this);
		getContentPane().add(ensaladaButton);
		
		
		//*ESTO SIEMPRE A LO ULTIMO*//
		ImageIcon imagen =  new ImageIcon(getClass().getResource("fondo pedidos grande.jpg"));  //para obtener una imagen en un label
		label1 = new JLabel(imagen);  //para asignarle una imagen a un label.
		label1.setBounds(0,0,1660,740);
		getContentPane().add(label1);	


	}
	/**
	 * @param Se le pasa el Action Event para saber donde tiene que escuchar el ActionListener	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== hamButton) {
			h.setVisible(true);
			p.setVisible(false);
			combo.setVisible(false);
			ensaladas.setVisible(false);
			bebidas.setVisible(false);
			guarnicion.setVisible(false);
		}
		if(e.getSource()==panchButton) {
			h.setVisible(false);
			p.setVisible(true);
			combo.setVisible(false);
			ensaladas.setVisible(false);
			bebidas.setVisible(false);
			guarnicion.setVisible(false);
		}
		if(e.getSource()==ensaladaButton) {
			h.setVisible(false);
			p.setVisible(false);
			combo.setVisible(false);
			ensaladas.setVisible(true);
			bebidas.setVisible(false);
			guarnicion.setVisible(false);
		}
		if(e.getSource()==bebButton) {
			h.setVisible(false);
			p.setVisible(false);
			combo.setVisible(false);
			ensaladas.setVisible(false);
			bebidas.setVisible(true);
			guarnicion.setVisible(false);
		}
		if(e.getSource()==comboButton) {
			h.setVisible(false);
			p.setVisible(false);
			combo.setVisible(true);
			ensaladas.setVisible(false);
			bebidas.setVisible(false);
			guarnicion.setVisible(false);
		}
		if(e.getSource()==guarnButton) {
			h.setVisible(false);
			p.setVisible(false);
			combo.setVisible(false);
			ensaladas.setVisible(false);
			bebidas.setVisible(false);
			guarnicion.setVisible(true);
		}
		if(e.getSource()== menuCliente) {
			Cliente alta = new Cliente(rico);
			alta.setVisible(true);
			dispose();
		}
		if(e.getSource()==menuEmpleado) {
			Empleados empleados = new Empleados(rico);
			empleados.setVisible(true);
			dispose();
		}
		if(e.getSource()==menuProducto) {
			Productos productos = new Productos(rico);
			productos.setVisible(true);
			dispose();
		}
		if(e.getSource()==menuPedido) {
			DetallePedidos detalle = new DetallePedidos(rico);
			detalle.setVisible(true);
			dispose();
		}
		if(e.getSource()==registroItem) {
		       Document documento = new Document();
		       HashMap<String, Empleado> empleados = new HashMap<String, Empleado>();
		       HashMap<String, ClienteVip> clientes = new HashMap<String, ClienteVip>();
		        try {
		            String ruta = System.getProperty("user.home");   //para obtener la ruta de nuestro usuario en nuestra pc
		            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "\\Desktop\\Registro_Rico_Personas.pdf"));     //para crear el reporte y indicarle donde se va a guardar y como se va a llamar el mismo
		            
		           // ImageIcon icono = new ImageIcon(Menu.class.getResource("/paquete/rico.jpeg"));
		           // icono.scaleToFit(650, 1000);            //para darle dimension a la imagen
		           // icono.setAlignment(Chunk.ALIGN_CENTER);                   //metodo para alinear nuestra imagen
		            

		            Paragraph parrafo = new Paragraph();
		            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		            parrafo.add("Rico Mangment \n\n");
		            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));
		            parrafo.add("Registros de Personas: \n\n");
		            
		            
		            Paragraph parrafo2 = new Paragraph();

		            parrafo2.add("\n\n");
		            parrafo2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));
		            parrafo2.add("Empleados: \n\n");
		            
		            
			        PdfPTable tablaEmpleado = new PdfPTable(3);           //para crear la tabla por parametro le pasas la cantidad de columnas que va a tener el reporte
			        tablaEmpleado.addCell("NOMBRE Y APELLIDO");                       
			        tablaEmpleado.addCell("DIRECCION");
			        tablaEmpleado.addCell("TELEFONO");
			        
			        try {
						empleados = rico.getArchivos().getListadoEmpleados();
						
					} catch (JSONException e1) {
						e1.printStackTrace();
					}
			        Set<Entry<String,Empleado>> set = empleados.entrySet();
			        Iterator it = set.iterator();
			        
			        while(it.hasNext()) 
			        {
			        	Entry<String,Empleado> entry = (Entry<String,Empleado>) it.next();
			        	tablaEmpleado.addCell(entry.getValue().getNombre());
			        	tablaEmpleado.addCell(entry.getValue().getDireccion());
			        	tablaEmpleado.addCell(entry.getValue().getTelefono());
			        }
			        
			        PdfPTable tablaCliente = new PdfPTable(3);   
			        tablaCliente.addCell("NOMBRE Y APELLIDO");                       
			        tablaCliente.addCell("DIRECCION");
			        tablaCliente.addCell("TELEFONO");
			        
			        try {
								clientes = rico.getArchivos().getListadoCliente();
								
						} catch (JSONException e1) {
							e1.printStackTrace();
						}
			        
			        Set<Entry<String,ClienteVip>> setC = clientes.entrySet();
			        Iterator itC = setC.iterator();
			        
			        while(itC.hasNext()) 
			        {
			        	Entry<String,ClienteVip> entryC = (Entry<String,ClienteVip>) itC.next();
			        	tablaCliente.addCell(entryC.getValue().getNombre());
			        	tablaCliente.addCell(entryC.getValue().getDireccion());
			        	tablaCliente.addCell(entryC.getValue().getTelefono());
			        }
							

		            Paragraph parrafo3 = new Paragraph();
		            parrafo3.add("\n\n");
		            parrafo3.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));
		            parrafo3.add("Clientes Vip: \n\n");

		            Paragraph parrafo4 = new Paragraph();
		            Date fecha = new Date();
		            parrafo4.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));
		            parrafo4.setAlignment(Paragraph.ALIGN_RIGHT);
		            parrafo4.add("\n\n\n");
		            parrafo4.add("Registro creado el:" + fecha.toString());
		               
		            documento.open();     
		            documento.add(parrafo);
		            documento.add(parrafo2);
		            documento.add(tablaEmpleado);
		            documento.add(parrafo3);
		            documento.add(tablaCliente);
		            documento.add(parrafo4);

		          
		            documento.close();
		            JOptionPane.showMessageDialog(null, "Reporte creado en su escritorio");
		            
		            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + ruta + "\\Desktop\\Registro_Rico_Personas.pdf");  ///abrimos el pdf automaticamente
 
		        } catch (DocumentException | HeadlessException | FileNotFoundException b) {
		        		b.printStackTrace();
		        } catch (IOException a) {
		        		a.printStackTrace();
		        } 
		}
		if(e.getSource()==pedidosItem) {
		       Document documento = new Document();
		       HashMap<String, ArrayList<Pedido>> listadoHash = new HashMap<String, ArrayList<Pedido>>();
		        try {
		            String ruta = System.getProperty("user.home");   //para obtener la ruta de nuestro usuario en nuestra pc
		            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "\\Desktop\\Registro_Rico_Pedidos.pdf"));     //para crear el reporte y indicarle donde se va a guardar y como se va a llamar el mismo
		        
		            Paragraph parrafo = new Paragraph();
		            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
		            parrafo.add("RICO REGISTRO DE PEDIDOS \n\n");
		            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.BLACK));
		       
		            documento.open();     
		            
		            documento.add(parrafo);
		           
		           PdfPTable tabla = new PdfPTable(3);           //para crear la tabla por parametro le pasas la cantidad de columnas que va a tener el reporte
		           tabla.addCell("Fecha");
		           tabla.addCell("Codigo");                            
		           tabla.addCell("Monto Total");
		           
		           PdfPTable tablaPedido = new PdfPTable(3);  
		           ListadoPedidos listado = rico.getArchivos().getListadoPedidos();
		           listadoHash = listado.getListaPedidosContenedorMap();
		           
			        Set<Entry<String,ArrayList<Pedido>>> set = listadoHash.entrySet();
			        Iterator it = set.iterator();
			        while(it.hasNext()) 
			        {
			        	Entry<String,ArrayList<Pedido>> entry = (Entry<String,ArrayList<Pedido>>) it.next();
			        	for(int i=0; i<entry.getValue().size(); i++) {
			        		tablaPedido.addCell(entry.getValue().get(i).getFecha());
			        	   	tablaPedido.addCell(String.valueOf(entry.getValue().get(i).getId()));
			        		tablaPedido.addCell("$  "+ String.valueOf(entry.getValue().get(i).getMontoVenta()));
			        	}
			        }
		           
		            Paragraph parrafo4 = new Paragraph();
		            Date fecha = new Date();
		            parrafo4.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD, BaseColor.BLACK));
		            parrafo4.setAlignment(Paragraph.ALIGN_RIGHT);
		            parrafo4.add("\n\n\n");
		            parrafo4.add("Registro creado el:" + fecha.toString());
		    
		          
		            documento.add(tabla);
		            documento.add(tablaPedido);
		            documento.add(parrafo4);
		            
		            documento.close();
		            JOptionPane.showMessageDialog(null, "Reporte creado en su escritorio");
		            
		            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + ruta + "\\Desktop\\Registro_Rico_Pedidos.pdf");  ///abrimos el pdf automaticamente
 
		        } catch (DocumentException | HeadlessException | FileNotFoundException b) {
		        		b.printStackTrace();
		        } catch (IOException a) {
		        		a.printStackTrace();
		        } 
		}
	}
	
	/**
	 * Se creaon los diferentes tipos de panales de los botones de los productos.
	 */
	public void ingresarPaneles() { //Creacion paneles 
		h = new Hamburguesa(rico,ventas);
		p =new Pancho(rico,ventas);
		combo = new Combos(rico,ventas);
		ensaladas = new Ensaladas(rico,ventas);
		bebidas = new Bebidas(rico,ventas);
		guarnicion = new Guarnicion(rico,ventas);
		
		
		getContentPane().add(pedidosActivos);
		getContentPane().add(h);
		getContentPane().add(p);
		getContentPane().add(combo);
		getContentPane().add(ensaladas);
		getContentPane().add(bebidas);
		getContentPane().add(guarnicion);
		getContentPane().add(ventas);
	}
	
	public void crearMenuBar() {
		menuBar=new JMenuBar();
		menuBar.setBackground(SystemColor.menu);
		menuBar.setBounds(0, 0, 1660, 24);
		getContentPane().add(menuBar);
		
		menu = new JMenu("Menu Principal");
		menu.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuBar.add(menu);
		
		menuCliente= new JMenuItem("Clientes");
		menuCliente.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuCliente.addActionListener(this);
		menu.add(menuCliente);
		
		menuEmpleado = new JMenuItem("Empleados");
		menuEmpleado.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuEmpleado.addActionListener(this);
		menu.add(menuEmpleado);
			
		menuProducto = new JMenuItem("Productos");
		menuProducto.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuProducto.addActionListener(this);
		menu.add(menuProducto);
		
		menuPedido = new JMenuItem("Buscar Pedidos");
		menuPedido.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuPedido.addActionListener(this);
		menu.add(menuPedido);
		
		menuRegistro = new JMenu("Registro");
		menuRegistro.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuRegistro.addActionListener(this);
		menu.add(menuRegistro);
		
		registroItem = new JMenuItem("Generar PDF personas");
		registroItem.addActionListener(this);
		registroItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuRegistro.add(registroItem);
		
		pedidosItem = new JMenuItem("Generar PDF Pedidos");
		pedidosItem.addActionListener(this);
		pedidosItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
		menuRegistro.add(pedidosItem);
	}

	/**
	 * Validamos el cierre de la aplicacion para mayor seguridad
	 */
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
	/**
	 * Confirmacion de salida de la aplicacion
	 */
	public void confirmarSalida()
	{
		int valor = JOptionPane.showConfirmDialog(this, "Estas seguro de cerrar la aplicacion","ADVERTENCIA"
													,JOptionPane.YES_NO_OPTION);
		if(valor == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}	
}
