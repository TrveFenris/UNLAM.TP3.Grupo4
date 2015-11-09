package tp3Funciones;


import java.io.File;

public class Main {

	public static void main(String[] args) {
		int cantArchivos;
		File folder = new File("Entradas");
		File[] listOfFiles = folder.listFiles();
		cantArchivos=listOfFiles.length;
		for (int i = 0; i < cantArchivos; i++) {
			if (listOfFiles[i].isFile()) {
		        String path = new String(listOfFiles[i].getName());
		        String [] datos;
				datos = path.split("\\.");
				File archivo=new File("Entradas/"+datos[0]+".in");
				FuncionCompuesta funcion = new FuncionCompuesta(archivo);
				funcion.guardarResultados(new File("Salidas/"+datos[0]+".out"));
		    }
		}
		System.out.println("FIN");
	}

}
