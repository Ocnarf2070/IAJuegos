package jugadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import espaciojuego.EstadoJuego;

/**
 * @author Lorenzo Mandow
 * @date   2017-11-23
 *
 * Jugador humano básico, que muestra por pantalla los sucesores ordenados, y pide
 * uno de ellos.
 */

public class JugadorHumano<E extends EstadoJuego<E>> implements Jugador<E> {

	@Override
	public E mueve(E e) {
		
		System.out.println("\n\n\n******** MOVIMIENTOS PARA EL JUGADOR HUMANO *************************");
		List<E> l = e.hijos();
		for(int cont = 0; cont < l.size(); cont++){
			E suc = l.get(cont);
			System.out.println(" ** SUCESOR " + cont);
			suc.ver();
		}
		System.out.println("*************************************************************************");
		
		int mov;
		do {
			mov = pedirMovimiento();
		} while (!(0 <= mov && mov <l.size()));
		
		System.out.println("\n\n\n");
		return l.get(mov);
		
	}

	private int pedirMovimiento () {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String linea;
		
		System.out.println("¿Qué movimiento eliges?");
		try {
			linea = br.readLine(); 
		} catch (IOException e) {
			return -1;
		}
		return Integer.parseInt(linea);
	}
	
}
