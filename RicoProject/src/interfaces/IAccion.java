package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import claseProductos.Producto;

public interface IAccion<V,T> {
	public void baja(T objeto);
	public T  buscar(int id);
	public String listar();
	public void alta(HashMap<V, T > mapa);
}
