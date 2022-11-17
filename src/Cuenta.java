// Importamos lo necesario para trabajar con las listas.
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    // Declaramos una serie de atributos
    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos = new ArrayList<>();
    private List<Ingreso> ingresos = new ArrayList<>();

    // Preparamos el constructor que recibe un objeto de tipo Usuario
    public Cuenta(Usuario usuario){
        // inicializamos los atributos
        this.setSaldo(0);
        this.setUsuario(usuario);
    }

    // GETTERS

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double addGastos(String description, double cantidad) throws GastoException {
        if(cantidad > saldo){
            throw new GastoException();
        }
        gastos.add(new Gasto(cantidad, description));
        // Actualiza el saldo después de añadir el gasto a la lista de gastos
        saldo -= cantidad;
        return saldo;
    }

    public double addIngresos(String description, double cantidad) {
        ingresos.add(new Ingreso(cantidad, description));
        // Actualiza el saldo después de añadir el ingreso a la lista de ingresos
        saldo += cantidad;
        return saldo;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }

    @Override
    public String toString() {
        return "Informaciones de la cuenta." +
                "\n\t" + usuario +
                "\n\tSaldo: " + saldo;
    }
}
