import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/DataEvidencia3"; //Se establece nombre de base datos "DtaEvidencia3 ewn MySQL"
    private static final String USER = "root1"; //Se establece el usuario de base datos "DtaEvidencia3 de MySQL"
    private static final String PASSWORD = "EA123"; //
    public static Connection getConnection() throws SQLException {
        try {
            // Registrar el driver (opcional desde Java 6)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de MySQL", e);
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

}