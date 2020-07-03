package Archivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.AllPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import GestionComercio.ClienteVip;
import GestionComercio.Empleado;
import GestionComercio.ListadoPedidos;
import GestionComercio.Persona;
import InterfazGrafica.Cliente;

public class ArchivoPersona {
	public ArchivoPersona() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * Archivo {@docRoot}
	 * @param Recibe un JsonObject y lo guarda en personas.Json
	 * @throws IOException
	 */
	public static void agregarArchivo(JSONObject object) {
		
		try {
			 FileWriter file = new FileWriter("personas.json");
			 file.write(object.toString());
			 file.flush();
			 file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Archivo {@docRoot}
	 * @return HashMap de <String,Empleado>
	 * @throws JSONException
	 */
	public HashMap<String,Empleado> leerEmpleado() throws JSONException
	{
		String contenido = "";
		JSONObject objectObject = null;
		HashMap<String, Empleado> personas = new HashMap<String, Empleado>();
		try {
			
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			objectObject = new JSONObject(contenido);
			personas = generateEmpleado(objectObject, personas);
			
		} 
		catch (FileNotFoundException e) {
			agregarArchivo(new JSONObject());
			leerEmpleado();
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		return personas;
	}
	
	/**
	 * Archivo {@docRoot}
	 * @return HashMap de tipo <String,ClienteVip>
	 * @throws JSONException
	 */
	public HashMap<String,ClienteVip>  leerCliente() throws JSONException{
		String contenido = "";
		JSONObject objectObject = null;
		HashMap<String, ClienteVip> personas = new HashMap<String, ClienteVip>();
		try {
			
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			objectObject = new JSONObject(contenido);
			personas = generateCliente(objectObject, personas);
			
		} catch (FileNotFoundException e) {
			agregarArchivo(new JSONObject());
			leerCliente();
		}catch (IOException e) {
			e.printStackTrace();
		} 
		return personas;
	}
	
	/**
	 * Archivo {@docRoot}
	 * @param  json JSONobject
	 * @param  personas HashMap<String,Empleado>
	 * @return HashMap<String,Empleado>
	 */
	public HashMap<String,Empleado> generateEmpleado(JSONObject json, HashMap<String, Empleado> personas)
	{
		
		
		try {
			JSONArray empleados = (JSONArray)json.getJSONArray("empleados");
			for(int i=0; i<empleados.length(); i++)
			{
				
				Empleado empleado = new Empleado();
				JSONObject aux = (JSONObject) empleados.get(i);
				empleado.setNombre(aux.getString("nombre"));
				empleado.setDireccion(aux.getString("direccion"));
				empleado.setPassword(aux.getString("password"));
				empleado.setPosicion(aux.getString("posicion"));
				empleado.setTelefono(aux.getString("telefono"));	
				personas.put(empleado.getNombre(), empleado);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return personas;

	}
	/**
	 * 
	 * @param  json JSONobject
	 * @param  personas HashMap<String,ClienteVip>
	 * @return HashMap<String,ClienteVip>
	 */
	public HashMap<String,ClienteVip> generateCliente(JSONObject json, HashMap<String, ClienteVip> personas)
	{
		
		
		try {
			
			JSONArray clientes= (JSONArray)json.getJSONArray("clientes");
			for(int i=0; i< clientes.length(); i++)
			{
				ClienteVip cliente = new ClienteVip();
				JSONObject aux = (JSONObject) clientes.get(i);
				cliente.setNombre(aux.getString("nombre"));
				cliente.setDireccion(aux.getString("direccion"));
				cliente.setTelefono(aux.getString("telefono"));
				cliente.setCantSellos(aux.getInt("cantSellos"));
				personas.put(cliente.getNombre(), cliente);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return personas;

	}
	
	/**
	 * 
	 * @param persona HashMap<String,Empleado>
	 */
	public void recorrerHashMapEmpleado( HashMap<String,Empleado> persona ) 
	{
		Set<Entry< String ,Empleado>> set = persona.entrySet();
		Iterator it =  set.iterator();
		System.out.println("Empleados");
		while(it.hasNext())
		{
			
			Map.Entry<String, Empleado> me = (Map.Entry<String, Empleado>)it.next();
			System.out.println(me.getKey().toString() +" "+me.getValue().toString());
		}
		
	}
	/**
	 * 
	 * @param persona HashMap<String,ClienteVip>
	 */
	public void recorrerHashMapCliente( HashMap<String,ClienteVip> persona ) 
	{
		Set<Entry< String ,ClienteVip>> set = persona.entrySet();
		Iterator it =  set.iterator();
		System.out.println("CLIENTES");
		while(it.hasNext())
		{

			Map.Entry<String, ClienteVip> me = (Map.Entry<String, ClienteVip>)it.next();
			System.out.println(me.getKey().toString() +" "+me.getValue().toString());
		}
		
	}
	

		
}
