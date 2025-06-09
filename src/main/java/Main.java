import java.util.Random; /* Libreria de java, genera números aleatorios en Java.*/
import java.util.Scanner; /* Libreria de java, Permite leer datos desde la consola.*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* PLUS DE LA ACTIVIDAD - Mostrar los registros almacenados antes de insertar nuevos */
        System.out.println("¿Desea visualizar los registros almacenados antes de insertar nuevos? (S/N)");
        String respuesta = scanner.nextLine().trim().toUpperCase();
        if (respuesta.equals("S")) {
            DatabaseConnection.verificarDatos();
        }
        /* PLUS DE LA ACTIVIDAD - Pedir autorización para insertar registros */
        System.out.println("\n¿ Desea insertar 50 nuevos registros en la base de datos de MySql? (S/N)");
        respuesta = scanner.nextLine().trim().toUpperCase();
        if (respuesta.equals("S")) {
            Random random = new Random();
            /* DATOS PREDEFINIDOS PARA INSERTAR EN MYSQL */
            String[] nombres = {"Carlos", "Ana", "Luis", "María", "Jorge", "Sofía", "Pedro", "Laura", "Fernando", "Isabel"};
            String[] apellidos = {"Gómez", "Martínez", "Rodríguez", "Fernández", "Pérez", "Sánchez", "Ramírez", "Torres", "Vargas", "Castro"};
            String[] materias = {"Matemáticas", "Física", "Química", "Historia", "Geografía", "Biología", "Literatura", "Arte", "Música", "Informática"};
            String[] nivelesAcademicos = {"Licenciatura", "Maestría", "Doctorado"};
            for (int i = 1; i <= 50; i++) {
                String nombre = nombres[random.nextInt(nombres.length)];
                String apellido = apellidos[random.nextInt(apellidos.length)];
                String fechaNacimiento = (1970 + random.nextInt(30)) + "-0" + (1 + random.nextInt(9)) + "-0" + (1 + random.nextInt(9));
                String genero = (random.nextBoolean()) ? "Masculino" : "Femenino";
                double estatura = Math.round((1.50 + (random.nextDouble() * 0.50)) * 100.0) / 100.0;
                double peso = 50 + (random.nextInt(50));
                String especialidad = materias[random.nextInt(materias.length)];
                String nivelAcademico = nivelesAcademicos[random.nextInt(nivelesAcademicos.length)];
                Profesor profesor = new Profesor(nombre, apellido, fechaNacimiento, genero, estatura, peso, especialidad, nivelAcademico);
                Profesor.agregarProfesor(profesor);
                DataProfesorMysql.insertarProfesor(profesor);
            }
            System.out.println("✔ ¡50 registros insertados correctamente en base de datos MySqL!");
        } else {
            System.out.println("❌ No se insertaron nuevos registros.");
        }
        scanner.close();
    }
}
