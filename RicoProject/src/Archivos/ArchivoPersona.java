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

import GestionComercio.ListadoClientes;
import GestionComercio.ListadoEmpleados;
import GestionComercio.Persona;

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
	public static String leer() {
		String contenido = "";
		try {
			contenido = new String(Files.readAllBytes(Paths.get("personas.json")));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contenido;
	}
}
