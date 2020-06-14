package GestionComercio;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import interfaces.IAccion;

public class ListadoClientes implements IAccion<Integer,ClienteVip> {
    private HashMap<Integer, ClienteVip> listaClientesContenedorMap;
    
    
    public ListadoClientes() {
		// TODO ENCONTRAR LA FORMA DE TRAER EL ARCHIVO DE JSON
	}

	@Override
	public void baja(ClienteVip objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteVip buscar(Integer busqueda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void listar() {
		Set <Entry<Integer,ClienteVip>> set = listaClientesContenedorMap.entrySet();
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
	public void alta(ClienteVip objeto) {
		
	}
	
	

}
