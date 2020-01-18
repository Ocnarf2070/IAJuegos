package PuzzleLineal;

import java.util.Iterator;

public class Test {
	public static void main(String[] args) {
		char[]tx = {'B','N','B','B','N',' '};
		Puzzle pz = new Puzzle(tx);
		PPuzzle res = new PPuzzle(pz);
		Iterator<Puzzle> it = res.amplitud().iterator();
		System.out.print("Sol: "+it.next());
		int coste=0;
		while(it.hasNext()) {
			Puzzle aux = it.next();
			System.out.print("->"+aux);
			coste += aux.coste(aux);
		}
		System.out.println("\nCoste: "+coste);
	}
}
