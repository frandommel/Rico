package GestionComercio;

import java.util.Date;

import contenedores.ContenedorMap;
import interfaces.IAccion;

public class ListadoPedidos implements IAccion<Pedido> {
      private ContenedorMap<Date, Pedido> listaPedidosContenedorMap;

      public ListadoPedidos() {
		
		this.listaPedidosContenedorMap = new ContenedorMap<Date, Pedido>();
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
