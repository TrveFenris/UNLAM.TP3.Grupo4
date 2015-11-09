package operaciones;

public class Multiplicacion implements Funcion {
	private Funcion operacion1;
	private Funcion operacion2;
	
	public Multiplicacion(Funcion a, Funcion b) {
		operacion1  = a;
		operacion2 = b;
	}
	
	public double resolver() {
		return (operacion1.resolver() * operacion2.resolver());
	}
}
