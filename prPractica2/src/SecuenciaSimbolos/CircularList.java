package SecuenciaSimbolos;

import java.util.ArrayList;
import java.util.List;

import EspacioDeEstados.Estado;

public class CircularList extends Estado  {
	private List<Character> lista;
	public CircularList(String str) {
		lista = new ArrayList<>();
		for(int i=0;i<str.length();i++)lista.add(str.charAt(i));
		// TODO Auto-generated constructor stub
	}
	private CircularList(List<Character> lista,int action) {
		this.lista=lista;
		if(action==-1)toLeft();
		else transport(action);
	}
	public void toLeft() {
		char aux = lista.get(lista.size()-1);
		lista.remove(lista.size()-1);
		lista.add(0, aux);
	}
	public void transport(int pos) {
		int tam = lista.size();
		char aux = lista.get(pos);
		lista.remove(pos);
		if(pos+1==tam)lista.add(0, aux);
		else lista.add(pos+1, aux);
	}
	@Override
	public List<CircularList> hijos() {
		List<CircularList> list = new ArrayList<>();
		list.add(new CircularList(clone(),-1));
		for(int i=0;i<lista.size();i++) {
			list.add(new CircularList(clone(), i));
		}
		// TODO Auto-generated method stub
		return list;
	}
	@Override
	public String toString() {
		String str="";
		for(int i=0; i<lista.size();i++) {
			str+=lista.get(i);
		}
		return str;
	}
	
	protected List<Character> clone() {
		List<Character> clone = new ArrayList<>();
		for(int i=0;i<lista.size();i++)clone.add(lista.get(i));
		return clone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		if(lista==null) result = prime*result;
		else {
			for(int i=0;i<lista.size();i++)result = prime * result + lista.get(i).hashCode();
		}
		return result;
	}
	public List<Character> getLista() {
		return lista;
	}
	@Override
	public boolean equals(Object obj) {
		boolean res=obj instanceof CircularList;
		CircularList pro=res?(CircularList)obj:null;
		int i=0;
		while(res&&i<lista.size()) {
			if(this.lista.get(i)!=pro.lista.get(i))res=false;
			i++;
		}
		return res;
	}
	
	
}
