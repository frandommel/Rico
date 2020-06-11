package GestionComercio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import interfaces.IAccion;

public class ListadoPedidos implements IAccion<String,ArrayList<Pedido>> {
      private HashMap<String, ArrayList<Pedido>> listaPedidosContenedorMap;
      private int montoDiario;

      public ListadoPedidos() {
		
    	  listaPedidosContenedorMap = new HashMap<String, ArrayList<Pedido>>();
		montoDiario=0;
	}

	@Override
	public void baja(ArrayList<Pedido> objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Pedido> buscar(int id) {
		///LO QUE PASEMOS EN EL LUGAR DE COMLETAR TIENE QUE SER EN FECHA, PASARLO A INTEGER PARA ESTA FUNCION Y AHI USARLO EN LA COMPARACION
		return null;
	}

	@Override
	public String listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(HashMap<String, ArrayList<Pedido>> mapa) {
		// TODO Auto-generated method stub
		
	}

	



	
      
}
