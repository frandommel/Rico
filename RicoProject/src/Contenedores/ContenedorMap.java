package Contenedores;

import java.sql.Date;
import java.util.HashMap;

import Interfaces.Accion;

public class ContenedorMap<K,T> implements Accion<T>{

	private HashMap<K, T> mapa;
		
	public ContenedorMap() {
		
		this.mapa = new HashMap<K,T>();
	}

	@Override
	public void alta(T objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void baja(T objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscar(T objeto) {
		// TODO Auto-generated method stub
		
	}

}
