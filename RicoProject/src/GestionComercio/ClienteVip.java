package GestionComercio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Archivos.ArchivoPersona;

public class ClienteVip extends Persona{
	public int cantSellos;

	public ClienteVip() {
		super();
		cantSellos=0;
	}

	/**
	 * 
	 * @param nombre String
	 * @param direccion String
	 * @param telefono String
	 * @param cantSellos int , generalmente 0 en el inicio de nuevos clientes
	 */
	public ClienteVip(String nombre, String direccion,String telefono,int cantSellos) {
		super(nombre, direccion,telefono);
		this.cantSellos=cantSellos;
		
	}
	
	public ClienteVip(String nombre, String apellido, String direccion) {
	///	super(nombre, apellido, direccion );  TODO BUSCAR EN EL ARCHIVO EL ID Y HACERLO AUTOMATICO
		this.cantSellos=0;
	}

	/**
	 * 
	 * @return cantSellos
	 */
	public int getCantSellos() {
		return cantSellos;
	}

	/**
	 * 
	 * @param cantSellos int 
	 */
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
		jsonObject.put("telefono", getTelefono());
		jsonObject.put("direccion",getDireccion());
		jsonObject.put("cantSellos",getCantSellos());

		return jsonObject;
	}

	
	
}
