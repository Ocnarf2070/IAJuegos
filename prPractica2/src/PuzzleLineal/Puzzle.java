package PuzzleLineal;

import java.util.ArrayList;
import java.util.List;

import EspacioDeEstados.Estado;
public class Puzzle extends Estado{
	char [] puzzle;
	int right,white,space,oldSpace;
	public Puzzle(char[] puzzle) {
		this.puzzle=puzzle;
		int i=0;
		while(puzzle[i]!='N') {
			if(puzzle[i]==' ')space=i;
			else {
			right++;
			white++;
			}
			i++;
		}
		while(i<puzzle.length) {
			if(puzzle[i]=='B')white++;
			else if(puzzle[i]==' ')space=i;
			i++;
		}
		oldSpace=space;
		// TODO Auto-generated constructor stub
	}
	public Puzzle(char[] puzzle,int blancas,int huecoAnt,int hueco) {
		this.puzzle=puzzle;
		white=blancas;
		space=hueco;
		oldSpace=huecoAnt;
		int i=0;
		while(puzzle[i]!='N') {
			if(puzzle[i]!=' ')
				right++;
			i++;
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public int coste(Estado e) {
		// TODO Auto-generated method stub
		return Math.abs(space-oldSpace);
	}
	@Override
	public List<Puzzle> hijos() {
		List <Puzzle> lista = new ArrayList<>();
		if(space+1<puzzle.length) lista.add(new Puzzle(intercambiar(space,space+1),this.white,space,space+1));
		if(space+2<puzzle.length) lista.add(new Puzzle(intercambiar(space,space+2),this.white,space,space+2));
		if(space-1>=0) lista.add(new Puzzle(intercambiar(space,space-1),this.white,space,space-1));
		if(space-2>=0) lista.add(new Puzzle(intercambiar(space,space-2),this.white,space,space-2));
		// TODO Auto-generated method stub
		return lista;
	}

	private char[] intercambiar(int os, int ns) {
		char [] aux = new char [puzzle.length];
		for(int i=0;i<puzzle.length;i++)aux[i]=puzzle[i];
		aux[os] = aux[ns];
		aux[ns]=' ';
		return aux;		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		int i;
		for(i=0;i<puzzle.length-1;i++)sb.append(puzzle[i]).append(',');
		sb.append(puzzle[i]).append(']');
		return sb.toString();
	}

}
