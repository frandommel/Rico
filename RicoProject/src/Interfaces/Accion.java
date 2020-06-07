package Interfaces;

public interface Accion<T> {
	public void alta(T objeto);
	public void baja(T objeto);
	public void buscar(T objeto);
}
