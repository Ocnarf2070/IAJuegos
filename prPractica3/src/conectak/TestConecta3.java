package conectak;
import espaciojuego.Juego;
import jugadores.Jugador;
import jugadores.JugadorAleatorio;
import jugadores.JugadorAlfaBeta;
import jugadores.JugadorEvaluar;
public class TestConecta3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConectaK e = new ConectaK(3,3,3);
		String men = "\t\t\t\tGana 1\tEmpate\tGana 2";
		System.out.println(men);
		for(int i=0;i<60;i++)System.out.print("-");
		System.out.print("\nAleatorio vs Aleatorio\t\t");
		aleatorioVsAleatorio(1000, e);
		System.out.print("Aleatorio vs Evaluar\t\t");
		aleatorioVsEvaluar(1000, e);
		System.out.print("Aleatorio vs AlfaBeta (p=2)\t");
		aleatorioVsAlfaBeta(1000, e,2);
		System.out.print("Aleatorio vs AlfaBeta (p=3)\t");
		aleatorioVsAlfaBeta(1000, e,3);
		System.out.print("Aleatorio vs AlfaBeta (p=4)\t");
		aleatorioVsAlfaBeta(1000, e,4);
		System.out.print("Aleatorio vs AlfaBeta (p=5)\t");
		aleatorioVsAlfaBeta(1000, e,5);
		System.out.print("Aleatorio vs AlfaBeta (p=6)\t");
		aleatorioVsAlfaBeta(1000, e,6);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void aleatorioVsAleatorio(int N,ConectaK e){
        Jugador j1 = new JugadorAleatorio<ConectaK>();
        Jugador j2 = new JugadorAleatorio<ConectaK>();
        Juego juego1 = new Juego(j1, j2, e);
        juego1.jugarNPartidas(false, N);
    }
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void aleatorioVsEvaluar(int N,ConectaK e){
        Jugador j1 = new JugadorAleatorio<ConectaK>();
        Jugador j2 = new JugadorEvaluar(new EvaluadorCK(3,3,3));
        Juego juego1 = new Juego(j1, j2, e);
        juego1.jugarNPartidas(false, N);
    }
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void aleatorioVsAlfaBeta(int N,ConectaK e,int p){
        Jugador j1 = new JugadorAleatorio<ConectaK>();
        Jugador j2 = new JugadorAlfaBeta<>(new EvaluadorCK(3,3,3), p);
        Juego juego1 = new Juego(j1, j2, e);
        juego1.jugarNPartidas(false, N);
        //System.out.println(j2.nodosVisitados());
    }
}
