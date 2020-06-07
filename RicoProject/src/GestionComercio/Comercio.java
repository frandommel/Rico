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
	private ListadoClientes clientes; /// esto es un mapa de clientes, generico.
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

	public ListadoClientes getClientes() {
		return clientes;
	}

	public void setClientes(ListadoClientes clientes) {
		this.clientes = clientes;
	}

	public ListadoEmpleados getEmpleados() {
		return empleados;
	}

	public void setEmpleados(ListadoEmpleados empleados) {
		this.empleados = empleados;
	}

	public ListadoPedidos getPedidos() {
		return pedidos;
	}

	public void setPedidos(ListadoPedidos pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Comercio: " + nombre + "\n Direccion=" + direccion + "\n CUIT=" + cuit + "\n Rubro=" + rubro
				+ " \n Listado de Empleados=" + empleados.toString() + "\n Listado de Pedidos=" + pedidos.toString() + "\n Listado de Clientes "+clientes.toString();
	}
	
	
	
	
	
}
