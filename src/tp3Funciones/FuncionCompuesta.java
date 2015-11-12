package tp3Funciones;

import java.util.Stack;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import operaciones.Constante;
import operaciones.Division;
import operaciones.Logaritmo;
import operaciones.Multiplicacion;
import operaciones.Funcion;
import operaciones.Potenciacion;
import operaciones.Resta;
import operaciones.Suma;
import variables.VariableX;
import variables.VariableY;
import variables.VariableZ;

public class FuncionCompuesta implements Funcion{
	private Funcion funcion;
	private double[] resultados;
	private int cantPuntos;
	private String[] cadena;
	
	public FuncionCompuesta(File archivo){
		FileReader fr=null;
		BufferedReader br=null;
		try{
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			cadena = linea.split(" ");
			this.funcion=crearFuncion();
			linea = br.readLine();
			String[] aux = linea.split(" ");
			int dimPunto = Integer.parseInt(aux[0]);
			cantPuntos = Integer.parseInt(aux[1]);
			resultados = new double[cantPuntos];
			//Resolver para cada punto
			for(int i=0;i<cantPuntos;i++){
				linea = br.readLine();
				aux = linea.split(" ");
				switch(dimPunto){
					case 1:
						VariableX.getReferenciaVariable().setValor(Integer.parseInt(linea));
						break;
					case 2:
						VariableX.getReferenciaVariable().setValor(Integer.parseInt(aux[0]));
						VariableY.getReferenciaVariable().setValor(Integer.parseInt(aux[1]));
						break;
					case 3:
						VariableX.getReferenciaVariable().setValor(Integer.parseInt(aux[0]));
						VariableY.getReferenciaVariable().setValor(Integer.parseInt(aux[1]));
						VariableZ.getReferenciaVariable().setValor(Integer.parseInt(aux[2]));
						break;
						
				}
				resultados[i] = funcion.resolver();
			}
			br.close();
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
	      {
	         try{                    
	            if( null != br ){   
	               br.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	public void guardarResultados(File archivo){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println(this.cantPuntos);
            for (int i = 0; i < this.cantPuntos; i++)
                pw.println(this.resultados[i]);

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
           try 
           {
	           if (null != fichero)
	              fichero.close();
           } 
           catch (Exception e2) 
           {
              e2.printStackTrace();
           }
        }
	}
	
	public double resolver(){
		if(funcion==null)
			return -1.11;
		return funcion.resolver();
	}
	
	
	private Funcion crearFuncion(){
		Stack<Funcion> pila= new Stack<Funcion>();
		Funcion f=null;
		Funcion izq=null;
		Funcion der=null;
		 int i=0;
		 while(i<cadena.length){
		 	while(!cadena[i].equals("+")&&!cadena[i].equals("-")&&!cadena[i].equals("*")&&!cadena[i].equals("/")&&!cadena[i].equals("^")&&!cadena[i].equals("ln")){
		 		
		 		if(cadena[i].equals("x")){
		 			pila.push(VariableX.getReferenciaVariable());
		 		}
		 		else if(cadena[i].equals("y")){
		 			pila.push(VariableY.getReferenciaVariable());
		 		}
		 		else if(cadena[i].equals("z")){
		 			pila.push(VariableZ.getReferenciaVariable());
		 		}
		 		else{
		 			pila.push(new Constante(Double.parseDouble(cadena[i])));
		 		}
		 		i++;
		 	}
		 	
			if(cadena[i].equals("+")){
				der=pila.pop();
				izq=pila.pop();
				f=new Suma(izq, der);
			}
			
			if(cadena[i].equals("-")){
				der=pila.pop();
				izq=pila.pop();
				f=new Resta(izq, der);
			}
			
			if(cadena[i].equals("*")){
				der=pila.pop();
				izq=pila.pop();
				f=new Multiplicacion(izq, der);
			}
			
			if(cadena[i].equals("/")){
				der=pila.pop();
				izq=pila.pop();
				f=new Division(izq, der);
			}
			
			if(cadena[i].equals("^")){
				der=pila.pop();
				izq=pila.pop();
				f=new Potenciacion(izq, der);
			}
			if(cadena[i].equals("ln")){
				f=new Logaritmo(pila.pop());
			}
			pila.push(f);
			i++;
		 }
		 return f;
	}
}
