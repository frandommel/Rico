package GestionComercio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import Archivos.ArchivoPedidos;
import Archivos.ArchivoPersona;
import Archivos.ArchivoProducto;
import Archivos.ManejadordeArchivos;
import claseProductos.Producto;

import interfaces.IAccion;

public class Comercio{
	private String nombre;
	private String direccion;
	private String cuit;
	private String rubro;
	private JSONObject personas;
	private ListadoPedidos pedidos;
	private HashMap<String, ArrayList<Producto>> productos;

	
	
	public Comercio() throws JSONException {
	nombre ="Rico Pancheria";
	direccion = "Alem 3550";
	cuit = "20-28335746-7";
	rubro="FastFood";
	
	/*ArchivoProducto archivoProducto = new ArchivoProducto();
	productos = archivoProducto.leer();*/
	
	ManejadordeArchivos archivos = new ManejadordeArchivos();
	productos = archivos.getListadoProductos();
	pedidos = archivos.getListadoPedidos();
	personas = archivos.getListadoPersonas();
	
	}
	
	public static void agregarPersona(Persona persona) throws JSONException 
	{
		
	}
	
	public HashMap<String, ArrayList<Producto>> getProductos() {
		return productos;
	}


	public void setProductos(HashMap<String, ArrayList<Producto>> productos) {
		this.productos = productos;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}


	public ListadoPedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(ListadoPedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	public JSONObject getPersonas() {
		return personas;
	}
	
	public void addPersonas(Persona persona) throws JSONException {
		if(persona instanceof ClienteVip)
		{
			personas.getJSONArray("clientes").put(persona.generateJson());
		}else if (persona instanceof Empleado) {
			personas.getJSONArray("empleados").put(persona.generateJson());
		}
		
		ManejadordeArchivos archivos = new ManejadordeArchivos();
		archivos.actualizarArchivoPersona(personas);
	}
	
	public JSONObject buscarPersona(String string, String tipoPersona) throws JSONException
	{
		/*ManejadordeArchivos archivos = new ManejadordeArchivos();
		JSONObject object = archivos.getListadoPersonas();
		
		JSONArray array = object.getJSONArray(string);
		
		return (JSONObject) array.get(id);*/
		boolean flag=false;
		int i = 0;
		ManejadordeArchivos archivos = new ManejadordeArchivos();
		JSONObject object = archivos.getListadoPersonas();
		JSONArray array = object.getJSONArray(tipoPersona);
		JSONObject aux = null;
		int size = array.length();
		while(i<size && flag == false)
		{
			aux = array.getJSONObject(i);
			if(aux.getString("nombre").equalsIgnoreCase(string)) 
			{
				flag = true;
			}
			i++;
		}
		return aux;
	}
	
	public void removePersonas(JSONObject aBorrar, String string) throws JSONException {
		int i=0;
		boolean flag = false;
		ManejadordeArchivos archivos = new ManejadordeArchivos();
		JSONObject object = archivos.getListadoPersonas();
		JSONArray array = object.getJSONArray(string);
		int size=array.length();
		while(i<size && flag == false) {
			JSONObject aux = array.getJSONObject(i);
			if(aux.getString("nombre").equalsIgnoreCase(aBorrar.getString("nombre"))) {
				array.remove(i);
				flag = true;
			}
			i++;
		}
		archivos.actualizarArchivoPersona(object);
	}
	
	public boolean validarPersona(String nombre, String password) throws JSONException 
	{
		boolean flag=false;
		int i = 0;
		ManejadordeArchivos archivos = new ManejadordeArchivos();
		JSONObject object = archivos.getListadoPersonas();
		JSONArray array = object.getJSONArray("empleados");
		int size = array.length();
		while(i<size && flag == false)
		{
			JSONObject aux = array.getJSONObject(i);
			if(aux.getString("nombre").equalsIgnoreCase(nombre) && aux.getString("password").equalsIgnoreCase(password)) 
			{
				flag = true;
			}
			i++;
		}
		return flag;
	}

	public void modificarPersona(JSONObject persona, String string) throws JSONException
	{
		boolean flag=false;
		int i = 0;
		ManejadordeArchivos archivos = new ManejadordeArchivos();
		JSONObject object = archivos.getListadoPersonas();
		JSONArray array = object.getJSONArray(string);
		int size = array.length();
		while(i<size && flag == false)
		{
			JSONObject aux = array.getJSONObject(i);
			if(aux.getString("nombre").equalsIgnoreCase(persona.getString("nombre"))) 
			{
				array.remove(i);
				flag = true;
				array.put(persona);
			}
			i++;
		}
		archivos.actualizarArchivoPersona(object);
	}
	
	/*public ArrayList<Producto> leerProductos(ArrayList<Producto>listaProd,String string) 
	{
		HashMap<String, ArrayList<Producto>> map = null;
		map = productos;
		ArrayList<Producto> aux=map.get(string);
		for (int i = 0; i < aux.size(); i++) {
		aux.get(i).getNombre();
		}
		return listaProd;
	}
*/
	@Override
	public String toString() {
		return "Comercio: " + nombre + "\n Direccion=" + direccion + "\n CUIT=" + cuit + "\n Rubro=" + rubro
				+ " \n Listado de Empleados=" + "\n Listado de Pedidos=" + pedidos.toString() + "\n Listado de Clientes ";
	}
	
	
	
	
	
}
