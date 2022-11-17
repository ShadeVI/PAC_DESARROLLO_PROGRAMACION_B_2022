import java.util.regex.*;

public class Usuario {
    // Declaramos los atributos de la clase Usuario
    private String nombre;
    private int edad;
    private String DNI;

    // El constructor vacío se podría omitir en ese caso
    public Usuario() {
    }

    // GETTERS Y SETTERS
    // Para el atributo: nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Para el atributo: edad
    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Para el DNI
    public String getDNI() {
        return DNI;
    }

    // Este método devolverá true si el DNI introducido es valido.
    // False si no es un formato valido.
    public boolean setDNI(String DNI) {
        // Creamos el pattern para la comprobación con Regex
        // Indicamos que los primeros 8 caracteres solo pueden ser números entre 0 y 9
        // -? indica que el carácter - puede aparecer 0 o 1 vez.
        // [A-Z] indica que solo puede haber un carácter al final y tiene que ser entre A y Z mayúsculas
        // ^ indica que la String que pasamos empieza con esta secuencia
        // $ y tiene que terminar con una letra mayúscula
        Pattern patterDNI = Pattern.compile("^[0-9]{8}-?[A-Z]$");

        // Creamos el Matcher pasando el DNI que estamos recibiendo como parámetro
        Matcher matcherDNI = patterDNI.matcher(DNI);

        // Usamos el método .matches() que devuelve un boolean para ver si tenemos coincidencia o no.
        boolean esDniCorrecto = matcherDNI.matches();

        // Si el formato del DNI es correcto, lo asignamos
        if(esDniCorrecto){
            this.DNI = DNI;
        }
        return esDniCorrecto;
    }

    // Sobreescribimos el método toString().
    @Override
    public String toString() {
        return "Datos del usuario" +
                "\n\tNombre: " + nombre +
                "\n\tEdad: " + edad +
                "\n\tDNI: " + DNI;
    }
}
