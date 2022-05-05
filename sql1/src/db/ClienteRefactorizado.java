package db;

import java.sql.Connection;
import java.sql.ResultSet;

public class ClienteRefactorizado {

	public static void main(String[] args) {
		//podriamos acceder a los metodos de manera static 
		//en ese caso seria una relacion de uso en UML
		//Elegimos crear un objeto en este caso porque esa
		//clase mantendrá la info de conexion en un atributo
		//private Connection conexion;
		//En este caso es composición en UML porque esta clase
		//cliente contiene una instacia de DBConnectionRefactorizado
		
		DBConnectionRefactorizado dbc = 
				new DBConnectionRefactorizado();
		dbc.conectarBD();

		String update = "INSERT INTO pizzas values(65,'6 quesos')";
		String consulta = "SELECT * from pizzas";

		dbc.ejecutar(update);

		ResultSet resultado = dbc.consultar(consulta);

		dbc.imprimirResultado(resultado);

	}

}