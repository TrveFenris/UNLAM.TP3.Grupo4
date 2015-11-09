package operaciones;

public class Logaritmo implements Funcion {
	private Funcion operacion1;
	
	public Logaritmo(Funcion a) {
		operacion1  = a;
	}
	
	public double resolver() throws ArithmeticException {
		if(operacion1.resolver() <= 0)
			throw new ArithmeticException("ERROR: No existe el logaritmo de un numero menor o igual a cero");
		return (Math.log(operacion1.resolver()));
	}
}
