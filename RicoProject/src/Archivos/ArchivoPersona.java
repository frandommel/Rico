package Archivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.AllPermission;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import GestionComercio.ClienteVip;
import GestionComercio.Empleado;
import GestionComercio.ListadoClientes;
import GestionComercio.ListadoEmpleados;
import GestionComercio.Persona;
import jSon.JSONPersona;

public class ArchivoPersona {
	public ArchivoPersona() {
		// TODO Auto-generated constructor stub
	}

	public static void agregarArchivo(JSONArray jsonarray) {
		
		try {
			 FileWriter file = new FileWriter("personas.json");
			 file.write(jsonarray.toString());
			 file.flush();
			 file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static JSONArray leer(){
		String contenido = "";
		JSONArray array= null;
		try {
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			array = new JSONArray(contenido);

		} catch (IOException e) {
			e.printStackTrace();
		} catch(JSONException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	
	public static void agregarPersona(Persona persona) throws JSONException 
	{
		JSONPersona listadosJsonPersona = new JSONPersona();
		JSONArray array = leer();
		JSONArray aux = new JSONArray();	
		boolean flag = false;
		int i =0;
	
		while(array.get(i) != null && flag) {
			
			aux = (JSONArray) array.get(i);
			JSONObject object = (JSONObject) aux.get(0);
			
			if(object.has("posicion") && persona instanceof Empleado) 
			{
				listadosJsonPersona.agregarObjeto(aux, persona.generateJson());
				flag = true;
				
			}else if(object.has("cantSellos") && persona instanceof ClienteVip) 
			{
				listadosJsonPersona.agregarObjeto(aux, persona.generateJson());
				flag = true;
			}
			i++;
		}
		
						
	}
		
}
