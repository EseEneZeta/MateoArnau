import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Definir constantes para el máximo de mecánicos y reparaciones
    static final int MAX_MECHANICS = 100;
    static final int MAX_REPAIRS = 100;

    // Scanner para entrada de datos
    static Scanner input = new Scanner(System.in);

    // Listas para almacenar datos
    static List<String> DNIsPropietaris = new ArrayList<>();
    static List<String> matriculasVehiculos = new ArrayList<>();
    static List<String> nombresModelos = new ArrayList<>();
    static List<Mecanic> mecanics = new ArrayList<>();
    static List<Reparacion> repairs = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    // Método para inicializar el programa
    public void init() {
        int menuItem = 0;
        do {
            // Mostrar menú
            System.out.println("TALLER DE REPARACIÓ DE VEHICLES");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Donar d’alta nou vehícle");
            System.out.println("[3] Donar d’alta nou mecànic");
            System.out.println("[4] Donar d'alta nova reparació");
            System.out.println("[5] Actualitzar Reparacions");
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
                        System.out.println("Has triat donar d'alta nou vehícle....");
                        altaNuevoVehiculo();
                        break;
                    case 3:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        afegirNouMecanic();
                        break;
                    case 4:
                        System.out.println("Has triat reparar un vehicle....");
                        altaNuevaReparacion();
                        break;
                    case 5:
                        System.out.println("Has triat actualizar les reparacions....");
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
            input.nextLine(); // Limpiar el buffer de entrada
            System.out.println("");

        } while (menuItem != 6);

    }

    /**
     * Añade un nuevo cliente al taller.
     *
     * @return void
     */
    private void afegirNouClient() {
        String dni;
        do {
            System.out.print("Introdueix el DNI del client (format: 12345678A): ");
            dni = input.next();
        } while (!validarFormatDNI(dni));

        input.nextLine(); // Limpiar el buffer de entrada
        System.out.print("Introdueix el nom del client: ");
        String nom = input.nextLine();

        DNIsPropietaris.add(dni);

        System.out.println("Client donat d'alta amb èxit!");
    }

    /**
     * Valida el formato del DNI.
     *
     * @param dni DNI del cliente
     * @return boolean
     */
    private boolean validarFormatDNI(String dni) {
        return dni.matches("\\d{8}[A-Za-z]");
    }

    /**
     * Añade un nuevo mecánico al taller.
     *
     * @return void
     */
    private void afegirNouMecanic() {
        if (mecanics.size() < MAX_MECHANICS) {
            Mecanic nouMecanic = new Mecanic();
            do {
                System.out.print("Introdueix el codi d'empleat (format: 123456): ");
                nouMecanic.setCodiEmpleat(input.next());
            } while (!nouMecanic.validarCodiEmpleat() || codiEmpleatExisteix(nouMecanic.getCodiEmpleat()));

            input.nextLine(); // Limpiar el buffer de entrada
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

    /**
     * Verifica si el código de empleado ya existe.
     *
     * @param codiEmpleat Código de empleado a verificar
     * @return boolean
     */
    private boolean codiEmpleatExisteix(String codiEmpleat) {
        for (Mecanic mecanic : mecanics) {
            if (mecanic.getCodiEmpleat().equals(codiEmpleat)) {
                System.out.println("Error: Aquest codi d'empleat ja existeix. Introdueix un altre.");
                return true;
            }
        }
        return false;
    }

    /**
     * Da de alta un nuevo vehículo en el taller.
     *
     * @return void
     */
    public void altaNuevoVehiculo() {
        if (DNIsPropietaris.isEmpty()) {
            System.out.println("No hi ha clients donats d'alta.");
            return;
        }

        String matriculaVehiculo;
        boolean formatoIncorrecto;
        do {
            System.out.print("Introdueix la matrícula del vehicle (el format és: 4 dígits + 3 lletres): ");
            input.nextLine(); // Limpiar el buffer de entrada
            matriculaVehiculo = input.nextLine();
            formatoIncorrecto = !validarMatricula(matriculaVehiculo);
            if (formatoIncorrecto) {
                System.out.println("Error: Format de matrícula incorrecte. Ha de ser 4 dígits seguits de 3 lletres.");
            }
        } while (formatoIncorrecto);

        if (matriculasVehiculos.contains(matriculaVehiculo)) {
            System.out.println("La matrícula del vehicle ja existeix. Introdueix-ne una de nova.");
            return;
        }

        System.out.print("Introdueix el model del vehicle: ");
        String nombreModelo = input.nextLine();
        if (nombreModelo.isEmpty()) {
            System.out.println("El nom del model del vehicle no pot estar buit.");
            return;
        }

        System.out.println("Llista de DNIs de propietaris:");
        for (String DNI : DNIsPropietaris) {
            System.out.println(DNI);
        }

        System.out.print("Selecciona el DNI del propietari del vehicle: ");
        String DNIPropietario = input.nextLine();
        if (!DNIsPropietaris.contains(DNIPropietario)) {
            System.out.println("El DNI seleccionat no està a la llista.");
            return;
        }

        matriculasVehiculos.add(matriculaVehiculo);
        nombresModelos.add(nombreModelo);
        DNIsPropietaris.add(DNIPropietario);
        System.out.println("Vehicle donat d'alta amb èxit.");
    }

    /**
     * Valida el formato de la matrícula del vehículo.
     *
     * @param matricula Matrícula del vehículo
     * @return boolean
     */
    public boolean validarMatricula(String matricula) {
        String patron = "\\d{4}[a-zA-Z]{3}";
        return matricula.matches(patron);
    }

    /**
     * Da de alta una nueva reparación en el taller.
     *
     * @return void
     */
    public void altaNuevaReparacion() {
        if (matriculasVehiculos.isEmpty()) {
            System.out.println("No hi ha vehicles donats d'alta. Si us plau, insereix primer algun vehicle.");
            return;
        }

        System.out.println("Llista de matrícules de vehicles:");
        for (String matricula : matriculasVehiculos) {
            System.out.println(matricula);
        }

        input.nextLine(); // Limpiar el buffer de entrada

        System.out.print("Introduce la matrícula del vehículo a reparar: ");
        String matriculaVehiculo = input.nextLine();
        if (!matriculasVehiculos.contains(matriculaVehiculo)) {
            System.out.println("La matrícula introducida no corresponde a ningún vehículo dado de alta.");
            return;
        }

        Mecanic mecanicoReparacion = null;
        for (Mecanic mecanico : mecanics) {
            if (mecanico.getEstado().equals("lliure")) {
                mecanicoReparacion = mecanico;
                mecanicoReparacion.setEstado("ocupado");
                break;
            }
        }

        String estadoReparacion = (mecanicoReparacion != null) ? "en curso" : "oberta";
        if (estadoReparacion.equals("oberta")) {
            System.out.println("No hay mecánicos disponibles. La reparación se asignará como 'oberta'.");
        }

        System.out.print("Introduce la descripción de la reparación: ");
        String descripcionReparacion = input.nextLine();
        if (descripcionReparacion.isEmpty()) {
            System.out.println("La descripción de la reparación no puede estar vacía.");
            return;
        }

        if (mecanicoReparacion != null) {
            System.out.println("La reparación será realizada por el mecánico: " + mecanicoReparacion.getNom() + ", que está actualmente " + mecanicoReparacion.getEstado() + ".");
        } else {
            System.out.println("No hay mecánicos disponibles para realizar la reparación.");
        }

        Reparacion nuevaReparacion = new Reparacion(matriculaVehiculo, (mecanicoReparacion != null) ? mecanicoReparacion.getCodiEmpleat() : null, estadoReparacion, descripcionReparacion);
        repairs.add(nuevaReparacion);

        System.out.println("Reparación añadida correctamente.");
    }

    /**
     * Actualiza el estado de una reparación existente en el taller.
     *
     * @return void
     */
    public void actualizarReparaciones() {
        if (repairs.isEmpty()) {
            System.out.println("No se están haciendo reparaciones.");
            return;
        }
        System.out.println("Matrículas de vehículos en reparación:");
        for (Reparacion repair : repairs) {
            System.out.println(repair.getMatricula());
        }
        System.out.print("Selecciona la matrícula del vehículo que quieras actualizar: ");
        input.nextLine(); // Limpiar el buffer de entrada
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

    /**
     * Clase que representa a un mecánico.
     */
    class Mecanic {
        private String codiEmpleat;
        private String nom;
        private String estado;

        public Mecanic() {
            this.estado = "lliure";
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

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        /**
         * Valida el código de empleado.
         *
         * @return boolean
         */
        public boolean validarCodiEmpleat() {
            // Implementación...
            return true; // Cambiar lógica según sea necesario
        }

        /**
         * Verifica si algún campo del mecánico está vacío.
         *
         * @return boolean
         */
        public boolean esBuit() {
            return codiEmpleat == null || nom == null || codiEmpleat.isEmpty() || nom.isEmpty();
        }
    }

    /**
     * Clase que representa una reparación.
     */
    class Reparacion {
        private String matricula;
        private String codigoMecanico;
        private String estado;
        private String descripcion;

        public Reparacion(String matricula, String codigoMecanico, String estado, String descripcion) {
            this.matricula = matricula;
            this.codigoMecanico = codigoMecanico;
            this.estado = estado;
            this.descripcion = descripcion;
        }

        public String getMatricula() {
            return matricula;
        }

        public void setMatricula(String matricula) {
            this.matricula = matricula;
        }

        public String getCodigoMecanico() {
            return codigoMecanico;
        }

        public void setCodigoMecanico(String codigoMecanico) {
            this.codigoMecanico = codigoMecanico;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
    }
}
