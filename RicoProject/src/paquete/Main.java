package paquete;

import java.util.ArrayList;

import javax.sound.midi.Soundbank;

import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;
import claseProductos.Producto;

public class Main {

	public static void main(String[] args) {
		
		Bebida bebida1 = new Bebida("Gaseosa 237cc",60,"Linea Pepsi");
		Bebida bebida2 = new Bebida("Gaseosa 500cc",70,"Linea Pepsi");
		Bebida bebida3 = new Bebida("Limonada",70,"Rico");
		Bebida bebida4 = new Bebida("Cerveza",150,"Corona");
		Bebida bebida5 = new Bebida("Cerveza",165,"Patagonia");
		Bebida bebida6 = new Bebida("Cerveza",130,"Stella Artois");
		

		Guarnicion guarni1 = new Guarnicion("Nuggets", 150);
		Guarnicion guarni2 = new Guarnicion("Papas Fritas", 100);
		Guarnicion guarni3 = new Guarnicion("Papas Rico", 200);

		
		Ensalada ensalada1=new Ensalada("Ukelele", 160 , 250);
		Ensalada ensalada2=new Ensalada("Hula Hula", 160 , 180);
		Ensalada ensalada3=new Ensalada("Aloha", 160 , 210);
		
		
		Pancho pancho1 = new Pancho("Rico",150,false);
		Pancho pancho2 = new Pancho("Salsa",100,false);
		Pancho pancho3 = new Pancho("Rookie",70,false);
		Pancho pancho4 = new Pancho("Veggie",70,false);
		
		Hamburguesa burguer1 = new Hamburguesa("Kelly",200,false);
		Hamburguesa burguer2 = new Hamburguesa("Doble queso",110,false);
		Hamburguesa burguer3 = new Hamburguesa("Big wave",280,false);
		Hamburguesa burguer4 = new Hamburguesa("Jeremy",180,false);
		Hamburguesa burguer5 = new Hamburguesa("Veggie",110,false);
		Hamburguesa burguer6 = new Hamburguesa("Doble carne Doble queso",160,false);
		

		
		Combo combito1=new Combo("Kelly",320,false,bebida1,burguer1,guarni2);
		Combo combito2=new Combo("Doble Queso",220,false,bebida1,burguer2,guarni2);
		Combo combito3=new Combo("Jeremy",280,true,bebida1,burguer3,guarni2);
		Combo combito4=new Combo("Big Wave",390,false,bebida1,burguer4,guarni2);
		Combo combito5=new Combo("Veggie",220,false,bebida1,burguer5,guarni2);
		
		System.out.println(combito3.toString());
		
		
	}

}
