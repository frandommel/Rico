package claseProductos;

public class Pancho extends Producto{
	private boolean esVeggie;
	

		
	//**Constructor**//
	public Pancho() {
		super();
		esVeggie = false;

	}

	public Pancho(String nombre, int precio, boolean esVeggie) {
		super(nombre, precio, "");
		this.esVeggie=esVeggie;
	}

	//**Getters**//
	public boolean isEsVeggie() {
		return this.esVeggie;
	}
	
	
		
	//**Setters**//
	public boolean setEsVeggie() {
		return true;
	}

	

	@Override
	public String toString() {
		return super.getNombre() +" Pancho [esVeggie=" + esVeggie+"\n";
	}

	

	
	
}
