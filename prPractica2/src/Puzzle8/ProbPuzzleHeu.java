package Puzzle8;

import EspacioDeEstados.Problema;

public class ProbPuzzleHeu extends Problema<Puzzle>{
	int ver;//ver: 1-> Piezas descolocadas 2 -> manhattan
	public ProbPuzzleHeu(Puzzle p,int ver)
    {
        this.ini = p;
        this.ver=ver;
    }
	@Override
	public boolean esFinal(Puzzle e) {
		// TODO Auto-generated method stub
		int cont = 0;

        for (int i = 0; i < e.tab.length; i++) {
            for (int j = 0; j < e.tab[0].length; j++) {
                if (e.tab[i][j] != cont) {
                    return false;
                } else {
                    cont++;
                }
            }
        }

        return true;
	}
	@Override
	public int h(Puzzle e) {
		int h=0;
		switch(ver) {
		case 1 : 
			int cont=0;
			for (int i = 0; i < e.tab.length; i++) {
	            for (int j = 0; j < e.tab[0].length; j++) {
	                if (e.tab[i][j] != cont&&e.tab[i][j]!=0)h++;
	                cont++;
	            }
	        }
			break;
		case 2 :
			cont=0;
			for(int i=0; i<e.tab.length;i++) {
				for(int j=0;j<e.tab[0].length;j++) {
					if(e.tab[i][j] != cont&&e.tab[i][j]!=0)h+=dist(e.tab[i][j], i, j, e);
					cont++;
				}
			}
			break;
		}
		return h;
	}
	private int dist(int cas, int x,int y,Puzzle e) {
		return Math.abs(x-(cas/e.tab[0].length))+Math.abs(y-(cas%e.tab[0].length));
		// TODO Auto-generated method stub

	}

}
