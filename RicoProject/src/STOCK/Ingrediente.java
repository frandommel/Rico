package STOCK;

public class Ingrediente {
	private String nombre;
	private double costo;
	private int stock;
	
	public Ingrediente() {
		
		this.nombre = "";
		this.costo = 0 ;
		this.stock = 0;
	}
	
	public Ingrediente(String nombre, double costo, int stock) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.stock = stock;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	/**
	 * @apiNote Show all atributtes of this class
	 * @return
	 */
	
	public String toString2() {
		return nombre + ", costo=" + costo + ", stock=" + stock + "]";
	}
	
	
	
	
}
