package modelo;

public class DescuentoPorSubTotal extends Descuento {
    private int aplicarDesdeValor;
    private int porcentajeDescuento;

    public DescuentoPorSubTotal(boolean activo, int aplicarDesdeValor, int porcentajeDescuento) {
        super(activo);
        this.aplicarDesdeValor = aplicarDesdeValor;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    double calcularDescuentoParticular(int cantidad, double precio) {
        if (precio * cantidad >= aplicarDesdeValor) {
            return (porcentajeDescuento / 100.0) * (precio * cantidad);
        }
        return 0.0;
    }

    public int getAplicarDesdeValor() {
        return aplicarDesdeValor;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

	@Override
	public String toString() {
		return "DescuentoPorSubTotal [aplicarDesdeValor=" + aplicarDesdeValor + ", porcentajeDescuento="
				+ porcentajeDescuento + "]\n";
	}
    
    
}
