package operaciones;


public class Constante implements Funcion {
	private double valor;
	
	public Constante(double val) {
		valor = val;
	}
	
	public double resolver() {
		return valor;
	}
}
