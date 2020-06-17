package GestionComercio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import claseProductos.Producto;


public class Pedido implements Serializable{
	private int id;
	private String condicion;
	private ArrayList<Producto> productos;
	private boolean isVip;
	private String fecha;
	private int montoVenta;
	private boolean cobrado;
	
	public Pedido() {
		
		this.id = 0;
		this.condicion = "Efectivo";
		this.productos = new ArrayList<Producto>();
		this.isVip = false;
		
		fecha=definirFecha();
		
		this.cobrado = false;
		this.montoVenta=0;
		
	}
	
	public Pedido(int id, String condicion, ArrayList<Producto> productos, boolean isVip) {
		super();
		this.id = id;
		this.condicion = condicion;
		this.productos = productos;
		this.isVip = isVip;
		this.fecha = definirFecha();
		this.cobrado = false;
		setMontoVenta();
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


	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	
	
	public boolean isCobrado() {
		return cobrado;
	}
	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}
	
	public int getMontoVenta() {
		return montoVenta;
	}

	public void setMontoVenta() {
		
		Integer montoVenta = 0;
		for(int i=0;i<productos.size();i++)
		{
			montoVenta=montoVenta+productos.get(i).getPrecio();
		}
		this.montoVenta = montoVenta;
	}

	@Override
	public String toString() {
		return "Pedido " + id + "--> Condicion: " + condicion + ", fecha=" + fecha + "\n"
				+ " Pedido: " + productos.toString() + ", Cliente Vip: " + isVip + ", Cobro: " + cobrado;
	}
	
	
	public String definirFecha()
	{
		Date fechaOrigen = new Date();
		int dia,mes,anio;
		String strFecha;
		dia=fechaOrigen.getDate();
		mes=fechaOrigen.getMonth()+1;
		anio=fechaOrigen.getYear()+1900;
		strFecha = dia+"/"+mes+"/"+anio;
		
		return strFecha;
	}

	public String getFecha() {
		return fecha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
	
	
	
	
}
