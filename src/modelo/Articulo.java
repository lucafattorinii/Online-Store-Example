package modelo;

public class Articulo {
    private int id;
    private String detalle;
    private double precio;
    private Descuento descuento;

    public Articulo(int id, String detalle, double precio, Descuento descuento) {
        this.id = id;
        this.detalle = detalle;
        this.precio = precio;
        this.descuento = descuento;
    }

    public int getId() {
        return id;
    }

    public String getDetalle() {
        return detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public Descuento getDescuento() {
        return descuento;
    }

	@Override
	public String toString() {
		return "Articulo [id=" + id + ", detalle=" + detalle + ", precio=" + precio + ", descuento=" + descuento + "]\n";
	}
    
    
}
