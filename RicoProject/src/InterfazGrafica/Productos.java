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
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import Archivos.ArchivoPedidos;
import Archivos.ArchivoProducto;
import GestionComercio.Comercio;
import claseProductos.Bebida;
import claseProductos.Producto;

public class Productos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label1,label,label2,label5,tipoLabel;
	private JTextField textField,textField2;
	private JButton button2,modificar,buscar;
	private JComboBox<String> comboBox,comboItemBox,comboItemHamb, comboItemPancho,comboItemEnsalada,comboItemGuarnicion,comboItemBebida;
	private Comercio rico;
	

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
	}
	
	public void initComponents() {
		cerrar();
		setBounds(0, 0, 698, 409);
		setTitle("Productos");
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
		  label.setBounds(102,109,80,16);
		  label.setFont(new Font("Andale Mono",1,18));
		  label.setForeground(new Color(255,255,255));
		  getContentPane().add(label);
			
		  label2 = new JLabel("Precio");
		  label2.setBounds(102,146,80,16);
			label2.setFont(new Font("Andale Mono",1,18));
			label2.setForeground(new Color(255,255,255));  
			getContentPane().add(label2);
			
			textField2 = new JTextField();
			textField2.setBounds(204, 143, 177, 24);
			textField2.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(textField2);
			
			agregarComboListaProductos();
			agregarItemsTipoCombo();
			
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
			ArchivoProducto p = new ArchivoProducto();
			if(e.getSource() == button2) 
			{
				VentanaPedido pedido = new VentanaPedido(rico);
				pedido.setVisible(true);
				dispose();
			}
			if(e.getSource()==comboBox) {
				quitarCombo();
				quitarNombreTipoCombo();
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
					if(comboItemHamb.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemHamb);
					}
				}
				if (comparado=="Pancho") {
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerPancho();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(true);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					if(comboItemPancho.getItemCount() == 0) 
					{
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemPancho);
					}
				}
				if (comparado=="Ensalada") {
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerEnsalada();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(true);
					comboItemGuarnicion.setVisible(false);
					if(comboItemEnsalada.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemEnsalada);
					}
				}
				if(comparado=="Bebida") {
					comboItemBebida.removeAll();
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					productos = p.leerBebida();
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(true);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					if(comboItemBebida.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemBebida);
					}
				}
				if(comparado == "Combo") {
					label5.setVisible(true);
					comboItemBox.setVisible(true);
				}
			}
			if(e.getSource()==comboItemBox)
			{
				String comparado = (String)comboItemBox.getSelectedItem();
				if(comparado=="Hamburguesa")
				{
					comboItemHamb.setVisible(true);		
					comboItemPancho.setVisible(false);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					
				}
				if(comparado=="Pancho")
				{
					comboItemHamb.setVisible(false);		
					comboItemPancho.setVisible(true);
					comboItemBebida.setVisible(false);
					comboItemEnsalada.setVisible(false);
					comboItemGuarnicion.setVisible(false);
					
				}
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
				}
			}
		}
		
		
		
		public void quitarCombo() {
			label5.setVisible(false);
			comboItemBox.setVisible(false);
		}
		public void quitarNombreTipoCombo() {
			comboItemHamb.setVisible(false);
		}
		
		public void agregarComboListaProductos() {
			label5 =new JLabel("Tipo");
			label5.setBounds(102,72,84,16);
			label5.setVisible(false);
			label5.setFont(new Font("Andale Mono",1,18));
			label5.setForeground(new Color(255,255,255));  
			getContentPane().add(label5);
			ArrayList<String> listaProducto = new ArrayList<String>();
			comboItemBox=new JComboBox<String>();
			comboItemBox.setBounds(204, 69, 177, 24);
			comboItemBox.setVisible(false);
			comboItemBox.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemBox);
			listaProducto.add("Hamburguesa");
			listaProducto.add("Pancho");
			moverArray2Combo(listaProducto, comboItemBox);
			comboItemBox.addActionListener(this);
		}
		
		public void agregarItemsTipoCombo()
		{
			ArchivoProducto p = new ArchivoProducto();
			
			comboItemHamb=new JComboBox<String>();
			comboItemHamb.setBounds(204, 106, 177, 24);
			comboItemHamb.setVisible(false);
			comboItemHamb.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemHamb);
			comboItemHamb.addActionListener(this);
			
			comboItemPancho=new JComboBox<String>();
			comboItemPancho.setBounds(204, 106, 177, 24);
			comboItemPancho.setVisible(false);
			comboItemPancho.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemPancho);

			comboItemPancho.addActionListener(this);
			
			comboItemEnsalada = new JComboBox<String>();
			comboItemEnsalada.setBounds(204, 106, 177, 24);
			comboItemEnsalada.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemEnsalada);
			comboItemEnsalada.addActionListener(this);
			
			comboItemBebida = new JComboBox<String>();
			comboItemBebida.setBounds(204, 106, 177, 24);
			comboItemBebida.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemBebida);
			comboItemBebida.addActionListener(this);
			
			comboItemGuarnicion = new JComboBox<String>();
			comboItemGuarnicion.setBounds(204, 106, 177, 24);
			comboItemGuarnicion.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemGuarnicion);
			comboItemGuarnicion.addActionListener(this);
			
		}
		
		public void agregarItem(JComboBox<String> listaItem,String item) {
			listaItem.addItem(item);
		}
		
		public void moverArray2Combo(ArrayList<String>listaItem,JComboBox<String> combo) {
			String item="";
			for(int i=0;i<listaItem.size();i++) {
				item=listaItem.get(i);
				agregarItem(combo, item);
			}
		}
		
		public ArrayList<String> pasar2ListaString(ArrayList<Producto>p){
			ArrayList<String>listaProd=new ArrayList<String>();
			for (int i = 0; i < p.size(); i++) {
				if(p.get(i) instanceof Bebida && p.get(i).getNombre().equalsIgnoreCase("Cerveza")){
					Bebida b = (Bebida) p.get(i);
					String nombre = b.getMarca();
					listaProd.add(nombre);
				}else {
					String nombre = p.get(i).getNombre();
					listaProd.add(nombre);
				}
			}
			return listaProd;
		}
		
		public int precioFromArchivo(ArrayList<Producto> p, String producto) {
			
			int buscado=0;
			for (int i = 0; i < p.size(); i++) {
				if(p.get(i).getNombre().equalsIgnoreCase(producto)) {
					buscado= p.get(i).getPrecio();
				}
			}
			
			return buscado;
		}
}
