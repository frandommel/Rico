package claseProductos;

public class Guarnicion extends Producto {
	private String porcion;

	public Guarnicion() {
		super();
		porcion="";
	}

	public Guarnicion(String nombre, int precio, String porcion) {
		super(nombre, precio, "");
		this.porcion=porcion;
	}

	public String getPorcion() {
		return porcion;
	}

	public void setPorcion(String porcion) {
		this.porcion = porcion;
	}

	@Override
	public String toString() {
		return super.getNombre()+" "+porcion;
	}

	
	
	
}
