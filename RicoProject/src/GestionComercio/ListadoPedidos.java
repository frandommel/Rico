package GestionComercio;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import interfaces.IAccion;

public class ListadoPedidos implements IAccion<String,Pedido> {
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
		// TODO Auto-generated method stub
		
	}



	@Override
	public Pedido buscar(String busqueda) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void listar() {
		// LISTA EL ARCHIVO COMPLETO
		
	}



	@Override
	public String listar(String clave) {
		// LISTA UN DIA EN ESPECIFICO
		return null;
	}



	@Override
	public void alta(Pedido objeto) {
		// TODO Auto-generated method stub
		
	}


	
      
}
