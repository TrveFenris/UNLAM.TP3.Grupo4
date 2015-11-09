package variables;

import operaciones.Funcion;

public class VariableZ implements Funcion{

	private double valor;
	private static VariableZ refVariable;
	
	private VariableZ() {
		super();
	}
	
	public static VariableZ getReferenciaVariable()
	{
		if(refVariable == null) {
			refVariable = new VariableZ();
		}
		return refVariable;
	}
	
	public double resolver(){
		return valor;
	}
	
	public void setValor(double valor){
		this.valor=valor;
	}
}
