package contenedores;

import java.util.Date;
import java.util.HashMap;

import interfaces.IAccion;

public class ContenedorMap<K,T>{

	private HashMap<K, T> mapa;
		
	public ContenedorMap() {
		
		this.mapa = new HashMap<K,T>();
	}
	
	public void agregar(K clave, T elemento)
	{
		mapa.put(clave, elemento);
	}
	
	


}
