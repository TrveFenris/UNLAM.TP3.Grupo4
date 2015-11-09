package operaciones;

public class Potenciacion implements Funcion{
	private Funcion operacion1;
	private Funcion operacion2;
	
	public Potenciacion(Funcion a, Funcion b) {
		operacion1  = a;
		operacion2 = b;
	}
	
	public double resolver() {
		return ( Math.pow(operacion1.resolver(), operacion2.resolver()) );
	}
}
