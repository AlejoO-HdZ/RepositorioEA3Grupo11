import java.sql.Connection; /* Libreria de java, JDBC Permite establecer una conexión con una base de datos usando .*/
import java.sql.PreparedStatement; /* Libreria de java, Permite ejecutar consultas SQL seguras en la base de datos.*/
import java.sql.SQLException; /* Libreria de java, Permite manejar errores de SQL en Java.*/

/** Clase para gestionar la inserción de profesores en la base de datos MySQL. */
public class DataProfesorMysql {
    public static void insertarProfesor(Profesor profesor) {
        String sql = "INSERT INTO profesores (nombre, apellido, fecha_nacimiento, genero, estatura, peso, especialidad, nivel_academico) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = DatabaseConnection.getConnection();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, profesor.getNombre());
            stmt.setString(2, profesor.getApellido());
            stmt.setString(3, profesor.getFechaNacimiento());
            stmt.setString(4, profesor.getGenero());
            stmt.setDouble(5, profesor.getEstatura());
            stmt.setDouble(6, profesor.getPeso());
            stmt.setString(7, profesor.getEspecialidad());
            stmt.setString(8, profesor.getNivelAcademico());
            stmt.executeUpdate();
            System.out.println("✔ Profesor: " + profesor.getNombre() + " " + profesor.getApellido() + " insertado correctamente en Base de datos MySqL.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar profesor: " + e.getMessage());
        }
    }
}
