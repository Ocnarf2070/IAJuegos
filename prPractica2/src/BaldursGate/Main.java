package BaldursGate;

import java.util.Scanner;
//import java.io.PrintWriter;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String fl = args[0];
			BaldursGateMap map = new BaldursGateMap(fl);
			System.out.print("Leyendo mapa...primer estado valido ("+map.val_x+","+map.val_y+")...hecho\nMapa Cargado: "+fl+"\nCoordenadas de origen en modo x y : ");
			Scanner sc = new Scanner(System.in); 
			int x=sc.nextInt();
			int y=sc.nextInt();
			System.out.print("Coordenadas de destino en modo x y : ");
			int fx=sc.nextInt();
			int fy=sc.nextInt();
			sc.close();
			if(map.map[x][y]=='@'||map.map[fx][fy]=='@')throw new NullPointerException();
	//		int x = Integer.decode(args[1]),y=Integer.decode(args[2]);
	//		int fx=Integer.decode(args[3]),fy=Integer.decode(args[4]);
	//		BaldursGateMap copyMap = new BaldursGateMap(fl);
			BaldursGate bg = new BaldursGate(map, x, y, fx, fy);
			BaldursGateSol sol = new BaldursGateSol(bg, map);
			sol.Solucion();
			
		}
		catch(NullPointerException ee) {System.out.println("No hay solucion");System.exit(10);}
	}
}
