package claseProductos;

public class Guarnicion extends Producto {

	public Guarnicion() {
		super();
	}

	public Guarnicion(String nombre, int precio) {
		super(nombre, precio, "");
	}

	

	@Override
	public String toString() {
		return super.getNombre();
	}

	
	
	
}
