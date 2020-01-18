package SecuenciaSimbolos;

import java.util.List;

public class PCDescolocadas extends PCircularList {

	public PCDescolocadas(CircularList inicial, CircularList fin) {
		super(inicial, fin);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int h(CircularList e) {
		// TODO Auto-generated method stub
		int des=0;
		List<Character> list = e.getLista();
		List<Character> lfin = fin.getLista();
		for(int i =0;i<list.size();i++) {
			des+=(list.get(i)==lfin.get(i))?0:1;
		}
		return des;
	}
}
