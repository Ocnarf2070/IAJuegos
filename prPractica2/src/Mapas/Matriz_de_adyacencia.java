package Mapas;
/**
 * @see http://www.jc-mouse.net/
 * @author mouse
 */
public class Matriz_de_adyacencia {
    
    private int n;
    private int[][] matriz;
    static char [] lugares;
    
    /**
     * Constructor de clase
     * @param n numero de nodos
     */
    public Matriz_de_adyacencia(char[] lugares) {
        this.n = lugares.length;
        Matriz_de_adyacencia.lugares=lugares;
        matriz = new int[this.n][this.n];
        //se inicializa matriz en 0
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }            
        }
    }
    
    private int posicion(char pos,int min,int max) {
		int medio=(max+min)/2;
		int pos1;
		if(lugares[medio]==pos)return medio;
		else if(lugares[medio]<pos) pos1=posicion(pos,medio+1,max);
		else pos1=posicion(pos, min, medio);
		return pos1;
	}
    
    public void add(char a, char b, int cant){
    	int i = posicion(a, 0, n-1);
    	int j = posicion(b, 0, n-1);
        matriz[i][j] = cant;
        matriz[j][i] = cant;
    }
    
    public void delete(char a, char b){
    	int i = posicion(a, 0, n-1);
    	int j = posicion(b, 0, n-1);
        if(matriz[i][j]>0) {
        	 matriz[i][j] = 0;
        	 matriz[j][i] = 0;
        }
           
    }
    
    public int[][] getMatriz() {
		return matriz;
	}

	public void imprimir(){
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );        
            }
            System.out.println();
        }  
    }
}