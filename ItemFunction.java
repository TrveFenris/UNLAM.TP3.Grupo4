package tp3funciones;

import java.util.Stack;

import tp3funciones.numericos.Numero;
import tp3funciones.numericos.Variable;
import tp3funciones.operacionesbinarias.OperacionDivision;
import tp3funciones.operacionesbinarias.OperacionMultiplicacion;
import tp3funciones.operacionesbinarias.OperacionPotenciacion;
import tp3funciones.operacionesbinarias.OperacionResta;
import tp3funciones.operacionesbinarias.OperacionSuma;
import tp3funciones.operacionesunarias.OperacionLogaritmo;

/** Representa un item de una funcion. Ya sea una variable, un numero o una operacion binaria/unaria (Composite)*/
public abstract class ItemFuncion {

//CONSTRUCTORES------------------------------------------------------------------------------------------------------------------------------------
	/** Representa un item de una funcion. Ya sea una variable, un numero o una operacion binaria/unaria */
	public ItemFuncion(){}
	
//FUNCIONES----------------------------------------------------------------------------------------------------------------------------------------	
	/** Funcion, que dependiendo que tipo de Item sea, opera con respecto a la pila 
	 *  Ejemplo: -Si el item es un numero o una variable: se apila
	 *  		 -Si es una operacion binaria: Desapila 2 numeros, aplica la operación (Sumar, multiplicar, u otra) y apila el resultado de la operacion
	 *  		 -Si es una operacion unaria: Desapila 1 numero, aplica la operacion (Logaritmo) y apila el resultado 
	 *  @param pila Pila utilizada para tratar la funcion RPN*/
	protected abstract void operar(Stack<ItemFuncion> pila);
	
	/** Funcion que convierte un item en un item de funcion
	 * @param item Item a convertir
	 * @return Item de funcion*/
	public static ItemFuncion parse(String item){
		if(isNumeric(item))
			return new Numero(Integer.parseInt(item));
		else if(item.equals("x") || item.equals("y") || item.equals("z")){
			return Variable.nuevaVariable(item);
		}
		else if(item.equals("+")){
			return new OperacionSuma();
		}
		else if(item.equals("-")){
			return new OperacionResta();
		}
		else if(item.equals("*")){
			return new OperacionMultiplicacion();
		}
		else if(item.equals("/")){
			return new OperacionDivision();
		}
		else if(item.equals("^")){
			return new OperacionPotenciacion();
		}
		else if(item.equals("ln")){
			return new OperacionLogaritmo();
		}
		
		return null;
	}
	
	/** Verifica si un string es un numero
	 * @param str String a verificar
	 * @return true en caso de ser un numero, false en caso de no serlo */
	public static boolean isNumeric(String str){	return str.matches("^(?:(?:\\-{1})?\\d+(?:\\.{1}\\d+)?)$");	}
}
