package MisionerosYCanivales;

import java.util.List;

public class TestBarca {
	
	public static void main(String[] args) {
		MisYCan mc = new MisYCan(2, 3, 3);
		List<MisYCan> list= mc.hijos();
		System.out.println(list);
		for(MisYCan aux : list)System.out.println(aux+":"+aux.hijos());
	}
	
}
