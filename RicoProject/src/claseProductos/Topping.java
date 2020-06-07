package claseProductos;

public class Topping {
	private int id;
	private String nombre;
	
	public Topping() {
	
		this.id = 0;
		this.nombre = "";
	}
	
	public Topping(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Topping [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
