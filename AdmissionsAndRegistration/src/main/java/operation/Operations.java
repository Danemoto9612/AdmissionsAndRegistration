package operation;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import person.Persons;

public class Operations {

    static Scanner sc = new Scanner(System.in);

    // Instanciación del vector de registros
    private static final Persons[] records = new Persons[100];
    // Controlador de la posición del nuevo registro y el tamaño lógico del vector
    private static int lenRecords = 0;
    // Variables para la función de retorno del número fibonacci
    private static int a = 0, b = 1, next;

    // Método para crear un registro nuevo
    public static void createRecord() {

        if (lenRecords < 50) {

            // Crear nuevo objeto de la clase Persons para almacenar en el registro.
            records[lenRecords] = new Persons();

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                  C R E A R   N U E V O   U S U A R I O");

            // Ciclo para pedir el nombre y verificar que si se ingrese uno
            while (true) {

                String data;
                System.out.println("----------------------------------------------------------------------------");
                System.out.print("Ingrese nombre: ");
                data = sc.nextLine();
                // Condición lógica para verificar que se haya ingresado un nombre
                if (data.length() > 0) {

                    records[lenRecords].name = data;

                    // Salida del ciclo
                    break;
                }
            }

            // Fecha de ingreso tomada por el sistema
            records[lenRecords].enterDate = LocalDate.now();
            // Hora de ingreso tomada por el sistema
            records[lenRecords].enterTime = LocalTime.now();
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Fecha de ingreso: " + records[lenRecords].enterDate);
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Hora de ingreso: " + records[lenRecords].enterTime);
            
            // Ciclo para verificar si el usuario requiere atención especial
            while (true) {

                String option;
                System.out.println("----------------------------------------------------------------------------");
                System.out.print("Requiere atención especial (1-Si 2-No): ");
                option = sc.nextLine();
                
                // Condición lógica para confirmar si requiere atención especial
                if (option.equals("1")) {

                    System.out.println("----------------------------------------------------------------------------");
                    records[lenRecords].specialService = true;
                    // Retorna un número de la serie Fibonacci para usar cómo código de atención especial
                    records[lenRecords].fibonacciNumber = returnFibonacci();
                    System.out.println("Atencion especial registrada con código: " + records[lenRecords].fibonacciNumber);
                    break;
                } else if (option.equals("2")) {

                    records[lenRecords].specialService = false;
                    break;
                } else {

                    // Muestra al usuario que ha elegido una opción inválida
                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                       O P C I O N   I N V A L I D A");
                }
            }
            
            // Actualiza el valor de lenRecords
            lenRecords++;
        } else {

            // El vector de registros se encuentra lleno
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("       I M P O S I B L E   A T E N D E R   M A S   U S U A R I O S");
        }
    }

    // Método para mostrar los registros existentes
    public static void showRecords() {
        
        // Verificar que existen registros para poder mostrarlos
        if (lenRecords > 0) {
            
            // Títulos de la tabla
            System.out.println("+------+--------+--------+-------+-------+---------+-----------+-----------+");
            System.out.println("|Nombre| F.Ingre| H.Ingre| F.Aten| H.Aten| Atendido| S.Especial| Código F. |");
            System.out.println("+------+--------+--------+-------+-------+---------+-----------+-----------+");
            
            // Ciclo para mostrar cada registro almacenado
            for (int i = 0; i < lenRecords; i++) {
               
                System.out.println(records[i].name + " " + records[i].enterDate + " " + records[i].enterTime
                + " " + records[i].serviceDate + " " + records[i].serviceTime + " " + records[i].service
                + " " + records[i].specialService + " " + records[i].fibonacciNumber);
            }
        } else {
            
            // No existen registros
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("           N O   S E   H A N   C R E A D O   R E G I S T R O S");
        }
    }

    // Método para atender a la siguiente persona en la fila
    public static void serveNextPerson() {
    }

    // Método para calcular el tiempo promedio de atención
    public static void calculateAverageTime() {
    }

    // Método para cambiar de fila
    public static void changeQueue() {
    }

    // Método para calcular atención en un intervalo dado
    public static void attentionInterval() {
    }
    
    // Método interno para retornar un número dentro de la serie Fibonacci
    private static int returnFibonacci() {
        
        next = a + b;
        a = b;
        b = next;
        
        return next;
    }
}
