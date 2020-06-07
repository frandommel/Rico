package interfaces;

public interface IAccion<T> {
	public void alta(T objeto);
	public void baja(T objeto);
	public <T> void buscar(int id);
	public String listar();
}
