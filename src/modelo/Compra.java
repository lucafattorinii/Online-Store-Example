package modelo;

import java.time.LocalDateTime;

public class Compra {
    private int cantidad;
    private Articulo articulo;
    private LocalDateTime fechaHora;

    public Compra(int cantidad, Articulo articulo, LocalDateTime fechaHora) {
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.fechaHora = fechaHora;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

	@Override
	public String toString() {
		return "Compra [cantidad=" + cantidad + ", articulo=" + articulo + ", fechaHora=" + fechaHora + "]\n";
	}
    
    
}
