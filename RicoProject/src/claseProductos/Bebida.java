package claseProductos;

public class Bebida extends Producto{
	private String marca;
	

	public Bebida() {
		super();
		this.marca = "";
	}
	
	/**
	 * @param nombre String
	 * @param precio Int
	 * @param marca String
	 * Constructor
	 */
	public Bebida(String nombre, int precio,String marca) {
		super(nombre, precio,"");
		this.marca = marca;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getMarca() {
		return marca;
	}
	
	/**
	 * 
	 * @param String
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	/**
	 * To string
	 */
	@Override
	public String toString() {
		return super.getNombre();
	}
	
	
	
	
	
}
