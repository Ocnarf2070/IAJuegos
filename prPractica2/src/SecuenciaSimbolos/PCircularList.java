package SecuenciaSimbolos;

import EspacioDeEstados.Problema;

public class PCircularList extends Problema<CircularList> {
	protected CircularList fin;
	public PCircularList(CircularList inicial,CircularList fin) {
		// TODO Auto-generated constructor stub
		this.ini=inicial;
		this.fin=fin;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean esFinal(CircularList e) {
		// TODO Auto-generated method stub
		return e.equals(fin);
	}

}
