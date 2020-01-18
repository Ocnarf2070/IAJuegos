package MisionerosYCanivales;

import java.util.LinkedList;
import java.util.List;

import EspacioDeEstados.Estado;

public class MisYCan extends Estado{
	static int TamBarca,Misioneros,Canivales;
	int mis,can;
	char PosBarca;
	
	public MisYCan(int tamBar, int mis, int can) {
		TamBarca=tamBar;
		this.mis=mis;
		this.can=can;
		Misioneros=mis;
		Canivales=can;
		PosBarca='I';
		// TODO Auto-generated constructor stub
	}
	private MisYCan(int mis,int can,char pos) {
		this.mis=mis;
		this.can=can;
		PosBarca=pos;
	}
	private char cambiarPosicion(char pos) {
		return (pos=='I')?'D':'I';
	}
	@Override
	public List<MisYCan> hijos() {
		List<MisYCan> list = new LinkedList<>();
		char newPos = cambiarPosicion(PosBarca);
		
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+mis+","+can+","+PosBarca+")";
	}

}
