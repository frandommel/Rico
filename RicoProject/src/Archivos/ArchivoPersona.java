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
import GestionComercio.Persona;
import InterfazGrafica.Cliente;

public class ArchivoPersona {
	public ArchivoPersona() {
		// TODO Auto-generated constructor stub
	}

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
	
	public HashMap<String,Persona>  leerEmpleado() throws JSONException
	{
		String contenido = "";
		JSONObject objectObject = null;
		HashMap<String, Persona> personas = new HashMap<String, Persona>();
		try {
			
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			objectObject = new JSONObject(contenido);
			personas = generateEmpleado(objectObject, personas);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return personas;
	}
	
	public HashMap<String,Persona>  leerCliente() throws JSONException{
		String contenido = "";
		JSONObject objectObject = null;
		HashMap<String, Persona> personas = new HashMap<String, Persona>();
		try {
			
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			objectObject = new JSONObject(contenido);
			personas = generateCliente(objectObject, personas);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return personas;
	}
	
	public HashMap<String,Persona> generateEmpleado(JSONObject json, HashMap<String, Persona> personas)
	{
		Empleado empleado = new Empleado();
		JSONArray empleados;
		try {
			empleados = (JSONArray)json.getJSONArray("empleados");
			for(int i=0; i<empleados.length(); i++)
			{
				JSONObject aux = (JSONObject) empleados.get(i);
				empleado.setNombre(aux.get("nombre").toString());
				empleado.setDireccion(aux.get("direccion").toString());
				empleado.setPassword(aux.get("password").toString());
				empleado.setPosicion(aux.get("posicion").toString());
				empleado.setTelefono(aux.get("telefono").toString());	
				personas.put(empleado.getNombre(), empleado);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return personas;

	}
	public HashMap<String,Persona> generateCliente(JSONObject json, HashMap<String, Persona> personas)
	{
		ClienteVip cliente = new ClienteVip();
		JSONArray clientes;
		try {
			clientes = (JSONArray)json.getJSONArray("clientes");
			for(int i=0; i< clientes.length(); i++)
			{
				JSONObject aux = (JSONObject) clientes.get(i);
				cliente.setNombre(aux.get("nombre").toString());
				cliente.setDireccion(aux.get("direccion").toString());
				cliente.setTelefono(aux.get("telefono").toString());
				String sellos = aux.get("cantSellos").toString();
				int sellosInt = Integer.parseInt(sellos);
				cliente.setCantSellos(sellosInt);
				personas.put(cliente.getNombre(), cliente);
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return personas;

	}
	
	public void recorrerHashMapEmpleado( HashMap<String,Persona> persona ) 
	{
		Set<Entry< String ,Persona>> set = persona.entrySet();
		Iterator it =  set.iterator();
		System.out.println("Empleados");
		while(it.hasNext())
		{
			
			Map.Entry<String, Persona> me = (Map.Entry<String, Persona>)it.next();
			System.out.println(me.getKey().toString() +" "+me.getValue().toString());
		}
		
	}
	public void recorrerHashMapCliente( HashMap<String,Persona> persona ) 
	{
		Set<Entry< String ,Persona>> set = persona.entrySet();
		Iterator it =  set.iterator();
		System.out.println("CLIENTES");
		while(it.hasNext())
		{

			Map.Entry<String, Persona> me = (Map.Entry<String, Persona>)it.next();
			System.out.println(me.getKey().toString() +" "+me.getValue().toString());
		}
		
	}
	

		
}
