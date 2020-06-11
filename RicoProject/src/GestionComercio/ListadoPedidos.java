package GestionComercio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import interfaces.IAccion;

public class ListadoPedidos implements IAccion<String,Pedido> {
      private HashMap<String, Pedido> listaPedidosContenedorMap;
      private int montoDiario;

      public ListadoPedidos() {
		
    	  listaPedidosContenedorMap = new HashMap<String, Pedido>();
		montoDiario=0;
	}

	@Override
	public void baja(Pedido objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void buscar(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alta(HashMap<String, Pedido> mapa) {
		
		
	}



	
      
}
