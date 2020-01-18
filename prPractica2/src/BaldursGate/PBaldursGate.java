package BaldursGate;

import EspacioDeEstados.Problema;

public class PBaldursGate extends Problema<BaldursGate> {

	public PBaldursGate(BaldursGate bg) {
		this.ini=bg;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean esFinal(BaldursGate e) {
		// TODO Auto-generated method stub
		return e.x==BaldursGate.fx&&e.y==BaldursGate.fy;
	}
	@Override
	public int h(BaldursGate e) {
		int difF = Math.abs(e.x - BaldursGate.fx);
		int difC = Math.abs(e.y - BaldursGate.fy);

		int A = Math.max(difF, difC);
		int I = Math.min(difF, difC);

		return 1414 * I + 1000 * (A - I);
//		return Math.max(Math.abs(e.x-BaldursGate.fx), Math.abs(e.y-BaldursGate.fy))*1000;
	}

}
