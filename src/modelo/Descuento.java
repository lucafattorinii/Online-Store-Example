package modelo;

public abstract class Descuento {
    private boolean activo;

    public Descuento(boolean activo) {
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    abstract double calcularDescuentoParticular(int cantidad, double precio);
}
