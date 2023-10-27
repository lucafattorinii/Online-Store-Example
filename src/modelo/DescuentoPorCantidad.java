package modelo;

public class DescuentoPorCantidad extends Descuento {
    private int cadaNUnidades;
    private int unidadesGratis;

    public DescuentoPorCantidad(boolean activo, int cadaNUnidades, int unidadesGratis) {
        super(activo);
        this.cadaNUnidades = cadaNUnidades;
        this.unidadesGratis = unidadesGratis;
    }

    @Override
    double calcularDescuentoParticular(int cantidad, double precio) {
        int unidadesCompradas = cantidad;
        int unidadesPorCadaN = cadaNUnidades;
        int unidadesRegaladas = (unidadesCompradas / unidadesPorCadaN) * unidadesGratis;
        return unidadesRegaladas * precio;
    }

    public int getCadaNUnidades() {
        return cadaNUnidades;
    }

    public int getUnidadesGratis() {
        return unidadesGratis;
    }

	@Override
	public String toString() {
		return "DescuentoPorCantidad [cadaNUnidades=" + cadaNUnidades + ", unidadesGratis=" + unidadesGratis + "]\n";
	}
    
    
}
