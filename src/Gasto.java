public class Gasto extends Dinero {
    public Gasto(double gasto, String description){
        setDinero(gasto);
        setDescription(description);
    }

    @Override
    public String toString() {
        String monedaFormateada = Main.formatearMoneda(getDinero());
        return "Gasto: " + getDescription() + ", cantidad: " + monedaFormateada;
    }
}
