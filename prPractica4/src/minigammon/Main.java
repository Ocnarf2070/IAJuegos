package minigammon;

import espaciojuego.Juego;
import jugadores.JugadorAleatorio;

public class Main {
	public static void main(String[] args) {
		
//		MiniGammon ini = new MiniGammon(5, 6);
//		int [] j1={2, 0, 3, 0, 0, 0, 0, 0},j2={0, 0, 0, 0, 0, 3, 0, 2},g= {0,0},l= {0,0};
//		MiniGammon e = new MiniGammon(j1,j2,g,l,true,ini.tiradaDado());
//		//e.ver();
//		JugadorAleatorio<MiniGammon> J1 = new JugadorAleatorio<>();
//		JugadorAleatorio<MiniGammon> J2 = new JugadorAleatorio<>();
//		@SuppressWarnings({ "rawtypes", "unchecked" })
//		Juego juego = new Juego (J1, J2, e);
//		juego.jugarPartida(true);
//		for(MiniGammon aux : e.hijos()) {
//			aux.ver();
//			System.out.println("-------------------------------");
//			for(MiniGammon aux1 : aux.hijos()) {
//				aux1.ver();
//			}
//			System.out.println("-------------------------------");
//		}
		int [] j1={1, 2, 0, 0},j2={0, 0, 2, 1},g= {0,0},l= {0,0};
		MiniGammon mg =new MiniGammon(j1,j2,g,l,true,0);
		mg.ver();
		mg.codifica();
		int [] j1_={0, 3, 0, 0, 0, 0, 0},j2_={0, 0, 0, 1, 2, 0, 0},g_= {0,0},l_= {2,2};
		MiniGammon mg2 =new MiniGammon(j1_,j2_,g_,l_,true,0);
		mg2.ver();
		mg2.codifica();
	}
}
