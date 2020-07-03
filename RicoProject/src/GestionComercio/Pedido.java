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
	
	/**
	 * 
	 * @param pedido2 crea una copia en base a otro pedido
	 */
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
	
	/**
	 * 
	 * @param id int
	 * @param condicion String
	 * @param productos ArrayList(Producto)
	 * @param isVip boolean
	 * @param montoVenta int
	 */
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
	
	/**
	 * 
	 * @return int attribute ID
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id int
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return String Condicion de pago del pedido
	 */
	public String getCondicion() {
		return condicion;
	}
	/**
	 * 
	 * @param condicion String
	 */
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}


	/**
	 * 
	 * @return Listado de Productos de un pedido
	 */
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	/**
	 * Agrega un producto al listado del pedido
	 * @param prodAgregado Producot
	 */
	public void addProductos(Producto prodAgregado) {
		productos.add(prodAgregado);
	}
	
	/**
	 * 
	 * @param productos ArrayList de Productos
	 */
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	/**
	 * 
	 * @return condicion del cliente
	 */
	public boolean isVip() {
		return isVip;
	}
	
	/**
	 * 
	 * @param isVip
	 */
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	
	/**
	 * 
	 * @return true si el pedido fue cobrado
	 */
	public boolean isCobrado() {
		return cobrado;
	}
	
	/**
	 * setea el cobro
	 * @param cobrado 
	 */
	public void setCobrado(boolean cobrado) {
		this.cobrado = cobrado;
	}
	
	/**
	 * 
	 * @return monto final del Pedido
	 */
	public int getMontoVenta() {
		return montoVenta;
	}

	/**
	 * 
	 * @return el Horario en que hizo el pedido en un formato Date
	 */
	public Date getHorario() {
		return horario;
	}

	
	/**
	 * 
	 * @param fecha String
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * 
	 * @param montoVenta int
	 */
	public void setMontoVenta(int montoVenta) {
		this.montoVenta = montoVenta;
	}

	@Override
	public String toString() {
		return "Pedido " + id + "--> Condicion: " + condicion + ", fecha=" + fecha + " Productos del pedido-> " + productos.toString() + ", Cliente Vip: " + isVip + ", Cobro: " + cobrado+", Monto: $"+montoVenta;
	}
	
	/**
	 * 
	 * @return String con la fecha actual;
	 */
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
