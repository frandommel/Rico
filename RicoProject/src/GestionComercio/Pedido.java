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
	private Date horario;
	
	public Pedido() {
		
		this.id = 0;
		this.condicion = "Efectivo";
		this.productos = new ArrayList<Producto>();
		this.isVip = false;
		
		fecha=definirFecha();
		
		this.cobrado = false;
		this.montoVenta=0;
		horario=new Date();
		
	}
	
	public Pedido(Pedido pedido2) {
		
		this.id = pedido2.getId();
		this.condicion = pedido2.getCondicion();
		this.productos = pedido2.getProductos();
		this.isVip = pedido2.isVip();
		
		fecha=pedido2.getFecha();
		
		this.cobrado = pedido2.isCobrado();
		this.montoVenta=pedido2.getMontoVenta();
		horario=pedido2.getHorario();
		
	}
	
	
	public Pedido(int id, String condicion, ArrayList<Producto> productos, boolean isVip,int montoVenta) {
		super();
		this.id = id;
		this.condicion = condicion;
		this.productos = productos;
		this.isVip = isVip;
		this.fecha = definirFecha();
		this.cobrado = false;
		horario=new Date();
		this.montoVenta=montoVenta;
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

	public void addProductos(Producto prodAgregado) {
		productos.add(prodAgregado);
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

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setMontoVenta(int montoVenta) {
		this.montoVenta = montoVenta;
	}

	@Override
	public String toString() {
		return "Pedido " + id + "--> Condicion: " + condicion + ", fecha=" + fecha + " Productos del pedido-> " + productos.toString() + ", Cliente Vip: " + isVip + ", Cobro: " + cobrado+", Monto: $"+montoVenta;
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
	
	public int verDemora()
	{
		Date fechaOrigen = new Date();
		return fechaOrigen.compareTo(horario);
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
