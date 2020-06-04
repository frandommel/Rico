package Clases;

public class Pancho extends Producto{
	private boolean esVeggie;

		
	//**Constructor**//
	public Pancho() {
		super();
		esVeggie = false;
	}

	public Pancho(String nombre, int precio, String observaciones, int cantToppings, boolean esVeggie) {
		super(nombre, precio, observaciones, cantToppings);
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
}
