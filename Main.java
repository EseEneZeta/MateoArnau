import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);



    public static void main(String[] args) {

        Main main = new Main();
        main.init();
    }



    public void init(){
        int menuItem = 0;
        do {
            System.out.println("TALLER DE REPARACIÓ DE VEHICLES");
            System.out.println("[1] Donar d’alta nou client");
            System.out.println("[2] Donar d’alta nou mecànic");
            System.out.println("[3] Introduir nou vehicle");
            System.out.println("[4] Crear fitxa de nova reparació");
            System.out.println("[5] Sortir");
            System.out.println("Sel·lecciona una opció: ");

            if (input.hasNextInt()){
                menuItem = input.nextInt();
                switch (menuItem){
                    case 1:
                        System.out.println("Has triat donar d’alta nou client....");
                        afegirNouClient();
                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        //insert code here
                        break;
                    case 3:
                        System.out.println("Has triat introduir nou vehicle....");
                        altaNuevaReparacion();
                        break;
                    case 4:
                        System.out.println("Has triat crear fitxa de nova reparació....");
                        //insert code here
                        break;
                    case 5:
                        System.out.println("Sortint....");
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                }
            }else{
                System.out.println("Opció no vàlida");
            }
            input.nextLine();
            System.out.println("");

        }while(menuItem!=5);

    }


    /**
     * Mètode per donar d’alta un nou client amb validació del DNI.
     */
    private void afegirNouClient() {
        // Implementació per afegir un nou client
        String dni;
        do {
            System.out.print("Introdueix el DNI del client (format: 12345678A): ");
            dni = input.next();
        } while (!validarFormatDNI(dni));

        input.nextLine(); // Consume the newline character left by next()

        System.out.print("Introdueix el nom del client: ");
        String nom = input.nextLine();

        // Add logic to save the client information
        System.out.println("Client donat d'alta amb èxit!");
    }

    /**
     * Mètode per validar el format del DNI: 8 enters seguits de 1 caràcter (lletra).
     *
     * @param dni DNI a validar.
     * @return Cert si el format del DNI és vàlid, Fals altrament.
     */
    private boolean validarFormatDNI(String dni) {
        return dni.matches("\\d{8}[A-Za-z]");
    }

}
    /**
     * Método para dar de alta una nueva reparación.
     */
    public void altaNuevaReparacion(){
        System.out.println("Has elegido introducir nueva reparación....");
        if (matriculasVehiculos.isEmpty()) {
            System.out.println("No hay vehículos dados de alta. Primero debes introducir un vehículo.");
            return;
        }
        System.out.println("Lista de matrículas de vehículos:");
        for (String matricula : matriculasVehiculos) {
            System.out.println(matricula);
        }
        System.out.print("Seleccione la matrícula del vehículo que quieras reparar: ");
        String matriculaSeleccionada = input.nextLine();
        if (!matriculasVehiculos.contains(matriculaSeleccionada)) {
            System.out.println("La matrícula seleccionada no está en el listado. Inténtalo de nuevo.");
            return;
        }
        System.out.println("Matrícula seleccionada: " + matriculaSeleccionada);

        /**
         * Método para buscar un mecánico disponible.
         */
        public String buscarMecanicoDisponible() {
            for (String estadoMecanico : codigosMecanicos) {
                if (estadoMecanico.equals("lliure")) {
                    int index = codigosMecanicos.indexOf(estadoMecanico);
                    codigosMecanicos.set(index, "ocupat");
                    return codigosMecanicos.get(index);
                }
            }
            return "";
        }


