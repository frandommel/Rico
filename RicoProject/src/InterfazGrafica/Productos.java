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
import claseProductos.Producto;

public class Productos extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel label1,label,label2,label3,label4,label5,tipoLabel,nombreProd;
	private JTextField textField,textField2,textField3,textField4;
	private JButton button,button2,modificar,buscar,borrar;
	private JComboBox<String> comboBox,comboItemBox,comboItemBox2, comboItemBox3;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Productos() {
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
		  label.setBounds(102,80,80,16);
		  label.setFont(new Font("Andale Mono",1,18));
		  label.setForeground(new Color(255,255,255));
		  getContentPane().add(label);
			
		  textField = new JTextField();
		  textField.setBounds(204, 76, 177, 24);
		  textField.setFont(new Font("Andale Mono",1,14));
		  getContentPane().add(textField);
			
		  label2 = new JLabel("Precio");
		  label2.setBounds(102,126,80,16);
			label2.setFont(new Font("Andale Mono",1,18));
			label2.setForeground(new Color(255,255,255));  
			getContentPane().add(label2);
			
			textField2 = new JTextField();
			textField2.setBounds(204, 122, 177, 24);
			textField2.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(textField2);
			
			label3 = new JLabel("Calorias");
			label3.setBounds(102,172,84,16);
			label3.setVisible(false);
			label3.setFont(new Font("Andale Mono",1,18));
			label3.setForeground(new Color(255,255,255));  
			getContentPane().add(label3);
			
			textField3 = new JTextField();
			textField3.setBounds(204, 168, 177, 24);
			textField3.setVisible(false);
			textField3.setFont(new Font("Andale Mono",1,18));
			getContentPane().add(textField3);
			
			label4 = new JLabel("Marca");
			label4.setBounds(102,172,84,16);
			label4.setVisible(false);
			label4.setFont(new Font("Andale Mono",1,18));
			label4.setForeground(new Color(255,255,255));  
			getContentPane().add(label4);
			
			textField4 = new JTextField();
			textField4.setBounds(204, 168, 177, 24);
			textField4.setVisible(false);
			textField4.setFont(new Font("Andale Mono",1,18));
			getContentPane().add(textField4);
			
			agregarComboListaProductos();
			agregarItemsTipoCombo();
			
			button=new JButton("Nuevo");
			button.setBounds(485,78,110,24);
			button.setFont(new Font("Arial", Font.BOLD, 12));
			button.setForeground(Color.BLACK); 
			button.addActionListener(this);
			button.setEnabled(false);
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
				Pedido pedido = new Pedido();
				pedido.setVisible(true);
				dispose();
			}
			if(e.getSource()==comboBox) {
				quitarCalorias();
				quitarMarca();
				quitarCombo();
				quitarNombreTipoCombo();
				String comparado = (String)comboBox.getSelectedItem();
				if(comparado=="Hamburguesa") {
				
				}
				if (comparado=="Pancho") {
					
				}
				if (comparado=="Ensalada") {
					label3.setVisible(true);
					textField3.setVisible(true);
				}
				if(comparado=="Bebida") {
					label4.setVisible(true);
					textField4.setVisible(true);
				}
				if(comparado == "Combo") {
					label5.setVisible(true);
					comboItemBox.setVisible(true);
				}
			}
			if(e.getSource()==comboItemBox)
			{
				String comparado = (String)comboItemBox.getSelectedItem();
				ArchivoProducto p = new ArchivoProducto();
			
			
				if(comparado=="Hamburguesa")
				{
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					nombreProd.setVisible(true);
					comboItemBox2.setVisible(true);		
					comboItemBox3.setVisible(false);
					productos = p.leerHamburguesa();
					if(comboItemBox2.getItemCount() == 0) {
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemBox2);
					}
				}
				if(comparado=="Pancho")
				{
					
					ArrayList<String> listaProducto = new ArrayList<String>();
					ArrayList<Producto> productos = new ArrayList<Producto>();
					nombreProd.setVisible(true);
					comboItemBox3.setVisible(true);
					comboItemBox2.setVisible(false);
					productos = p.leerPancho();
					if(comboItemBox3.getItemCount() == 0) 
					{
						listaProducto = pasar2ListaString(productos);
						moverArray2Combo(listaProducto, comboItemBox3);
					}
				}
			
		  }
		}
		
		public void quitarCalorias() {
			label3.setVisible(false);
			textField3.setVisible(false);
		}
		public void quitarMarca() {
			label4.setVisible(false);
			textField4.setVisible(false);
		}
		public void quitarCombo() {
			label5.setVisible(false);
			comboItemBox.setVisible(false);
		}
		public void quitarNombreTipoCombo() {
			nombreProd.setVisible(false);
			comboItemBox2.setVisible(false);
		}
		
		public void agregarComboListaProductos() {
			label5 =new JLabel("Tipo");
			label5.setBounds(102,172,84,16);
			label5.setVisible(false);
			label5.setFont(new Font("Andale Mono",1,18));
			label5.setForeground(new Color(255,255,255));  
			getContentPane().add(label5);
			ArrayList<String> listaProducto = new ArrayList<String>();
			comboItemBox=new JComboBox<String>();
			comboItemBox.setBounds(204, 168, 177, 24);
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
			nombreProd = new JLabel("Nombre");
			nombreProd.setBounds(102,218,84,16);
			nombreProd.setVisible(false);
			nombreProd.setFont(new Font("Andale Mono",1,18));
			nombreProd.setForeground(new Color(255,255,255));  
			getContentPane().add(nombreProd);
			
			comboItemBox2=new JComboBox<String>();
			comboItemBox2.setBounds(204, 214, 177, 24);
			comboItemBox2.setVisible(false);
			comboItemBox2.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemBox2);

			comboItemBox2.addActionListener(this);
			
			comboItemBox3=new JComboBox<String>();
			comboItemBox3.setBounds(204, 214, 177, 24);
			comboItemBox3.setVisible(false);
			comboItemBox3.setFont(new Font("Andale Mono",1,14));
			getContentPane().add(comboItemBox3);

			comboItemBox3.addActionListener(this);
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
				String nombre = p.get(i).getNombre();
				listaProd.add(nombre);
			}
			return listaProd;
		}
}
