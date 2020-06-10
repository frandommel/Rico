package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import claseProductos.Producto;

public interface IAccion<T> {
	public void baja(T objeto);
	public <T> void buscar(int id);
	public String listar();
	public void alta(HashMap<String, ArrayList<T>> mapa);
}
