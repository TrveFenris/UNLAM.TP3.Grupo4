package operaciones;


public class Constante implements Operacion {
	private double valor;
	
	public Constante(double val) {
		valor = val;
	}
	
	public double resolver() {
		return valor;
	}
}
