package Clases;

public class Ensalada extends Producto {
	public double calorias;
		
	
	//**Constructor**//
	
	public Ensalada() 
	{
		super();
		calorias = 0;
	}

	public Ensalada(String nombre, int precio, String observaciones, int cantToppings,double calorias)
	{
		super(nombre, precio, observaciones, cantToppings);
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
}
