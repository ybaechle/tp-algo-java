import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le numéro de l'exercice à exécuter :");
        int numExo = scanner.nextInt();
        start(numExo);
    }

    public static void start(int numExo) {
        switch (numExo) {
            case 1:
                exercise1();
                break;
            case 2:
                exercise2();
                break;
            default:
                System.out.println("Numéro d'exercice invalide");
                break;
        }
    }

    public static void exercise1() {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;

        // Saisir les coefficients a, b, c
        System.out.println("Entrez la valeur de a (doit être un entier non nul) : ");
        while (!scanner.hasNextInt() || (a = scanner.nextInt()) == 0) {
            System.out.println("a doit être un nombre entier non nul. Veuillez réessayer : ");
            scanner.nextLine(); // Effacer l'entrée non valide
        }

        System.out.println("Entrez la valeur de b : ");
        while (!scanner.hasNextInt()) {
            System.out.println("b doit être un nombre entier. Veuillez réessayer : ");
            scanner.nextLine();
        }
        b = scanner.nextInt();

        System.out.println("Entrez la valeur de c : ");
        while (!scanner.hasNextInt()) {
            System.out.println("c doit être un nombre entier. Veuillez réessayer : ");
            scanner.nextLine();
        }
        c = scanner.nextInt();


        // Calcul du discriminant
        int delta = b * b - 4 * a * c;
        double sqrtDelta = Math.sqrt(delta);

        System.out.println("Equation: " + a + "x^2 + " + b + "x + " + c + " = 0");

        if (delta > 0) {
            // Deux solutions réelles et distinctes
            double x1 = (-b + sqrtDelta) / (2 * a);
            double x2 = (-b - sqrtDelta) / (2 * a);
            System.out.println("L'équation a deux solutions réelles et distinctes : x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            // Une seule solution réelle
            double x = (double) -b / (2 * a);

            System.out.println("L'équation a une solution réelle : x = " + x);
        } else {
            // Pas de solution réelle
            System.out.println("L'équation n'a pas de solutions réelles.");
        }

        scanner.close();
    }

    public static void exercise2() {
        Scanner scanner = new Scanner(System.in);
        int x = 0, y = 0;

        // Saisir les valeurs x et y
        System.out.println("Entrez la valeur de x (doit être un entier positif) : ");
        while (!scanner.hasNextInt() || (x = scanner.nextInt()) <= 0) {
            System.out.println("x doit être un nombre entier positif. Veuillez réessayer : ");
            scanner.nextLine(); // Effacer l'entrée non valide
        }

        System.out.println("Entrez la valeur de y (doit être un entier positif) : ");
        while (!scanner.hasNextInt() || (y = scanner.nextInt()) <= 0) {
            System.out.println("y doit être un nombre entier positif. Veuillez réessayer : ");
            scanner.nextLine(); // Effacer l'entrée non valide
        }

        // Calcul de x puissance y
        long result = puissance(x, y);

        System.out.println(x + " puissance " + y + " vaut " + result);

        scanner.close();
    }

    private static long puissance(int x, int y) {
        return (long) Math.pow(x, y);

    }

}
