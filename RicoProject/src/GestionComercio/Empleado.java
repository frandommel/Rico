package GestionComercio;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Archivos.ArchivoPersona;

public class Empleado extends Persona {
	private String password;
	private String posicion;
	
	
	
	public Empleado() {
		super();
		this.password = "";
		this.posicion = "";
	}



	public Empleado(String nombre, String direccion,String telefono,String password,String posicion) {
		super(nombre, direccion,telefono);
		this.password = password;
		this.posicion = posicion;
		}

	

/**
 * 
 * @return String con el password
 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return String con la posicion(puesto) dentro del Comercio
	 */
	public String getPosicion() {
		return posicion;
	}

	/**
	 * 
	 * @param posicion String
	 */
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}



	@Override
	public JSONObject generateJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nombre", getNombre());
		jsonObject.put("telefono", getTelefono());
		jsonObject.put("direccion", getDireccion());
		jsonObject.put("password", getPassword());
		jsonObject.put("posicion", getPosicion());
		
		return jsonObject;
	}
		


}
