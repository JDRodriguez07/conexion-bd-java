package conexion_app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	private static final String URL = "jdbc:mysql://localhost:3306/guarderiaMascotas";
	private static final String USER = "root";
	private static final String PASSWORD = "Congolo123";

	public static void main(String[] args) {

		try {
			Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement statement = connection.createStatement();

			// Crear			
			String insertSQL = "INSERT INTO propietario (id_propietario, nombre, apellido, correo, telefono) VALUES ('7080', 'bunny', 'bugs', 'conejobicho@gmail.com', '3245689090')";
			//statement.executeUpdate(insertSQL);
			
			String insertMascotaSQL = "INSERT INTO mascota(nombre, edad_meses, raza, genero, id_propietario) VALUES ('Caceres', '48', 'Criollo', 'macho', '1234')";
			statement.execute(insertMascotaSQL);
			
			// Leer
			String selectSQL = "SELECT * FROM propietario";
			ResultSet resultSet = statement.executeQuery(selectSQL);
			while (resultSet.next()) {
				int id = resultSet.getInt("id_propietario");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String correo = resultSet.getString("correo");
				String telefono = resultSet.getString("telefono");
				System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Email: " + correo + ", Telefono: " + telefono);
			}


			// Actualizar
			String updateSQL = "UPDATE propietario SET correo = 'pepito.perez@gmail.com' WHERE nombre = 'Pepito'";
			//statement.executeUpdate(updateSQL);					

			// Eliminar
			String deleteSQL = "DELETE FROM propietario WHERE nombre = 'Pepito'";
			//statement.executeUpdate(deleteSQL);
			 

			//resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
