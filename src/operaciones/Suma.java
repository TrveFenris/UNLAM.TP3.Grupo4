package operaciones;

public class Suma implements Funcion {
	private Funcion operacion1;
	private Funcion operacion2;
	
	public Suma(Funcion a, Funcion b) {
		operacion1  = a;
		operacion2 = b;
	}
	
	public double resolver() {
		return (operacion1.resolver() + operacion2.resolver());
	}
}
