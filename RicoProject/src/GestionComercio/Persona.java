package GestionComercio;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Persona {
	private String nombre;
	private String telefono;
	private String direccion;
	private int id;
	
	public Persona() {
		super();
		this.nombre = "";
		this.direccion = "";
		this.id = 0	;
		telefono="";
	}
	
	public Persona(String nombre, String direccion,String telefono, int id) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.id = id;
		this.telefono=telefono;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona "+id+"--> "+ nombre + ". Direccion: " + direccion;
	}
	
	
	public abstract JSONObject generateJson() throws JSONException;
	
	
}
