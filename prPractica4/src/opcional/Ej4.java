package opcional;
import espaciojuego.Juego;
import jugadores.Jugador;
import jugadores.JugadorAleatorio;
import jugadores.JugadorEvaluarLineal;
import minigammon.MiniGammon;
public class Ej4 {

	public static void main(String[] args) {
		System.out.println("Aleatorio frente a EvaluarTV");
		int [] j1={2, 0, 3, 0, 0, 0, 0, 0},j2={0, 0, 0, 0, 0, 3, 0, 2},g= {0,0},l= {0,0};
		verEntrenamientoAleatorio(j1,j2,g,l,true,1,2,5, 0.1, 0.1, 2500, 100, 1000);

	}
	private static void verEntrenamientoAleatorio(int[] fichasJ1, int[] fichasJ2, int[] golpeadas, int[] liberadas, boolean turno1,
			int tiradaDado,int carasDado,int fichasParaGanar,double alfa, double pexp, int partidas, int cada, int pruebas){
		System.out.print("Entrenamos Minigammon N-"+fichasJ1.length+". Alfa: "+alfa+" Pexp: "+pexp);
		System.out.println(" Partidas: "+partidas+" Pruebas: "+pruebas+" cada "+cada);
		new MiniGammon(fichasParaGanar, carasDado);
		MiniGammon e = new MiniGammon(fichasJ1, fichasJ2, golpeadas, liberadas, turno1, tiradaDado);
		JugadorEvaluarLineal<MiniGammon> j2 = new JugadorEvaluarLineal<>(e, alfa);
		JugadorEvaluarLineal<MiniGammon> j1 = new JugadorEvaluarLineal<>(e, alfa);

		Jugador<MiniGammon> ja = new JugadorAleatorio<>();
		for(int i = 0; i< partidas; i++){
			j1.aprendeTurno1(j2, e, pexp);
			j2.aprendeTurno2(j1, e, pexp);
			if(i%cada==0) {
				Juego<MiniGammon,Jugador<MiniGammon>,Jugador<MiniGammon>> juego1 = new Juego<MiniGammon, Jugador<MiniGammon>, Jugador<MiniGammon>>(j1,ja,e);
				//System.out.print(i/cada+" ");
				juego1.jugarNPartidas(pruebas);
			}
		}    
		System.out.println();
	}
}
