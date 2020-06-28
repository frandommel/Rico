package GestionComercio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import Archivos.ArchivoPedidos;
import Archivos.ArchivoPersona;
import Archivos.ArchivoProducto;
import Archivos.ManejadordeArchivos;
import claseProductos.Bebida;
import claseProductos.Producto;

import interfaces.IAccion;

public class Comercio{
	private String nombre;
	private String direccion;
	private String cuit;
	private String rubro;
	private ListadoPedidos pedidos;
	private HashMap<String, ArrayList<Producto>> productos;
	private HashMap<String, Empleado> empleados;
	private HashMap<String,ClienteVip> clientes;
	private ManejadordeArchivos archivos;
	
	
	public Comercio() {
	nombre ="Rico Pancheria";
	direccion = "Alem 3550";
	cuit = "20-28335746-7";
	rubro="FastFood";
	
	
	archivos = new ManejadordeArchivos();
	productos = archivos.getListadoProductos();
	try {
		empleados = archivos.getListadoEmpleados();
		clientes = archivos.getListadoCliente();
	} catch (JSONException e) {
		e.printStackTrace();
	}
	//pedidos = archivos.getListadoPedidos();
	
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
	
	public HashMap<String,Empleado> getEmpleado()
	{
		return empleados;
	}
	
	public void setEmpleado( HashMap<String , Empleado> empleados )
	{
		this.empleados = empleados;
	}


	public HashMap<String,ClienteVip> getCliente()
	{
		return clientes;
	}
	
	public void setCliente( HashMap<String , ClienteVip> clientes )
	{
		this.clientes = clientes;
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
	
	public boolean validarPersona(String nombre, String password)  
	{
		boolean flag=false;
		Set<Entry<String,Empleado>> set = empleados.entrySet();
		Iterator it = set.iterator();
		while(it.hasNext()) 
		{
			Map.Entry<String, Empleado> me = (Map.Entry<String, Empleado>)it.next();
			if(me.getValue().getNombre().equalsIgnoreCase(nombre) && me.getValue().getPassword().equalsIgnoreCase(password)) {
				flag = true;
			}
			
		}		
		return flag;
	}
	
	public Empleado buscarEmpleado(String empleadoBuscar) 
	{
		Set<Entry<String,Empleado>> set = empleados.entrySet();
		Empleado empleadoRetorno = new Empleado();
		Iterator it = set.iterator();
		while(it.hasNext())	
		{
			Map.Entry<String, Empleado> me = (Map.Entry<String, Empleado>)it.next();
			if(me.getValue().getNombre().equalsIgnoreCase(empleadoBuscar)){
				empleadoRetorno = me.getValue();
			}
		}
		return empleadoRetorno;
	}
	
	public ClienteVip buscarCliente(String clienteBuscar) 
	{
		Set<Entry<String,ClienteVip>> set = clientes.entrySet();
		ClienteVip clienteRetorno = new ClienteVip();
		Iterator it = set.iterator();
		while(it.hasNext())	
		{
			Map.Entry<String, ClienteVip> me = (Map.Entry<String, ClienteVip>)it.next();
			if(me.getValue().getNombre().equalsIgnoreCase(clienteBuscar)){
				clienteRetorno = me.getValue();
			}
		}
		return clienteRetorno;
	}
	
	public void addPersonas(Persona persona)
	{
		if(persona instanceof ClienteVip)
		{
			ClienteVip cliente = (ClienteVip) persona;
			clientes.put(cliente.getNombre(), cliente);
			
		} else if (persona instanceof Empleado)
		{
			Empleado empleado = (Empleado) persona;
			empleados.put(empleado.getNombre(), empleado);
		}
		
		archivos.actualizarArchivoPersona(this);
	  }
	
	public void removeEmpleado(Empleado aBorrar)
	{
		int i=0;
		boolean flag = false;
		Set<Entry<String,Empleado>> set = empleados.entrySet();
		Empleado empleadoRetorno = new Empleado();
		Iterator it = set.iterator();
		while(it.hasNext())	
		{
			Map.Entry<String, Empleado> me = (Map.Entry<String, Empleado>)it.next();
			if(me.getValue().getNombre().equalsIgnoreCase(aBorrar.getNombre())){
				empleados.remove(me.getKey());
			}
		}
		archivos.actualizarArchivoPersona(this);
	}
	
	public void modificarEmpleado(Empleado buscado,String nuevaPosicion, String nuevaDireccion, String nuevoTel)
	{
		boolean flag=false;
		if(!buscado.getPosicion().equalsIgnoreCase(nuevaPosicion))
		{
			buscado.setPosicion(nuevaPosicion);
		}
		if(!buscado.getDireccion().equalsIgnoreCase(nuevaDireccion))
		{
			buscado.setDireccion(nuevaDireccion);
		}
		if(!buscado.getTelefono().equalsIgnoreCase(nuevoTel))
		{
			buscado.setTelefono(nuevoTel);
		}
		archivos.actualizarArchivoPersona(this);
	}
	
	public void removeCliente(ClienteVip aBorrar)
	{
		int i=0;
		boolean flag = false;
		Set<Entry<String,ClienteVip>> set = clientes.entrySet();
		ClienteVip empleadoRetorno = new ClienteVip();
		Iterator it = set.iterator();
		while(it.hasNext())	
		{
			Map.Entry<String, ClienteVip> me = (Map.Entry<String, ClienteVip>)it.next();
			if(me.getValue().getNombre().equalsIgnoreCase(aBorrar.getNombre())){
				clientes.remove(me.getKey());
			}
		}
		archivos.actualizarArchivoPersona(this);
	}
	
	public void modificarCliente(ClienteVip buscado, String nuevaDireccion, String nuevoTel)
	{
		boolean flag=false;
		if(!buscado.getDireccion().equalsIgnoreCase(nuevaDireccion))
		{
			buscado.setDireccion(nuevaDireccion);
		}
		if(!buscado.getTelefono().equalsIgnoreCase(nuevoTel))
		{
			buscado.setTelefono(nuevoTel);
		}
		archivos.actualizarArchivoPersona(this);
	}

	public Producto leerProducto(String claveString , String producto) {
		Producto p = null;
		ArrayList<Producto> aux= productos.get(claveString);
		for (int i = 0; i < aux.size(); i++) {
			if(aux.get(i).getNombre().equalsIgnoreCase(producto)) {
				p=aux.get(i);
			}
		}
		
		return p;
	}
	
	public Producto leerCerveza(String claveString , String producto) {
		Producto producto2 = null;
		Bebida bebida = null;
		ArrayList<Producto> aux= productos.get(claveString);
		for (int i = 0; i < aux.size(); i++) {
			if(aux.get(i).getNombre().equalsIgnoreCase("Cerveza")) {
				bebida = (Bebida)aux.get(i);
				if(bebida.getMarca().equalsIgnoreCase(producto)) {
					producto2 = bebida;
				}
			}
		}
		return producto2;
	}
	
	
	@Override
	public String toString() {
		return "Comercio: " + nombre + "\n Direccion=" + direccion + "\n CUIT=" + cuit + "\n Rubro=" + rubro;
				//+ " \n Listado de Empleados=" + "\n Listado de Pedidos=" + pedidos.toString() + "\n Listado de Clientes ";
	}
	
	
	
	
	
}
