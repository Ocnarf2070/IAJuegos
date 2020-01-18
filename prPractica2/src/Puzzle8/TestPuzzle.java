package Puzzle8;

import java.util.List;
/**
 * Pruebas para el puzzle 2D de piezas deslizantes.
 * 
 * @Jose Miguel Horcas Aguilera, Lorenzo Mandow
 *
 */
public class TestPuzzle {
    
    public static void main(String[] args) {
    	//Puzzle s = new Puzzle(3,3);
    	int [] [] s1 = {{3,2,5},{6,8,4},{7,1,0}};
    	Puzzle s = new Puzzle(s1);
    	System.out.println("Para el puzzle: ");
    	s.ver();
    	System.out.println("Heuristica 0:");testH0(s);System.out.println();
    	System.out.println("Heuristica Descolocadas:");testDes(s);System.out.println();
    	System.out.println("Heuristica Manhattan:");testManh(s);System.out.println();
    	System.out.println("Heuristica DPB (4 comodines):");testDPB(s,4);System.out.println();
    	System.out.println("Heuristica DPB (5 comodines):");testDPB(s,5);System.out.println();
    	int [] [] s2 = {{8,7,6},{0,4,1},{2,5,3}};
    	s= new Puzzle(s2);
    	System.out.println("Para el puzzle: ");
    	s.ver();
    	System.out.println("Heuristica 0:");testH0(s);System.out.println();
    	System.out.println("Heuristica Descolocadas:");testDes(s);System.out.println();
    	System.out.println("Heuristica Manhattan:");testManh(s);System.out.println();
    	System.out.println("Heuristica DPB (4 comodines):");testDPB(s,4);System.out.println();
    	System.out.println("Heuristica DPB (5 comodines):");testDPB(s,5);System.out.println();
    	
    }
    public static void testDes(Puzzle s){
    		ProbPuzzleDescolocadas problema = new ProbPuzzleDescolocadas(s);
    		List<Puzzle> l =  problema.aMono();
    		
    		if (l != null) {
    			System.out.println("Profundidad de la solucion: " + (l.size()-1));
                /*System.out.println("Camino Solucion:");
                for (Puzzle e : l) {
                	System.out.print("h: "+problema.h(e)+"->");
                	e.ver();
                  
                }*/
                System.out.println("Iteraciones: "+problema.repeticiones(s));
            } else {
                System.out.println("No se ha podido encontrar la Solucion");
            }        
    	}
    public static void testManh(Puzzle s){
    		ProbPuzzleManhattan problema = new ProbPuzzleManhattan(s);
    		List<Puzzle> l =  problema.aMono();
    		
    		if (l != null) {
    			System.out.println("Profundidad de la solucion: " + (l.size()-1));
//                System.out.println("Camino Solucion:");
//                for (Puzzle e : l) {
//                	System.out.print("h: "+problema.h(e)+"->");
//                	e.ver();
//                  
//                }
                System.out.println("Iteraciones: "+problema.repeticiones(s));

            } else {
                System.out.println("No se ha podido encontrar la Solucion");
            }        
    	}
    
    public static void testH0(Puzzle s){
		ProbPuzzleH0 problema = new ProbPuzzleH0(s);
		
		List<Puzzle> l =  problema.aMono();
		
		if (l != null) {
			System.out.println("Profundidad de la solucion: " + (l.size()-1));
//            System.out.println("Camino Solucion:");
//            for (Puzzle e : l) {
//               e.ver();
//            }
            System.out.println("Iteraciones: "+problema.repeticiones(s));

        } else {
            System.out.println("No se ha podido encontrar la Solucion");
        }        
	}
	
	public static void testDPB(Puzzle s,int com) {
		ProbPuzzleBDP problema = new ProbPuzzleBDP(s, com);
		
		List<Puzzle> l = problema.aMono();
		
		if (l != null) {
			System.out.println("Profundidad de la solucion: " + (l.size()-1));
//            System.out.println("Camino Solucion:");
//            for (Puzzle e : l) {
//               e.ver();
//            }
            System.out.println("Iteraciones: "+problema.repeticiones(s));

        } else {
            System.out.println("No se ha podido encontrar la Solucion");
        }        
	}
	
}
