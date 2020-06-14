package GestionComercio;

import org.json.JSONException;
import org.json.JSONObject;

public class ClienteVip extends Persona{
	public int cantSellos;

	public ClienteVip() {
		super();
		cantSellos=0;
	}

	public ClienteVip(String nombre, String apellido, String direccion, int id,int cantSellos) {
		super(nombre, apellido, direccion, id);
		this.cantSellos=cantSellos;
	}
	
	public ClienteVip(String nombre, String apellido, String direccion) {
	///	super(nombre, apellido, direccion );  TODO BUSCAR EN EL ARCHIVO EL ID Y HACERLO AUTOMATICO
		this.cantSellos=0;
	}

	public int getCantSellos() {
		return cantSellos;
	}

	public void setCantSellos(int cantSellos) {
		this.cantSellos = cantSellos;
	}

	@Override
	public String toString() {
		return super.toString()+" ClienteVip " + cantSellos + " Sellos.";
	}
	@Override
	public JSONObject generateJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nombre",getNombre());
		jsonObject.put("apellido",getApellido());
		jsonObject.put("direccion",getDireccion());
		jsonObject.put("id",getId());
		jsonObject.put("password",getCantSellos());

		return jsonObject;
	}
	

	
	
}
