package Mapas;

import java.util.ArrayList;
import java.util.List;

import EspacioDeEstados.Estado;

public class EstadoMapa extends Estado{
	static int [][] mapa;
	static char [] lugares;
	char pos;
	public EstadoMapa(int[][] mapa,char ini) {
		EstadoMapa.mapa=mapa;
		pos=ini;
		lugares=Matriz_de_adyacencia.lugares;
		// TODO Auto-generated constructor stub
	}
	private EstadoMapa(char newPos) {
		pos=newPos;
		// TODO Auto-generated constructor stub
	}
	private int posicion(char pos,int min,int max) {
		int medio=(max+min)/2;
		int pos1;
		if(lugares[medio]==pos)return medio;
		else if(lugares[medio]<pos) pos1=posicion(pos,medio+1,max);
		else pos1=posicion(pos, min, medio);
		return pos1;
	}
	@Override
	public List<EstadoMapa> hijos() {
		List<EstadoMapa> lista= new ArrayList<>();
		int num = posicion(pos, 0, lugares.length-1);
		for(int i=0;i<lugares.length;i++) {
			if(mapa[num][i]!=0)lista.add(new EstadoMapa(lugares[i]));
		}
		// TODO Auto-generated method stub
		return lista;
	}
	@Override
	public int coste(Estado e) {
		int i = posicion(this.pos, 0, lugares.length-1);
    	int j = posicion(((EstadoMapa)e).pos, 0, lugares.length-1);
		// TODO Auto-generated method stub
		return mapa[i][j];
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Character.toString(pos);
	}
}
