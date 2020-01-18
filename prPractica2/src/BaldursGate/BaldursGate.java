package BaldursGate;

import java.util.ArrayList;
import java.util.List;
import EspacioDeEstados.Estado;

public class BaldursGate extends Estado {
	static int fx,fy;
	int max_x,max_y,min_x,min_y;
	int x,y;
	int coste;
	static BaldursGateMap mapa;
	public BaldursGate(BaldursGateMap map,int x, int y, int fx, int fy) {
		BaldursGate.fx=fx;BaldursGate.fy=fy;
		BaldursGate.mapa=map;
		this.x=x;this.y=y;
		if(x<fx) {
			min_x=x;
			max_x=fx;
		}else {
			min_x=fx;
			max_x=x;
		}
		if(y<fy) {
			min_y=y;
			max_y=fy;
		}else {
			min_y=fy;
			max_y=y;
		}
		// TODO Auto-generated constructor stub
	}
	private BaldursGate(int x, int y,int Mx,int My,int mx,int my,int coste) {
		this.coste=coste;
		this.x=x;this.y=y;
		max_x=Mx;max_y=My;
		min_x=mx;min_y=my;
		if(x>max_x)max_x=x;
		if(y>max_y)max_y=y;
		if(x<min_x)min_x=x;
		if(y<min_y)min_y=y;
		// TODO Auto-generated constructor stub
	}
	@Override
	public int coste(Estado e) {
		// TODO Auto-generated method stub
		return coste;
	}
	@Override
	public List<? extends Estado> hijos() {
		int arr=x-1,aba=x+1;
		int izq=y-1,der=y+1;
		int limDer=mapa.map[0].length , limAba=mapa.map.length;
		
		List<Estado> list = new ArrayList<>();
		
		if(arr>=0&&mapa.map[arr][y]!='@')list.add(new BaldursGate(arr, y,max_x,max_y,min_x,min_y, 1000));
		
		if(arr>=0&&izq>=0&&mapa.map[arr][izq]!='@')list.add(new BaldursGate(arr, izq,max_x,max_y,min_x,min_y, 1414));
		
		if(izq>=0&&mapa.map[x][izq]!='@')list.add(new BaldursGate(x, izq,max_x,max_y,min_x,min_y,  1000));
		
		if(aba<limAba&&izq>=0&&mapa.map[aba][izq]!='@')list.add(new BaldursGate(aba, izq,max_x,max_y,min_x,min_y,  1414));
		
		if(aba<limAba&&mapa.map[aba][y]!='@')list.add(new BaldursGate(aba, y,max_x,max_y,min_x,min_y,  1000));
		
		if(aba<limAba&&der<limDer&&mapa.map[aba][der]!='@')list.add(new BaldursGate(aba, der,max_x,max_y,min_x,min_y,  1414));
		
		if(der<limDer&&mapa.map[x][der]!='@')list.add(new BaldursGate(x, der,max_x,max_y,min_x,min_y,  1000));
		
		if(arr>=0&&izq>=0&&mapa.map[arr][der]!='@')list.add(new BaldursGate(arr, der,max_x,max_y,min_x,min_y,  1414));

		return list;
	}
	@Override
	public String toString() {
//		StringBuilder sb = new StringBuilder("("+x+","+y+")\nMax:("+max_x+","+max_y+")\nMin:("+min_x+","+min_y+")\n");
//		// TODO Auto-generated method stub
//		for(int i=min_x;i<=max_x;i++) {
//			for(int j=min_y;j<=max_y;j++) {
//				if(i==x&&j==y)sb.append('P');
//				else if(mapa.map[i][j]=='.')sb.append(' ');
//				else sb.append(mapa.map[i][j]);
//			}
//			sb.append("\n");
//		}
//		return sb.toString();
		return "("+x+","+y+")";
	}
}
