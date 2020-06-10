package claseProductos;

public class Bebida extends Producto{
	private String marca;
	

	public Bebida() {
		super();
		this.marca = "";
	}
	
	
	public Bebida(String nombre, int precio,String marca) {
		super(nombre, precio,"");
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
		return super.getNombre()+" "+ marca + " Precio : $" + super.getPrecio()+"\n";
	}
	
	
	
	
	
}
