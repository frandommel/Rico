package interfaces;

import java.util.ArrayList;
import java.util.HashMap;

import claseProductos.Producto;

public interface IAccion<V,T> {
	public void baja(T objeto);
	public T  buscar(V busqueda);
	public void listar();
	public String listar(V clave);
	public void alta(T objeto);
}
