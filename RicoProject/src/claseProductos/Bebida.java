package claseProductos;

public class Bebida extends Producto{
	private String marca;
	

	public Bebida() {
		super();
		this.marca = "";
	}
	
	/**
	 * @param String
	 * @param Int
	 * @param String
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
		return super.getNombre()+" "+ marca + " Precio : $" + super.getPrecio()+"\n";
	}
	
	
	
	
	
}
