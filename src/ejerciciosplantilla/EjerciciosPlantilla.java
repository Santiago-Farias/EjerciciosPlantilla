package ejerciciosplantilla;

import java.util.Scanner;

public class EjerciciosPlantilla {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        int numProducts, productsSoldInDay, productsSoldByProduct;
        
        double inventoryValue = 0.0, profitOfDay = 0.0, profitOfProduct = 0.0;
        
        String productSoldName = null;
        
        boolean productNotFound = false;
        
        // Ingresar la cantidad de productos diferentes que hay en la tienda.
        System.out.println("Ingrese la cantidad de productos diferentes que se"
                + " venden en la tienda.");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido");
                scanner.next();
            }
            numProducts = scanner.nextInt();

            if (numProducts <= 0) {
                System.out.println("Ingrese un número válido");
            }
        } while (numProducts <= 0);
        
        // Declarar vectores.
        String productName[] = new String[numProducts];
        double productPrice[] = new double[numProducts];
        int productStock[] = new int[numProducts];
        
        // Ingresar los datos de cada producto.
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Ingrese el nombre del producto N°" + (i + 1));
            while (!scanner.hasNext("[a-zA-Z]+")) {
                // Revisar lo del nombre único.
                System.out.println("Ingrese un nombre válido."); 
                scanner.next();
            }
            productName[i] = scanner.next();
            
            System.out.println("Ingrese el precio del producto N°" + (i + 1));
            do {
            while (!scanner.hasNextDouble()) {
                System.out.println("Ingrese un número válido.");
                scanner.next();
            }
            productPrice[i] = scanner.nextInt();
            
                if (productPrice[i] <= 0) {
                    System.out.println("Ingrese un número válido.");
                }
            } while (productPrice[i] <= 0);
            
            System.out.println("Ingrese la cantidad en Stock del producto N°"
                    + (i + 1));
            do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                scanner.next(); 
            }
            productStock[i] = scanner.nextInt();
            
                if (productStock[i] < 0) {
                    System.out.println("Ingrese un número válido.");
                }
            } while (productStock[i] < 0);
            
            inventoryValue = inventoryValue + productPrice[i];
        }
        
        for (int i = 0; i < numProducts; i++) {
            System.out.println(productStock[i]);
        }
        // Ingresar las ventas del día.
        System.out.println("Ingrese la cantidad de ventas que se realizaron en"
                + " el día.");
        do {
        while (!scanner.hasNextInt()) {
            System.out.println("Ingrese un número válido.");
            scanner.next();
        }
        productsSoldInDay = scanner.nextInt();
        
            if (productsSoldInDay < 0) {
                System.out.println("Ingrese un número válido.");
            }
        } while (productsSoldInDay < 0);
        
        if (productsSoldInDay == 0) {
            productNotFound = true;
        }
        
        // Solicitar el nombre del producto vendido en cada venta y
        // la cantidadvendida.
        while (!productNotFound) {
            for (int i = 0; i < productsSoldInDay; i++) {
                System.out.println("Venta N° " + (i + 1));
                System.out.println("Ingrese el nombre del producto vendido.");
                while (!scanner.hasNext("[a-zA-Z]+")) {
                    System.out.println("¡Nombre Inválido!");
                    System.out.println("Ingrese un nombre del"
                            + " siguiente listado: ");
                    for (int j = 0; j < numProducts; j++) {
                        System.out.print(productName[j] + "; ");
                    }
                    scanner.next();
                }
                productSoldName = scanner.next();

                for (int a = 0; a < numProducts; a++) {
                    if (productSoldName.equalsIgnoreCase(productName[a])) {
                        System.out.println("Ingrese la cantidad vendida de '"
                                + productName[a] + "'.");
                        productsSoldByProduct = scanner.nextInt();
                        // Restar el Stock vendido de cada producto.
                        productStock[a] = productStock[a]
                                - productsSoldByProduct; 

                        // Calcular los ingresos de cada producto.                        
                        profitOfProduct = productPrice[a] 
                                * productsSoldByProduct; 
                        // Calcular los ingresos del día.
                        profitOfDay = profitOfDay + profitOfProduct; 
                    } else {
                        productNotFound = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < numProducts; i++) {
            System.out.println(productStock[i]);
        }
        
        System.out.println("Ganancias del día: " + profitOfDay);
    }
}
