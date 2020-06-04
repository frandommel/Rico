package Clases;

import java.util.ArrayList;

public class Combo <T>{
	private String nombre;
	private double precio;
	private boolean agrandado;
	private ArrayList<T> combo;
	private String observaciones;
	
	
	//**Constructor**//
	
	public Combo() {
		nombre="";
		precio=0;
		agrandado=false;
		combo=new ArrayList<T>();
		observaciones="";
	}
	
	public Combo(String nombre, double precio, boolean agrandado, String observaciones) {
		this.nombre = nombre;
		this.precio = precio;
		this.agrandado = agrandado;
		this.observaciones = observaciones;
	}	
	
	//**Getters**//
	
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public boolean isAgrandado() {
		return agrandado;
	}
	public String getObservaciones() {
		return observaciones;
	}
	
	//**Setters**//
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setAgrandado(boolean agrandado) {
		this.agrandado = agrandado;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
