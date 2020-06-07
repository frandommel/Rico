package claseProductos;

public class Bebida extends Producto{
	private String marca;
	private String tipo;
	

	public Bebida() {
		super();
		this.marca = "";
	}
	
	
	public Bebida(String nombre, int precio, String observaciones,String marca) {
		super(nombre, precio, observaciones);
		this.marca = marca;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	@Override
	public String toString() {
		return super.getNombre()+" "+ marca;
	}
	
	
	
	
}
