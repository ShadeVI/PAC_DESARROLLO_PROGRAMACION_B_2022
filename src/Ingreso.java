public class Ingreso extends Dinero {
    public Ingreso(double ingreso, String description){
        setDinero(ingreso);
        setDescription(description);
    }

    @Override
    public String toString() {
        String monedaFormateada = Main.formatearMoneda(getDinero());
        return "Ingreso: " + getDescription() + ", cantidad: " + monedaFormateada;
    }
}
