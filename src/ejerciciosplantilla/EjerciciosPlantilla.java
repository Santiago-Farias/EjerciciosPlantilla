package ejerciciosplantilla;

import java.util.Scanner;

public class EjerciciosPlantilla {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numProducts, productsSoldInDay = 0, productsSoldByProduct = 0, mainMenu = 0;

        double inventoryValue = 0.0, profitOfDay = 0.0, profitOfProduct = 0.0;

        String productSoldName = null;

        boolean productNotFound = false, exitMenu = false;

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
        int productsSoldByProductHistory[] = new int[numProducts];

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

        String productSoldNameHistory[] = new String[productsSoldInDay];
        // Solicitar el nombre del producto vendido en cada venta y
        // la cantidadvendida.
            for (int i = 0; i < productsSoldInDay; i++) {
                System.out.println("Venta N° " + (i + 1));
                System.out.println("Ingrese el nombre del producto vendido de esta lista: ");
                for (int j = 0; j < numProducts; j++) {
                    System.out.print(productName[j] + "; ");
                }
                System.out.println("");

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
                productSoldNameHistory[i] = productSoldName;

                for (int a = 0; a < numProducts; a++) {
                    if (productSoldName.equalsIgnoreCase(productName[a])) {
                        System.out.println("Ingrese la cantidad vendida de '"
                                + productName[a] + "'.");
                        System.out.println("El Stock disponinle es de: " + productStock[a]);
                        do {
                            while (!scanner.hasNextInt()) {
                                System.out.println("Ingrese un número válido.");
                                scanner.next();
                            }
                            productsSoldByProduct = scanner.nextInt();
                            productsSoldByProductHistory[i] = productsSoldByProduct;

                            if (productsSoldByProduct < 0 || productsSoldByProduct > productStock[a]) {
                                System.out.println("Ingrese un número válido.");
                                System.out.println("El Stock disponinle es de: " + productStock[a]);
                            }
                        } while (productsSoldByProduct < 0 || productsSoldByProduct > productStock[a]);
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

        do {
            System.out.println("");
            System.out.println("----MENÚ PRINCIPAL----");
            System.out.println("1. Mostrar el valor totál del inventario.");
            System.out.println("2. Resúmen del día.");
            System.out.println("3. Productos restantes en Stock.");
            System.out.println("4. Ganancias en el día.");
            System.out.println("5. Salir.");
            System.out.println("");
            System.out.println("Ingrese una opción.");
            do {
                while (!scanner.hasNextInt()) {
                    System.out.println("Opción inexistente, por favor ingrese una de las opciones del menú.");
                    scanner.next();
                }

                mainMenu = scanner.nextInt();

                if (mainMenu <= 0 || mainMenu > 5) {
                    System.out.println("Opción inexistente, por favor ingrese una de las opciones del menú.");
                }
            } while (mainMenu <= 0 || mainMenu > 5);

            switch (mainMenu) {
                case 1:
                    System.out.println("Valor del inventario: $" + inventoryValue);
                    break;
                case 2:
                    System.out.println("Total de ventas en el día: " + productsSoldInDay);
                    System.out.println("Producto----U. Vendidas");
                    for (int i = 0; i < numProducts; i++) {
                        System.out.println(productSoldNameHistory[i] + "--------------" + productsSoldByProductHistory[i]);
                    }
                    break;
                case 3:
                    for (int i = 0; i < numProducts; i++) {
                        System.out.println("Producto: " + productName[i] + " Cantidad en Stock: " + productStock[i]);
                    }
                    break;
                case 4:
                    System.out.println("Ganancias del día: " + profitOfDay);
                    break;
                case 5:
                    exitMenu = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (!exitMenu);
    }
}
