package operaciones;

public class Potenciacion {
	private Operacion operacion1;
	private Operacion operacion2;
	
	public Potenciacion(Operacion a, Operacion b) {
		operacion1  = a;
		operacion2 = b;
	}
	
	public double resolver() {
		return ( Math.pow(operacion1.resolver(), operacion2.resolver()) );
	}
}
