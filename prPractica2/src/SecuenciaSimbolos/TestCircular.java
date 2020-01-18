package SecuenciaSimbolos;

public class TestCircular {

	public static void main(String[] args) {
		String ini = "ABCDEFGHIJ";
		String fin = "IDEJBFCGAH";
		CircularList cl = new CircularList(ini);
		CircularList clfin = new CircularList(fin);
		PCircularList prob = new PCircularList(cl, clfin);
		long t1 = System.nanoTime();
		for(CircularList aux : prob.amplitud()) {
			System.out.print(aux+"->");
		}
		long t2 = System.nanoTime();
		System.out.println();
		System.out.println("Iteraciones: "+prob.iteraciones());
		System.out.println("Tiempo: "+(t2-t1)/(1e9));
		System.out.println();

		
		PCircularList prob2 = new PCDescolocadas(cl, clfin);
		t1 = System.nanoTime();
		for(CircularList aux : prob2.aMono()) {
			System.out.print(aux+"->");
		}
		t2 = System.nanoTime();
		System.out.println();
		System.out.println("Iteraciones: "+prob2.iteraciones());
		System.out.println("Tiempo: "+(t2-t1)/(1e9));
		System.out.println();

		
		PCircularList prob3 = new PCManhattan(cl, clfin);
		t1 = System.nanoTime();
		for(CircularList aux : prob3.aMono()) {
			System.out.print(aux+"->");
		}
		t2 = System.nanoTime();
		System.out.println();
		System.out.println("Iteraciones: "+prob3.iteraciones());
		System.out.println("Tiempo: "+(t2-t1)/(1e9));

	}
}
