// Menú principal de acciones sobre el programa
package main;

// Clase Scanner nativa de java
import java.util.Scanner;
// Clase Operations encargada de las acciones del programa
import operation.Operations;

public class MainMenu {

    // Scanner para leer entrada del usuario
    static Scanner sc = new Scanner(System.in);

    // Variable para almacenar la entrada del usuario
    static String option;

    public static void admissionsAndRegistrationMenu() {

        // Ciclo para controlar el menú de acciones
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

            // Selección de acciones 
            switch (option) {

                case "1" -> {
                    
                    // Método para crear nuevos registros de usuarios
                    Operations.createRecord(); // Pertenece al package operation y a la clase Operations
                }
                case "2" -> {
                    
                    // Método para mostrar los registros creados (la fila de personas)
                    Operations.showRecords(); // Pertenece al package operation y a la clase Operations
                }
                case "3" -> {
                    
                    // Método para desencolar (Atender a la siguiente persona)
                    Operations.serveNextPerson(); // Pertenece al package operation y a la clase Operations
                }
                case "4" -> {
                    
                    // Método para calcular el promedio de tiempo en atender a una persona
                    Operations.calculateAverageTime(); // Pertenece al package operation y a la clase Operations
                }
                case "5" -> {
                    
                    // Método para mover a otra fila en caso de error
                    Operations.changeQueue(); // Pertenece al package operation y a la clase Operations
                }
                case "6" -> {
                    
                    // Método para calular la cantidad de atenciones en un intervalo de tiempo
                    Operations.attentionInterval(); // Pertenece al package operation y a la clase Operations
                }
                case "7" -> {
                    
                    // Salir y mostrar mensaje de despedida
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                      H A S T A   L A   P R O X I M A");
                    System.out.println("----------------------------------------------------------------------------");
                }
                case "8" -> {
                    
                    // Huevo de pascua muestra el creador del programa
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                        CREADO POR DANIEL MORALES");
                }
                default -> {
                    
                    // Muestra al usuario que ha elegido una opción inválida
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                       O P C I O N   I N V A L I D A");
                }
            }
        // Condición lógica del ciclo
        } while (!option.equals("7"));
    }
}