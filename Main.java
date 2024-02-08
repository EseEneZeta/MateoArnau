import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    public void init() {
        int menuItem = 0;
        String[][] clientes = new String[100][2];
        String[][] vehiculos = new String[100][3];
        String[][] mecanicos = new String[100][3];
        String[][] reparaciones = new String[100][4];

        do {
            System.out.println("TALLER DE REPARACIÓ DE VEHICLES");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Donar d’alta nou mecànic");
            System.out.println("[3] Introduir nou vehicle");
            System.out.println("[4] Crear fitxa de nova reparació");
            System.out.println("[5] Sortir");
            System.out.print("Sel·lecciona una opció: ");

            if (input.hasNextInt()) {
                menuItem = input.nextInt();
                switch (menuItem) {
                    case 1:
                        System.out.println("Has triat donar d’alta nou client....");
                        altaNuevoCliente(clientes, input);
                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        altaNuevoMecanico(mecanicos, input);
                        break;
                    case 3:
                        System.out.println("Has triat introduir nou vehicle....");
                        altaNuevoVehiculo(clientes, vehiculos, input);
                        break;
                    case 4:
                        System.out.println("Has triat crear fitxa de nova reparació....");
                        altaNuevaReparacion(vehiculos, mecanicos, reparaciones, input);
                        break;
                    case 5:
                        System.out.println("Sortint....");
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                }
            } else {
                System.out.println("Opció no vàlida");
            }
            input.nextLine();
            System.out.println("");

        } while (menuItem != 5);
    }

    private void altaNuevoCliente(String[][] clientes, Scanner scanner) {
        System.out.println("### Alta de Nou Client ###");

        System.out.print("Introdueix el DNI del client: ");
        String dni = scanner.next();
        System.out.print("Introdueix el nom del client: ");
        String nombre = scanner.next();

        if (validarFormatoDNI(dni)) {
            if (!existeCliente(clientes, dni)) {
                if (!nombre.isEmpty()) {
                    for (int i = 0; i < clientes.length; i++) {
                        if (clientes[i][0] == null) {
                            clientes[i][0] = dni;
                            clientes[i][1] = nombre;
                            System.out.println("Client donat d'alta amb èxit.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Error: El nom del client no pot estar buit.");
                }
            } else {
                System.out.println("Error: Aquest DNI ja està registrat.");
            }
        } else {
            System.out.println("Error: Format de DNI incorrecte.");
        }
    }

    private void altaNuevoMecanico(String[][] mecanicos, Scanner scanner) {
        System.out.println("### Alta de Nou Mecànic ###");

        System.out.print("Introdueix el codi del mecànic: ");
        String codigo = scanner.next();
        System.out.print("Introdueix el nom del mecànic: ");
        String nombre = scanner.next();

        // Implementa la lógica para dar de alta un nuevo mecánico

        System.out.println("Mecànic donat d'alta amb èxit.");
    }

    private void altaNuevoVehiculo(String[][] clientes, String[][] vehiculos, Scanner scanner) {
        System.out.println("### Alta de Nou Vehicle ###");

        // Implementa la lógica para dar de alta un nuevo vehículo

        System.out.println("Vehicle donat d'alta amb èxit.");
    }

    private void altaNuevaReparacion(String[][] vehiculos, String[][] mecanicos,
                                     String[][] reparaciones, Scanner scanner) {
        System.out.println("### Crear Fitxa de Nova Reparació ###");

        // Implementa la lógica para crear una ficha de nueva reparación

        System.out.println("Fitxa de reparació creada amb èxit.");
    }

    private boolean validarFormatoDNI(String dni) {
        // Implementa la lógica para validar el formato del DNI
        return true; // Cambia esto según tus requisitos
    }

    private boolean existeCliente(String[][] clientes, String dni) {
        // Implementa la lógica para verificar si un cliente ya existe
        return false; // Cambia esto según tus requisitos
    }
}
