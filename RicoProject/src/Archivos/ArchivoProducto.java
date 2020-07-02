package Archivos;

import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.json.JSONObject;
import org.omg.CORBA.DataInputStream;

import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;
import claseProductos.Producto;

public class ArchivoProducto 
{

	public ArchivoProducto() {
		
	}
	
	//** SE AGREGA COMBOS A UN ARCHIVO **//
	public void agregarCombo(ArrayList <Combo> combo) 
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("combos.bin");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(combo);
			object.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				file.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	//** SE LEE COMBO DE UN ARCHIVO **//
	public ArrayList<Producto> leerCombo()
	{
		FileInputStream file = null;
		ArrayList<Producto> combo = new ArrayList<Producto>();
		
		try {
			
			file = new FileInputStream("combos.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			combo = (ArrayList<Producto>) object.readObject();		
			object.close();
		} catch (FileNotFoundException e) {
				agregarCombo(new ArrayList<Combo>());
				leerCombo();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return combo;

	}
	
	public ArrayList<Combo> leerComboCambio()
	{
		FileInputStream file = null;
		ArrayList<Combo> combo = new ArrayList<Combo>();
		
		try {
			
			file = new FileInputStream("combos.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			combo = (ArrayList<Combo>) object.readObject();		
			object.close();
		} catch (FileNotFoundException e) {
			agregarCombo(new ArrayList<Combo>());
			leerCombo();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return combo;

	}
	
	//** SE AGREGA HAMBURGUESA A UN ARCHIVO **//
	public void agregarHamburguesa(ArrayList <Hamburguesa> hambu) 
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("hamburguesa.bin");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(hambu);
			object.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				file.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	//** SE LEE HAMBURGUESA DE UN ARCHIVO **//
	public ArrayList<Producto> leerHamburguesa()
	{
		FileInputStream file = null;
		ArrayList <Producto> lista = new ArrayList<Producto>();
		
		try {
			
			file = new FileInputStream("hamburguesa.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Producto>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			agregarHamburguesa(new ArrayList<Hamburguesa>());
			leerHamburguesa();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
		//	System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Hamburguesa> leerHamburguesaCambio()
	{
		FileInputStream file = null;
		ArrayList <Hamburguesa> lista = new ArrayList<Hamburguesa>();
		
		try {
			
			file = new FileInputStream("hamburguesa.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Hamburguesa>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
		//	System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	//** SE AGREGA PANCHO A UN ARCHIVO **//
	public void agregarPancho(ArrayList <Pancho> pancho) 
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("pancho.bin");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(pancho);
			object.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				file.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	//** SE LEE PANCHO DE UN ARCHIVO **//
	public ArrayList<Producto> leerPancho()
	{
		FileInputStream file = null;
		ArrayList <Producto> lista = new ArrayList<Producto>();
		
		try {
			
			file = new FileInputStream("pancho.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Producto>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			agregarPancho(new ArrayList<Pancho>());
			leerPancho();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Pancho> leerPanchoCambio()
	{
		FileInputStream file = null;
		ArrayList <Pancho> lista = new ArrayList<Pancho>();
		
		try {
			
			file = new FileInputStream("pancho.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Pancho>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	//** SE AGREGA ENSALADA A UN ARCHIVO **//
	public void agregarEnsalada(ArrayList <Ensalada> ensalada) 
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("ensalada.bin");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(ensalada);
			object.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				file.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	//** SE LEE ENSALADA DE UN ARCHIVO **//
	public ArrayList<Producto> leerEnsalada()
	{
		FileInputStream file = null;
		ArrayList <Producto> lista = new ArrayList<Producto>();
		
		try {
			
			file = new FileInputStream("ensalada.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Producto>)object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			agregarEnsalada(new ArrayList<Ensalada>());
			leerEnsalada();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
		//	System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return lista;

	}
	
	public ArrayList<Ensalada> leerEnsaladaCambio()
	{
		FileInputStream file = null;
		ArrayList <Ensalada> lista = new ArrayList<Ensalada>();
		
		try {
			
			file = new FileInputStream("ensalada.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Ensalada>)object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
		//	System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return lista;

	}
	
	//** SE AGREGA GUARNICION A UN ARCHIVO **//
	public void agregarGuarnicion(ArrayList <Guarnicion> guarnicion) 
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("guarnicion.bin");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(guarnicion);
			object.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				file.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	//** SE LEE GUARNICION DE UN ARCHIVO **//
	public ArrayList<Producto> leerGuarnicion()
	{
		FileInputStream file = null;
		ArrayList <Producto> lista = new ArrayList<Producto>();
		
		try {
			
			file = new FileInputStream("guarnicion.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Producto>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			agregarGuarnicion(new ArrayList<Guarnicion>());
			leerGuarnicion();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return lista;

	}
	
	public ArrayList<Guarnicion> leerGuarnicionCambio()
	{
		FileInputStream file = null;
		ArrayList <Guarnicion> lista = new ArrayList<Guarnicion>();
		
		try {
			
			file = new FileInputStream("guarnicion.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Guarnicion>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return lista;

	}

	//** SE AGREGA BEBIDAS A UN ARCHIVO **//
	public void agregarBebida(ArrayList <Bebida> bebida) 
	{
		FileOutputStream file = null;
		try 
		{
			file = new FileOutputStream("bebida.bin");
			ObjectOutputStream object = new ObjectOutputStream(file);
			
			object.writeObject(bebida);
			object.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				file.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	//** SE LEE BEBIDAS DE UN ARCHIVO **//
	public ArrayList<Producto> leerBebida()
	{
		FileInputStream file = null;
		ArrayList <Producto> lista = new ArrayList<Producto>();	
		try {
			
			file = new FileInputStream("bebida.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Producto>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			agregarBebida(new ArrayList<Bebida>());
			leerBebida();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return lista;

	}
	
	public ArrayList<Bebida> leerBebidaCambio()
	{
		FileInputStream file = null;
		ArrayList <Bebida> lista = new ArrayList<Bebida>();	
		try {
			
			file = new FileInputStream("bebida.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			lista = (ArrayList<Bebida>) object.readObject();
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (EOFException e) {
			//System.out.println("FIN DEL ARCHIVO");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return lista;

	}
	
	
	
	public HashMap<String , ArrayList<Producto>> leer()
	{
		HashMap<String, ArrayList<Producto>> mapaProductosContenedorMap = new HashMap<String, ArrayList<Producto>>();
		
		mapaProductosContenedorMap.put("Hamburguesa", leerHamburguesa());
		mapaProductosContenedorMap.put("Combo", leerCombo());
		mapaProductosContenedorMap.put("Pancho", leerPancho());
		mapaProductosContenedorMap.put("Ensalada", leerEnsalada());
		mapaProductosContenedorMap.put("Bebida", leerBebida());
		mapaProductosContenedorMap.put("Guarnicion", leerGuarnicion());
		
		return mapaProductosContenedorMap;
		
	}
	
	

	
}
