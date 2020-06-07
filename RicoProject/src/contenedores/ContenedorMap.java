package contenedores;

import java.sql.Date;
import java.util.HashMap;

import interfaces.IAccion;

public class ContenedorMap<K,T>{

	private HashMap<K, T> mapa;
		
	public ContenedorMap() {
		
		this.mapa = new HashMap<K,T>();
	}


}
