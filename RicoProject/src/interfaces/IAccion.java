package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import claseProductos.Producto;

public interface IAccion<V,T> {
	public ArrayList<T>  buscar(V busqueda);
	public String listar();
	public void alta(T objeto);
}
