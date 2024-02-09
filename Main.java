import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final int MAX_MECHANICS = 100;
    static final int MAX_REPAIRS = 100;
    static Scanner input = new Scanner(System.in);
    static List<String> DNIsPropietarios = new ArrayList<>();
    static List<String> matriculasVehiculos = new ArrayList<>();
    static List<String> nombresModelos = new ArrayList<>();
    static List<Mecanic> mecanics = new ArrayList<>();
    static List<Reparacion> repairs = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    public void init() {
        int menuItem = 0;
        do {
            System.out.println("TALLER DE REPARACIÓN DE VEHÍCULOS");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Dar de alta nuevo vehículo");
            System.out.println("[3] Donar d’alta nou mecànic");
            System.out.println("[4] Introduir nou vehicle");
            System.out.println("[5] Crear fitxa de nova reparació");
            System.out.println("[6] Sortir");
            System.out.println("Sel·lecciona una opció: ");

            if (input.hasNextInt()) {
                menuItem = input.nextInt();
                switch (menuItem) {
                    case 1:
                        System.out.println("Has triat donar d’alta nou client....");
                        afegirNouClient();
                        break;
                    case 2:
                        altaNuevoVehiculo();
                        break;
                    case 3:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        afegirNouMecanic();
                        break;
                    case 4:
                        System.out.println("Has triat introduir nou vehicle....");
                        altaNuevaReparacion();
                        break;
                    case 5:
                        System.out.println("Has triat crear fitxa de nova reparació....");
                        actualizarReparaciones();
                        break;
                    case 6:
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

        } while (menuItem != 6);

    }

    private void afegirNouClient() {
        String dni;
        do {
            System.out.print("Introdueix el DNI del client (format: 12345678A): ");
            dni = input.next();
        } while (!validarFormatDNI(dni));

        input.nextLine();
        System.out.print("Introdueix el nom del client: ");
        String nom = input.nextLine();
        System.out.println("Client donat d'alta amb èxit!");
    }

    private boolean validarFormatDNI(String dni) {
        return dni.matches("\\d{8}[A-Za-z]");
    }

    private void afegirNouMecanic() {
        if (mecanics.size() < MAX_MECHANICS) {
            Mecanic nouMecanic = new Mecanic();
            do {
                System.out.print("Introdueix el codi d'empleat (format: 123456): ");
                nouMecanic.setCodiEmpleat(input.next());
            } while (!nouMecanic.validarCodiEmpleat() || codiEmpleatExisteix(nouMecanic.getCodiEmpleat()));

            input.nextLine();
            System.out.print("Introdueix el nom del mecànic: ");
            nouMecanic.setNom(input.nextLine());
            if (nouMecanic.esBuit()) {
                System.out.println("Error: Tots els camps són obligatoris.");
            } else {
                mecanics.add(nouMecanic);
                System.out.println("Mecànic donat d'alta amb èxit!");
            }
        } else {
            System.out.println("Error: S'ha arribat al nombre màxim de mecànics.");
        }
    }

    private boolean codiEmpleatExisteix(String codiEmpleat) {
        for (Mecanic mecanic : mecanics) {
            if (mecanic.getCodiEmpleat().equals(codiEmpleat)) {
                System.out.println("Error: Aquest codi d'empleat ja existeix. Introdueix un altre.");
                return true;
            }
        }
        return false;
    }

    public void altaNuevoVehiculo() {
        System.out.println("Has elegido dar de alta nuevo vehículo....");
        if (DNIsPropietarios.isEmpty()) {
            System.out.println("No hay clientes dados de alta.");
            return;
        }
        System.out.print("Introduce la matrícula del vehículo (el formato es: 4 dígitos + 3 letras): ");
        String matriculaVehiculo = input.nextLine();
        if (!validarMatricula(matriculaVehiculo)) {
            System.out.println("Formato de matrícula incorrecto. Debe ser 4 dígitos seguidos de 3 letras.");
            return;
        }
        if (matriculasVehiculos.contains(matriculaVehiculo)) {
            System.out.println("La matrícula del vehículo ya existe. Introduce una nueva.");
            return;
        }
        System.out.print("Introduce el modelo del vehículo: ");
        String nombreModelo = input.nextLine();
        if (nombreModelo.isEmpty()) {
            System.out.println("El nombre del modelo del vehículo no puede estar vacío.");
            return;
        }
        System.out.println("Lista de DNIs de propietarios:");
        for (String DNI : DNIsPropietarios) {
            System.out.println(DNI);
        }
        System.out.print("Seleccione el DNI del propietario del vehículo: ");
        String DNIPropietario = input.nextLine();
        if (!DNIsPropietarios.contains(DNIPropietario)) {
            System.out.println("El DNI seleccionado no está en la lista.");
            return;
        }
        matriculasVehiculos.add(matriculaVehiculo);
        nombresModelos.add(nombreModelo);
        DNIsPropietarios.add(DNIPropietario);
        System.out.println("Vehículo dado de alta con éxito.");
    }

    private boolean validarMatricula(String matricula) {
        return matricula.matches("\\d{4}[A-Za-z]{3}");
    }

    public void altaNuevaReparacion() {
        System.out.println("Has elegido introducir nueva reparación....");
        if (matriculasVehiculos.isEmpty()) {
            System.out.println("No hay vehículos dados de alta. Primero debes introducir un vehículo.");
            return;
        }
        System.out.println("Lista de matrículas de vehículos:");
        for (String

                matricula : matriculasVehiculos) {
            System.out.println(matricula);
        }
        System.out.print("Seleccione la matrícula del vehículo que quieras reparar: ");
        String matriculaSeleccionada = input.nextLine();
        if (!matriculasVehiculos.contains(matriculaSeleccionada)) {
            System.out.println("La matrícula seleccionada no está en el listado. Inténtalo de nuevo.");
            return;
        }
        System.out.println("Matrícula seleccionada: " + matriculaSeleccionada);
    }

    public void actualizarReparaciones() {
        System.out.println("Has elegido actualizar las reparaciones....");
        if (repairs.isEmpty()) {
            System.out.println("No se están haciendo reparaciones.");
            return;
        }
        System.out.println("Matrículas de vehículos en reparación:");
        for (Reparacion repair : repairs) {
            System.out.println(repair.getMatricula());
        }
        System.out.print("Selecciona la matrícula del vehículo que quieras actualizar: ");
        String matriculaSeleccionada = input.nextLine();
        if (!matriculasVehiculos.contains(matriculaSeleccionada)) {
            System.out.println("La matrícula no tiene una reparación haciéndose. Inténtalo de nuevo.");
            return;
        }
        int index = matriculasVehiculos.indexOf(matriculaSeleccionada);
        System.out.println("Estado actual de la reparación: " + repairs.get(index).getEstado());
        System.out.print("Ingrese el nuevo estado de la reparación (abierta/en curso/acabada): ");
        String nuevoEstado = input.nextLine();
        if (nuevoEstado.equals("abierta") || nuevoEstado.equals("en curso") || nuevoEstado.equals("acabada")) {
            repairs.get(index).setEstado(nuevoEstado);
            System.out.println("Estado de la reparación actualizado con éxito.");
        } else {
            System.out.println("Estado de la reparación no válido. Inténtalo de nuevo.");
        }
    }
}

class Mecanic {
    private String codiEmpleat;
    private String nom;

    public Mecanic() {
    }

    public String getCodiEmpleat() {
        return codiEmpleat;
    }

    public void setCodiEmpleat(String codiEmpleat) {
        this.codiEmpleat = codiEmpleat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean validarCodiEmpleat() {
        return true;
    }

    public boolean esBuit() {
        return codiEmpleat == null || nom == null || codiEmpleat.isEmpty() || nom.isEmpty();
    }
}

class Reparacion {
    private String matricula;
    private String estado;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
