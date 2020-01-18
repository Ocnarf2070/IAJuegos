package Puzzle8;

import Puzzle8.Puzzle;
import EspacioDeEstados.Problema;
/**
 * Problema del N- puzzle 8 con estado objetivo ordenado. Ejemplo para puzzle 8:
 *   0 1 2
 *   3 4 5
 *   6 7 8
 *   
 *   
 * 
 * @author Lorenzo Mandow 
 * @version 2013-10-08
 */
public class ProbPuzzleH0 extends Problema<Puzzle>{
	protected int rep;
    /**
     * Constructor for objects of class ProbPuzzleH0
     */
    public ProbPuzzleH0(Puzzle p)
    {
    	rep=0;
        this.ini = p;
    }

    /**
     * @return     verdadero si las fichas estan ordenadas por filas de
     *             izquierda a derecha y de arriba hacia abajo, empezando
     *             por el hueco (0).
     */
    @Override
    public boolean esFinal(Puzzle e){

    	int cont = 0;

        for (int i = 0; i < e.tab.length; i++) {
            for (int j = 0; j < e.tab[0].length; j++) {
                if (e.tab[i][j] != cont) {
                    return false;
                } else {
                    cont++;
                }
            }
        }

        return true;
    }
    public int repeticiones(Puzzle e) {
    	return rep;
    }
    @Override
    public int h(Puzzle e) {
    	rep++;
    	// TODO Auto-generated method stub
    	return super.h(e);
    }
}
