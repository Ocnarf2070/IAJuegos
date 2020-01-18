package conectak;

import espaciojuego.*;
import jugadores.*;

public class TestConectaKOrd {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConectaK e = new ConectaK(6, 7, 4);
		System.out.println("Profundidad\tMinimax\tAB(Aleatorio)\tAB(ordenado)");
		System.out.println("-------------------------------------------------------");
		for(int i=2;i<=6;i++) {
			String str=Integer.toString(i)+"          \t";
			JugadorMinimax<ConectaK> j1 = new JugadorMinimax<>(new EvaluadorCK(6, 7, 4), i);
			Juego juego = new Juego(j1,null,e);
			//juego.jugarPartida(false);
			juego.unMovimiento();
			str+=j1.nodos()+"\t";
			JugadorAlfaBeta<ConectaK> j2 = new JugadorAlfaBeta<>(new EvaluadorCK(6, 7, 4), i);
			Juego juego2 = new Juego(j2,null,e);
			//juego.jugarPartida(false);
			juego2.unMovimiento();
			str+=j2.nodos()+"      \t";
			JugadorAlfaBeta<ConectaK> j3 = new JugadorAlfaBeta<>(new EvaluadorCK(6, 7, 4), i,new ConectaK.ordenCentro());
			Juego juego3 = new Juego(j3,null,e);
			//juego.jugarPartida(false);
			juego3.unMovimiento();
			str+=j3.nodos();
			System.out.println(str);
		}
		
	}

}
