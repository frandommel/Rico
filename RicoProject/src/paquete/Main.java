package paquete;

import java.util.ArrayList;

import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Producto;

public class Main {

	public static void main(String[] args) {
		
		Bebida bebida1 = new Bebida("Gaseosa",65,"","Pepsi");
		Hamburguesa burguer1 = new Hamburguesa("Kelly",120,"",2,false,false);
		Guarnicion guarni1 = new Guarnicion("Papas Fritas", 50, "", "Pequeña");
		
		Combo combito=new Combo("Kelly",200,false,"",bebida1,burguer1,guarni1);
		System.out.println(combito.toString());

	}

}
