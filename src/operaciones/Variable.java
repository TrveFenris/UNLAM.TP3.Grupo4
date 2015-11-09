package operaciones;


public class Variable implements Operacion {
	private double valor;
	private static Variable refVariable;
	
	private Variable() {
		
	}
	
	public Variable getReferenciaVariable() {
		if(refVariable == null) {
			refVariable = new Variable();
		}
		return refVariable;
	}
	
	public double resolver() {
		return valor;
	}
	
	public void setValor(double val) {
		valor = val;
	}
}
