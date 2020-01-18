package minigammon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import espaciojuego.EstadoJuego;

public class MiniGammon extends EstadoJuego<MiniGammon>{

	private int [] fichasJ1,fichasJ2,golpeadas,liberadas;
	private static int fichaGanar;
	private static int carasDado;
	private static Random dado = new Random();
	private int tiradaDado;
	public MiniGammon(int fichasParaGanar, int carasDado) {
		fichaGanar=fichasParaGanar;
		MiniGammon.carasDado=carasDado;
		int num=-1;
		while(num<1)num=dado.nextInt(carasDado+1);
		tiradaDado = num;
		// TODO Auto-generated constructor stub
	}

	public MiniGammon(int[] fichasJ1, int[] fichasJ2, int[] golpeadas, int[] liberadas, boolean turno1,
			int tiradaDado) {
		this.fichasJ1=fichasJ1;
		this.fichasJ2=fichasJ2;
		this.golpeadas=golpeadas;
		this.liberadas=liberadas;
		this.turno1=turno1;
		this.tiradaDado=tiradaDado;
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<MiniGammon> hijos() {
		List <MiniGammon> list = new ArrayList<>();
		int sigNum = -1;
		while(sigNum<1)sigNum=dado.nextInt(carasDado+1);
		if(turno1) 
			if(golpeadas[0]==0)
				for(int i=0;i<fichasJ1.length;i++) {
					int sigCas=i+tiradaDado;
					if(sigCas<fichasJ1.length) {
						if(fichasJ1[i]!=0&&fichasJ2[sigCas]<2) {
							int [] J1 = fichasJ1.clone();
							int [] J2 = fichasJ2.clone();
							int [] golp = golpeadas.clone();
							if(J2[sigCas]==1) {
								golp[1]++;
								J2[sigCas]--;
							}
							J1[i]--;
							J1[sigCas]++;
							list.add(new MiniGammon(J1, J2, golp, liberadas, !turno1, sigNum));
						}
					}else if(sigCas>=fichasJ1.length&&fichasJ1[i]!=0){
						int [] J1 = fichasJ1.clone();
						int [] lib = liberadas.clone();
						J1[i]--;
						lib[0]++;
						list.add(new MiniGammon(J1, fichasJ2, golpeadas, lib, !turno1, sigNum));
					}
				}
			else {
				if(fichasJ2[tiradaDado-1]==0) {
					int [] J1 = fichasJ1.clone();
					int [] golp = golpeadas.clone();
					J1[tiradaDado-1]++;
					golp[0]--;
					list.add(new MiniGammon(J1, fichasJ2, golp, liberadas, !turno1, sigNum));
				}else if(fichasJ2[tiradaDado-1]==1) {
					int [] J1 = fichasJ1.clone();
					int [] J2 = fichasJ2.clone();
					int [] golp = golpeadas.clone();
					J1[tiradaDado-1]++;
					J2[tiradaDado-1]--;
					golp[0]--;
					golp[1]++;
					list.add(new MiniGammon(J1, J2, golp, liberadas, !turno1, sigNum));
				}
			}
		else {
			if(golpeadas[1]==0)
				for(int i=fichasJ2.length-1;i>=0;i--) {
					int sigCas=i-tiradaDado;
					if(sigCas>=0) {
						if(fichasJ2[i]!=0&&fichasJ1[sigCas]<2) {
							int [] J1 = fichasJ1.clone();
							int [] J2 = fichasJ2.clone();
							int [] golp = golpeadas.clone();
							if(J1[sigCas]==1) {
								golp[0]++;
								J1[sigCas]--;
							}
							J2[i]--;
							J2[sigCas]++;
							list.add(new MiniGammon(J1, J2, golp, liberadas, !turno1, sigNum));
						}
					}else if(sigCas<=-1&&fichasJ2[i]!=0){
						int [] J2 = fichasJ2.clone();
						int [] lib = liberadas.clone();
						J2[i]--;
						lib[1]++;
						list.add(new MiniGammon(fichasJ1, J2, golpeadas, lib, !turno1, sigNum));
					}
				}
			else {
				if(fichasJ1[fichasJ1.length-tiradaDado]==0) {
					int [] J2 = fichasJ2.clone();
					int [] golp = golpeadas.clone();
					J2[fichasJ1.length-tiradaDado]++;
					golp[1]--;
					list.add(new MiniGammon(fichasJ1, J2, golp, liberadas, !turno1, sigNum));
				}else if(fichasJ1[fichasJ1.length-tiradaDado]==1) {
					int [] J1 = fichasJ1.clone(); 
					int [] J2 = fichasJ2.clone();
					int [] golp = golpeadas.clone();
					J2[fichasJ1.length-tiradaDado]++;
					J1[fichasJ1.length-tiradaDado]--;
					golp[1]--;
					golp[0]++;
					list.add(new MiniGammon(J1, J2, golp, liberadas, !turno1, sigNum));
				}
			}
		}
		if(list.isEmpty()) {
			MiniGammon aux = new MiniGammon(fichasJ1, fichasJ2, golpeadas, liberadas, !turno1, sigNum);
			list.add(aux);
		}
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public boolean ganaActual() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ganaOtro() {
		// TODO Auto-generated method stub
		return !turno1?liberadas[0]==fichaGanar:liberadas[1]==fichaGanar;
	}

	@Override
	public boolean agotado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ver() {
		System.out.println("----------* (J1 baja) o (J2 sube) ---- Turno1? "+(turno1?"true":"false")+", Tirada dado: "+tiradaDado+" ---");
		for(int i=0;i<fichasJ1.length;i++) {
			System.out.print(i+"| ");
			if(fichasJ1[i]!=0) {
				for(int j=0;j<fichasJ1[i];j++)System.out.print("*");
			}
			if(fichasJ2[i]!=0) {
				for(int j=0;j<fichasJ2[i];j++)System.out.print("o");
			}
			System.out.println();
		}
		System.out.print("Golpeadas (J1, J2) : "+golpeadas[0]+","+golpeadas[1]+" || ");
		System.out.println("Liberadas (J1, J2) : "+liberadas[0]+","+liberadas[1]);

		// TODO Auto-generated method stub
		
	}

	public int[] fichasJ1() {
		// TODO Auto-generated method stub
		return fichasJ1;
	}

	public int[] fichasJ2() {
		// TODO Auto-generated method stub
		return fichasJ2;
	}

	public int[] golpeadas() {
		// TODO Auto-generated method stub
		return golpeadas;
	}

	public int[] liberadas() {
		// TODO Auto-generated method stub
		return liberadas;
	}

	public int tiradaDado() {
		// TODO Auto-generated method stub
		return tiradaDado;
	}

	@Override
	public String toString() {
		String string="----------* (J1 baja) o (J2 sube) ---- Turno1? "+(turno1?"true":"false")+", Tirada dado: "+tiradaDado+" ---\n";
		for(int i=0;i<fichasJ1.length;i++) {
			string += i+"| ";
			if(fichasJ1[i]!=0) {
				for(int j=0;j<fichasJ1[i];j++)string+="*";
			}
			if(fichasJ2[i]!=0) {
				for(int j=0;j<fichasJ2[i];j++)string+="o";
			}
			string+="\n";
		}
		string+="Golpeadas (J1, J2) : "+golpeadas[0]+","+golpeadas[1]+" || ";
		string+="Liberadas (J1, J2) : "+liberadas[0]+","+liberadas[1]+"\n";
		// TODO Auto-generated method stub
		return string;
	}
	

}
