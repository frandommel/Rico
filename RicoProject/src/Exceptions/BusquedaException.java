package Exceptions;

public class BusquedaException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param msg String con el mensaje de la excepcion
	 */
	public BusquedaException(String msg) {
		super(msg);
	
	}

	
	/**
	 * envia un mensaje respecto a los pedidos que no han sido encontrados
	 */
	@Override
	public String getMessage() {
		return "No hay pedidos del dia " + super.getMessage();
	}
}
