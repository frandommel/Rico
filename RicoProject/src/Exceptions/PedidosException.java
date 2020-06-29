package Exceptions;

import GestionComercio.Pedido;

public class PedidosException extends Exception {
	private Pedido pedido;
	
	public PedidosException(String msg){
	super(msg);
	}
	
	@Override
	public String getMessage() {
		return "El pedido"+pedido.getId()+super.getMessage();
	}
	
	
}
