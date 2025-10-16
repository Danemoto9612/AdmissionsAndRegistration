package main;

import java.util.Scanner;

public class MainMenu {

    static Scanner sc = new Scanner(System.in);

    static String option;

    public static void admissionsAndRegistrationMenu() {

        do {

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                       <<<   M A I N   M E N U   >>>");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("1. Registrar ingreso                   5. Pasar a otra fila");
            System.out.println("2. Mostrar fila                        6. Personas atendidas en un intervalo");
            System.out.println("3. Atender persona                     7. Salir");
            System.out.println("4. Calcular y mostrar promedio         8. Easter");
            System.out.println("----------------------------------------------------------------------------");
            System.out.print("Ingrese opcion: ");
            option = sc.nextLine();

            switch (option) {

                case "1" -> {
                }
                case "2" -> {
                }
                case "3" -> {
                }
                case "4" -> {
                }
                case "5" -> {
                }
                case "6" -> {
                }
                case "7" -> {
                    
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                      H A S T A   L A   P R O X I M A");
                    System.out.println("----------------------------------------------------------------------------");
                }
                case "8" -> {
                    
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                        CREADO POR DANIEL MORALES");
                }
                default -> {
                    
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                       O P C I O N   I N V A L I D A");
                }
            }
        } while (!option.equals("7"));
    }
}
