import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet; /* INTERFAZ DE JDBC: Se usa para almacenar y recorrer los resultados de una consulta SQL.*/
import java.sql.Statement; /* INTERFAZ DE JDBC: Se usa para ejecutar consultas SQL en la base de datos.*/

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/DataEvidencia3"; //Se establece nombre de base datos "DtaEvidencia3 ewn MySQL"
    private static final String USER = "root1"; //Se establece el usuario de base datos "DtaEvidencia3 de MySQL"
    private static final String PASSWORD = "EA123";
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el driver (opcional desde Java 6)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver de MySQL", e);
        }
    }
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("¡Conexión exitosa a la base de datos de MYSQL!");
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
    /* PLUS DE LA ACTIVIDAD - LISTA VISUALMENTE los datos almacenados en la tabla profesores con mejor presentación. */
    public static void verificarDatos() {
        String sql = "SELECT * FROM profesores";

        try (Connection conexion = getConnection();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n===== LISTA DE PROFESORES ALMACENADOS =====");
            System.out.printf("%-5s %-15s %-15s %-20s %-15s\n", "ID", "Nombre", "Apellido", "Especialidad", "Nivel Académico");
            System.out.println("-------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-15s %-15s %-20s %-15s\n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("especialidad"),
                        rs.getString("nivel_academico"));
            }
            System.out.println("=============================================================\n");
        } catch (SQLException e) {
            System.err.println("Error al verificar los datos: " + e.getMessage());
        }
    }
}