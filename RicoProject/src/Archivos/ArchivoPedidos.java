package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import GestionComercio.Pedido;
import claseProductos.Bebida;
import claseProductos.Producto;

public class ArchivoPedidos {
	
	//** SE AGREGA BEBIDAS A UN ARCHIVO **//
		public void agregarPedido(ArrayList <Pedido> pedido) 
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
		//** SE LEE BEBIDAS DE UN ARCHIVO **//
		public ArrayList<Pedido> leerPedido()
		{
			FileInputStream file = null;
			ArrayList <Pedido> lista = new ArrayList<Pedido>();	
			try {
				
				file = new FileInputStream("pedidos.bin");
				ObjectInputStream object = new ObjectInputStream(file);
				lista = (ArrayList<Pedido>) object.readObject();
				object.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			catch (EOFException e) {
				//System.out.println("FIN DEL ARCHIVO");
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
			return lista;

		}
}
