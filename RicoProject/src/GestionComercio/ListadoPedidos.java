package GestionComercio;

import java.io.Serializable;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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



	

	
	
      
}
