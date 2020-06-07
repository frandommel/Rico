package Clases;

public abstract class Producto {
	private String nombre;
	private int precio;
	private String observaciones; 

	
	//**Constructors**//
	
	public Producto() {
		nombre="";
		precio=0;
		observaciones="";

	}
	
	public Producto(String nombre, int precio, String observaciones ) {
		this.nombre = nombre;
		this.precio = precio;
		this.observaciones = observaciones;

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

	@Override
	public String toString() {
		return nombre + " Precio : $" + precio;
	}
	
	
	
	//**Metodos**//
	
	
	
	
	
}
