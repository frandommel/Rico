package claseProductos;

public class Pancho extends Producto{
	private boolean esVeggie;
	private int cantToppings;

		
	//**Constructor**//
	public Pancho() {
		super();
		esVeggie = false;
	}

	public Pancho(String nombre, int precio, int cantToppings, boolean esVeggie) {
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
		return "Pancho [esVeggie=" + esVeggie + ", cantToppings=" + cantToppings + "]";
	}

	

	
	
}
