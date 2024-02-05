import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    public void init() {
        int menuItem = 0;
        String[][] clientes = new String[100][2]; // Array para almacenar clientes
        String[][] vehiculos = new String[100][3]; // Array para almacenar vehículos
        String[][] mecanicos = new String[100][3]; // Array para almacenar mecánicos
        String[][] reparaciones = new String[100][4]; // Array para almacenar reparaciones

        do {
            System.out.println("TALLER DE REPARACIÓ DE VEHICLES");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Donar d’alta nou mecànic");
            System.out.println("[3] Introduir nou vehicle");
            System.out.println("[4] Crear fitxa de nova reparació");
            System.out.println("[5] Sortir");
            System.out.println("Sel·lecciona una opció: ");

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

    // Método para dar de alta un nuevo cliente
    private static void altaNuevoCliente(String[][] clientes, Scanner scanner) {
        System.out.println("### Alta de Nou Client ###");

        // TODO: Pedir datos al usuario (DNI y nombre)
        System.out.print("Introdueix el DNI del client: ");
        String dni = scanner.next();
        System.out.print("Introdueix el nom del client: ");
        String nombre = scanner.next();

        // TODO: Validar el formato del DNI
        if (validarFormatoDNI(dni)) {
            // TODO: Verificar si el DNI ya existe
            if (!existeCliente(clientes, dni)) {
                // TODO: Validar que el nombre no sea vacío
                if (!nombre.isEmpty()) {
                    // TODO: Almacenar datos del nuevo cliente en la matriz
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

    // Método para dar de alta un nuevo mecánico
    private static void altaNuevoMecanico(String[][] mecanicos, Scanner scanner) {
        // TODO: Implementar lógica para dar de alta un nuevo mecánico
        System.out.println("Mètode per donar d'alta un nou mecànic (a implementar)...");
    }

    // Método para dar de alta un nuevo vehículo
    private static void altaNuevoVehiculo(String[][] clientes, String[][] vehiculos, Scanner scanner) {
        // TODO: Implementar lógica para dar de alta un nuevo vehículo
        System.out.println("Mètode per donar d'alta un nou vehicle (a implementar)...");
    }

    // Método para crear ficha de nueva reparación
    private static void altaNuevaReparacion(String[][] vehiculosculos, String[][] mecanicos,
                                            String[][] reparaciones, Scanner scanner) {
        // TODO: Implementar lógica para crear ficha de nueva reparaciónnklcshvjsbvjdksvbsvbsjuvbjsvbskjvbsjvbsjkv
        //TODO: Arnau trabajargitaaaadiajdliahjdadkjlshadkjahdkjshdakjddadadsgi
        System.out.println("Mètode per crear fitxa de nova reparació (a implementar)...");
    }

    // Método para validar el formato del DNI
    private static boolean validarFormatoDNI(String dni) {
        // TODO: Implementa la lógica de validación del formato del DNI
        return false;
    }

    // Método para verificar si un cliente ya existe
    private static boolean existeCliente(String[][] clientes, String dni) {
        // TODO: Implementa la lógica para verificar si un cliente ya existe
        return false;
    }

    // Resto de las clases y métodos...
    private static boolean
}
