package InterfazGrafica;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import Archivos.ArchivoPedidos;
import Archivos.ArchivoProducto;
import GestionComercio.ClienteVip;
import GestionComercio.Comercio;
import claseProductos.Bebida;
import claseProductos.Producto;

public class Productos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label1,label,label2,tipoLabel;
	private JTextField textField2;
	private JButton button2,modificar,buscar;
	private JComboBox<String> comboBox,comboItemHamb, comboItemPancho,comboItemEnsalada,comboItemGuarnicion,comboItemBebida,comboItemCombos;
	private Comercio rico;
	private String nombre, claveValor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
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
	public Productos(Comercio comercio) {
		rico = comercio;
		initComponents();
		nombre = "";
		claveValor="";
	}
	/**
	 * Inicio los componentes
	 */
	public void initComponents() {
		cerrar();
		setBounds(0, 0, 698, 409);
		setTitle("Productos");
		this.setResizable(false);
		this.setLocationRelativeTo(null);//la ventana se abre en el medio
		iniciarJpanel();
		setIconImage(new ImageIcon(getClass().getResource("descarga.jpg")).getImage());	
	}
	
	/**
	 * Inicio el Jpanel de productos
	 */
	public void iniciarJpanel() {
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 689, 378);
		contentPane.setBackground(new Color(241,98,63));
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		setContentPane(contentPane);
		
		tipoLabel = new JLabel("Producto");
		tipoLabel.setBounds(102, 32, 80, 16);
		tipoLabel.setFont(new Font("Andale Mono",1,18));
		tipoLabel.setForeground(new Color(255,255,255));  
		getContentPane().add(tipoLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(204, 32, 177, 24);
		comboBox.setFont(new Font("Andale Mono",1,14));
		comboBox.addItem("Hamburguesa");
		comboBox.addItem("Pancho");
		comboBox.addItem("Combo");
		comboBox.addItem("Guarnicion");
		comboBox.addItem("Ensalada");
		comboBox.addItem("Bebida");
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		
		label=new JLabel("Nombre");
		  label.setBounds(102,72,80,16);
		  label.setFont(new Font("Andale Mono",1,18));
		  label.setForeground(new Color(255,255,255));
		  getContentPane().add(label);
			
		  label2 = new JLabel("Precio");
		  label2.setBounds(102,109,80,16);
			label2.setFont(new Font("Andale Mono",1,18));
			label2.setForeground(new Color(255,255,255));  
			getContentPane().add(label2);
			
			textField2 = new JTextField();
			textField2.setBounds(204, 106, 177, 24);
			textField2.setFont(new Font("Andale Mono",1,14));
			textField2.setEnabled(false);
			getContentPane().add(textField2);
			
			agregarComboListaProductos();
			agregarItemsTipoCombo();
			
			buscar = new JButton("Modificar");
			buscar.setBounds(485,124,110,24);
			buscar.setFont(new Font("Arial", Font.BOLD, 12));
			buscar.setForeground(Color.BLACK); 
			buscar.addActionListener(this);
			getContentPane().add(buscar);
			
			modificar = new JButton("Guardar");
			modificar.setBounds(485,170,110,24);
			modificar.setEnabled(false);
			modificar.setFont(new Font("Arial", Font.BOLD, 12));
			modificar.setForeground(Color.BLACK);  
			modificar.addActionListener(this);
			getContentPane().add(modificar);
			
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
	
	/**
	 * Cierre de la aplicacion
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
		 * Validacion para salir de la aplicacion
		 */
		public void confirmarSalida()
		{
			int valor = JOptionPane.showConfirmDialog(this, "Estas seguro de cerrar la aplicacion","ADVERTENCIA"
														,JOptionPane.YES_NO_OPTION);
			if(valor == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}
		/**
		 * @param AtionEvent
		 * Metodo que se utiliza para el manejo de las interacciones de la interfaz
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			ArchivoProducto p = new ArchivoProducto();
			if(e.getSource() == button2) 
			{
				VentanaPedido pedido = new VentanaPedido(rico);
				pedido.setVisible(true);
				this.setVisible(false);
			}
			if(e.getSource()==comboBox) {
				String comparado = (String)comboBox.getSelectedItem();
				if(comparado=="Hamburguesa") {
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerHamburguesa();
					comboItemHamb.setVisible(true);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					comboItemCombos.setVisible(false);
					if(comboItemHamb.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemHamb);
					}
				}
				if (comparado.equals("Pancho")) {
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerPancho();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(true);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					comboItemCombos.setVisible(false);
					if(comboItemPancho.getItemCount() == 0) 
					{
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemPancho);
					}
				}
				if (comparado.equals("Ensalada")) {
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerEnsalada();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(true);
					comboItemGuarnicion.setVisible(false);
					comboItemCombos.setVisible(false);
					if(comboItemEnsalada.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemEnsalada);
					}
				}
				if(comparado.equals("Bebida")) {
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerBebida();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(true);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					comboItemCombos.setVisible(false);
					if(comboItemBebida.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemBebida);
					}
				}
				if(comparado.equals("Guarnicion")) {
					comboItemGuarnicion.removeAll();
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerGuarnicion();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(true);
					comboItemCombos.setVisible(false);
					if(comboItemGuarnicion.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemGuarnicion);
					}
				}
				if(comparado.equals("Combo")) {
					comboItemCombos.removeAll();
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerCombo();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					comboItemCombos.setVisible(true);
					if(comboItemCombos.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemCombos);
					}
				}
				claveValor= comparado;
			}
			if(e.getSource()==comboItemEnsalada) {
				String comparado2 = (String)comboItemEnsalada.getSelectedItem();
				if(comparado2.equals("Ukelele"))
				{
					String string = comparado2;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerEnsalada();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado2.equals("Aloha")) {
					String string = comparado2;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerEnsalada();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado2.equals("Hula Hula")) {
					String string = comparado2;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerEnsalada();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
			}
			if(e.getSource()==comboItemHamb) {
				String comparado3 = (String)comboItemHamb.getSelectedItem();
				if(comparado3.equals("Kelly"))
				{
					String string = comparado3;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerHamburguesa();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado3.equals("Doble queso")) {
					String string = comparado3;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerHamburguesa();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado3.equalsIgnoreCase("Big Wave")) {
					String string = comparado3;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerHamburguesa();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado3.equals("Jeremy")) {
					String string = comparado3;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerHamburguesa();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado3.equals("Veggie")) {
					String string = comparado3;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerHamburguesa();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado3.equals("Doble carne Doble queso")) {
					String string = comparado3;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerHamburguesa();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
			}
			if(e.getSource()==comboItemPancho) {
				String comparado4 = (String)comboItemPancho.getSelectedItem();
				if(comparado4.equals("Rico"))
				{
					String string = comparado4;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerPancho();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado4.equals("Pancho")) {
					String string = comparado4;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerPancho();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado4.equals("Rookie")) {
					String string = comparado4;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerPancho();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado4.equals("Veggie")) {
					String string = comparado4;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerPancho();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
			}
			if(e.getSource()==comboItemGuarnicion) 
			 {
				String comparado5 = (String)comboItemGuarnicion.getSelectedItem();
				if (comparado5.equals("Nuggets")) {
					String string = comparado5;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerGuarnicion();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado5.equals("Papas Fritas")) {
					String string = comparado5;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerGuarnicion();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado5.equals("Papas Rico")) {
					String string = comparado5;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerGuarnicion();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
			}
			if(e.getSource()==comboItemBebida) 
			 {
				String comparado6 = (String)comboItemBebida.getSelectedItem();
				if (comparado6.equals("Gaseosa 237cc")) {
					String string = comparado6;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerBebida();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado6.equals("Gaseosa 500cc")) {
					String string = comparado6;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerBebida();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado6.equals("Limonada")) {
					String string = comparado6;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerBebida();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado6.equals("Corona")) {
					String string = comparado6;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerBebida();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado6.equals("Patagonia")) {
					String string = comparado6;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerBebida();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparado6.equals("Stella Artois")) {
					String string = comparado6;
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos=p.leerBebida();
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
			}
			if(e.getSource()==comboItemCombos) {
				String comparadoCombo = (String)comboItemCombos.getSelectedItem();
				ArrayList<Producto> productos = new ArrayList<Producto>();
				productos=p.leerCombo();
				if(comparadoCombo.contains("Rico"))
				{
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Pancho")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Rookie")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Veggie")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if(comparadoCombo.contains("Kelly"))
				{
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Doble Queso")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Big Wave")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Jeremy")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Veggie")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				if (comparadoCombo.contains("Doble carne Doble queso")) {
					String string = comparadoCombo;
					int precio =precioFromArchivo(productos, string);
					textField2.setText(String.valueOf(precio));
					nombre=string;
				}
				
			}
			if(e.getSource()==buscar) {
				textField2.setEnabled(true);
				modificar.setEnabled(true);
			}
			if(e.getSource()== modificar)
			{
				System.out.println("clave: "+claveValor + "nombre: "+nombre);
					Producto producto = rico.leerProducto(claveValor, nombre);
					int valor = JOptionPane.showConfirmDialog(this, "Desea modificar?","ADVERTENCIA"
							,JOptionPane.YES_NO_OPTION);
					if(valor == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "Precio Modificado");
						VentanaPedido pedido = new VentanaPedido(rico);
						pedido.setVisible(true);
						dispose();
						rico.modificarProducto(producto, textField2.getText());
					}
					
			}
		}
		
		/**
		 * Agrego como a la lista de productos
		 */
		public void agregarComboListaProductos() {
			ArrayList<String> listaProducto = new ArrayList<String>();
			listaProducto.add("Hamburguesa");
			listaProducto.add("Pancho");
		}
		
		/**
		 * Agrego item tipo combo
		 */
		public void agregarItemsTipoCombo()
		{
			ArchivoProducto p = new ArchivoProducto();
			
			comboItemHamb=new JComboBox<String>();
			comboItemHamb.setBounds(204, 69, 177, 24);
			comboItemHamb.setVisible(false);
			comboItemHamb.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemHamb);
			comboItemHamb.addActionListener(this);
			
			comboItemPancho=new JComboBox<String>();
			comboItemPancho.setBounds(204, 69, 177, 24);
			comboItemPancho.setVisible(false);
			comboItemPancho.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemPancho);

			comboItemPancho.addActionListener(this);
			
			comboItemEnsalada = new JComboBox<String>();
			comboItemEnsalada.setBounds(204, 69, 177, 24);
			comboItemEnsalada.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemEnsalada);
			comboItemEnsalada.addActionListener(this);
			
			comboItemBebida = new JComboBox<String>();
			comboItemBebida.setBounds(204, 69, 177, 24);
			comboItemBebida.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemBebida);
			comboItemBebida.addActionListener(this);
			
			comboItemGuarnicion = new JComboBox<String>();
			comboItemGuarnicion.setBounds(204, 69, 177, 24);
			comboItemGuarnicion.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemGuarnicion);
			comboItemGuarnicion.addActionListener(this);
			
			comboItemCombos=new JComboBox<String>();
			comboItemCombos.setBounds(204, 69, 177, 24);
			comboItemCombos.setVisible(false);
			comboItemCombos.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemCombos);
			comboItemCombos.addActionListener(this);
		}
		
		/**
		 * 
		 * @param JComboBox<String>
		 * @param String
		 */
		public void agregarItem(JComboBox<String> listaItem,String item) {
			listaItem.addItem(item);
		}
		
		/**
		 * 
		 * @param ArrayList<String>
		 * @param JComboBox<String> c
		 */
		public void moverArray2Combo(ArrayList<String>listaItem,JComboBox<String> combo) {
			String item="";
			for(int i=0;i<listaItem.size();i++) {
				item=listaItem.get(i);
				agregarItem(combo, item);
			}
		}
		
		/**
		 * 
		 * @param ArrayList<Producto>
		 * @return ArrayList<String> 
		 */
		public ArrayList<String> pasar2ListaString(ArrayList<Producto>p){
			ArrayList<String>listaProd=new ArrayList<String>();
			for (int i = 0; i < p.size(); i++) {
				Producto producto = p.get(i);
				if(producto instanceof Bebida && producto.getNombre().equalsIgnoreCase("Cerveza")){
					Bebida b = (Bebida) producto;
					String nombre = b.getMarca();
					listaProd.add(nombre);
				}else {
					String nombre = p.get(i).getNombre();
					listaProd.add(nombre);
				}
			}
			return listaProd;
		}
		
		/**
		 * 
		 * @param ArrayList<Producto> 
		 * @param String
		 * @return int
		 */
		public int precioFromArchivo(ArrayList<Producto> p, String producto) {	
			int buscado=0;
			for (int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().equalsIgnoreCase(producto)) {
					buscado= p.get(i).getPrecio();
				}
				if(p.get(i).getNombre().equalsIgnoreCase("Cerveza")) {
					Bebida bebida = (Bebida) p.get(i);
					if(bebida.getMarca().equalsIgnoreCase(producto)) {
						buscado = bebida.getPrecio();
					}
				}
				if(p.get(i).getNombre().equalsIgnoreCase("Combo "+producto)) {
						buscado = p.get(i).getPrecio();
				}
			}
			return buscado;
		}
		
		
}
