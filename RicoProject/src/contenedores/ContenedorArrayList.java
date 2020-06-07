package contenedores;

import java.util.ArrayList;


public class ContenedorArrayList<T>{
	private ArrayList<T> arrayList = new ArrayList<T>();

	public ArrayList<T> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<T> arrayList) {
		this.arrayList = arrayList;
	} 
	
	@Override
	public String toString() {
		StringBuilder builder=new StringBuilder();
		
		for(int i=0;i<arrayList.size();i++)
		{
			builder.append(arrayList.get(i).toString());
		}
		
		return builder.toString();
	}
	
	
}
