package claseProductos;

import java.io.Serializable;

public abstract class Producto implements Serializable {
	private String nombre;
	private int precio;
	private String observaciones; 

	
	//**Constructors**//
	
	public Producto() {
		nombre="";
		precio=0;
		observaciones="";

	}
	/**
	 * 
	 * @param nombre String
	 * @param precio int
	 * @param observaciones String
	 */
	public Producto(String nombre, int precio, String observaciones ) {
		this.nombre = nombre;
		this.precio = precio;
		this.observaciones = observaciones;
	}
	
	///**Getters**//
	
	/**
	 * 
	 * @return String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @return int
	 */
	public int getPrecio() {
		return precio;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getObservaciones() {
		return observaciones;
	}	
	///***Setters**///
	
	/**
	 * 
	 * @param int
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	/**
	 * 
	 * @param String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @param String
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * To string
	 */
	@Override
	public String toString() {
		return nombre;
	}	
	
}
