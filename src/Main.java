import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(new Locale("es", "ES")); // Configuro el scanner para que use el Locale Español
        Usuario usuario = creacionUsuario(scanner);

        Cuenta cuenta = new Cuenta(usuario);
        boolean terminar = false;
        while(!terminar){
            System.out.println("Realiza una nueva acción");
            System.out.println("1 Introduce un nuevo gasto");
            System.out.println("2 Introduce un nuevo ingreso");
            System.out.println("3 Mostrar gastos");
            System.out.println("4 Mostrar ingresos");
            System.out.println("5 Mostrar saldo");
            System.out.println("0 Salir");
            terminar = menu(scanner, cuenta);
        }
        //cierro el scanner para librar recursos
        scanner.close();
    }

    // Método para imprimir el mensaje de despedida.
    private static void finPrograma() {
        System.out.println("Fin del programa.");
        System.out.print("Gracias por utilizar la aplicación M03B en el curso 1s2223.");
    }

    /* Método de presentación de acciones para el menu
     *  Devuelve true para terminar, false para seguir el bucle exterior
     */
    private static boolean menu(Scanner scanner, Cuenta cuenta) {

        int eleccionMenu = Integer.parseInt(scanner.nextLine());

        switch (eleccionMenu){
            case 0:
                finPrograma();
                return true;
            case 1:
                nuevoGasto(cuenta, scanner);
                break;
            case 2:
                nuevoIngreso(cuenta, scanner);
                break;
            case 3:
                mostrarGastos(cuenta);
                break;
            case 4:
                mostrarIngresos(cuenta);
                break;
            case 5:
                mostrarSaldo(cuenta);
                break;
            default:
                System.out.println("Elección no valida.");
        }
        return false;

    }

    // Métodos de utilidad.
    public static String formatearMoneda(double monedaDouble){
        DecimalFormat df = new DecimalFormat("#,#00.00");
        String result = df.format(monedaDouble);
        return result.concat("€");
    }

    // Métodos del menu
    private static void mostrarSaldo(Cuenta cuenta) {
        System.out.println("El saldo actual de la cuenta es: " + formatearMoneda(cuenta.getSaldo()));
    }

    private static void mostrarIngresos(Cuenta cuenta) {
        List<Ingreso> ingresos = cuenta.getIngresos();
        for(Ingreso ingreso : ingresos){
            System.out.println(ingreso);
        }
    }

    private static void mostrarGastos(Cuenta cuenta) {
        List<Gasto> gastos = cuenta.getGastos();
        for(Gasto gasto : gastos){
            System.out.println(gasto);
        }
    }

    private static void nuevoIngreso(Cuenta cuenta, Scanner scanner) {
        System.out.println("Introduce la descripción: ");
        String descripcion = scanner.nextLine();
        System.out.println("Introduce la cantidad: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        double saldoRestante = cuenta.addIngresos(descripcion, cantidad);
        System.out.println("Saldo actual: " + formatearMoneda(saldoRestante));
    }

    private static void nuevoGasto(Cuenta cuenta, Scanner scanner) {
        try {
            System.out.println("Introduce la descripción: ");
            String descripcion = scanner.nextLine();
            System.out.println("Introduce la cantidad: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();
            double saldoRestante = cuenta.addGastos(descripcion, cantidad);
            System.out.println("Saldo restante: " + formatearMoneda(saldoRestante));
        } catch (GastoException e) {
            System.err.println(e.getMessage());
        }
    }

        // Método de creación del objeto usuario.
    private static Usuario creacionUsuario(Scanner scanner){

        Usuario usuario = new Usuario();

        System.out.print("Introduzca el nombre: ");
        String nombre = scanner.nextLine();
        usuario.setNombre(nombre);

        System.out.print("Introduzca la edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        usuario.setEdad(edad);

        boolean esDNIValido;
        do{
            System.out.print("Introduzca DNI: ");
            String DNI = scanner.nextLine();
            esDNIValido = usuario.setDNI(DNI);
            if(!esDNIValido){
                System.out.println("DNI introducido incorrecto");
            }
        }while(!esDNIValido);

        System.out.println("Usuario creado correctamente");
        System.out.println(usuario);
        return usuario;
    }
}
