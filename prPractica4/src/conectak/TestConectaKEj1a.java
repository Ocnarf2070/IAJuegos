package conectak;

import espaciojuego.Juego;
import jugadores.Jugador;
import jugadores.JugadorAleatorio;
import jugadores.JugadorEvaluarTV;

public class TestConectaKEj1a {
	public static void main(String[] args) {
		System.out.println("Aleatorio frente a EvaluarTV");
		verEntrenamientoAleatorio(3, 3, 3, 0.1, 0.1, 10000, 100, 1000);
		verEntrenamientoAleatorio(4, 4, 3, 0.1, 0.1, 10000, 100, 1000);
		verEntrenamientoAleatorio(4, 4, 4, 0.1, 0.1, 10000, 100, 1000);
		
	}
	public static void verEntrenamientoAleatorio (int f, int c, int k, double alfa, double pexp, int partidas, int cada, int pruebas){
		System.out.print("Entrenamos c-"+k+" "+f+" x "+c+". Alfa: "+alfa+" Pexp: "+pexp);
		System.out.println(" Partidas: "+partidas+" Pruebas: "+pruebas+" cada "+cada);
		
		ConectaK e = new ConectaK(f,c,k);
        JugadorEvaluarTV<ConectaK> j2 = new JugadorEvaluarTV<ConectaK>(alfa);
        Jugador<ConectaK> j1 = new JugadorAleatorio<>();

        Jugador<ConectaK> ja = new JugadorAleatorio<>();
        for(int i = 0; i< partidas; i++){
        	j2.aprendeTurno2(ja, e, pexp);
        	if(i!=0&&i%cada==0) {
        		Juego<ConectaK,Jugador<ConectaK>,Jugador<ConectaK>> juego1 = new Juego<ConectaK, Jugador<ConectaK>, Jugador<ConectaK>>(j1,j2,e);
        		//System.out.print(i/cada+" ");
        		juego1.jugarNPartidas(pruebas);
        	}
        }    
        System.out.println();
	}
}
