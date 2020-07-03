package claseProductos;

import java.util.ArrayList;

public class Ensalada extends Producto {
	public double calorias;
	
	
	//**Constructor**//
	
	public Ensalada() 
	{
		super();
		calorias = 0;
		
	}
	/**
	 * 
	 * @param nombre String
	 * @param precio int
	 * @param calorias double
	 */
	public Ensalada(String nombre, int precio,double calorias)
	{
		super(nombre, precio, "");
		this.calorias=calorias;
		
	}

	
	/**
	 * 
	 * @return Double con el atributo calorias
	 */
	public double getCalorias() {
		return calorias;
	}

	
	/**
	 * 
	 * @param calorias Double
	 */
	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}
	
	/**
	 * To string
	 */
	@Override
	public String toString() {
		return "Ensalada "+super.getNombre();
		
	}

	
	
	
	
}
