package Mapas;

import EspacioDeEstados.Problema;

public class PMapa extends Problema<EstadoMapa>{
	private char fin;
	char[] lug;
	int[] heu;
	public PMapa(EstadoMapa inicial,char fin,int[] heu) {
		this.ini=inicial;
		this.fin=fin;
		lug = Matriz_de_adyacencia.lugares;
		this.heu=heu;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean esFinal(EstadoMapa e) {
		// TODO Auto-generated method stub
		return e.pos==fin;
	}
	private int posicion(char pos,int min,int max) {
		int medio=(max+min)/2;
		int pos1;
		if(lug[medio]==pos)return medio;
		else if(lug[medio]<pos) pos1=posicion(pos,medio+1,max);
		else pos1=posicion(pos, min, medio);
		return pos1;
	}
	@Override
	public int h(EstadoMapa e) {
		// TODO Auto-generated method stub
		return heu[posicion(e.pos, 0, lug.length-1)];
	}

}
