package GestionComercio;

import java.util.ArrayList;
import java.util.Date;

import contenedores.ContenedorMap;
import interfaces.IAccion;

public class Comercio{
	private String nombre;
	private String direccion;
	private String cuit;
	private String rubro;
	private ListadoClientes clientes;
	private ListadoEmpleados empleados;
	private ListadoPedidos pedidos;

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	
	
	@Override
	public String toString() {
		return "Comercio: " + nombre + "\n Direccion=" + direccion + "\n CUIT=" + cuit + "\n Rubro=" + rubro
				+ " \n Listado de Empleados=" + empleados.toString() + "\n Listado de Pedidos=" + pedidos.toString() + "\n Listado de Clientes "+clientes.toString();
	}
	
	
	
	
	
}
