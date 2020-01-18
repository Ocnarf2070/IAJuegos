package PuzzleLineal;

import EspacioDeEstados.Problema;

public class PPuzzle extends Problema<Puzzle> {

	public PPuzzle(Puzzle inicial) {
		this.ini=inicial;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean esFinal(Puzzle e) {
		// TODO Auto-generated method stub
		return e.right==e.white;
	}

}
