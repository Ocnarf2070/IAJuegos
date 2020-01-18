package BaldursGate;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class BaldursGateSol {
	static BaldursGateMap map;
	private PBaldursGate prob;
	private static List<BaldursGate> sol;
	public BaldursGateSol(BaldursGate bg,BaldursGateMap map) {
		prob = new PBaldursGate(bg);
		sol = prob.aMono();
		BaldursGateSol.map=map;
		// TODO Auto-generated constructor stub
	}

	public void Solucion() {
		Iterator<BaldursGate> it = sol.iterator();
		int min_x = 0,min_y = 0,max_x = 0,max_y = 0;
		PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>();
		while(it.hasNext()) {
			BaldursGate tt =it.next();
			//copyMap.map[tt.x][tt.y]='o';
			pq.add(new Pair<Integer, Integer>(tt.x, tt.y));
			if(!it.hasNext()) {
				min_x=tt.min_x;
				min_y=tt.min_y;
				max_x=tt.max_x;
				max_y=tt.max_y;
			}
		}
		System.out.println("Dibujando:..\nDimensiones .... "+min_x+" "+min_y+", "+max_x+" "+max_y);
		System.out.println(verSolucion(map,pq,min_x,min_y,max_x,max_y));
		System.out.println("hecho");




		//System.out.println(verSolucion(copyMap,min_x,min_y,max_x,max_y));
		//PrintWriter pw = new PrintWriter("mapa.txt");
		//pw.write(copyMap.toString());
		//	pw.write("-----------------------------------------------------------------------------\n");
		//	for(Estado pp: bg.hijos()) {
		//		pw.write(pp.toString());
		//		pw.write("-----------------------------------------------------------------------------\n");
		//	}
		//	
		//pw.close();
	}

	//private static String verSolucion(BaldursGateMap copyMap, int min_x, int min_y, int max_x, int max_y) {
	private static String verSolucion(BaldursGateMap map, PriorityQueue<Pair<Integer, Integer>> pq, int min_x, int min_y, int max_x, int max_y) {
		StringBuilder sb = new StringBuilder();
		Pair<Integer, Integer> pair = pq.peek();
		pq.remove(pair);
		for(int i=min_x;i<=max_x;i++) {
			for(int j=min_y;j<=max_y;j++) {
				if(pair!=null&&pair.getFirst()==i&&pair.getSecond()==j) {
					sb.append('o');
					pair=pq.peek();
					pq.remove(pair);
				}
				else if(map.map[i][j]=='.')sb.append(' ');
				else if(map.map[i][j]=='@')sb.append('x');
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
