
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private Programa programa = new Programa();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setBounds(100, 100, 698, 409);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Adicion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Adicion adicion = new Adicion();
				adicion.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(211, 86, 291, 25);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Caja");
		button.setBounds(211, 124, 291, 25);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Clientes");
		button_1.setBounds(211, 162, 291, 25);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Personal");
		button_2.setBounds(211, 200, 291, 25);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Informes");
		button_3.setBounds(211, 238, 291, 25);
		contentPane.add(button_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 119, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Adicion");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Nuevo Pedido");
		mnNewMenu_1.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Adicion adicion = new Adicion();
				adicion.setVisible(true);
				dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Modificar Pedido");
		mnNewMenu_1.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Adicion adicion = new Adicion();
				adicion.setVisible(true);
				dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Ver Demora");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Adicion adicion = new Adicion();
				adicion.setLocationRelativeTo(null);
				adicion.setVisible(true);
				dispose();
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Caja");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Clientes");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				programa.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(12, 371, 97, 25);
		contentPane.add(btnNewButton_1);
	}
	
	/*private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}*/
}
