package Puzzle8;

public class ProbPuzzleDescolocadas extends ProbPuzzleH0{

	public ProbPuzzleDescolocadas(Puzzle p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int h(Puzzle e) {
		rep++;
		int h=0;
		int cont=0;
		for (int i = 0; i < e.tab.length; i++) {
            for (int j = 0; j < e.tab[0].length; j++) {
                if (e.tab[i][j] != cont&&e.tab[i][j]!=0)h++;
                cont++;
            }
        }
		// TODO Auto-generated method stub
		return h ;
	}

}
