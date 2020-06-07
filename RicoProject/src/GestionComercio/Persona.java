package GestionComercio;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String direccion;
	private int id;
	
	public Persona() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.direccion = "";
		this.id = 0	;
	}
	
	public Persona(String nombre, String apellido, String direccion, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Persona "+id+"--> "+ nombre + " " + apellido + ". Direccion: " + direccion;
	}
	
	
	
	
	
}
