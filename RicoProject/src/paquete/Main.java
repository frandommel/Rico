package paquete;

import java.util.ArrayList;

import Clases.Bebida;
import Clases.Combo;
import Clases.Guarnicion;
import Clases.Hamburguesa;
import Clases.Producto;

public class Main {

	public static void main(String[] args) {
		
		Bebida bebida1 = new Bebida("Gaseosa",65,"","Pepsi");
		Hamburguesa burguer1 = new Hamburguesa("Kelly",120,"",2,false,false);
		Guarnicion guarni1 = new Guarnicion("Papas Fritas", 50, "", "Peque�a");
		
		Combo combito=new Combo("Kelly",200,false,"",bebida1,burguer1,guarni1);
		System.out.println(combito.toString());

	}

}
