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
import GestionComercio.Persona;

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
	
	public static JSONObject leer() throws JSONException{
		String contenido = "";
		JSONObject objectObject = null;
		try {
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			objectObject = new JSONObject(contenido);

		} catch (IOException e) {
			e.printStackTrace();
		} 
		return objectObject;
	}

		
}
