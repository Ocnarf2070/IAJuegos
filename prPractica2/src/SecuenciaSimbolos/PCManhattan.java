package SecuenciaSimbolos;

import java.util.List;

public class PCManhattan extends PCircularList {

	
	public PCManhattan(CircularList inicial, CircularList fin) {
		super(inicial, fin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int h(CircularList e) {
		// TODO Auto-generated method stub
		int distMan = 0;
		List<Character> list = e.getLista();
		List<Character> lfin = fin.getLista();
		for(int i =0;i<list.size();i++)distMan+=dist(i,list.get(i),lfin);
		return distMan;
	}

	
	private int dist(int i, Character character, List<Character> lfin) {
		// TODO Auto-generated method stub
		return Math.abs(i-lfin.indexOf(character));
	}
}
