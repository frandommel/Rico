package GestionComercio;

import java.util.Date;

import contenedores.ContenedorMap;
import interfaces.IAccion;

public class ListadoPedidos implements IAccion<Pedido> {
      private ContenedorMap<Date, Pedido> listaPedidosContenedorMap;
      private int montoDiario;

      public ListadoPedidos() {
		
		this.listaPedidosContenedorMap = new ContenedorMap<Date, Pedido>();
		montoDiario=0;
	}

	/** Metodos de la interfaz **/
      
	@Override
	public void alta(Pedido objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void baja(Pedido objeto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <Pedido> void buscar(int id) {
		
		
	}

	@Override
	public String listar() {
		// TODO Auto-generated method stub
		return null;
	}
      
      
}
