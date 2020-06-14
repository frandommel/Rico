package GestionComercio;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

public class Empleado extends Persona {
	private String password;
	private int sueldo;
	private String posicion;
	
	
	
	public Empleado() {
		super();
		this.password = "";
		this.sueldo = 0;
		this.posicion = "";
	}



	public Empleado(String nombre, String apellido, String direccion, int id,String password, int sueldo, String posicion) {
		super(nombre, apellido, direccion, id);
		this.password = password;
		this.sueldo = sueldo;
		this.posicion = posicion;
		}

	


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public int getSueldo() {
		return sueldo;
	}



	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}



	public String getPosicion() {
		return posicion;
	}



	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}



	@Override
	public JSONObject generateJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nombre", getNombre());
		jsonObject.put("apellido", getApellido());
		jsonObject.put("direccion", getDireccion());
		jsonObject.put("id", getId());
		jsonObject.put("password", getPassword());
		jsonObject.put("sueldo", getSueldo());
		jsonObject.put("posicion", getPosicion());
		
		return jsonObject;
	}
	



	
	
	

}
