package operaciones;

public class Logaritmo implements Operacion {
	private Operacion operacion1;
	
	public Logaritmo(Operacion a) {
		operacion1  = a;
	}
	
	public double resolver() throws ArithmeticException {
		if(operacion1.resolver() <= 0)
			throw new ArithmeticException("ERROR: No existe el logaritmo de un numero menor o igual a cero");
		return (Math.log(operacion1.resolver()));
	}
}
