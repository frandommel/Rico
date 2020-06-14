package GestionComercio;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class Persona {
	private String nombre;
	private String telefono;
	private String direccion;
	
	public Persona() {
		super();
		this.nombre = "";
		this.direccion = "";
		telefono="";
	}
	
	public Persona(String nombre, String direccion,String telefono) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
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
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return nombre + ". Direccion: " + direccion + ". Telefono: "+telefono;
	}
	
	
	public abstract JSONObject generateJson() throws JSONException;
	
	
}
