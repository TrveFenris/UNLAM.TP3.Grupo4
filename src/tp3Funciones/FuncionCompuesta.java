package tp3Funciones;

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
	private String[] datos;
	private Funcion funcion;
	private double[] resultados;
	private int cantPuntos;
	
	public FuncionCompuesta(File archivo){
		FileReader fr=null;
		BufferedReader br=null;
		try{
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			System.out.println(linea);
			datos = linea.split(" ");
			crearFuncion(datos.length-1);
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
						//System.out.println(VariableX.getReferenciaVariable().resolver());
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
				System.out.println(resultados[i]);
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
		return funcion.resolver();
	}
	
	private Funcion crearFuncion(int indice){
		System.out.println(datos[indice]);
		if(indice==0){
			if(datos[indice].equals("x")){
				return VariableX.getReferenciaVariable();
			}
			if(datos[indice].equals("y")){
				return VariableY.getReferenciaVariable();
			}
			if(datos[indice].equals("z")){
				return VariableZ.getReferenciaVariable();
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
		
		if(datos[indice].equals("x")){
			return VariableX.getReferenciaVariable();
		}
		
		if(datos[indice].equals("y")){
			return VariableY.getReferenciaVariable();
		}
		
		if(datos[indice].equals("z")){
			return VariableZ.getReferenciaVariable();
		}
		else
			return new Constante(Double.parseDouble(datos[indice]));
	}
}
