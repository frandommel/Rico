package Clases;

public abstract class Producto {
	private String nombre;
	private int precio;
	private String observaciones; 
	private int cantToppings;
	
	//**Constructors**//
	
	public Producto() {
		nombre="";
		precio=0;
		observaciones="";
		cantToppings=0;
	}
	
	public Producto(String nombre, int precio, String observaciones, int cantToppings) {
		this.nombre = nombre;
		this.precio = precio;
		this.observaciones = observaciones;
		this.cantToppings = cantToppings;
	}
	
	///**Getters**//
	
	public String getNombre() {
		return nombre;
	}

	public int getPrecio() {
		return precio;
	}
	
	public String getObservaciones() {
		return observaciones;
	}
	
	public int getCantToppings() {
		return cantToppings;
	}
	
	///***Setters**///
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public void setCantToppings(int cantToppings) {
		this.cantToppings = cantToppings;
	}
	
	//**Metodos**//
	
	
	
	
}
