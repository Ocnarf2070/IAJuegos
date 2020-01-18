package jugadores;

import java.util.Random;
import espaciojuego.EstadoJuegoTV;

/**
 * Jugador que elige el siguiente movimiento evaluando los sucesores
 * inmediatos a la posición actual usando una Tabla de Valor calculada
 * mediante apriendizaje con refuerzo.
 * 
 * @author Lorenzo Mandow
 * @versión: 2017-11-20
 * */
public class JugadorEvaluarTV<E extends EstadoJuegoTV<E>> extends JugadorEntrenable<E> {
    
    public JugadorEvaluarTV(){
        super(new EvaluadorTV<E>());
    }
    
    public JugadorEvaluarTV(double alfa) {
        super(new EvaluadorTV<E>(alfa));
    }
}
