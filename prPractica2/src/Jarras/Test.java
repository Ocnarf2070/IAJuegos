package Jarras;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jarra e = new Jarra(5, 0);
		PJarra pj = new PJarra(e);
		for(Jarra e2:pj.amplitud())e2.ver();
	}
}
