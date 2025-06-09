import java.util.ArrayList; /* Libreria de java, Permite usar listas dinámicas en Java. */

/* PUNTO 1b) CLASE PROFESOR: CREACION Y CONSTRUCCION CLASE HIJA: representa un profesor, heredando atributos de Persona. */
public class Profesor extends Persona { //Aqui con palabra clave EXTENDS profesor hereda de persona
    private String especialidad; //Se agrega atributo nuevo
    private String nivelAcademico; // se agrega atributo nuevo

    // PUNTO 1d) CREACION DE UN TDA : Se usa ArrayList para almacenar 50 REGISTROS de profesores dinámicamente
    private static ArrayList<Profesor> listaProfesores = new ArrayList<>();
    /** Constructor de la clase Profesor.
     * @param nombre Nombre del profesor.
     * @param apellido Apellido del profesor.
     * @param fechaNacimiento Fecha de nacimiento en formato YYYY-MM-DD.
     * @param genero Género del profesor.
     * @param estatura Estatura en metros.
     * @param peso Peso en kilogramos.
     * @param especialidad Especialidad del profesor.
     * @param nivelAcademico Nivel académico del profesor.
     */
    public Profesor(String nombre, String apellido, String fechaNacimiento, String genero, double estatura, double peso, String especialidad, String nivelAcademico) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso); // Uso de SUPER para inicializar los atributos heredados.
        this.especialidad = especialidad; /* PUNTO 1c) Utilizacion de THIS */
        this.nivelAcademico = nivelAcademico; /* PUNTO 1c) Utilizacion de THIS */
    }

    public String getEspecialidad() { return especialidad; }
    public String getNivelAcademico() { return nivelAcademico; }

    /**
     * Muestra la información del profesor en la consola.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // Uso de super para llamar al método de la clase padre
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Nivel Académico: " + nivelAcademico);
    }

    /**
     * Agrega un profesor a la lista de almacenamiento.
     * @param profesor Objeto Profesor a agregar.
     */
    public static void agregarProfesor(Profesor profesor) {
        listaProfesores.add(profesor);
    }

    /**
     * Obtiene la lista de profesores almacenados.
     * @return Lista de profesores.
     */
    public static ArrayList<Profesor> obtenerProfesores() {
        return listaProfesores;
    }
}

