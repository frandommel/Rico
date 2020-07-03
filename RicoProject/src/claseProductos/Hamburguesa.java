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
	 * @param String
	 * @param int
	 * @param boolean
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
		StringBuilder builder = new StringBuilder();
		builder.append("Hamburguesa " );
		builder.append(super.toString());
		if(esVeggie==true)
		{
			builder.append(" VEGETARIANA.");
		}
		builder.append("\n");
		
		
		
		return builder.toString();
	}
	
	
	
	
}
