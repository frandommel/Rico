package claseProductos;


import java.io.Serializable;
import java.util.ArrayList;



public class Combo extends Producto implements Serializable{
	
	private boolean agrandado;
	private ArrayList<Producto> productosCombo;  

	
	
	//**Constructor**//
	
	public Combo() {
		super("",0,"");
		agrandado=false;  ///TODO SI ES TRUE TENES QUE PONERLE GRANDE A LAS GUARNICION Y BEBIDA;
		productosCombo=new ArrayList<Producto>();  
	}
	
	public Combo(String nombre, int precio,Bebida bebida,Producto producto1,Producto producto2) {
		
		super(nombre, precio, "");
		this.agrandado = false;
		productosCombo= generarListado(bebida,producto1,producto2);
		
		funcionAgrandado(agrandado,productosCombo);
		}	
	
	
	/**
	 * To string
	 */
	@Override
	public String toString() {
		
		return super.getNombre();
	}
	
	/**
	 * 
	 * @param agrandado boolean
	 * @param listaCombo ArrayList<Producto>
	 */
	private void funcionAgrandado(boolean agrandado, ArrayList<Producto> listaCombo) 
	{
		Bebida bebidaGrande = new Bebida("Gaseosa 500 cc",70,"Linea Pepsi");
		if(agrandado==true)
		{
			listaCombo.remove(0);
			listaCombo.add(0, bebidaGrande);
			super.setPrecio(super.getPrecio()+20);
		}
	
	}
	
	/**
	 * 
	 * @param bebida Bebida
	 * @param producto1 Producto
	 * @param Producto
	 * @return ArrayList<Producto> 
	 */
	private ArrayList<Producto> generarListado(Bebida bebida,Producto producto1,Producto producto2) {
		
		ArrayList<Producto> listado = new ArrayList<Producto>();
		listado.add(bebida);
		listado.add(producto1);
		listado.add(producto2);
		
		return listado;
	}
}
