package Clases;

public class Hamburguesa extends Producto {
	private boolean esVeggie;
	private boolean aptoCeliaco;
	private int cantToppings;
	
	//**Constructor**//
	
	public Hamburguesa() {
		super();
		esVeggie=false;
		aptoCeliaco=false;		
	}
	public Hamburguesa(String nombre, int precio, String observaciones, int cantToppings, boolean esVeggie, boolean aptoCeliaco) {
		super(nombre, precio, observaciones);
		this.aptoCeliaco=aptoCeliaco;
		this.esVeggie=esVeggie;
		this.cantToppings=cantToppings;
	}
	
	//**Getters**//
	public boolean isEsVeggie() {
		return this.esVeggie;
	}
	
	public boolean isAptoCeliaco() {
		return this.aptoCeliaco;
	}	
	
		
	public int getCantToppings() {
		return cantToppings;
	}
	//**Setters**//
	public boolean setEsVeggie() {
		return true;
	}
	public boolean setAptoCeliaco() {
		return true;
	}
	
	
	public void setCantToppings(int cantToppings) {
		this.cantToppings = cantToppings;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hamburguesa " );
		builder.append(super.toString());
		if(esVeggie==true && aptoCeliaco==true)
		{
			builder.append(" VEGETARIANA / SIN TACC. ");
		}else if (esVeggie==true) {
			builder.append(" VEGETARIANA. ");
		}else if(aptoCeliaco==true){
			
			builder.append(" SIN TACC. ");
		}
		
		
		
		return builder.toString();
	}
	
	
}
