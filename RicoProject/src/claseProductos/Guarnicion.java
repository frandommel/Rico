package claseProductos;

public class Guarnicion extends Producto {

	public Guarnicion() {
		super();
	}
	
	/**
	 * 
	 * @param String
	 * @param int
	 * Constructor
	 */
	public Guarnicion(String nombre, int precio) {
		super(nombre, precio, "");
	}
	/**
	 * To string
	 */
	@Override
	public String toString() {
		return super.getNombre()+"\n";
	}

	
	
	
}
