package Jarras;

import EspacioDeEstados.*;

public class PJarra extends Problema<Jarra>{

	public PJarra(Jarra inicial) {
		this.ini=inicial;
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean esFinal(Jarra e) {
		// TODO Auto-generated method stub
		return e.p==1;
	}

}
