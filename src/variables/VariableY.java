package variables;

import operaciones.Funcion;

public class VariableY implements Funcion{

	private double valor;
	private static VariableY refVariable;
	
	private VariableY() {
		super();
	}
	
	public static VariableY getReferenciaVariable()
	{
		if(refVariable == null) {
			refVariable = new VariableY();
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
