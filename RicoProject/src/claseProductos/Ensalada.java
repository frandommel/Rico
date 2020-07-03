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
	 * @param String
	 * @param int
	 * @param double
	 */
	public Ensalada(String nombre, int precio,double calorias)
	{
		super(nombre, precio, "");
		this.calorias=calorias;
		
	}

	
	/**
	 * 
	 * @return Double
	 */
	public double getCalorias() {
		return calorias;
	}

	
	/**
	 * 
	 * @param Double
	 */
	public void setCalorias(double calorias) {
		this.calorias = calorias;
	}
	
	/**
	 * To string
	 */
	@Override
	public String toString() {
		return "Ensalada "+super.getNombre()+" -> Calorias : " + calorias+"\n";
		
	}

	
	
	
	
}
