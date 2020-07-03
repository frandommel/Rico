package claseProductos;

public class Pancho extends Producto{
	private boolean esVeggie;
	

		
	//**Constructor**//
	public Pancho() {
		super();
		esVeggie = false;

	}
	/**
	 * 
	 * @param String
	 * @param  precio
	 * @param boolean
	 * Constructor
	 */
	public Pancho(String nombre, int precio, boolean esVeggie) {
		super(nombre, precio, "");
		this.esVeggie=esVeggie;
	}

	//**Getters**//
	/**
	 * 
	 * @return boolean
	 */
	public boolean isEsVeggie() {
		return this.esVeggie;
	}
	
	
		
	//**Setters**//
	/**
	 * 
	 * @return boolean
	 */
	public boolean setEsVeggie() {
		return true;
	}

	
	/**
	 * To string
	 */
	@Override
	public String toString() {
		return super.getNombre() +" Pancho [esVeggie=" + esVeggie+"\n";
	}

	

	
	
}
