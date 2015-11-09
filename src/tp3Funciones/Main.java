package tp3Funciones;


import java.io.File;

public class Main {

	public static void main(String[] args) {
		int cantArchivos;
		File folder = new File("IN");
		File[] listOfFiles = folder.listFiles();
		cantArchivos=listOfFiles.length;
		for (int i = 0; i < cantArchivos; i++) {
			if (listOfFiles[i].isFile()) {
		        String path = new String(listOfFiles[i].getName());
		        String [] datos;
				datos = path.split("\\.");
				File archivo=new File("IN/"+datos[0]+".in");
				TP3Funciones tp3 = new TP3Funciones(archivo,
						new File("OUT/"+datos[0]+".out"));
				tp3.resolver();
		    }
		}
		System.out.println("FIN");
	}

}
