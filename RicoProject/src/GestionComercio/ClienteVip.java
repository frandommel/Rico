package GestionComercio;

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
	
	
	
}
