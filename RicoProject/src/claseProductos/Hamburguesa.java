package claseProductos;

public class Hamburguesa extends Producto {
	private boolean esVeggie;
	
	private int cantToppings;
	
	//**Constructor**//
	
	public Hamburguesa() {
		super();
		esVeggie=false;
	}
	public Hamburguesa(String nombre, int precio, int cantToppings, boolean esVeggie) {
		super(nombre, precio, "");
		this.esVeggie=esVeggie;
		this.cantToppings=cantToppings;
	}
	
	//**Getters**//
	public boolean isEsVeggie() {
		return this.esVeggie;
	}
	
		
	
		
	public int getCantToppings() {
		return cantToppings;
	}
	//**Setters**//
	public boolean setEsVeggie() {
		return true;
	}
	
	
	public void setCantToppings(int cantToppings) {
		this.cantToppings = cantToppings;
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
		
		
		
		return builder.toString();
	}
	
	
	
	
}
