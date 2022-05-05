package act7_2;

import java.sql.ResultSet;

public class PrincipalEmp {

	public static void main(String[] args) {
		Empleados emp = new Empleados();
		emp.conectarBD();

		String update = "INSERT INTO empleados values(32323,7454545,'antonio','perez',1000)";
		String delete = "INSERT INTO empleados values(32323,7454545,'antonio','perez',1000)";
		String consulta = "SELECT * from empleados";

		emp.actualizar(update);

		ResultSet resultado = emp.consultarEmpleados(consulta);

		emp.imprimirResultadoEmp(resultado);
	}

}
