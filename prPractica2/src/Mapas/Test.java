package Mapas;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ini,fin;
		char[] lug= {'A','B','C','D','E','F','G'};
		int[] est = {29,10,15,4,4,5,0};
		Matriz_de_adyacencia matriz = new Matriz_de_adyacencia(lug);
		matriz.add('A', 'B', 10);
		matriz.add('A', 'C', 15);
		matriz.add('B', 'D', 15);
		matriz.add('C','D',5);
		matriz.add('C', 'E', 7);
		matriz.add('E', 'D', 6);
		matriz.add('D', 'F', 4);
		matriz.add('E', 'F', 2);
		matriz.add('E', 'G', 7);
		matriz.add('G', 'F', 6);
		//matriz.imprimir();
		Scanner sc = new Scanner(System.in);
		System.out.print("Cargando mapa...\nMapa Cargado\nPosiciones disponibles: ");
		for(int i=0;i<lug.length;i++)System.out.print(lug[i]+" ");
		System.out.println();
		System.out.print("Lugar inicial: ");
		ini=sc.next().charAt(0);
		System.out.println("Lugar final: ");
		fin=sc.next().charAt(0);
		sc.close();
		try {
		EstadoMapa mapa = new EstadoMapa(matriz.getMatriz(), ini);
		PMapa prob = new PMapa(mapa, fin, est);
		Iterator<EstadoMapa> it = prob.aMono().iterator();
		System.out.println("Iteraciones: "+prob.iteraciones());
		System.out.print("Solución: "+it.next());
		while(it.hasNext()) {
			System.out.print("->"+it.next());
		}
		}catch (NullPointerException e) {
			System.out.println("No hay solucion");
			System.exit(10);
			// TODO: handle exception
		}
		
	}

}
