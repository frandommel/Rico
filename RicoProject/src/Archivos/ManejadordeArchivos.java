package Archivos;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import GestionComercio.ClienteVip;
import GestionComercio.Empleado;
import GestionComercio.ListadoPedidos;
import GestionComercio.Persona;
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
		destinoPedido = pedido.leerPedidos();
		return destinoPedido;
		
	}
	
	public HashMap<String, Empleado> getListadoEmpleados() throws JSONException
	{
		return persona.leerEmpleado();
	}
	public HashMap<String ,ClienteVip> getListadoCliente() throws JSONException
	{
		return persona.leerCliente();
	}
	
	public void actualizarArchivoPersona(HashMap<String, Persona> personas)
	{
		
		//LOGICA DE TRANFOSRMACION DE HASHMAP A JSON
		
		
		//persona.agregarArchivo(personas);
		
	}

	
}
