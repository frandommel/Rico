package claseProductos;

public class Hamburguesa extends Producto {
	private boolean esVeggie;
	
	
	
	//**Constructor**//
	
	public Hamburguesa() {
		super();
		esVeggie=false;
		
	}
	public Hamburguesa(String nombre, int precio,boolean esVeggie) {
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
