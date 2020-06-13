package jSon;

import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import GestionComercio.ClienteVip;
import GestionComercio.Empleado;
import GestionComercio.Persona;

public class Personas {
	JSONArray arregloPersonasArray;
	
	
	public Personas() throws JSONException {
		 arregloPersonasArray = new JSONArray();
		// arregloPersonasArray.put(leerArrayClientes());
		// arregloPersonasArray.put(leerArrayEmpleado());
	}
	
	
	

	public JSONArray getArregloPersonasArray() {
		return arregloPersonasArray;
	}

	public JSONObject generateEmpleado(Empleado empleado) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nombre", empleado.getNombre());
		jsonObject.put("apellido", empleado.getApellido());
		jsonObject.put("direccion", empleado.getDireccion());
		jsonObject.put("id", empleado.getId());
		jsonObject.put("password", empleado.getPassword());
		jsonObject.put("sueldo", empleado.getSueldo());
		jsonObject.put("posicion", empleado.getPosicion());
		
		
		return jsonObject;
	}
	
	public JSONObject generateCliente(ClienteVip clienteVip) throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("nombre", clienteVip.getNombre());
		jsonObject.put("apellido", clienteVip.getApellido());
		jsonObject.put("direccion", clienteVip.getDireccion());
		jsonObject.put("id", clienteVip.getId());
		jsonObject.put("password", clienteVip.getCantSellos());

		return jsonObject;
	}
	
	public void agregar(JSONArray arreglo,JSONObject object)
	{
		arreglo.put(object);
	}
	
	public void eliminar(JSONArray arreglo,JSONObject object) throws JSONException
	{
		int posicion=-1;
		int i = 0;
		while(i<arreglo.length() && posicion!=-1)
		{
			if(arreglo.get(i) == object)
			{
				posicion=i;
			}
			i++;
		}
		
		if(posicion!=-1)
		{
			arreglo.remove(posicion);
		}
				
	}
	

	public JSONArray leerArrayEmpleado () throws JSONException
	{
		JSONArray jsonArray = new JSONArray();
		
		
		
		return jsonArray;
	}
	
	private JSONArray leerArrayClientes() {
		JSONArray jsonArray = new JSONArray();
		
		
		
		return jsonArray;
	}
	
	
}
