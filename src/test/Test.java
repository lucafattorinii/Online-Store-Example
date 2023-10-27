package test;

import modelo.*;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        // Test 1
    	System.out.println("Test 1:\n");
        Sistema sistema = new Sistema();
        DescuentoPorCantidad descuento1 = new DescuentoPorCantidad(true, 3, 1);
        DescuentoPorCantidad descuento2 = new DescuentoPorCantidad(true, 5, 2);
        DescuentoPorSubTotal descuento3 = new DescuentoPorSubTotal(false, 500, 10);
        DescuentoPorSubTotal descuento4 = new DescuentoPorSubTotal(true, 1000, 50);

        sistema.agregarArticulo("art1", 100.0, descuento1);
        sistema.agregarArticulo("art2", 150.0, descuento2);
        sistema.agregarArticulo("art3", 200.0, descuento3);
        sistema.agregarArticulo("art4", 500.0, descuento4);

        System.out.println("Lista de articulos en el sistema:");
        for (Articulo articulo : sistema.getArticulos()) {
            System.out.println(articulo);
        }


        // Test 2
        try {
            sistema.agregarArticulo("art1", 100.0, descuento1);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2: " + e.getMessage());
        }

        // Test 3
        sistema.agregarCompra(6, sistema.traerArticulo("art1"), LocalDateTime.parse("2023-10-20T09:00"));
        sistema.agregarCompra(5, sistema.traerArticulo("art2"), LocalDateTime.parse("2023-10-20T09:30"));
        sistema.agregarCompra(10, sistema.traerArticulo("art2"), LocalDateTime.parse("2023-10-20T10:00"));
        sistema.agregarCompra(3, sistema.traerArticulo("art3"), LocalDateTime.parse("2023-10-20T10:30"));
        sistema.agregarCompra(4, sistema.traerArticulo("art4"), LocalDateTime.parse("2023-10-20T11:00"));

        System.out.println("Lista de compras en el sistema:");
        for (Compra compra : sistema.getCompras()) {
            System.out.println(compra);
        }

        // Test 4
       
        try {
            sistema.agregarCompra(0, sistema.traerArticulo("art1"), LocalDateTime.parse("2023-10-20T11:30"));
        } catch (IllegalArgumentException e) {
            System.out.println("Test 4: " + e.getMessage());
        }

		// Test 5
        
		for (int i = 2; i <= 4; i++) {
			//Compra compra = sistema.getCompras().get(i);
			double precioTotal = sistema.precioTotal();
			System.out.println("Total compra indice " + i + ": " + precioTotal);
		}

        // Test 6
		
        LocalDateTime desde = LocalDateTime.parse("2023-10-20T09:15");
        LocalDateTime hasta = LocalDateTime.parse("2023-10-20T10:30");
        System.out.println("Compras entre " + desde + " y " + hasta + ":");
        for (Compra compra : sistema.traerCompra(desde, hasta)) {
            System.out.println(compra);
        }

        // Test 7
        
        System.out.println("Compras con DescuentoPorCantidad entre " + desde + " y " + hasta + ":");
        for (Compra compra : sistema.traerComprasDescuentoPorCantidad(desde, hasta)) {
            System.out.println(compra);
        }

        // Test 8
        
        boolean activo = true;
        System.out.println("Articulos con descuentos activos:");
        for (Articulo articulo : sistema.traerArticulosConDescuento(activo)) {
            System.out.println(articulo);
        }
    }
}
