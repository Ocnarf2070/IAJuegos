package jugadores;

import java.util.List;
import espaciojuego.EstadoJuego;


/**
 * Jugador que elige el siguiente movimiento evaluando los sucesores
 * de la posición actual a una profundidad dada, y propagando los
 * valores mediante la estrategia MiniMax.
 * 
 * @author Lorenzo Mandow
 * 
 * @versión: 2017-11-20 
 *
 */
public class JugadorMinimax<E extends EstadoJuego<E>> extends JugadorEvaluar<E>{ 
    private int profMax;            // Profundidad máxima de búsqueda.
    private int nodos;
    /**
     * Constructor.
     * 
     * @param ev                Evaluador.
     * @param profundidadMaxima Profundidad máxima de búsqueda.
     */
    public JugadorMinimax(Evaluador<E> ev, int profundidadMaxima) {
        super(ev);
        nodos=0;
        this.profMax = profundidadMaxima;
    }
    
    @Override
    public E mueve(E e) {
    	
    	boolean miTurno = e.turno1();
    	
        VE resultado = negamax(e, this.profMax, miTurno, 1);
        
        //System.out.println("Evaluación del movimiento: " + resultado.v());
        
        return (E) resultado.e();
    }
    
  
    /**
     * Realiza una evaluación MINIMAX de un estado dado a una profundidad dada.
     * El cálculo se realiza mediante una función recursiva por la cola que implementa
     * el método de cálculo conocido como NEGAMAX: en cada nivel se calcula siempre el
     * máximo de los sucesores cambiado de signo, pero las evaluaciones se van cambiando
     * de signo según la profundidad, de modo que en los niveles MIN, calcular el máximo 
     * cambiado de signo de las evaluaciones cambiadas de signo equivale a calcular el mínimo.
     * 
     * @param e     Estado del juego.
     * @param prof  Profundiad de la búsqueda.
     * @param miTurno  true si MAX es el primer jugador, false si es el segundo.
     * @param signo Tomará inicialmente el valor 1, e irá alternando de signo con la profundidad.
     * @return      Objeto VE con el mejor estado sucesor y su valoración minimax.
     */
    
    public VE negamax (E e, int prof, boolean miTurno, int signo) {
        E mejorE = null;
        double mejorV = Double.NEGATIVE_INFINITY;
        double v2;
        
        if (prof == 0 || e.ganaActual() || e.ganaOtro() || e.agotado()) {
        	nodos++;
            mejorV = signo*this.evaluador.evalua(e, miTurno);
        } else {
            for (E e2 : ordenar(e.hijos())) {
                v2 = -(negamax(e2, prof-1, miTurno, -signo).v());
                if ((v2 > mejorV) || (mejorE == null)) {
                    mejorV = v2;
                    mejorE = e2;
                }
            }
        }
        return new VE(mejorV, mejorE);
    }
    
    List<E> ordenar (List<E> l) {
        return super.barajar(l);    
    }
    
    public int nodos() {
    	return nodos;
    }
}