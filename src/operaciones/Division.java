package operaciones;

public class Division implements Funcion{
	private Funcion operacion1;
	private Funcion operacion2;
	
	public Division(Funcion a, Funcion b) {
		operacion1  = a;
		operacion2 = b;
	}
	
	public double resolver() throws ArithmeticException {
		if(operacion2.resolver() == 0)
			throw new ArithmeticException("ERROR: Division por cero no admitida");
		return (operacion1.resolver() / operacion2.resolver());
	}
}
