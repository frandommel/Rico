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
	
	/**
	 * 
	 * @return String nombre de la persona
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * @param nombre String 
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return String direccion de la persona
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * 
	 * @param direccion String
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * 
	 * @return String atributo telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * 
	 * @param telefono String
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return nombre + ". Direccion: " + direccion + ". Telefono: "+telefono;
	}
	
	/**
	 * 
	 * @return JsonObject con el contenido de los distintos tipos de personas
	 * @throws JSONException
	 */
	public abstract JSONObject generateJson() throws JSONException;
	
	
}
