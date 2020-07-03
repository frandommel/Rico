package GestionComercio;

import java.io.Serializable;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import interfaces.IAccion;

public class ListadoPedidos implements IAccion<String,Pedido>, Serializable {
      private HashMap<String, ArrayList<Pedido>> listaPedidosContenedorMap;
      private int montoTotal;

      public ListadoPedidos() {
		
    	  listaPedidosContenedorMap = new HashMap<String, ArrayList<Pedido>>();
    	  montoTotal = getMontoTotal();
	}

      /**
       * 
       * @return El monto total de del Listado completo
       */
      private int getMontoTotal() {
		int montoTotal = 0;
		Set<Map.Entry<String, ArrayList<Pedido>>> setE = getListaPedidosContenedorMap().entrySet();
		Iterator it = setE.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<String, ArrayList<Pedido>> me = (Map.Entry<String, ArrayList<Pedido>>) it.next();
			montoTotal = montoTotal + getMontoDiario(me.getKey());
		}
		
		return montoTotal;
	}

      /**
       * 
       * @param keyDia String
       * @return int con el monto especifico de un dia del listado
       */
	public int getMontoDiario (String keyDia)
	{
		int monto=0;
		//Pedido aux = new Pedido();
		//String fechaActual = aux.definirFecha();
		ArrayList<Pedido> cuentaDiaria = listaPedidosContenedorMap.get(keyDia);
		
		for(int i=0;i<cuentaDiaria.size();i++)
		{
			monto = monto + cuentaDiaria.get(i).getMontoVenta();
		}
		
		return monto;		
	}

	@Override
	public String listar() {
		return getListaPedidosContenedorMap().toString();
	}
	
	@Override
	public void alta(Pedido objeto) {
			ArrayList<Pedido> aux = listaPedidosContenedorMap.get(objeto.getFecha());
			aux.add(objeto);
	}
	

	@Override
	public ArrayList<Pedido> buscar(String busqueda) {
		
		return getListaPedidosContenedorMap().get(busqueda);
		
	}

	/**
	 * 
	 * @param busqueda String
	 * @return String 
	 */
	public String listarDia(String busqueda) {
		return buscar(busqueda).toString();
	}

	/**
	 * inicia el dia en caso de que sea la primer vez que se abra el programa en esa fecha
	 * @see ArchivoPedidos
	 * @see ListadoPedidos
	 */
	public void inciarDia() {
		String fechaActual = definirFecha();
		ArrayList<Pedido> listaX = new ArrayList<Pedido>();
		listaPedidosContenedorMap.put(fechaActual, listaX);
	}

	/**
	 * 
	 * @return HashMap con el listado completo
	 */
	public HashMap<String, ArrayList<Pedido>> getListaPedidosContenedorMap() {
		return listaPedidosContenedorMap;
	}

	/**
	 * 
	 * @return String con la fecha actual;
	 */
	public String definirFecha()
	{
		Date fechaOrigen = new Date();
		int dia,mes,anio;
		String strFecha;
		dia=fechaOrigen.getDate();
		mes=fechaOrigen.getMonth()+1;
		anio=fechaOrigen.getYear()+1900;
		strFecha = dia+"/"+mes+"/"+anio;
		
		return strFecha;
	}


	
	
      
}
