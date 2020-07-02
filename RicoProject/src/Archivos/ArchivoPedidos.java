package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import GestionComercio.ListadoPedidos;
import GestionComercio.Pedido;
import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Producto;

public class ArchivoPedidos	implements Serializable {

	public ArchivoPedidos()
	{
		
	}
	
	
	public void archivarPedido(ListadoPedidos pedido) 
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("pedidos.bin");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(pedido);
			object.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				file.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public ListadoPedidos leerPedidos()
	{
		FileInputStream file = null;
		ListadoPedidos listado = new ListadoPedidos();
		
		try {
			
			file = new FileInputStream("pedidos.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			listado = (ListadoPedidos) object.readObject();

		
			object.close();
		} catch (FileNotFoundException e) {
			
			JOptionPane.showMessageDialog(null, "Bienvenido a su nuevo sistema !\nGracias por utilizar nuestros servicios \nDVD® Software Development ");
			archivarPedido(new ListadoPedidos());
			leerPedidos();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		return listado;

	}
}
