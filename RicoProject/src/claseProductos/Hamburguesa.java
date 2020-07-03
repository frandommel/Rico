package claseProductos;

public class Hamburguesa extends Producto {
	private boolean esVeggie;
	
	
	
	//**Constructor**//
	
	public Hamburguesa() {
		super();
		esVeggie=false;
		
	}
	/**
	 * 
	 * @param nombre String
	 * @param precio int
	 * @param esVeggie boolean
	 */
	public Hamburguesa(String nombre, int precio,boolean esVeggie) {
		super(nombre, precio, "");
		this.esVeggie=esVeggie;
		
	}
	
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
		return "Hamburguesa " + super.getNombre();
	}
	
	
	
	
}
