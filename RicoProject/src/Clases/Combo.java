package Clases;

import java.util.ArrayList;

import Contenedores.ContenedorArrayList;

public class Combo <T>{
	private String nombre;
	private double precio;
	private boolean agrandado;
	private ArrayList<Producto> productosCombo;  /// TODO UTILIZAR CONTENEDOR ARRAYLIST
	
	private String observaciones;
	private static Bebida bebida;
	
	
	//**Constructor**//
	
	public Combo() {
		nombre="";
		precio=0;
		agrandado=false;  ///TODO SI ES TRUE TENES QUE PONERLE GRANDE A LAS GUARNICION Y BEBIDA;
		productosCombo=new ArrayList<Producto>();  
		observaciones="";
	}
	
	public Combo(String nombre, double precio, boolean agrandado, String observaciones,Bebida bebida,Producto producto1,Producto producto2) {
		this.nombre = nombre;
		this.precio = precio;
		this.agrandado = agrandado;
		
		this.observaciones = observaciones;
		productosCombo= generarListado(bebida,producto1,producto2);
		
		funcionAgrandado(agrandado,productosCombo);
		
		
		//TODO REVISAR CARGA COMBO EN EL CONSTRUCTOR
		
		
	}	
	
	private static void funcionAgrandado(boolean agrandado, ArrayList<Producto> listaCombo) {
		if(agrandado==true)
		{
			for (Producto aux : listaCombo) {
				if(aux instanceof Guarnicion)
				{
					((Guarnicion) aux).setPorcion(" Grande ");
				}
			}
		}
	}
	
	private  ArrayList<Producto> generarListado(Bebida bebida,Producto producto1,Producto producto2) {
		
		ArrayList<Producto> listado = new ArrayList<Producto>();
		listado.add(producto1);
		listado.add(bebida);
		listado.add(producto2);
		
		return listado;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Combo " + nombre );
		if(agrandado==true)
		{
			builder.append(" AGRANDADO ");
		}
		builder.append("\n Precio = $" + precio+ "\n Productos --> " + productosCombo.toString()	+ "\n Observaciones: " + observaciones);
		
		return builder.toString();
	}
}
