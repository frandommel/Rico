package Archivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import GestionComercio.ClienteVip;
import GestionComercio.Comercio;
import GestionComercio.Empleado;
import GestionComercio.ListadoPedidos;
import GestionComercio.Persona;
import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;
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
	
	
	/**
	 * 
	 * @return HashMap<String, ArrayList<Producto>>
	 * Obtengo los listados de los productos
	 */
	public HashMap<String, ArrayList<Producto>> getListadoProductos()
	{
		HashMap<String, ArrayList<Producto>> destinoProductos = new HashMap<String, ArrayList<Producto>>();
		destinoProductos = productos.leer();
		return destinoProductos;
	}
	
	/**
	 * 
	 * @return ListadoPedidos 
	 * Obtengo los listados de los pedidos.
	 */
	public ListadoPedidos getListadoPedidos()
	{
		ListadoPedidos destinoPedido = new ListadoPedidos();
		destinoPedido = pedido.leerPedidos();
		if(destinoPedido.getListaPedidosContenedorMap().containsKey(definirFecha())==false)
		{
			destinoPedido.inciarDia();
		}
	
		return destinoPedido;	
	}
	
	/**
	 * 
	 * @return HashMap<String, Empleado> 
	 * @throws JSONException
	 * Obtengo listado de empleados
	 */
	public HashMap<String, Empleado> getListadoEmpleados() throws JSONException
	{
		return persona.leerEmpleado();
	}
	/**
	 * 
	 * @return HashMap<String ,ClienteVip> 
	 * @throws JSONException
	 * Obtengo listado de clientes
	 */
	public HashMap<String ,ClienteVip> getListadoCliente() throws JSONException
	{
		return persona.leerCliente();
	}
	
	/**
	 * 
	 * @param  empleados HashMap<String, Empleado> 
	 * @param  clientes HashMap<String, ClienteVip>
	 * Actualizamos el archivo de personas
	 */
	public void actualizarArchivoPersona(HashMap<String, Empleado> empleados, HashMap<String, ClienteVip> clientes)
	{
		//LOGICA DE TRANFOSRMACION DE HASHMAP A JSON
		
		try {
			JSONObject jsonArchivo = new JSONObject();
			JSONArray jsonEmpleados = mapa2JsonEmpleado(empleados);
			JSONArray jsonClientes = mapa2JsonCliente(clientes);
			jsonArchivo.put("empleados", jsonEmpleados);
			jsonArchivo.put("clientes", jsonClientes);
			ArchivoPersona.agregarArchivo(jsonArchivo);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param mapa HashMap<String, Empleado> 
	 * @return JSONArray
	 * @throws JSONException
	 * 
	 */
	public JSONArray mapa2JsonEmpleado(HashMap<String, Empleado> mapa) throws JSONException 
	{
		JSONArray array = new JSONArray();
		Set<Entry< String ,Empleado>> set = mapa.entrySet();
		Iterator it =  set.iterator();
		while(it.hasNext())
		{
			Map.Entry<String, Empleado> me = (Map.Entry<String, Empleado>)it.next();
			array.put(me.getValue().generateJson());
		}
		return array;
	}
	/**
	 * 
	 * @param mapa HashMap<String, ClienteVip> 
	 * @return JSONArray
	 * @throws JSONException
	 */
	public JSONArray mapa2JsonCliente(HashMap<String, ClienteVip> mapa) throws JSONException 
	{
		JSONArray array = new JSONArray();
		Set<Entry< String ,ClienteVip>> set = mapa.entrySet();
		Iterator it =  set.iterator();
		while(it.hasNext())
		{
			Map.Entry<String, ClienteVip> me = (Map.Entry<String, ClienteVip>)it.next();
			array.put(me.getValue().generateJson());
		}
		return array;
	}
	
	/**
	 * 
	 * @return JSONObject 
	 */
	public JSONObject leerPersonas()
	{
		String contenido = "";
		JSONObject objectObject = null;
		try {
			
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			objectObject = new JSONObject(contenido);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return objectObject; 	
	}
	
	/**
	 * 
	 * @param ListadoPedidos
	 */
	public void actualizarArchivoPedidos(ListadoPedidos pedidos)
	{
		pedido.archivarPedido(pedidos);
	}
	
	/**
	 * 
	 * @param Producto
	 */
	public void actualizarArchivoProducto(Producto productoNuevo)
	{
		if(productoNuevo instanceof Hamburguesa) {
			ArrayList<Hamburguesa> lista = productos.leerHamburguesaCambio();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(productoNuevo.getNombre())) {
					lista.get(i).setPrecio(productoNuevo.getPrecio());
				}
			}
			productos.agregarHamburguesa(lista);
		}else if(productoNuevo instanceof Pancho) {
			ArrayList<Pancho> lista = productos.leerPanchoCambio();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(productoNuevo.getNombre())) {
					lista.get(i).setPrecio(productoNuevo.getPrecio());
				}
			}
			productos.agregarPancho(lista);
		}else if(productoNuevo instanceof Ensalada) {
			ArrayList<Ensalada> lista = productos.leerEnsaladaCambio();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(productoNuevo.getNombre())) {
					lista.get(i).setPrecio(productoNuevo.getPrecio());
				}
			}
			productos.agregarEnsalada(lista);
		}else if(productoNuevo instanceof Guarnicion) {
			ArrayList<Guarnicion> lista = productos.leerGuarnicionCambio();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(productoNuevo.getNombre())) {
					lista.get(i).setPrecio(productoNuevo.getPrecio());
				}
			}
			productos.agregarGuarnicion(lista);
		}else if(productoNuevo instanceof Bebida) {
			ArrayList<Bebida> lista = productos.leerBebidaCambio();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getMarca().equalsIgnoreCase(productoNuevo.getNombre())) {
					lista.get(i).setPrecio(productoNuevo.getPrecio());
				}
			}
			productos.agregarBebida(lista);
		}else if (productoNuevo instanceof Combo) {
			ArrayList<Combo> lista = productos.leerComboCambio();
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getNombre().equalsIgnoreCase(productoNuevo.getNombre())) {
					lista.get(i).setPrecio(productoNuevo.getPrecio());
				}
			}
			productos.agregarCombo(lista);
		}
		
	}
	
	/**
	 * 
	 * @return String
	 * Retornamos la fecha cambiada a string
	 */
	public static String definirFecha()
	{
		Date fechaOrigen = new Date();
		int dia,mes,anio;
		String strFecha;
		dia=fechaOrigen.getDate();
		mes=fechaOrigen.getMonth()+1;
		anio=fechaOrigen.getYear()+1900;
		strFecha = dia+"/"+mes+"/"+anio;
		
		return strFecha;
	}
	
}
