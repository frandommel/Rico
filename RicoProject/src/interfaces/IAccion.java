package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import claseProductos.Producto;

public interface IAccion<V,T> {
	public T  buscar(V busqueda,int id);
	public String listar(V clave);
	public void alta(T objeto);
}
