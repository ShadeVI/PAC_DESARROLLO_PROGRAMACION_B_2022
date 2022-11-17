// Clase abstracta de donde van a heredar las clases Gasto e Ingreso
// Contiene los métodos para manejar el dinero y la descripción
public abstract class Dinero {
    protected double dinero;
    protected String description;

    // GETTERS Y SETTERS
    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
