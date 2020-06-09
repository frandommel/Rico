package paquete;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.sound.midi.Soundbank;

import Archivos.ArchivoProducto;
import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;
import claseProductos.Producto;

public class Main {

	public static void main(String[] args){
		
		ArchivoProducto archiProductos = new ArchivoProducto();
		
		Bebida bebidaGaseosa237 = new Bebida("Gaseosa 237cc",60,"Linea Pepsi");
		Bebida bebidaGaseosa500 = new Bebida("Gaseosa 500cc",70,"Linea Pepsi");
		Bebida bebidaLimonada = new Bebida("Limonada",70,"Rico");
		Bebida bebidaCorona = new Bebida("Cerveza",150,"Corona");
		Bebida bebidaPatagonia = new Bebida("Cerveza",165,"Patagonia");
		Bebida bebidaStellaArtois = new Bebida("Cerveza",130,"Stella Artois");
		

		Guarnicion guarnicionNuggets = new Guarnicion("Nuggets", 150);
		Guarnicion guarnicionPapas = new Guarnicion("Papas Fritas", 100);
		Guarnicion guarnicionRico = new Guarnicion("Papas Rico", 200);

		
		Ensalada ensaladaUkelele=new Ensalada("Ukelele", 160 , 250);
		Ensalada ensaladaHulaHula=new Ensalada("Hula Hula", 160 , 180);
		Ensalada ensaladaAloha=new Ensalada("Aloha", 160 , 210);
		
		
		Pancho panchoRico = new Pancho("Rico",150,false);
		Pancho panchoSalsas = new Pancho("Pancho",100,false);
		Pancho panchoRookie = new Pancho("Rookie",70,false);
		Pancho panchoVeggie = new Pancho("Veggie",70,false);
		
		Hamburguesa burguerKelly = new Hamburguesa("Kelly",200,false);
		Hamburguesa burguerDobleQueso = new Hamburguesa("Doble queso",110,false);
		Hamburguesa burguerBigWave = new Hamburguesa("Big wave",280,false);
		Hamburguesa burguerJeremy = new Hamburguesa("Jeremy",180,false);
		Hamburguesa burguerVeggie = new Hamburguesa("Veggie",110,false);
		Hamburguesa burguerDobleCarneDobleQueso = new Hamburguesa("Doble carne Doble queso",160,false);
		

		
		Combo comboKelly=new Combo("Combo Kelly",320,bebidaGaseosa237,burguerKelly,guarnicionPapas);
		Combo comboDobleQueso=new Combo("Combo Doble Queso",220,bebidaGaseosa237,burguerDobleQueso,guarnicionPapas);
		Combo comboJeremy=new Combo("Combo Jeremy",280,bebidaGaseosa237,burguerJeremy,guarnicionPapas);
		Combo comboBigWave=new Combo("Combo Big Wave",390,bebidaGaseosa237,burguerBigWave,guarnicionPapas);
		Combo comboVeggie=new Combo("Combo Veggie",220,bebidaGaseosa237,burguerVeggie,guarnicionPapas);
		Combo comboDobleCarneDobleQueso= new Combo("Combo Doble carne Doble queso",390,bebidaGaseosa237,burguerDobleCarneDobleQueso,guarnicionPapas);
		Combo comboRico = new Combo ("Combo Rico",325,bebidaGaseosa237,panchoRico,guarnicionPapas);
		Combo comboRookie = new Combo ("Combo Rookie",230,bebidaGaseosa237,panchoRookie,guarnicionPapas);
		Combo comboVeggiePancho = new Combo ("Combo Pancho Veggie",85,bebidaGaseosa237,panchoVeggie,guarnicionPapas);
		Combo comboSalsas = new Combo ("Combo Salsas",230,bebidaGaseosa237,panchoSalsas,guarnicionPapas);
	
		/*combos.agregarCombo(comboKelly);
		combos.agregarCombo(comboDobleQueso);
		combos.agregarCombo(comboJeremy);
		combos.agregarCombo(comboBigWave);
		combos.agregarCombo(comboVeggie);
		combos.agregarCombo(comboDobleCarneDobleQueso);
		combos.agregarCombo(comboRico);
		combos.agregarCombo(comboRookie);
		combos.agregarCombo(comboVeggiePancho);
		combos.agregarCombo(comboSalsas);*/
		
		
		archiProductos.leerCombo();

		
		
		
		
	}

}
