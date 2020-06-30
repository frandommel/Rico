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
	}

	
	
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
	public void baja(Pedido objeto) {
		
	}
	

	@Override
	public String listar(String clave) {
		ArrayList<Pedido> diaXpedidos = listaPedidosContenedorMap.get(clave);
		StringBuilder builder = new StringBuilder();
		builder.append("Dia "+clave+":\n");
		for(int i=0;i<diaXpedidos.size();i++)
		{
			
			builder.append(diaXpedidos.get(i));
			builder.append("\n");
		}
		
		
		String listado = builder.toString();
		return listado;
	}


	public void inciarDia() {
		String fechaActual = definirFecha();
		ArrayList<Pedido> listaX = new ArrayList<Pedido>();
		listaPedidosContenedorMap.put(fechaActual, listaX);
	}

	@Override
	public void alta(Pedido objeto) {
		if(listaPedidosContenedorMap.containsKey(objeto.getFecha()))
		{
			ArrayList<Pedido> aux = listaPedidosContenedorMap.get(objeto.getFecha());
			aux.add(objeto);
			listaPedidosContenedorMap.replace(objeto.getFecha(), aux);
		}else
		{
			ArrayList<Pedido> aux = new ArrayList<Pedido>();
			aux.add(objeto);
			listaPedidosContenedorMap.put(objeto.getFecha(), aux);
		}
	}
	
	public boolean cobro(Pedido objeto)
	{
		ArrayList<Pedido> aux = listaPedidosContenedorMap.get(objeto.getFecha());
		Pedido buscado = new Pedido();
		int i =0;
		boolean flag = false;
		
		while(i<aux.size()  && flag==false)
		{
			if(aux.get(i).equals(objeto))
			{
				buscado = aux.get(i);
				flag=true;
			}
			
			i++;
		}
		
		if(flag==true)
		{
			buscado.setCobrado(true);
		}
		
		return flag;
		
	}



	@Override
	public Pedido buscar(String busqueda, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder= new StringBuilder();
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		Set<Map.Entry<String, ArrayList<Pedido>>> setE = listaPedidosContenedorMap.entrySet();
		Iterator it =setE.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<String, ArrayList<Pedido>> me = (Map.Entry<String, ArrayList<Pedido>>) it.next();
			pedidos = me.getValue();
			for(int i = 0;i<pedidos.size();i++)
			{
				stringBuilder.append(me.getValue().toString());
				stringBuilder.append("\n");
			}
			
		}
		
		
		return stringBuilder.toString();
	}



	public HashMap<String, ArrayList<Pedido>> getListaPedidosContenedorMap() {
		return listaPedidosContenedorMap;
	}



	public void setListaPedidosContenedorMap(HashMap<String, ArrayList<Pedido>> listaPedidosContenedorMap) {
		this.listaPedidosContenedorMap = listaPedidosContenedorMap;
	}

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
