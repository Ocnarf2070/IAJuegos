package Puzzle8;

public class ProbPuzzleManhattan extends ProbPuzzleH0 {

	public ProbPuzzleManhattan(Puzzle p) {
		super(p);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int h(Puzzle e) {
		int h=0;
		int cont=0;
		rep++;
		for(int i=0; i<e.tab.length;i++) {
			for(int j=0;j<e.tab[0].length;j++) {
				if(e.tab[i][j] != cont&&e.tab[i][j]!=0)h+=dist(e.tab[i][j], i, j, e.tab[0].length);
				cont++;
			}
		}
		return h;
	}
	
	private int dist(int cas, int x,int y,int colum) {
		return Math.abs(x-(cas/colum))+Math.abs(y-(cas%colum));
		// TODO Auto-generated method stub

	}

}
