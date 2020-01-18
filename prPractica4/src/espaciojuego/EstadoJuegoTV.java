package espaciojuego;

/**
 * Representación de los estados de un juego bipersonal de suma cero.
 * Incorpora los métodos necesarios para indexar los estados en una
 * tabla hash. Esto se utiliza, por ejemplo, en la implementación de
 * funciones de evaluación que usan tablas de valor.
 * 
 * @author Lorenzo Mandow
 * @version: 2017-11-17
 * @param <E>
 *
 */

public abstract class EstadoJuegoTV<E extends EstadoJuego<E>> extends EstadoJuego<E> {

	/**
	 * Si se desea usar las definiciones por defecto de equals y hashCode, el método
	 *  toString debe proporcionar cadenas distintas para estados distintos. 
	 */
	public abstract String toString();
	
	/**
     * Por defecto utilizaremos la cadena generada por toString(). Por ese motivo, 
     * toString() debe devolver una cadena que identifique univocamente el
     * estado.
     * 
     * Esta no es la manera mas eficiente de implementar equals, pero puede redefinirse
     * mas adelante.
     * 
     * @param  e El estado a comaprar
     * @return  verdadero si los dos estados son iguales.
     */
    public boolean equals(Object e)
    {
        return this.getClass().equals(e.getClass()) && this.toString().equals(e.toString());
    }    
    
    
    /**
     * Por defecto utilizaremos el codigo hash de la cadena generada por toString(). Por
     * ese motivo, toString() debe devolver una cadena que identifique univocamente el
     * estado.
     * 
     * Esta no es la manera mas eficiente de implementar hashCode, pero puede redefinirse
     * mas adelante.
     * 
     * @return codigo hash del estado para indexar una tabla hash (requerido por HashMap).
     */
    
    public int hashCode ()
    {
       return this.toString().hashCode();
    }
    
    /**
     * Muestra por pantalla el estado e.
     */
    public void ver(){
        System.out.println(this.toString());
	}

}
