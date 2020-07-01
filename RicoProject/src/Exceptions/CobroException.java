package Exceptions;

import GestionComercio.Pedido;

public class CobroException extends Exception {

	private Pedido pedido;
	
	public CobroException(String msg,Pedido e) {
		super(msg);
		pedido=e;
	}
	
	@Override
	public String getMessage() {
		return "ALERTA! El pedido "+pedido.getId()+super.getMessage();
	}
}
