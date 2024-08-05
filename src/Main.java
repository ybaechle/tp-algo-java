import java.util.Arrays;
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
            case 3:
                exercise3();
                break;
            default:
                System.out.println("Numéro d'exercice invalide");
                break;
        }
    }

    public static void exercise1() {
        System.out.println("**********************************");
        System.out.println("*   Lancement de l'exercice 1    *");
        System.out.println("**********************************");

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
        System.out.println("**********************************");
        System.out.println("*   Lancement de l'exercice 2    *");
        System.out.println("**********************************");

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


    public static void exercise3() {
        System.out.println("**********************************");
        System.out.println("*   Lancement de l'exercice 3    *");
        System.out.println("**********************************");

        // Déclaration et initialisation d'un tableau de 10 entiers
        int[] tabEntiers = {15, -5, 8, 1, -10, 3, 20, 0, 6, 12};

        // Tri et affichage du tableau trié
        Arrays.sort(tabEntiers);
        System.out.println("Tableau après le tri : " + Arrays.toString(tabEntiers));

        // Valeur à rechercher
        System.out.println("Veuillez entrer le nombre à rechercher : ");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        // Recherche de la valeur x dans le tableau
        int position = rechercherEntier(tabEntiers, x);

        // Affichage du résultat de la recherche
        if (position != -1) {
            System.out.println("La valeur " + x + " se trouve à la position " + position + " en partant de l'indice 0 du tableau.");
        } else {
            System.out.println("La valeur " + x + " n'existe pas dans le tableau.");
        }
    }

    // Fonction de recherche dichotomique
    public static int rechercherEntier(int[] tab, int x) {
        int gauche = 0;
        int droite = tab.length - 1;

        while (gauche <= droite) {
            int milieu = (gauche + droite) / 2;

            if (tab[milieu] == x) {
                return milieu; // Élément trouvé
            } else if (tab[milieu] < x) {
                gauche = milieu + 1;
            } else {
                droite = milieu - 1;
            }
        }

        return -1; // Élément non trouvé
    }
}


