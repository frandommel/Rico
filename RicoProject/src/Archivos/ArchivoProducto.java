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

import claseProductos.Combo;
import claseProductos.Hamburguesa;

public class ArchivoProducto 
{

	public ArchivoProducto() {
		
	}
	
	//** SE AGREGA COMBOS A UN ARCHIVO **//
	public void agregarCombo(Combo combo) 
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
		Combo combo = null;
		
		try {
			
			file = new FileInputStream("combos.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			while((combo = (Combo) object.readObject()) != null) 
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
	public void agregarHamburguesa(Hamburguesa hambu) 
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
		Hamburguesa hambu = null;
		
		try {
			
			file = new FileInputStream("hamburguesa.bin");
			ObjectInputStream object = new ObjectInputStream(file);
			while((hambu = (Hamburguesa) object.readObject()) != null) 
			{
					System.out.println(hambu.toString());	
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
