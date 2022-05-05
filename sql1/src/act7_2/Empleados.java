package act7_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Empleados {


	private Connection conexion;
	protected int dni;
	protected String nombre;
	protected String apellidos; 
	protected int sueldo;

	public void conectarBD() {
		String host = "localhost";
		int puerto = 3306;
		String db = "empleados";
		String url = "jdbc:mysql://" + host + ":" + puerto + "/" + db;
		String login = "root";
		String password = "";

		try {
			// Conectamos con la base de datos
			conexion = DriverManager.getConnection(url, login, password);
			System.out.println((conexion != null) ? "CONEXION OK" : "CONEXION FALLIDA");
			
		} catch (java.sql.SQLException sqle) {
			System.out.println("Error: " + sqle);
		}
	}
	
	
	public ResultSet consultarEmpleados(String consulta) {
		ResultSet resultado;
		try {
			PreparedStatement sentencia = conexion.prepareStatement(consulta);
			resultado = sentencia.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return resultado;
	}
	
	public boolean insertarEmp(Empleados empleados) {
		
		
		return true;
		
	}
	public boolean actualizar(String cambio) {
		try {
			PreparedStatement sentencia = conexion.prepareStatement(cambio);
			int totalRows = sentencia.executeUpdate(); // devuelve el número de tuplas modificadas
			System.out.println("Se han modificado: " + totalRows + " tuplas");
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean borrar(String dni) {
		try {
			PreparedStatement sentencia = conexion.prepareStatement(dni);
			int totalRows = sentencia.executeUpdate(); // devuelve el número de tuplas modificadas
			System.out.println("Se han borrado: " + totalRows + " tuplas");
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public void imprimirResultadoEmp(ResultSet resultado) {
		try {
			System.out.println("\nID\tDNI\tNOMBRE\tAPELLIDOS\tSALARIO");
			System.out.println("--------------------------------");
			while (resultado.next()) {
				System.out.println(
						resultado.getInt("id") + "\t" +
								resultado.getInt("dni") + "\t" + resultado.getString("nombre")
								+ "\t" + resultado.getString("apellidos") + "\t" +
									resultado.getInt("sueldo") + "\t"
									);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
