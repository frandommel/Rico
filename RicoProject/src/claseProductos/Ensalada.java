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

	public Ensalada(String nombre, int precio,double calorias)
	{
		super(nombre, precio, "");
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
		return "Ensalada "+super.getNombre()+" -> Calorias : " + calorias+"\n";
		
	}

	
	
	
	
}
