package GestionComercio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import interfaces.IAccion;

public class ListadoEmpleados implements IAccion<Integer,Empleado> {
    private HashMap<Integer, Empleado> listaEmpleadoContenedorMap;

    public ListadoEmpleados() {
		listaEmpleadoContenedorMap = new HashMap<Integer, Empleado>();
	}

	@Override
	public void baja(Empleado objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void buscar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(HashMap<Integer, Empleado> mapa) {
		// TODO Auto-generated method stub
		
	}

	
	

}
