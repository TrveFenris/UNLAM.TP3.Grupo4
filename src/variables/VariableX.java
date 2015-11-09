package variables;

import operaciones.Funcion;

public class VariableX implements Funcion{

	private double valor;
	private static VariableX refVariable;
	
	private VariableX() {
		super();
	}
	
	public static VariableX getReferenciaVariable()
	{
		if(refVariable == null) {
			refVariable = new VariableX();
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
