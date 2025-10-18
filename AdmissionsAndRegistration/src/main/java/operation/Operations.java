package operation;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import person.Persons;

public class Operations {

    static Scanner sc = new Scanner(System.in);

    static final Persons[] records = new Persons[100];
    static final Persons[] auxRecords = new Persons[100];
    static String[] eTime = new String[100];
    static String[] sTime = new String[100];
    static int lenRecords = 0;
    static int a = 0, b = 1, next;
    static LocalDate date;
    static LocalTime time;
    static LocalTime begin;
    static LocalTime end;
    static int counterPeople = 0;
    static int counterAtention = 0;
    static int i = 0;

    static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    // Método para crear un registro nuevo
    public static void createRecord() {

        if (lenRecords < 50) {

            records[lenRecords] = new Persons();

            counterPeople++;

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                  C R E A R   N U E V O   U S U A R I O");

            while (true) {

                String data;
                System.out.println("----------------------------------------------------------------------------");
                System.out.print("Ingrese nombre: ");
                data = sc.nextLine();

                if (data.length() > 0) {

                    records[lenRecords].name = data;

                    break;
                }
            }

            date = LocalDate.now();
            records[lenRecords].enterDate = date.format(dateFormat);
            time = LocalTime.now();
            records[lenRecords].enterTime = time.format(timeFormat);

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Fecha de ingreso: " + records[lenRecords].enterDate);
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Hora de ingreso: " + records[lenRecords].enterTime);

            while (true) {

                String option;
                System.out.println("----------------------------------------------------------------------------");
                System.out.print("Requiere atención especial (1-Si 2-No): ");
                option = sc.nextLine();

                if (option.equals("1")) {

                    System.out.println("----------------------------------------------------------------------------");
                    records[lenRecords].specialService = true;
                    records[lenRecords].fibonacciNumber = returnFibonacci();
                    System.out.println("Atencion especial registrada con código: " + records[lenRecords].fibonacciNumber);
                    break;
                } else if (option.equals("2")) {

                    records[lenRecords].specialService = false;
                    break;
                } else {

                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                       O P C I O N   I N V A L I D A");
                }
            }

            lenRecords++;
        } else {

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("       I M P O S I B L E   A T E N D E R   M A S   U S U A R I O S");
        }
    }

    // Método para mostrar los registros existentes
    public static void showRecords() {

        if (lenRecords > 0) {

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("+-------------------+--------------+--------------+--------------+--------------+-----------+-----------+-------+");
            System.out.printf("%-20s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4s| %n", "| NOMBRE", "F. INGRESO", "H. INGRESO", "F. ATENCION", "H. ATENCION",
                    "ATENDIDO", "S. ESPCIAL", "CODIGO");
            System.out.println("+-------------------+--------------+--------------+--------------+--------------+-----------+-----------+-------+");

            for (int i = 0; i < lenRecords; i++) {

                if (records[i].specialService == false) {

                    if (records[i].service == false) {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4s  | %n", records[i].name, records[i].enterDate, records[i].enterTime,
                                "----", "----", "NO",
                                "NO", "N/A");
                    } else {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4s  | %n", records[i].name, records[i].enterDate, records[i].enterTime,
                                records[i].serviceDate, records[i].serviceTime, "SI",
                                "NO", "N/A");
                    }
                } else {

                    if (records[i].service == false) {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4d  | %n", records[i].name, records[i].enterDate, records[i].enterTime,
                                "----", "----", "NO",
                                "SI", records[i].fibonacciNumber);
                    } else {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4d  | %n", records[i].name, records[i].enterDate, records[i].enterTime,
                                records[i].serviceDate, records[i].serviceTime, "SI",
                                "SI", records[i].fibonacciNumber);
                    }
                }
            }

            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
        } else {

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("           N O   S E   H A N   C R E A D O   R E G I S T R O S");
        }
    }

    // Método para atender a la siguiente persona en la fila
    public static void serveNextPerson() {

        if (lenRecords > 0) {

            date = LocalDate.now();
            time = LocalTime.now();
            records[0].serviceDate = date.format(dateFormat);
            records[0].serviceTime = time.format(timeFormat);

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("        A T E N D I E N D O   U S U A R I O   E N   L A   F I L A");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("+-------------------+--------------+--------------+--------------+--------------+-----------+-----------+-------+");
            System.out.printf("%-20s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4s| %n", "| NOMBRE", "F. INGRESO", "H. INGRESO", "F. ATENCION", "H. ATENCION",
                    "ATENDIDO", "S. ESPCIAL", "CODIGO");
            System.out.println("+-------------------+--------------+--------------+--------------+--------------+-----------+-----------+-------+");
            System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10b| %-4d  | %n", records[0].name, records[0].enterDate, records[0].enterTime,
                    records[0].serviceDate, records[0].serviceTime, "SI",
                    records[0].specialService, records[0].fibonacciNumber);
            System.out.println("+-------------------+--------------+--------------+--------------+--------------+-----------+-----------+-------+");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Total usuarios en espera: " + (counterPeople - 1));
            System.out.println("----------------------------------------------------------------------------");

            eTime[i] = records[0].enterTime;
            sTime[i] = records[0].serviceTime;
            i++;

            counterPeople--;

            for (int i = 0; i < lenRecords - 1; i++) {

                records[i] = records[i + 1];
            }

            lenRecords--;
        } else {

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("           N O   S E   H A N   C R E A D O   R E G I S T R O S");
        }
    }

    // Método para calcular el tiempo promedio de atención
    public static void calculateAverageTime() {

        if (i > 0) {

            long totalMinutes = 0;

            for (int j = 0; j < i; j++) {

                if (eTime[j] != null && sTime[j] != null) {

                    LocalTime input = LocalTime.parse(eTime[j], timeFormat);
                    LocalTime output = LocalTime.parse(sTime[j], timeFormat);

                    long minutes = java.time.Duration.between(input, output).toMinutes();

                    if (minutes < 0) {

                        minutes += 24 * 60;
                    }

                    totalMinutes += minutes;
                }
            }

            long average = totalMinutes / i;

            long hours = average / 60;
            long minutes = average % 60;

            String averageFormat = String.format("%02d:%02d", hours, minutes);

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("         P R O M E D I O   D E   T I E M P O   D E   A T E N C I O N");
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Usuarios atendidos: " + i);
            System.out.println("Tiempo promedio: " + averageFormat);
            System.out.println("----------------------------------------------------------------------------");

        } else {

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("       N O   S E   H A N   A T E N D I D O   U S U A R I O S   A U N");
        }
    }

    // Método para cambiar de fila
    public static void changeQueue() {

        if (lenRecords > 0) {

            for (int i = 0; i < lenRecords; i++) {

                auxRecords[i] = records[i];
            }

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("                   N U E V A   F I L A   C R E A D A");
            System.out.println("----------------------------------------------------------------------------");
            // Títulos de la tabla
            System.out.println("+-------------------+--------------+--------------+--------------+--------------+-----------+-----------+-------+");
            System.out.printf("%-20s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4s| %n", "| NOMBRE", "F. INGRESO", "H. INGRESO", "F. ATENCION", "H. ATENCION",
                    "ATENDIDO", "S. ESPCIAL", "CODIGO");
            System.out.println("+-------------------+--------------+--------------+--------------+--------------+-----------+-----------+-------+");

            // Ciclo para mostrar cada registro almacenado
            for (int i = 0; i < lenRecords; i++) {

                if (auxRecords[i].specialService == false) {

                    if (auxRecords[i].service == false) {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4s  | %n", auxRecords[i].name, auxRecords[i].enterDate, auxRecords[i].enterTime,
                                "----", "----", "NO",
                                "NO", "N/A");
                    } else {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4s  | %n", auxRecords[i].name, auxRecords[i].enterDate, auxRecords[i].enterTime,
                                auxRecords[i].serviceDate, auxRecords[i].serviceTime, "SI",
                                "NO", "N/A");
                    }
                } else {

                    if (auxRecords[i].service == false) {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4d  | %n", auxRecords[i].name, auxRecords[i].enterDate, auxRecords[i].enterTime,
                                "----", "----", "NO",
                                "SI", auxRecords[i].fibonacciNumber);
                    } else {

                        System.out.printf("| %-18s| %-13s| %-13s| %-13s| %-13s| %-10s| %-10s| %-4d  | %n", auxRecords[i].name, auxRecords[i].enterDate, auxRecords[i].enterTime,
                                auxRecords[i].serviceDate, auxRecords[i].serviceTime, "SI",
                                "SI", auxRecords[i].fibonacciNumber);
                    }
                }
            }

            System.out.println("+---------------------------------------------------------------------------------------------------------------+");
        } else {

            // No existen registros
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("           N O   S E   H A N   C R E A D O   R E G I S T R O S");
        }
    }

    // Método para calcular atenciones en un intervalo dado
    public static void attentionInterval() {

        if (i > 0) {

            while (true) {

                try {

                    System.out.println("----------------------------------------------------------------------------");
                    System.out.print("Ingrese hora de inicio (HH:mm): ");
                    String beginStr = sc.nextLine();
                    begin = LocalTime.parse(beginStr, timeFormat);
                    break;
                } catch (Exception e) {

                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                   F O R M A T O   I N V A L I D O");
                }
            }

            while (true) {

                try {

                    System.out.println("----------------------------------------------------------------------------");
                    System.out.print("Ingrese hora de fin (HH:mm): ");
                    String endStr = sc.nextLine();
                    end = LocalTime.parse(endStr, timeFormat);
                    break;
                } catch (Exception e) {

                    System.out.println("----------------------------------------------------------------------------");
                    System.out.println("                   F O R M A T O   I N V A L I D O");
                }
            }

            counterAtention = 0;

            for (String times : sTime) {

                if (times != null) {

                    LocalTime hour = LocalTime.parse(times, timeFormat);

                    if (!hour.isBefore(begin) && !hour.isAfter(end)) {

                        counterAtention++;
                    }
                }
            }

            System.out.println("----------------------------------------------------------------------------");
            System.out.println(" Intervalo consultado: " + begin + " - " + end);
            System.out.println(" Atenciones realizadas: " + counterAtention);
        } else {

            System.out.println("----------------------------------------------------------------------------");
            System.out.println("       N O   S E   H A N   A T E N D I D O   U S U A R I O S   A U N");
        }
    }

    // Método interno para retornar un número dentro de la serie Fibonacci
    private static int returnFibonacci() {

        next = a + b;
        a = b;
        b = next;

        return next;
    }
}
