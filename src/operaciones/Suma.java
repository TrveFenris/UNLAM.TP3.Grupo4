package operaciones;

public class Suma implements Operacion {
	private Operacion operacion1;
	private Operacion operacion2;
	
	public Suma(Operacion a, Operacion b) {
		operacion1  = a;
		operacion2 = b;
	}
	
	public double resolver() {
		return (operacion1.resolver() + operacion2.resolver());
	}
}
