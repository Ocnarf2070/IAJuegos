package conectak;
import jugadores.JugadorMinimax;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MatrizPosibilidades matriz = new MatrizPosibilidades(3,3,3);
	        
	        for (int f = 0; f < 3; f++) {
	            for (int c = 0; c < 3; c++) {
	                System.out.print("(");
	                for (Integer i : matriz.posibilidades(f, c)) {
	                    System.out.print(i + " ");
	                }
	                System.out.print(")"   );
	            }
	            System.out.println();
	        }
	        System.out.println("num pos: " + matriz.numPosibilidades());
		ConectaK tab = new ConectaK(3,3,3);
		tab=tab.elegirSucNth(2);
		tab=tab.elegirSucNth(0);
		tab.ver();
		System.out.println("-----------------------------------------------");
		JugadorMinimax<ConectaK> j = new JugadorMinimax<>(new EvaluadorCK(3,3,3), 1);
		j.mueve(tab);
	}
}

