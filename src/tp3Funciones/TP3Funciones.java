package tp3Funciones;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

/** Programacion avanzada, TP3 Funciones **/

public class TP3Funciones {

//ATRIBUTOS----------------------------------------------------------------------------------------------------------------------------------------
	private File entrada;
	private File salida;	
//CONSTRUCTORES------------------------------------------------------------------------------------------------------------------------------------
	/** Programacion avanzada, TP3 Funciones 
	 * @param entrada Archivo de entrada
	 * @param salida Archivo de salida*/
	public TP3Funciones(File entrada, File salida) {	
		this.entrada=entrada;
		this.salida=salida;
	}

//METODOS------------------------------------------------------------------------------------------------------------------------------------------
//	/** Resuelve el TP3 */
	public void resolver() {
//		FileReader fr = null;
//		BufferedReader br = null;
//        FileWriter fichero = null;
//        PrintWriter pw = null;
//	    try{
//	    	//Preparar lectura de archivo
//			fr = new FileReader (this.entrada);
//			br = new BufferedReader(fr);
//			//Preparar escritura de archivo
//			fichero = new FileWriter(this.salida);
//			pw = new PrintWriter(fichero);
//			
//		    //Definir Funcion
//			ItemFuncion[] funcion = cargarFuncion(br.readLine());
//		    //Cargar cantidad de variables y puntos
//		    String[] aux = br.readLine().split(" ");
//		    int cantVar = Integer.parseInt(aux[0]);
//		    int cantPuntos = Integer.parseInt(aux[1]);
//		    pw.println(cantPuntos);							//Escribir en archivo de salida cantidad de puntos a tratar
//		    
//		    aux = null;
//		    //Cargar y tratar puntos
//		    for(int i=0;i<cantPuntos;++i){
//		    	Stack<ItemFuncion> pila = new Stack<>();					//Pila utilizada para realizar las operaciones
//		    	
//		    	//Cargar variables
//		    	Variable.definirValorVariables(br.readLine(), cantVar); 	//Redefinir el valor de las variables con los puntos leidos (Singleton)
//		    	
//		    	//Resolver la funcion (Recorrer toda la funcion)
//		    	for(int j=0; j<funcion.length; ++j){
//		    		funcion[j].operar(pila);			//Opera dependiendo del tipo de item en la pila
//		    	}
//		    	
//		    	//Escribir resultado
//		    	double resultado = ((Numero)pila.pop()).getValor();			//El ultimo valor en la pila, siempre sera el resultado de la funcion
//		    	pw.println(doubleToString(resultado));						//Escribir resultado en el archivo.
//		    }
//		    
//	    }
//	    catch(Exception e){
//	         e.printStackTrace();
//	    }finally{
//	    	//Lectura
//	    	try{                    
//    			if( null != fr )   
//    				fr.close();           
//			}
//	    	catch (Exception e2){ 
//	    		e2.printStackTrace();
//	    	}
//    		//Escritura
//	    	try{
//				if (null != fichero)
//					fichero.close();
//            }
//	    	catch (Exception e2) {
//            	e2.printStackTrace();
//            }
//	    	
//	    }
	}
//	
////FUNCIONES----------------------------------------------------------------------------------------------------------------------------------------
//	/** Retorna la funcion enviada como una lista de Items
//	 * @param funcion Funcion expresada en RPN
//	 * @return Lista de items. Respeta el orden enviado.*/
//	private ItemFuncion[] cargarFuncion(String funcion) throws IOException{
//		String[] items= funcion.split(" ");				//Separar la funcion RPN en items
//		ItemFuncion[] v= new ItemFuncion[items.length];	//Crear vector con items de la funcion
//		//Cargar vector con los items de la funcion
//		for(int i=0; i<items.length; ++i){
//			v[i] = ItemFuncion.parse(items[i]);			//Convertir y almacenar el item de la funcion
//		}
//		//Retorno
//		return v;											//Retorno
//	}
//	/** Funcion que representa un double. Evita representar el double con decimales redundantes
//	 *  Ejemplo: 10.0 -> 10
//	 *  @param d Numero a representar como string
//	 *  @return Representacion del double*/
//	public static String doubleToString(double d){
//	    if(d == (long) d)
//	        return String.format("%d",(long)d);
//	    else
//	        return String.format("%s",d);
//	}
//	
}
