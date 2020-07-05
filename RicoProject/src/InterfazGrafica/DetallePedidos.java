package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import GestionComercio.Comercio;
import GestionComercio.ListadoPedidos;
import GestionComercio.Pedido;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Exceptions.BusquedaException;

public class DetallePedidos extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel dateLabel,montoTotalLabel;
	private JTextField dateField,montoTotalField;
	private Comercio rico;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JButton buscar,volver;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetallePedidos frame = new DetallePedidos();
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
	public DetallePedidos(Comercio comercio) {
		this.rico = comercio;
		initComponents();
	}
	/**
	 * Inicio los componentes
	 */
	public void initComponents() {
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setTitle("Pedidos");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setBackground(new Color(241,98,63));
		getContentPane().setLayout(null);
	
		dateLabel = new JLabel("Ingrese fecha de pedidos");
		dateLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setBounds(12, 13, 212, 31);
		getContentPane().add(dateLabel);
	
		dateField = new JTextField("2/7/2020");
		dateField.setEditable(true);
		dateField.setBounds(236, 14, 116, 31);
		getContentPane().add(dateField);
		dateField.setColumns(10);
		
		montoTotalLabel = new JLabel("Total Venta");
		montoTotalLabel.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 16));
		montoTotalLabel.setForeground(Color.WHITE);
		montoTotalLabel.setBounds(503, 502, 124, 31);
		getContentPane().add(montoTotalLabel);
		
		montoTotalField = new JTextField();
		montoTotalField.setEditable(false);
		montoTotalField.setBounds(639, 503, 116, 31);
		getContentPane().add(montoTotalField);
		montoTotalField.setColumns(10);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(404, 14, 116, 31);
		getContentPane().add(buscar);
		buscar.addActionListener(this);
		
		volver = new JButton("Volver");
		volver.setBounds(28, 503, 116, 31);
		getContentPane().add(volver);
		volver.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 72, 727, 417);
		getContentPane().add(scrollPane);
		
		DefaultTableModel modelo = new DefaultTableModel();
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nro", "Detalle", "Precio"
			}
		));
		table_1.getColumnModel().getColumn(1).setPreferredWidth(314);
		scrollPane.setViewportView(table_1);
	
	
	}
	/**
	 * @param  e ActionEvent
	 * Metodo que se utiliza para el manejo de las interacciones de la interfaz
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		if(e.getSource()==buscar) {
			String clave = dateField.getText();
			int montoTotal=0;
			int numCol = table_1.getModel().getColumnCount();
			try
			{
				
				
				pedidos=busquedaPedido(pedidos, clave);
				if(pedidos.isEmpty())
				{
					throw new BusquedaException(clave);
				}
				for (int i = 0; i < pedidos.size(); i++) {
					Object [] fila= new Object[numCol];
					fila[0] = pedidos.get(i).getId();
					fila[1] = pedidos.get(i).getProductos().toString();
					fila[2] = "$    "+pedidos.get(i).getMontoVenta();
					((DefaultTableModel)table_1.getModel()).addRow(fila);
					montoTotal+=pedidos.get(i).getMontoVenta();
				}
				montoTotalField.setText("$   "+String.valueOf(montoTotal));
				buscar.setEnabled(false);
			}catch(BusquedaException x)
			{
				JOptionPane.showMessageDialog(null, x.getMessage());
				buscar.setEnabled(true);
			}
			
		}
		if(e.getSource()==volver) {
			VentanaPedido pedido = new VentanaPedido(rico);
			pedido.setVisible(true);
			//JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);///cambiar a otra ventana desde otro jpanel
			this.setVisible(false);
		}
		
	}
	
	public ArrayList<Pedido> busquedaPedido(ArrayList<Pedido> pedidos,String clave) throws BusquedaException
	{
		pedidos = rico.getPedidos().buscar(clave);
		if(pedidos==null)
		{
			throw new BusquedaException(clave);
		}
		return pedidos;
	}
}
