package Jarras;

import java.util.ArrayList;
import java.util.List;

import EspacioDeEstados.Estado;

public class Jarra extends Estado{
	int g; //p = contenido jarra pequeña, q = contenido jarra grande
	int p;
	private static final int G=5,P=2;
	public Jarra(int g, int p) {
		this.g = g;
		this.p = p;
	// TODO Auto-generated constructor stub
	}
	@Override
	public List<Jarra> hijos() {
		List<Jarra> lista = new ArrayList<>();
		int total = g+p;
		if(g>0)lista.add(new Jarra(0, p));
		if(p>0)lista.add(new Jarra(g, 0));
		if(total<=P&&g>0)lista.add(new Jarra(0, total));
		if(total<=G&&p>0)lista.add(new Jarra(total, 0));
		if(total>=P&&g>0)lista.add(new Jarra(total-P, P));
		if(total>=G&&p>0)lista.add(new Jarra(G, total-G));
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+g+","+p+")";
	}

}
