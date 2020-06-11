package GestionComercio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

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
	public Empleado buscar(Integer busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listar() {
		Set <Entry<Integer,Empleado>> set = listaEmpleadoContenedorMap.entrySet();
		Iterator iterator = set.iterator();
		StringBuilder builder = new StringBuilder();
		while(iterator.hasNext())
		{
			builder.append(iterator.next().toString());
			builder.append("\n");
		}
		
		System.out.println(builder.toString());
	
	}

	@Override
	public String listar(Integer clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(Empleado objeto) {
		// TODO Auto-generated method stub
		
	}

		

}
