import java.util.Scanner;

public class Main {

    private static final int MAX_MECHANICS = 10;
    private Scanner input = new Scanner(System.in);
    private Mecanic[] mecanics = new Mecanic[MAX_MECHANICS];
    private int numMecanics = 0;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    public void init() {
        int menuItem = 0;
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
                        afegirNouClient();
                        break;
                    case 2:
                        System.out.println("Has triat donar d’alta nou mecànic....");
                        afegirNouMecanic();
                        break;
                    case 3:
                        System.out.println("Has triat introduir nou vehicle....");
                        // insert code here
                        break;
                    case 4:
                        System.out.println("Has triat crear fitxa de nova reparació....");
                        // insert code here
                        break;
                    case 5:
                        System.out.println("Sortint....");
                        break;
                    default:
                        System.out.println("Opció no vàlida");
                }
            } else {
                System.out.println("Opció no vàlida");
                input.nextLine();
            }
            System.out.println();

        } while (menuItem != 5);
    }

    /**
     * Mètode per donar d’alta un nou client amb validació del DNI.
     */
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

    /**
     * Mètode per validar el format del DNI: 8 enters seguits de 1 caràcter (lletra).
     *
     * @param dni DNI a validar.
     * @return Cert si el format del DNI és vàlid, Fals altrament.
     */
    private boolean validarFormatDNI(String dni) {
        return dni.matches("\\d{8}[A-Za-z]");
    }

    /**
     * Mètode per afegir un nou mecànic al taller.
     * Verifica si encara hi ha espai per a nous mecànics i, en cas afirmatiu,
     * sol·licita i valida la informació del nou mecànic (codi d'empleat i nom).
     * Si el mecànic es pot afegir amb èxit, l'emmagatzema a la llista de mecànics.
     */
    private void afegirNouMecanic() {

        if (numMecanics < MAX_MECHANICS) {

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

                mecanics[numMecanics++] = nouMecanic;
                System.out.println("Mecànic donat d'alta amb èxit!");
            }
        } else {
            System.out.println("Error: S'ha arribat al nombre màxim de mecànics.");
        }
    }

    /**
     * Verifica si el codi d'empleat ja existeix en la llista de mecànics.
     *
     * @param codiEmpleat Codi d'empleat a verificar.
     * @return Cert si el codi d'empleat ja existeix, Fals altrament.
     */
    private boolean codiEmpleatExisteix(String codiEmpleat) {
        for (int i = 0; i < numMecanics; i++) {
            if (mecanics[i].getCodiEmpleat().equals(codiEmpleat)) {
                System.out.println("Error: Aquest codi d'empleat ja existeix. Introdueix un altre.");
                return true;
            }
        }
        return false;
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
