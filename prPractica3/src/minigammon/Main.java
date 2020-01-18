package minigammon;

import espaciojuego.Juego;
import jugadores.JugadorAleatorio;

public class Main {
	public static void main(String[] args) {
		
		MiniGammon ini = new MiniGammon(5, 6);
		int [] j1={2, 0, 3, 0, 0, 0, 0, 0},j2={0, 0, 0, 0, 0, 3, 0, 2},g= {0,0},l= {0,0};
		MiniGammon e = new MiniGammon(j1,j2,g,l,true,ini.tiradaDado());
		//e.ver();
		JugadorAleatorio<MiniGammon> J1 = new JugadorAleatorio<>();
		JugadorAleatorio<MiniGammon> J2 = new JugadorAleatorio<>();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		Juego juego = new Juego (J1, J2, e);
		juego.jugarPartida(true);
//		for(MiniGammon aux : e.hijos()) {
//			aux.ver();
//			System.out.println("-------------------------------");
//			for(MiniGammon aux1 : aux.hijos()) {
//				aux1.ver();
//			}
//			System.out.println("-------------------------------");
//		}
	}
}
