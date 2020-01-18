package conectak;

import espaciojuego.Juego;
import jugadores.Jugador;
import jugadores.JugadorEvaluar;
import jugadores.JugadorEvaluarTV;

public class TestConectaKEj3 {
	public static void main(String[] args) {
		verEntrenamiento(3, 3, 3, 0.1, 0.1, 10000, 100, 1000);
		verEntrenamiento(4, 4, 3, 0.1, 0.1, 10000, 100, 1000);
		verEntrenamiento(4, 4, 4, 0.1, 0.1, 10000, 100, 1000);
	}
	public static void verEntrenamiento (int f, int c, int k, double alfa, double pexp, int partidas, int cada, int pruebas){
		System.out.print("Entrenamos c-"+k+" "+f+" x "+c+". Alfa: "+alfa+" Pexp: "+pexp);
		System.out.println(" Partidas: "+partidas+" Pruebas: "+pruebas+" cada "+cada);
		
		ConectaK e = new ConectaK(f,c,k);
        JugadorEvaluarTV<ConectaK> j1 = new JugadorEvaluarTV<>(alfa);
        JugadorEvaluarTV<ConectaK> j2 = new JugadorEvaluarTV<>(alfa);

        Jugador<ConectaK> jck = new JugadorEvaluar<>(new EvaluadorCK(f, c, k));
        for(int i = 0; i< partidas; i++){
        	j1.aprendeTurno1(j2, e, pexp);
        	j2.aprendeTurno2(j1, e, pexp);
        	if(i%cada==0&&i!=0) {
        		Juego<ConectaK,Jugador<ConectaK>,Jugador<ConectaK>> juego1 = new Juego<ConectaK, Jugador<ConectaK>, Jugador<ConectaK>>(j1,jck,e);
        		juego1.jugarNPartidas(pruebas);
        		
        	}
        }
        System.out.println();
	}

}
