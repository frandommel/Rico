package paquete;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.sound.midi.Soundbank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Archivos.ArchivoPersona;
import Archivos.ArchivoProducto;
import GestionComercio.ClienteVip;
import GestionComercio.Comercio;
import GestionComercio.Empleado;
import GestionComercio.Pedido;
import GestionComercio.Persona;
import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;
import claseProductos.Producto;

public class Main {

	public static void main(String[] args) throws JSONException{
		
		
		Persona cliente1 = new ClienteVip("Juan Duhalde", "Roldan 890", "22356894782", 0);
		Persona cliente2 = new ClienteVip("Fran Dommel", "Sierras de Los Padre 2251", "22356892582", 0);
		Persona cliente3 = new ClienteVip("Juan Gomez", "Carasa 890", "22353394782", 0);

		ArchivoPersona archivoPersona = new ArchivoPersona();
		
		JSONObject objetoPersonasJsonObject = new JSONObject();
		JSONArray arrayEmpleados = new JSONArray();
		JSONArray arrayClientes = new JSONArray();
		
		arrayClientes.put(cliente1.generateJson());
		arrayClientes.put(cliente2.generateJson());
		arrayClientes.put(cliente3.generateJson());
		
		objetoPersonasJsonObject.put("clientes",arrayClientes);
	
		Persona cliente4 = new Empleado("Juan Duhalde", "Roldan 890", "22356894782", "1234", "Delivery");
		Persona cliente5 = new Empleado("Fran Dommel", "Sierras de Los Padre 2251", "22356892582","5678","ChePibe");
		Persona cliente6 = new Empleado("Juan Gomez", "Carasa 890", "22353394782", "291011", "Dueño");
		
		arrayEmpleados.put(cliente4.generateJson());
		arrayEmpleados.put(cliente5.generateJson());
		arrayEmpleados.put(cliente6.generateJson());
		
		objetoPersonasJsonObject.put("empleados",arrayEmpleados);
		 
		
		archivoPersona.agregarArchivo(objetoPersonasJsonObject);
		
		System.out.println(archivoPersona.leer());
		
		Comercio comercioRico = new Comercio();
		
		//comercioRico.removePersonas("empleados", 0);
		
		System.out.println(comercioRico.getPersonas().toString());
		
		
		
		/*ArrayList <Combo> combos = new ArrayList();
		ArrayList <Hamburguesa> hamburguesas = new ArrayList();
		ArrayList <Pancho> panchos = new ArrayList();
		ArrayList <Ensalada> ensaladas = new ArrayList();
		ArrayList <Guarnicion> guarniciones = new ArrayList();
		ArrayList <Bebida> bebidas = new ArrayList();
		
		Bebida bebidaGaseosa237 = new Bebida("Gaseosa 237cc",60,"Linea Pepsi");
		Bebida bebidaGaseosa500 = new Bebida("Gaseosa 500cc",70,"Linea Pepsi");
		Bebida bebidaLimonada = new Bebida("Limonada",70,"Rico");
		Bebida bebidaCorona = new Bebida("Cerveza",150,"Corona");
		Bebida bebidaPatagonia = new Bebida("Cerveza",165,"Patagonia");
		Bebida bebidaStellaArtois = new Bebida("Cerveza",130,"Stella Artois");
		
		bebidas.add(bebidaGaseosa237);
		bebidas.add(bebidaGaseosa500);
		bebidas.add(bebidaLimonada);
		bebidas.add(bebidaCorona);
		bebidas.add(bebidaPatagonia);
		bebidas.add(bebidaStellaArtois);
		

		Guarnicion guarnicionNuggets = new Guarnicion("Nuggets", 150);
		Guarnicion guarnicionPapas = new Guarnicion("Papas Fritas", 100);
		Guarnicion guarnicionRico = new Guarnicion("Papas Rico", 200);
		
		guarniciones.add(guarnicionNuggets);
		guarniciones.add(guarnicionPapas);
		guarniciones.add(guarnicionRico);

		
		Ensalada ensaladaUkelele=new Ensalada("Ukelele", 160 , 250);
		Ensalada ensaladaHulaHula=new Ensalada("Hula Hula", 160 , 180);
		Ensalada ensaladaAloha=new Ensalada("Aloha", 160 , 210);
		
		ensaladas.add(ensaladaUkelele);
		ensaladas.add(ensaladaHulaHula);
		ensaladas.add(ensaladaAloha);
		
		
		Pancho panchoRico = new Pancho("Rico",150,false);
		Pancho panchoSalsas = new Pancho("Pancho",100,false);
		Pancho panchoRookie = new Pancho("Rookie",70,false);
		Pancho panchoVeggie = new Pancho("Veggie",70,false);
		
		panchos.add(panchoRico);
		panchos.add(panchoSalsas);
		panchos.add(panchoRookie);
		panchos.add(panchoVeggie);
		
		
		
		Hamburguesa burguerKelly = new Hamburguesa("Kelly",200,false);
		Hamburguesa burguerDobleQueso = new Hamburguesa("Doble queso",110,false);
		Hamburguesa burguerBigWave = new Hamburguesa("Big wave",280,false);
		Hamburguesa burguerJeremy = new Hamburguesa("Jeremy",180,false);
		Hamburguesa burguerVeggie = new Hamburguesa("Veggie",110,false);
		Hamburguesa burguerDobleCarneDobleQueso = new Hamburguesa("Doble carne Doble queso",160,false);
		
		hamburguesas.add(burguerKelly);
		hamburguesas.add(burguerDobleQueso);
		hamburguesas.add(burguerBigWave);
		hamburguesas.add(burguerJeremy);
		hamburguesas.add(burguerVeggie);
		hamburguesas.add(burguerDobleCarneDobleQueso);
		
		combos.add(new Combo("Combo Kelly",320,bebidaGaseosa237,burguerKelly,guarnicionPapas));
		combos.add(new Combo("Combo Doble Queso",220,bebidaGaseosa237,burguerDobleQueso,guarnicionPapas));
		combos.add(new Combo("Combo Jeremy",280,bebidaGaseosa237,burguerJeremy,guarnicionPapas));
		combos.add(new Combo("Combo Big Wave",390,bebidaGaseosa237,burguerBigWave,guarnicionPapas));
		combos.add(new Combo("Combo Veggie",220,bebidaGaseosa237,burguerVeggie,guarnicionPapas));
		combos.add(new Combo("Combo Doble carne Doble queso",390,bebidaGaseosa237,burguerDobleCarneDobleQueso,guarnicionPapas));
		combos.add(new Combo ("Combo Rico",325,bebidaGaseosa237,panchoRico,guarnicionPapas));
		combos.add(new Combo ("Combo Rookie",230,bebidaGaseosa237,panchoRookie,guarnicionPapas));
		combos.add(new Combo ("Combo Pancho Veggie",85,bebidaGaseosa237,panchoVeggie,guarnicionPapas));
		combos.add( new Combo ("Combo Salsas",230,bebidaGaseosa237,panchoSalsas,guarnicionPapas));
		
	
		//Agregamos combos
		archiProductos.agregarCombo(combos);
		//Agregamos hamburguesas
		archiProductos.agregarHamburguesa(hamburguesas);
		//Agregamos pancho
		archiProductos.agregarPancho(panchos);
		//Agregamos ensalada
		archiProductos.agregarEnsalada(ensaladas);
		//Agregamos guarnicion
		archiProductos.agregarGuarnicion(guarniciones);
		//Agregamos bebida
		archiProductos.agregarBebida(bebidas);*/
		//TRAE EL ARCHIVO DE TODOS LOS PRODUCTOS Y DEVUELVE UN MAPA DEL MISMO
		//archiProductos.leer();
		
		/*JSONObject jsonObject=cliente.generateJson();
		JSONObject jsonObject2=empleado.generateJson();

		System.out.println(jsonObject);
		System.out.println(jsonObject2);*/
		
		
		
	}

}
