package BaldursGate;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class BaldursGateMap {
	
	char[][]map;
	String mov;
	int val_x,val_y;
	public BaldursGateMap(String fl) {
		int i = 0,j,i2=0,j2=0;
		boolean mapa=false;
		try(Scanner sc = new Scanner(new File(fl))){
			while(sc.hasNextLine()&&!mapa) {
				String line=sc.nextLine();
				//System.out.print(line+"->");
				try(Scanner ss = new Scanner(line)){
					while(ss.hasNext()&&!mapa) {
						String pal=ss.next();
						//System.out.print(pal+"->");
						if(pal.equals("type"))mov=ss.next();
						else if(pal.equals("height"))i=ss.nextInt();
						else if(pal.equals("width")) {
							j=ss.nextInt();
							map = new char [i][j];
						}else if(pal.equals("map"))mapa=true;
					}
				}
			}
			boolean valido=false;
			while(sc.hasNextLine()) {
				String line=sc.nextLine();
				//System.out.println((line=sc.nextLine()));
				for(j2=0;j2<line.length();j2++) {
					char pal=line.charAt(j2);
					map[i2][j2]=pal;
					if(!valido && map[i2][j2]=='.') {
						val_x=i2;
						val_y=j2;
						valido=true;
					}
				}
				i2++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Este mapa no existe");
			System.exit(10);
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// TODO Auto-generated method stub
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
