package Clases;

import java.util.ArrayList;

public class Ensalada extends Producto {
	public double calorias;
	
	
	//**Constructor**//
	
	public Ensalada() 
	{
		super();
		calorias = 0;
		
	}

	public Ensalada(String nombre, int precio, String observaciones,double calorias)
	{
		super(nombre, precio, observaciones);
		this.calorias=calorias;
		
	}

	//**Getters**//
	
	public double getCalorias() {
		return calorias;
	}

	//**Setters**//

	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}

	@Override
	public String toString() {
		return "Ensalada "+super.getNombre()+" -> Calorias : " + calorias;
		
	}
	
	
	
}
