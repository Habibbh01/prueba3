package ficheros;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LecturaEscrituraFicheros {

	public static void main(String[] args) {
		// en eclipse el directorio acctual es el de project
		// es decir el que contiene las carpetas src, bin, etc.
		lecturaFichero("fichero_leer.txt");
		escrituraFichero("fichero_escritura.txt");
	}
	
	
	

	
	public static void escrituraFichero(String rutaFichero) {
		String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };
		/** FORMA 1 DE ESCRITURA **/
		FileWriter fichero = null;
		try {
			fichero = new FileWriter(rutaFichero);
			// Escribimos linea a linea en el fichero
			for (String linea : lineas) {
				fichero.write(linea + "\n");
			}
			fichero.close();
		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	
	
	
	
	
	public static void lecturaFichero(String rutaFichero) {
		// Fichero del que queremos leer
		File fichero = new File(rutaFichero);
		Scanner s = null;
		try {
			// Leemos el contenido del fichero
			System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(fichero);
			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); // Guardamos la linea en un String
				System.out.println(linea); // Imprimimos la linea
			}
		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta ono
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
	}
	
	
	
	
	
	

}
