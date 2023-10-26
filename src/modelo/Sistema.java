package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<Articulo> articulos;
    private List<Compra> compras;

    public Sistema() {
        this.articulos = new ArrayList<>();
        this.compras = new ArrayList<>();
    }
    
    public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}



	public Articulo traerArticulo(String detalle) {
        for (Articulo articulo : articulos) {
            if (articulo.getDetalle().equals(detalle)) {
                return articulo;
            }
        }
        return null;
    }

    public boolean agregarArticulo(String detalle, double precio, Descuento descuento) {
        for (Articulo articulo : articulos) {
            if (articulo.getDetalle().equals(detalle)) {
                throw new IllegalArgumentException("Ya existe un artículo con el mismo detalle.");
            }
        }
        int nuevoId = articulos.isEmpty() ? 1 : articulos.get(articulos.size() - 1).getId() + 1;
        Articulo nuevoArticulo = new Articulo(nuevoId, detalle, precio, descuento);
        articulos.add(nuevoArticulo);
        return true;
    }

    public boolean agregarCompra(int cantidad, Articulo articulo, LocalDateTime fechaHora) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de la compra debe ser mayor que 0.");
        }
        Compra nuevaCompra = new Compra(cantidad, articulo, fechaHora);
        compras.add(nuevaCompra);
        return true;
    }

    public double precioTotal() {
        double total = 0.0;
        for (Compra compra : compras) {
            total += compra.getArticulo().getPrecio() * compra.getCantidad();
        }
        return total;
    }

    public List<Compra> traerCompra(LocalDateTime desde, LocalDateTime hasta) {
        List<Compra> comprasEnIntervalo = new ArrayList<>();
        for (Compra compra : compras) {
            LocalDateTime fecha = compra.getFechaHora();
            if (fecha.isEqual(desde) || fecha.isEqual(hasta) || (fecha.isAfter(desde) && fecha.isBefore(hasta))) {
                comprasEnIntervalo.add(compra);
            }
        }
        return comprasEnIntervalo;
    }

    public List<Compra> traerComprasDescuentoPorCantidad(LocalDateTime desde, LocalDateTime hasta) {
        List<Compra> comprasConDescuento = new ArrayList<>();
        for (Compra compra : compras) {
            if (compra.getArticulo().getDescuento() instanceof DescuentoPorCantidad) {
                LocalDateTime fecha = compra.getFechaHora();
                if (fecha.isEqual(desde) || fecha.isEqual(hasta) || (fecha.isAfter(desde) && fecha.isBefore(hasta))) {
                    comprasConDescuento.add(compra);
                }
            }
        }
        return comprasConDescuento;
    }

    public List<Articulo> traerArticulosConDescuento(boolean activo) {
        List<Articulo> articulosConDescuento = new ArrayList<>();
        for (Articulo articulo : articulos) {
            if (articulo.getDescuento().isActivo() == activo) {
                articulosConDescuento.add(articulo);
            }
        }
        return articulosConDescuento;
    }
}
