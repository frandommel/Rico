package GestionComercio;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Persona {
	private String nombre;
	private int telefono;
	private String direccion;
	private int id;
	
	public Persona() {
		super();
		this.nombre = "";
		this.direccion = "";
		this.id = 0	;
		telefono=0;
	}
	
	public Persona(String nombre, String direccion,int telefono, int id) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.id = id;
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
	
	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Persona "+id+"--> "+ nombre + ". Direccion: " + direccion;
	}
	
	
	public abstract JSONObject generateJson() throws JSONException;
	
	
}
