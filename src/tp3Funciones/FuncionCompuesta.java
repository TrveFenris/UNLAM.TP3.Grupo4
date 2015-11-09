package tp3Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
	private String[] datos;
	private Funcion funcion;
	
	public FuncionCompuesta(File archivo){
		FileReader fr=null;
		BufferedReader br=null;
		try{
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			datos = linea.split(" ");
			crearFuncion(datos.length-1);
			linea = br.readLine();
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
	
	public double resolver(){
		return funcion.resolver();
	}
	
	private Funcion crearFuncion(int indice){
		if(indice==0){
			if(datos[indice].equals("x")){
				VariableX x = VariableX.getReferenciaVariable();
			}
			if(datos[indice].equals("y")){
				VariableY y = VariableY.getReferenciaVariable();
			}
			if(datos[indice].equals("z")){
				VariableZ z = VariableZ.getReferenciaVariable();
			}
			else
				return new Constante(Double.parseDouble(datos[indice]));
		}
		
		if(datos[indice].equals("+")){
			return funcion=new Suma(crearFuncion(indice-1),crearFuncion(indice-2));
		}
		
		if(datos[indice].equals("-")){
			return funcion=new Resta(crearFuncion(indice-1),crearFuncion(indice-2));
		}
		
		if(datos[indice].equals("*")){
			return funcion=new Multiplicacion(crearFuncion(indice-1),crearFuncion(indice-2));
		}
		
		if(datos[indice].equals("/")){
			return funcion=new Division(crearFuncion(indice-1),crearFuncion(indice-2));
		}
		
		if(datos[indice].equals("^")){
			return funcion=new Potenciacion(crearFuncion(indice-1),crearFuncion(indice-2));
		}
		
		if(datos[indice].equals("ln")){
			return funcion=new Logaritmo(crearFuncion(indice-1));
		}
		return new Constante(1);
	}
}
