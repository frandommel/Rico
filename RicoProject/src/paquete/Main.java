package paquete;

import java.util.ArrayList;

import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;
import claseProductos.Producto;

public class Main {

	public static void main(String[] args) {
		
		Bebida bebida1 = new Bebida("Cerveza",65,"","Heineken");
		System.out.println(bebida1.toString());
		
		Hamburguesa burguer1 = new Hamburguesa("Kelly",200,false);
		Hamburguesa burguer2 = new Hamburguesa("Doble queso",110,false);
		Hamburguesa burguer3 = new Hamburguesa("Big wave",280,false);
		Hamburguesa burguer4 = new Hamburguesa("Jeremy",180,false);
		Hamburguesa burguer5 = new Hamburguesa("Veggie",110,false);
		Hamburguesa burguer6 = new Hamburguesa("Doble carne Doble queso",160,false);
		
		Guarnicion guarni1 = new Guarnicion("Papas Fritas", 50,"Pequeña");
		
		Ensalada ensalada1=new Ensalada("Ukelele", 190 , 200);
		System.out.println(ensalada1.toString());
		
		Pancho dommel = new Pancho("Rico",120,2,false);
		System.out.println(dommel.toString());

		
		Combo combito=new Combo("Kelly",320,false,bebida1,burguer1,guarni1);
		System.out.println(combito.toString());
		
		Combo combito1=new Combo("Doble Queso",220,false,bebida1,burguer1,guarni1);
		System.out.println(combito.toString());
		
		Combo combito2=new Combo("Jeremy",280,false,bebida1,burguer1,guarni1);
		System.out.println(combito.toString());
		
		Combo combito3=new Combo("Big Wave",390,false,bebida1,burguer1,guarni1);
		System.out.println(combito.toString());
		
		Combo combito4=new Combo("Veggie",220,false,bebida1,burguer1,guarni1);
		System.out.println(combito.toString());
		
	}

}
