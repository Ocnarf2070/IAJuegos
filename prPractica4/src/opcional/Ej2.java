package opcional;

import conectak.ConectaK;
import conectak.EvaluadorCK;
import espaciojuego.Juego;
import jugadores.Jugador;
import jugadores.JugadorAlfaBeta;
import jugadores.JugadorEvaluar;
import jugadores.JugadorEvaluarTV;

public class Ej2 {
	public static void main(String[] args) {
		verEntrenamiento(3, 3, 3, 0.1, 0.1, 1000, 100, 1000);
		verEntrenamiento(4, 4, 3, 0.1, 0.1, 1000, 100, 1000);
		verEntrenamiento(4, 4, 4, 0.1, 0.1, 1000, 100, 1000);
	}
	public static void verEntrenamiento (int f, int c, int k, double alfa, double pexp, int partidas, int cada, int pruebas){
		System.out.print("Entrenamos c-"+k+" "+f+" x "+c+". Alfa: "+alfa+" Pexp: "+pexp);
		System.out.println(" Partidas: "+partidas+" Pruebas: "+pruebas+" cada "+cada);
		
		ConectaK e = new ConectaK(f,c,k);
        JugadorEvaluarTV<ConectaK> j1 = new JugadorEvaluarTV<>(alfa);
        JugadorEvaluarTV<ConectaK> j2 = new JugadorEvaluarTV<>(alfa);

        String p2 = "JugadorAlfaBeta(prof3) frente a EvaluarTV\n";        		
    	String p1 = "EvaluarTV frente a JugadorAlfaBeta(prof3)\n";
        Jugador<ConectaK> jab = new JugadorAlfaBeta<>(new EvaluadorCK(f,c,k), 3);
        for(int i = 0; i< partidas; i++){
        	j1.aprendeTurno1(j2, e, pexp);
        	j2.aprendeTurno2(j1, e, pexp);
        	

        	if(i%cada==0&&i!=0) {
        		Juego<ConectaK,Jugador<ConectaK>,Jugador<ConectaK>> juego1 = new Juego<ConectaK, Jugador<ConectaK>, Jugador<ConectaK>>(j1,jab,e);
        		p1+=juego1.jugarNPartidasStr(pruebas);
        		Juego<ConectaK,Jugador<ConectaK>,Jugador<ConectaK>> juego2 = new Juego<ConectaK, Jugador<ConectaK>, Jugador<ConectaK>>(jab,j2,e);
        		p2+=juego2.jugarNPartidasStr(pruebas);
        	}
        }
        System.out.println(p1+p2);
	}

}

