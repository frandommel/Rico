package Archivos;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import claseProductos.Bebida;
import claseProductos.Combo;
import claseProductos.Ensalada;
import claseProductos.Guarnicion;
import claseProductos.Hamburguesa;
import claseProductos.Pancho;

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
	public void leerCombo()
	{
		FileInputStream file = null;
		ArrayList<Combo> combo;
		
		try {
			
			file = new FileInputStream("combos.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			
			while((combo = (ArrayList <Combo>) object.readObject()) != null) 
			{
					System.out.println(combo.toString());	
			}
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

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
	public void leerHamburguesa()
	{
		FileInputStream file = null;
		ArrayList <Hamburguesa> hambu;
		
		try {
			
			file = new FileInputStream("hamburguesa.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			while((hambu = (ArrayList<Hamburguesa>) object.readObject()) != null) 
			{
					System.out.println("\n" + hambu.toString());	
			}
			
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

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
	public void leerPancho()
	{
		FileInputStream file = null;
		ArrayList <Pancho> hambu;
		
		try {
			
			file = new FileInputStream("pancho.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			while((hambu = (ArrayList<Pancho>) object.readObject()) != null) 
			{
					System.out.println("\n" + hambu.toString());	
			}
			
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

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
	public void leerEnsalada()
	{
		FileInputStream file = null;
		ArrayList <Ensalada> ensalada;
		
		try {
			
			file = new FileInputStream("ensalada.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			while((ensalada = (ArrayList<Ensalada>) object.readObject()) != null) 
			{
					System.out.println("\n" + ensalada.toString());	
			}
			
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

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
	public void leerGuarnicion()
	{
		FileInputStream file = null;
		ArrayList <Guarnicion> guarnicion;
		
		try {
			
			file = new FileInputStream("guarnicion.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			while((guarnicion = (ArrayList<Guarnicion>) object.readObject()) != null) 
			{
					System.out.println("\n" + guarnicion.toString());	
			}
			
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

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
	public void leerBebida()
	{
		FileInputStream file = null;
		ArrayList <Bebida> bebida;	
		try {
			
			file = new FileInputStream("bebida.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			while((bebida = (ArrayList<Bebida>) object.readObject()) != null) 
			{
					System.out.println("\n" + bebida.toString());	
			}			
			object.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
}
