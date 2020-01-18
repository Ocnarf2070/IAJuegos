package jugadores;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import conectak.ConectaK;
import espaciojuego.EstadoJuego;


/**
 * Jugador que elige el siguiente movimiento evaluando los sucesores
 * de la posición actual a una profundidad dada, y propagando los
 * valores mediante la estrategia Alfa-Beta.
 * 
 * @author Lorenzo Mandow
 * 
 * @versión: 2017-11-20
 *
 */
public class JugadorAlfaBeta<E extends EstadoJuego<E>> extends JugadorEvaluar<E> {

    private int profMax;            // Profundidad máxima de búsqueda.
    private int nodos;
    private boolean alea;
    private Comparator<E> orden;
    /**
     * Constructor.
     * 
     * @param ev                Evaluador.
     * @param profundidadMaxima Profundidad máxima de búsqueda.
     */
    public JugadorAlfaBeta(Evaluador<E> ev, int profundidadMaxima) {
        super(ev);
        nodos=0;
        this.profMax = profundidadMaxima;
        alea=true;
        orden=new Comparator<E>() {

			@Override
			public int compare(E o1, E o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
    }
    public JugadorAlfaBeta(Evaluador<E> ev, int profundidadMaxima,Comparator<E> orden) {
        super(ev);
        nodos=0;
        this.profMax = profundidadMaxima;
        alea=false;
        this.orden=orden;
    }
    
    @Override
    public E mueve(E e) {
    	
    	boolean miTurno = e.turno1();
    	
        VE resultado = negamaxAB(e, this.profMax, miTurno, 1);
        
       
       // System.out.println("Evaluación del movimiento: " + resultado.v());
        
        return ((E) resultado.e());
    }
    
    /**
     * 
     */
    
    public VE negamaxAB (E e, int prof, boolean miTurno, int signo) {
        return negamaxAB(e, prof, miTurno, signo, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    public VE negamaxAB (E e, int prof, boolean miTurno, int signo, double alfa, double beta) {
        E mejorE = null;
        double mejorV = Double.NEGATIVE_INFINITY;
        double v2;
        if (prof == 0 || e.ganaActual() || e.ganaOtro() || e.agotado()) {
        	nodos++;
        	mejorV = signo*this.evaluador.evalua(e, miTurno);
        } else {
            for (E e2 : ordenar(e.hijos())) {
                v2 = -(negamaxAB (e2, prof-1, miTurno, -signo, -beta, -alfa).v());
                if ((v2 > mejorV) || (mejorE == null)) {
                    mejorV = v2;
                    mejorE = e2;
                     if (v2 >= beta){
                         return new VE(mejorV, mejorE);
                    }
                    if (v2 >  alfa){
                        alfa = v2;
                    }
                }
            }
        }
        return new VE(mejorV, mejorE);
    }
  
	List<E> ordenar (List<E> l) {
		if(!alea) {
			Collections.sort(l,orden);
			return l;
		}else return super.barajar(l);
    }
    public int nodos() {
    	return nodos;
    }
}
