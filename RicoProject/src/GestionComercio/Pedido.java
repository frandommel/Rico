package GestionComercio;

import java.util.Date;

import claseProductos.Producto;
import contenedores.ContenedorArrayList;

public class Pedido {
	private int id;
	private String condicion;
	private ContenedorArrayList<Producto> productos;
	private boolean isVip;
	private Date fecha;
	private boolean cobrado;
	
	public Pedido() {
		
		this.id = 0;
		this.condicion = "Efectivo";
		this.productos = new ContenedorArrayList<Producto>();
		this.isVip = false;
		this.fecha = new Date();
		this.cobrado = false;
	}
	
	public Pedido(int id, String condicion, ContenedorArrayList<Producto> productos, boolean isVip) {
		super();
		this.id = id;
		this.condicion = condicion;
		this.productos = productos;
		this.isVip = isVip;
		this.fecha = new Date();
		this.cobrado = false;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public ContenedorArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ContenedorArrayList<Producto> productos) {
		this.productos = productos;
	}
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isCobrado() {
		return cobrado;
	}
	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}

	@Override
	public String toString() {
		return "Pedido " + id + "--> Condicion: " + condicion + ", fecha=" + fecha + "\n"
				+ " Pedido: " + productos.toString() + ", Cliente Vip: " + isVip + ", Cobro: " + cobrado;
	}
	
	
	
}
