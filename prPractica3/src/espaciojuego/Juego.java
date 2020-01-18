package espaciojuego;

import jugadores.Jugador;

/**
 * @version 2017-11-17
 * @author Lorenzo Mandow
 * 
 * Entorno formado por el estado de un juego y dos jugadores cuyos
 * movimientos se alternan por turnos.
 */
public class Juego<E extends EstadoJuego<E>, J extends Jugador<E>> {// & JuegoConDado, J extends Jugador<E>> {
    public J jug1;
    public J jug2;
    E eIni;
    
    /**
     * Constructor. Recibe los dos jugadores y el estado inicial del juego.
     * 
     * @param jug1  Jugador 1 (empieza el juego).
     * @param jug2  Jugador 2.
     * @param eIni  Estado inicial de un juego.
     * 
     */
    
    public Juego (J j1, J j2, E eIni){
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
        J jug;     
        
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
    
    public void jugarNPartidas (boolean eco,int numRep) {
    	double gana1 = 0,gana2 = 0,empate = 0;
    	for(int i=0;i<numRep;i++) {
    		int j =  jugarPartida(false);
            
            if (j == 0) empate++;
            else if (j == 1) gana1++;
            else gana2++;
        }
    	System.out.println((gana1*100/numRep)+"\t"+(empate*100/numRep)+"\t"+(gana2*100/numRep));
    }
    
    public void unMovimiento() {
    	E e = this.eIni;
    	J jug;     
    	jug = e.turno1() ? this.jug1 : this.jug2;
    	e = jug.mueve(e);
    	//e.ver();
    }
}