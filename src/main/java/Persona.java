/* PUNTO 1a) CLASE PERSONA: CREACION Y CONSTRUCCION DE CLASE PADRE representa una persona con atributos básicos.*/
public class Persona {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String genero;
    private double estatura;
    private double peso;

    /**
     * Constructor de la clase Persona.
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param fechaNacimiento Fecha de nacimiento en formato YYYY-MM-DD.
     * @param genero Género de la persona.
     * @param estatura Estatura en metros.
     * @param peso Peso en kilogramos.
     */
    /* PUNTO 1c) Utilizacion de THIS en los ocnstructores*/
    public Persona(String nombre, String apellido, String fechaNacimiento, String genero, double estatura, double peso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estatura = estatura;
        this.peso = peso;
    }

    // Métodos getter
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getFechaNacimiento() { return fechaNacimiento; }
    public String getGenero() { return genero; }
    public double getEstatura() { return estatura; }
    public double getPeso() { return peso; }

    /**
     * Muestra la información de la persona en la consola.
     */
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Género: " + genero);
        System.out.println("Estatura: " + estatura + " m");
        System.out.println("Peso: " + peso + " kg");
    }
}
