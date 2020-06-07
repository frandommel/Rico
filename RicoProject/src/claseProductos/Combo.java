package claseProductos;


import java.util.ArrayList;

import contenedores.ContenedorArrayList;

public class Combo extends Producto{
	
	private boolean agrandado;
	private ArrayList<Producto> productosCombo;  

	
	
	//**Constructor**//
	
	public Combo() {
		super("",0,"");
		agrandado=false;  ///TODO SI ES TRUE TENES QUE PONERLE GRANDE A LAS GUARNICION Y BEBIDA;
		productosCombo=new ArrayList<Producto>();  
	}
	
	public Combo(String nombre, int precio, boolean agrandado,Bebida bebida,Producto producto1,Producto producto2) {
		
		super(nombre, precio, "");
		this.agrandado = agrandado;
		productosCombo= generarListado(bebida,producto1,producto2);
		
		funcionAgrandado(agrandado,productosCombo);
		}	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Combo " + super.getNombre());
		if(agrandado==true)
		{
			builder.append(" AGRANDADO ");
		}
		builder.append("\n Precio = $" + super.getPrecio()+ "\n Productos --> " + productosCombo.toString()	+ "\n Observaciones: " + super.getObservaciones());
		
		return builder.toString();
	}
	
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
	
	private ArrayList<Producto> generarListado(Bebida bebida,Producto producto1,Producto producto2) {
		
		ArrayList<Producto> listado = new ArrayList<Producto>();
		listado.add(bebida);
		listado.add(producto1);
		listado.add(producto2);
		
		return listado;
	}
}
