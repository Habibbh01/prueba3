package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	static String db = "pizzas";
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost:3306/" + db + "?useSSL=false";
	Connection conn = null;

	public static void main(String[] args) {
		//llamo al constructor
		DBConnection dbc = new DBConnection();
	}
	
	public DBConnection() {
		/*
		 * Base de datos local/remota A continuación se muestra un ejemplo de uso, para
		 * una base de datos llamada pizzas. El SGBD se encuentra en la máquina local
		 * (localhost) y las credenciales de usuario son pizzauser/Perro20.
		 */
		try {
			conn = DriverManager.getConnection(url, login, password);
			if (conn != null) {
				//inserción
				int totalRows= conn.prepareStatement("INSERT INTO pizzas values(55,'5 quesos')").executeUpdate();
				System.out.println(totalRows+" filas modificadas");
				
				//consulta
				System.out.println("Conexión ok: " + conn);
				ResultSet rs = conn.prepareStatement("SELECT * FROM pizzas").executeQuery();
				
				System.out.println("\nID\tNOMBRE");
				while (rs.next()) {
					System.out.print(rs.getString("nombre")+"\t");
					System.out.print(rs.getInt("id"));
					System.out.println();
				}
				
			}
		} catch (SQLException e) {
			System.out.println("Se ha producido un error en la conexión:");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}