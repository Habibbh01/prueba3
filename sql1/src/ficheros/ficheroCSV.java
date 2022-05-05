package ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ficheroCSV {
	private final static String SEPARADOR = ",";
	private final static String COMILLAS = " \" ";

	public static void main(String[] args) {
		BufferedReader lectorCSV = null;
		try {
			lectorCSV = new BufferedReader(new FileReader("./datos.csv"));
			String linea = lectorCSV.readLine();
			while (null != linea) {
				String[] campos = linea.split(SEPARADOR);
				//campos = eliminarComillasEnExtremos(campos);
				for(String campo:campos) {
					System.out.println(campo);
				}
				System.out.println("\n");
				
				linea = lectorCSV.readLine();
			}
		} catch (Exception e) {
			System.out.println("Error al leer: ");
			e.printStackTrace();
		} finally {
			try {
				lectorCSV.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static String[] eliminarComillasEnExtremos(String[] campos) {
		String result[] = new String[campos.length];
		// ^" es una expresion regular que indica que la cadena empieza por "
		// "$ es una expresion regular que indica que la cadena termina por "
		for (int i = 0; i < result.length; i++) {
			result[i] = campos[i].replaceAll("^" + COMILLAS,

					"").replaceAll(COMILLAS + "$", "");

		}
		return result;
	}
}
