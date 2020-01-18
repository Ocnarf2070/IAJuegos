package jugadores;

import java.util.Random;

import espaciojuego.EstadoJuego;
import espaciojuego.EstadoJuegoAprox;
import espaciojuego.EstadoJuegoTV;

public class JugadorEvaluarLineal<E extends EstadoJuego<E> & EstadoJuegoAprox> extends JugadorEntrenable<E> {
    
    public JugadorEvaluarLineal(E estadoIni) {
    	super(new EvaluadorAproxLineal<E>(estadoIni.codifica().length));
    }
    
    public JugadorEvaluarLineal(E estadoIni, double alfa) {
    	super(new EvaluadorAproxLineal<E>(estadoIni.codifica().length, alfa));
    }
    
    public double[] consultarPesos(){
    	return ((EvaluadorAproxLineal<E>) this.evaluador).consultarPesos();
    }
    
}
