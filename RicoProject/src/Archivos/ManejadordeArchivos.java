package Archivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
	
}
