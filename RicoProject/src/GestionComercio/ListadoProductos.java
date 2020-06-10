package GestionComercio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Archivos.ArchivoProducto;
import claseProductos.Producto;
import interfaces.IAccion;

public class ListadoProductos implements IAccion<Producto> {
      private HashMap<String, ArrayList<Producto>> listaProductoContenedorMap;
    // private ArchivoProducto archivoProducto;

       public ListadoProductos() {
		listaProductoContenedorMap = new HashMap<String, ArrayList<Producto>>();
		//TODO HACER QUE ESTE LISTADO, TENGA COMO KEY EL TIPO DEL PRODUCTO, Y HAGA UN MAPA DE ARRAYLIST CON CADA PRODUCTO DE LA CARTA
		
	}
	@Override
	public void baja(Producto objeto) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <T> void buscar(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String listar() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void alta(HashMap<String, ArrayList<Producto>> mapa) {
		// TODO Auto-generated method stub
		
	}

   
	
	
      
}
