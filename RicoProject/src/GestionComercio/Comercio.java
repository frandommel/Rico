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
	setNombre("Rico Pancheria");
	setDireccion("Alem 3550");
	setCuit("20-28335746-7");
	setRubro("FastFood");
	
	
	archivos = new ManejadordeArchivos();
	productos = archivos.getListadoProductos();
	try {
		pedidos = archivos.getListadoPedidos();
		
		empleados = archivos.getListadoEmpleados();
		clientes = archivos.getListadoCliente();
	} catch (JSONException e) {
		e.printStackTrace();
	}
	
	}
	
	/**
	 * 
	 * @return Coleccion de tipo HashMap con el arrayList de Producto, diferenciado por claves String de fecha
	 */
	public HashMap<String, ArrayList<Producto>> getProductos() {
		return productos;
	}

	/**
	 * 
	 * @param productos Coleccion de tipo HashMap que setea el Listado de Productos
	 */
	public void setProductos(HashMap<String, ArrayList<Producto>> productos) {
		this.productos = productos;
	}
	
	/**
	 * 
	 * @return mapa de empleados, diferencia por clave de tipo String con nombres completos del empleado
	 */
	public HashMap<String,Empleado> getEmpleado()
	{
		return empleados;
	}
	
	/**
	 * 
	 * @param empleados Coleccion de tipo HashMap que setea el Listado de Empleados
	 */
	public void setEmpleado( HashMap<String , Empleado> empleados )
	{
		this.empleados = empleados;
	}

	/**
	 * 
	 * @return mapa de clientes, diferencia por clave de tipo String con nombres completos del cliente
	 */
	public HashMap<String,ClienteVip> getCliente()
	{
		return clientes;
	}
	
	/**
	 * 
	 * @param clientes Coleccion de tipo HashMap que setea el Listado de clientes
	 */
	public void setCliente( HashMap<String , ClienteVip> clientes )
	{
		this.clientes = clientes;
	}
	
	/**
	 * @see {@link <a href=https://www.facebook.com/ricomardelplata/> RICO FACEBOOK </a>}
	 * @return nombre del Comercio
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param nombre String, setea el atributo nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return direccion del comercio
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * @param direccion String, setea el atributo direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @see {@link <a href=https://www.afip.gob.ar/sitio/externos/default.asp > AFIP </a>}
	 * @return cuit del comercio
	 */
	public String getCuit() {
		return cuit;
	}

	/**
	 * 
	 * @param cuit String, setea el atributo cuit
	 */
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	/**
	 * 
	 * @return rubro del comercio
	 */
	public String getRubro() {
		return rubro;
	}

	/**
	 * 
	 * @param rubro String, que setea el atributo
	 */
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	/**
	 * 
	 * @return Listado de pedidos
	 */
	public ListadoPedidos getPedidos() {
		return pedidos;
	}

	
	/**
	 * 
	 * @param pedido que va  aser ingresado en una ListaPedidos
	 * @see ListadoPedidos
	 */
	public void setPedidos(Pedido pedido) {
		pedidos.alta(pedido);
	}
	
	
	/**
	 * 
	 * @return ManejadordeArchivos para manipular los archivos en base a las colecciones
	 * @see ManejadordeArchivos
	 */
	public ManejadordeArchivos getArchivos() {
		return archivos;
	}

	/**
	 * 
	 * @param empleadoBuscar String nombre del Empleado 
	 * @return Empleado de la coleccion de Empleados
	 */
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
	
	/**
	 * 
	 * @param clienteBuscarString nombre del ClienteVip
	 * @see ClienteVip 
	 * @return ClienteVip de la coleccion de Clientes
	 */
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
	
	/**
	 * 
	 * @param persona, selecciona segun el tipo de Persona, cual es el lugar correcto en la coleccion de Personas
	 */
	public void addPersonas(Persona persona)
	{
		if(persona instanceof ClienteVip)
		{
			ClienteVip cliente = (ClienteVip) persona;
			clientes.put(cliente.getNombre(), cliente);
			System.out.println(clientes);
			
		} else if (persona instanceof Empleado)
		{
			Empleado empleado = (Empleado) persona;
			empleados.put(empleado.getNombre(), empleado);
		}
		
		archivos.actualizarArchivoPersona(empleados,clientes);
	  }
	
	/**
	 * Modifica los datos de un empleado
	 * 
	 * @param buscado Empleado
	 * @param nuevaPosicion String
	 * @param nuevaDireccion String
	 * @param nuevoTel String
	 * 
	 * 
	 */
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
		archivos.actualizarArchivoPersona(empleados,clientes);
	}
	
	/**
	 * Elimina un empleado del listado y del archivo en base al objeto del parametro
	 * @param aBorrar Empleado
	 */
	public void removeEmpleado(Empleado aBorrar)
	{
		int i=0;
		boolean flag = false;
		Set<Entry<String,Empleado>> set = empleados.entrySet();
		
		Iterator it = set.iterator();
		while(it.hasNext())	
		{
			Map.Entry<String, Empleado> me = (Map.Entry<String, Empleado>)it.next();
			if(me.getValue().getNombre().equalsIgnoreCase(aBorrar.getNombre())){
				empleados.remove(me.getKey());
				break;
			}
		}
		archivos.actualizarArchivoPersona(empleados,clientes);
	}
	
	/**
	 * Remueve un Cliente de las colecciones y archivos
	 * @param aBorrar ClienteVip
	 */
	public void removeCliente(ClienteVip aBorrar)
	{
		int i=0;
		boolean flag = false;
		Set<Entry<String,ClienteVip>> set = clientes.entrySet();
		
		Iterator it = set.iterator();
		while(it.hasNext())	
		{
			Map.Entry<String, ClienteVip> me = (Map.Entry<String, ClienteVip>)it.next();
			if(me.getValue().getNombre().equalsIgnoreCase(aBorrar.getNombre())){
				clientes.remove(me.getKey());
				break;
			}
		}
		archivos.actualizarArchivoPersona(empleados,clientes);
	}
	/**
	 * Modifica los datos de un Cliente
	 * @param buscado ClienteVip
	 * @param nuevaDireccion String
	 * @param nuevoTel String
	 */
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
		archivos.actualizarArchivoPersona(empleados,clientes);
	}

	/**
	 * 
	 * @param claveString String
	 * @param producto String
	 * @return Producto del listado, en base a el tipo y el nombre
	 */
	public Producto leerProducto(String claveString , String producto) {
		Producto p = null;
		ArrayList<Producto> aux= productos.get(claveString);
		for (int i = 0; i < aux.size(); i++) {
			if(aux.get(i).getNombre().equalsIgnoreCase(producto)) {
				p=aux.get(i);
			}
			if(aux.get(i).getNombre().equalsIgnoreCase("Cerveza")) {
				Bebida bebida = (Bebida) aux.get(i);
				if(bebida.getMarca().equalsIgnoreCase(producto)) {
					p = bebida;
				}
			}
		}
		return p;
	}
	
	
	/**
	 * Tratamiento especial para cervezas diferenciando su marca
	 * @param claveString String
	 * @param producto String
	 * @return Producto
	 */
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
	
	public void modificarProducto(Producto producto,String nuevoPrecio)
	{
		boolean flag=false;
		producto.setPrecio(Integer.parseInt(nuevoPrecio));
		archivos.actualizarArchivoProducto(producto);
	}
	
	
	@Override
	public String toString() {
		return "Comercio: " + nombre + "\n Direccion=" + direccion + "\n CUIT=" + cuit + "\n Rubro=" + rubro;
				//+ " \n Listado de Empleados=" + "\n Listado de Pedidos=" + pedidos.toString() + "\n Listado de Clientes ";
	}
	
	/**
	 * 
	 * @return String con la fecha actual;
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
