package Archivos;

import java.util.ArrayList;
import java.util.HashMap;

import GestionComercio.ListadoClientes;
import GestionComercio.ListadoEmpleados;
import GestionComercio.ListadoPedidos;
import claseProductos.Producto;

public class ManejadordeArchivos {
	private ArchivoPersona persona;
	private ArchivoPedidos pedido;
	private ArchivoProducto productos;
	
	public ManejadordeArchivos() {
		super();
		this.persona = new ArchivoPersona();
		this.pedido = new ArchivoPedidos();
		this.productos = new ArchivoProducto();
	}
	
		
	public HashMap<String, ArrayList<Producto>> getListadoProductos()
	{
		HashMap<String, ArrayList<Producto>> destinoProductos = new HashMap<String, ArrayList<Producto>>();
		destinoProductos = productos.leer();
		
		return destinoProductos;
	}
	
	
	public ListadoPedidos getListadoPedidos()
	{
		ListadoPedidos destinoPedido = new ListadoPedidos();
		destinoPedido = pedido.leerPedido();
		
		return destinoPedido;
		
	}
	
	
	

	
	
}
