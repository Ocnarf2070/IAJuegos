package espaciojuego;

import jugadores.Jugador;

/**
 * @version 2017-12-21
 * @author Lorenzo Mandow
 * 
 * Entorno formado por el estado de un juego y dos jugadores cuyos
 * movimientos se alternan por turnos.
 */
public class Juego<E extends EstadoJuego<E>, J1 extends Jugador<E>, J2 extends Jugador<E>> {
    public J1 jug1;
    public J2 jug2;
    E eIni;
    
    /**
     * Constructor. Recibe los dos jugadores y el estado inicial del juego.
     * 
     * @param jug1  Jugador 1 (empieza el juego).
     * @param jug2  Jugador 2.
     * @param eIni  Estado inicial de un juego.
     * 
     */
    
    public Juego (J1 j1, J2 j2, E eIni){
        this.jug1 = j1;
        this.jug2 = j2;
        this.eIni = eIni;
    }
    
    /**
     * Controla el desarrollo de la partida hasta que haya terminado.
     * 
     * @param eco   Permite opcionalmente mostrar por pantalla el desarrollo del juego.
     * @return      1, 0, -1, según gane el primer jugador, haya empate, o gane el segundo jugador, respectivamente.
     */
    public int jugarPartida (boolean eco) {
        
    	E e = this.eIni;
        Jugador<E> jug;     
        
        if(eco){e.ver();}
        
        //Desarrollo de la partida
        while(!(e.ganaActual() || e.ganaOtro() || e.agotado())){
        	 jug = e.turno1() ? this.jug1 : this.jug2;     // Le toca a jug.
             e = jug.mueve(e);
             if (eco) {e.ver();}
        }//while
        
        //Resultado
        if(e.ganaActual()){
        	return e.turno1() ? 1 : -1;
        } else if (e.ganaOtro()){
        	return e.turno1() ? -1 : 1;
        } else { //agotado
        	return 0;
        }
    }
    
    public void jugarNPartidas (int numRep) {
    	double gana1 = 0,gana2 = 0,empate = 0;
    	for(int i=0;i<numRep;i++) {
    		int j =  jugarPartida(false);
            
            if (j == 0) empate++;
            else if (j == 1) gana1++;
            else gana2++;
        }
    	System.out.print("Gana 1: "+(gana1*100/numRep)+"% ("+(int)gana1+")\t");
    	System.out.print("Empate: "+(empate*100/numRep)+"% ("+(int)empate+")\t");
    	System.out.println("Gana 2: "+(gana2*100/numRep)+"% ("+(int)gana2+") ");
    }
    public String jugarNPartidasStr (int numRep) {
    	double gana1 = 0,gana2 = 0,empate = 0;
    	for(int i=0;i<numRep;i++) {
    		int j =  jugarPartida(false);
            
            if (j == 0) empate++;
            else if (j == 1) gana1++;
            else gana2++;
        }
    	return ("Gana 1: "+(gana1*100/numRep)+"% ("+(int)gana1+")\t")+
    	("Empate: "+(empate*100/numRep)+"% ("+(int)empate+")\t")+
    	("Gana 2: "+(gana2*100/numRep)+"% ("+(int)gana2+") \n");
    }
    
//	public int jugarPartidaConDado(int carasDado, boolean eco){   
//    	
//		Random dado = new Random();
//        E e = this.eIni;
//		J jug;
//		int tirada;
//
//        
//        if(eco){e.ver();}
//        
//        //Desarrollo de la partida
//        while(!(e.ganaActual() || e.ganaOtro() || e.agotado())){
//        	 jug = e.turno1() ? this.jug1 : this.jug2;     // Le toca a jug.
//        	 //tiramos el dado para la siguiente jugada
//        	 tirada = dado.nextInt(carasDado) + 1;
//        	 if(eco){System.out.println("  ** La tirada del dado fue : " + tirada + "  ***");}
//        	 e.tiradaDado(tirada);
//             e = (E) jug.mueve(e);
//             if (eco) {e.ver();}
//        }//while
//        
//        //Resultado
//        if(e.ganaActual()){
//        	return e.turno1() ? 1 : -1;
//        } else if (e.ganaOtro()){
//        	return e.turno1() ? -1 : 1;
//        } else { //agotado
//        	return 0;
//        }
//    }
}