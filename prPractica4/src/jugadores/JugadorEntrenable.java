package jugadores;

import java.util.List;
import java.util.Random;

import espaciojuego.EstadoJuego;

/**
 * Modelo para un jugador entrenable mediante aprendizaje por refuerzo.
 * Se caracteriza por utilizar un evaluador entrenable (clase abstracta
 * EvaluadorEntrenable). Incorpora los métodos para entrenar el evaluador.
 * 
 * @author Lorenzo Mandow
 * @versión: 2017-11-21
 * */

public abstract class JugadorEntrenable<E extends EstadoJuego<E>> extends JugadorEvaluar<E> {
    
	//Para exploración aleatoria
	Random rnd = new Random();
	
    public JugadorEntrenable(EvaluadorEntrenable<E> ev) {
		super(ev);
	}
    
    /**
     * Entrena al jugador mediante una partida con el jugador j1 a partir del estado e.
     * Suponemos que j1 jugará en el turno 1 del
     * juego y el jugador en el turno 2.
     * 
     * @param j1   Jugador que jugará el primer turno
     * @param e    Estado inicial del juego
     * @param pExp Probabilidad de exploración, debe ser un valor mayor o igual que 0.0 y menor que 1.0
     *
     */
    
    public void aprendeTurno2(Jugador<E> j1, E e, double pExp){
    	aprendeTurno2(j1, e, pExp, false);
    }
    
//    public void aprendeTurno2 (Jugador<E> j1, E e, double pExp, boolean miTurno){
//        
//    	// Movimiento de j1
//        E e2 = j1.mueve(e);
//        
//        //Comprobamos si terminó el juego
//        if(e2.ganaActual() || e2.ganaOtro() || e2.agotado()){
//        	((EvaluadorEntrenable<E>)this.evaluador).actualizaDT(e, e2, miTurno);
//        } else {                                                   //el juego continúa
//            boolean explora = (rnd.nextDouble() < pExp); 
//            
//            //Realizamos nuestro movimiento, aleatorio con probabilidad 'explora'
//            E e3;
//            if (explora){
//                List<E> lh = e2.hijos();
//                int n = rnd.nextInt(lh.size());
//                e3 = lh.get(n);
//            } else {
//                e3 = this.mueve(e2);
//            }//if explora
//            
//            //actualizamos el valor de e
//            ((EvaluadorEntrenable<E>)this.evaluador).actualizaDT(e, e3, miTurno);
//          
//            //Comprobamos si terminó el juego
//            if(!(e3.ganaActual() || e3.ganaOtro() || e3.agotado())){
//          	    aprendeTurno2(j1, e3, pExp, miTurno);
//            }//if !
//        }//if e2.ganaActual
//    }
    
    public void aprendeTurno2 (Jugador<E> j1, E e, double pExp, boolean miTurno){
    	E e3 = null;
    	do{
    		E e2= j1.mueve(e);
    		if(e2.ganaActual() || e2.ganaOtro() || e2.agotado()) {
            	((EvaluadorEntrenable<E>)this.evaluador).actualizaDT(e, e2, miTurno);
    			break;
    		}else {                                                  
                boolean explora = (rnd.nextDouble() < pExp); 
                
                if (explora){
                    List<E> lh = e2.hijos();
                    int n = rnd.nextInt(lh.size());
                    e3 = lh.get(n);
                } else {
                    e3 = this.mueve(e2);
                }
                
                ((EvaluadorEntrenable<E>)this.evaluador).actualizaDT(e, e3, miTurno);
                e=e3;
                
            }
    	}while(!(e3.ganaActual() || e3.ganaOtro() || e3.agotado()));
        
          
    }
    
    
public void aprendeTurno1 (Jugador<E> j2, E e, double pExp){
        
    	boolean explora = (rnd.nextDouble() < pExp); 
    	
    	E e2;
        if (explora){
            List<E> lh = e.hijos();
            int n = rnd.nextInt(lh.size());
            e2 = lh.get(n);
        } else {
            e2 = this.mueve(e);
        }//if explora
        
        //llamamos a la recursión de aprendeTurno2, pero somos el primer jugador
        this.aprendeTurno2(j2, e2, pExp, true);
    }
    
}
