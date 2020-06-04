package Clases;

public class Hamburguesa extends Producto {
	private boolean esVeggie;
	private boolean aptoCeliaco;
	
	
	//**Constructor**//
	
	public Hamburguesa() {
		super();
		esVeggie=false;
		aptoCeliaco=false;		
	}
	public Hamburguesa(String nombre, int precio, String observaciones, int cantToppings, boolean esVeggie, boolean aptoCeliaco) {
		super(nombre, precio, observaciones, cantToppings);
		this.aptoCeliaco=aptoCeliaco;
		this.esVeggie=esVeggie;
	}
	
	//**Getters**//
	public boolean isEsVeggie() {
		return this.esVeggie;
	}
	
	public boolean isAptoCeliaco() {
		return this.aptoCeliaco;
	}	
		
	//**Setters**//
	public boolean setEsVeggie() {
		return true;
	}
	public boolean setAptoCeliaco() {
		return true;
	}
}
