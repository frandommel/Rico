package Archivos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import GestionComercio.ListadoClientes;
import GestionComercio.ListadoEmpleados;
import GestionComercio.Persona;

public class ArchivoPersona {
	public ArchivoPersona() {
		// TODO Auto-generated constructor stub
	}

	public ListadoEmpleados leerEmpleados() throws FileNotFoundException {
		FileInputStream file = new FileInputStream("empleados.bin");
		ListadoEmpleados empleados = new ListadoEmpleados();
		
		try {
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empleados;
	}

	public ListadoClientes leerClientes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	
}
