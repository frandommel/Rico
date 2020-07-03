package paquete;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.sound.midi.Soundbank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Archivos.ArchivoPedidos;
import Archivos.ArchivoPersona;
import Archivos.ArchivoProducto;
import GestionComercio.ClienteVip;
import GestionComercio.Comercio;
import GestionComercio.Empleado;
import GestionComercio.ListadoPedidos;
import GestionComercio.Pedido;
import GestionComercio.Persona;
import InterfazGrafica.Inicio;
import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;
import claseProductos.Producto;

public class Main {

	public static void main(String[] args) throws JSONException{

	Comercio comercioRico = new Comercio();
		
		
	Inicio inicio= new Inicio(comercioRico);
	inicio.setVisible(true);
		
	
		
	}
	
	
	

}
