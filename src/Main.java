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
            case 4:
                exercise4();
                break;
            case 5:
                exercise5();
                break;
            case 6:
                exercise6();
                break;
            case 7:
                exercise7();
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

    /**
     * Calcule la puissance d'un entier x élevé à un entier y.
     * Cette méthode utilise la fonction `Math.pow` pour calculer la valeur de x élevé à la puissance y.
     * Le résultat est converti en long pour éviter les pertes de précision liées aux grandes valeurs.
     *
     * @param x la base, un entier
     * @param y l'exposant, un entier
     * @return le résultat de x^y en tant que long
     */
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

    /**
     * Recherche un entier dans un tableau trié en utilisant l'algorithme de recherche dichotomique.
     * Cette méthode effectue une recherche dichotomique (ou recherche binaire) pour trouver la position d'un entier donné
     * dans un tableau trié d'entiers. Si l'entier est trouvé, l'index de l'élément est retourné. Sinon, la méthode retourne -1.
     * Le tableau doit être trié au préalable pour que la recherche fonctionne correctement.
     *
     * @param tab le tableau trié d'entiers dans lequel effectuer la recherche
     * @param x   l'entier à rechercher
     * @return l'index de l'entier recherché dans le tableau, ou -1 si l'entier n'est pas trouvé
     */
    private static int rechercherEntier(int[] tab, int x) {
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


    public static void exercise4() {
        System.out.println("**********************************");
        System.out.println("*   Lancement de l'exercice 4    *");
        System.out.println("**********************************");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez renseigner la taille du tableau : ");
        int TAILLE_MAX = scanner.nextInt();

        int[] tableau = new int[TAILLE_MAX];

        // Remplissage du tableau avec des valeurs aléatoires positives et négatives comprises entre -500 et 499
        for (int i = 0; i < TAILLE_MAX; i++) {
            tableau[i] = (int) (Math.random() * 1000) - 500;
        }

        // Affichage des valeurs du tableau
        System.out.println("Contenu du tableau : " + Arrays.toString(tableau));

        // Recherche de la plus grande valeur dans le tableau
        int max = lireMaxTabEntiers(tableau);
        System.out.println("La plus grande valeur dans le tableau est : " + max);

        scanner.close();
    }

    /**
     * Trouve et retourne la plus grande valeur dans un tableau d'entiers.
     * Cette méthode parcourt un tableau d'entiers donné pour trouver la valeur maximale.
     * La recherche commence avec la première valeur du tableau comme valeur initiale de `max`,
     * et compare chaque élément à l'itération suivante pour déterminer s'il est plus grand que le `max` actuel.
     *
     * @param tab le tableau d'entiers dans lequel rechercher la valeur maximale
     * @return la plus grande valeur trouvée dans le tableau
     * @throws IllegalArgumentException si le tableau est vide
     */
    private static int lireMaxTabEntiers(int[] tab) {
        // Initialiser max avec la première valeur du tableau
        int max = tab[0];

        for (int i = 1; i < tab.length; i++) {
            if (tab[i] > max) {
                max = tab[i];
            }
        }

        return max;
    }


    public static void exercise5() {
        System.out.println("**********************************");
        System.out.println("*   Lancement de l'exercice 5    *");
        System.out.println("**********************************");

        String choice;

        do {
            choice = calculProduit();
        } while (choice.equalsIgnoreCase("y"));
    }

    /**
     * Génère un tableau de multiplication et permet à l'utilisateur de trouver le produit de deux nombres.
     * Cette méthode crée un tableau de multiplication de taille définie par les constantes LIGNES et COLONNES.
     * Les produits des nombres de 1 à 9 sont stockés dans le tableau, avec l'index 0 des lignes et colonnes ignoré.
     * L'utilisateur est invité à entrer deux entiers, X et Y, pour obtenir le produit correspondant de X et Y
     * dans le tableau de multiplication. La méthode demande ensuite à l'utilisateur s'il souhaite relancer
     * le programme pour un autre calcul.
     *
     * @return une chaîne indiquant si l'utilisateur souhaite effectuer un autre calcul ("y" pour oui, "n" pour non)
     */
    private static String calculProduit() {
        // Définition des constantes pour le nombre de lignes et de colonnes
        final int LIGNES = 10;
        final int COLONNES = 10;

        // Déclaration et initialisation du tableau à 2 dimensions de 9x9
        int[][] tabMultiplication = new int[LIGNES][COLONNES];

        // Remplir le tableau avec les produits de multiplication
        for (int i = 1; i < tabMultiplication.length; i++) {
            for (int j = 1; j < tabMultiplication[i].length; j++) {
                tabMultiplication[i][j] = i * j;
            }
        }

        // Affichage du tableau 2D, en ignorant la ligne et la colonne 0
        for (int i = 1; i < LIGNES; i++) {
            for (int j = 1; j < COLONNES; j++) {
                System.out.print(tabMultiplication[i][j] + "\t");
            }
            System.out.println();
        }

        // Saisie de x et y par l'utilisateur
        Scanner scanner = new Scanner(System.in);
        int x, y;

        do {
            System.out.println("Entrez la valeur de X (entier de 1 à 9) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un entier !");
                scanner.nextLine();
            }
            x = scanner.nextInt();
        } while (x < 1 || x > 9);

        do {
            System.out.println("Entrez la valeur de Y (entier de 1 à 9) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un entier !");
                scanner.nextLine();
            }
            y = scanner.nextInt();
        } while (y < 1 || y > 9);

        // Affichage de la valeur à l'intersection de X et Y
        int valeur = tabMultiplication[x][y];
        System.out.println("Le résultat de " + x + " X " + y + " = " + valeur);

        // On demande à l'utilisateur s'il souhaite relancer le programme
        scanner.nextLine();
        System.out.println("Souhaitez-vous encore un calcul ? y pour oui ou n pour non");
        String choice = scanner.nextLine();

        if (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
            System.out.println("Choix invalide, le programme va s'arrêter.");
            return "n";
        }
        scanner.close();

        return choice;

    }


    public static void exercise6() {
        System.out.println("**********************************");
        System.out.println("*   Lancement de l'exercice 6    *");
        System.out.println("**********************************");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez renseigner la taille du tableau : ");
        int TAILLE_MAX = scanner.nextInt();

        int[] tableau = new int[TAILLE_MAX];

        // Remplissage du tableau avec des valeurs aléatoires positives et négatives comprises entre -500 et 499
        for (int i = 0; i < TAILLE_MAX; i++) {
            tableau[i] = (int) (Math.random() * 1000) - 500;
        }

        // Affichage des valeurs du tableau avant tri
        System.out.println("Contenu du tableau avant tri : " + Arrays.toString(tableau));

        // Demander à l'utilisateur de trier par ordre croissant ou décroissant
        scanner.nextLine(); // Consommer le saut de ligne restant
        String choice;
        while (true) {
            System.out.println("Voulez-vous trier par ordre croissant ou décroissant ? Tapez \"asc\" pour croissant ou \"desc\" pour décroissant : ");
            choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("asc") || choice.equals("desc")) {
                break;
            } else {
                System.out.println("Choix invalide : " + choice);
            }
        }

        // Tri du tableau par ordre croissant ou décroissant
        // L'IDE a optimisé la structure du switch par une notation plus concise
        int[] tableauTrie = switch (choice) {
            case "asc" -> trierTableau(tableau, true);
            case "desc" -> trierTableau(tableau, false);
            default -> tableau;
        };

        // Affichage des valeurs du tableau après tri
        System.out.println("Tableau après tri : " + Arrays.toString(tableauTrie));

        scanner.close();
    }

    /**
     * Trie un tableau d'entiers en ordre croissant ou décroissant selon le paramètre spécifié.
     * Cette méthode utilise l'algorithme de tri par insertion pour trier le tableau d'entiers fourni.
     * L'ordre de tri est déterminé par le paramètre `asc`. Si `asc` est vrai, le tableau est trié
     * en ordre croissant, sinon il est trié en ordre décroissant.
     *
     * @param tab le tableau d'entiers à trier
     * @param asc un booléen spécifiant l'ordre de tri; vrai pour un tri croissant, faux pour un tri décroissant
     * @return le tableau trié
     */
    private static int[] trierTableau(int[] tab, boolean asc) {
        for (int i = 1; i < tab.length; i++) {
            int current = tab[i];
            int j = i;

            // Boucle pour déplacer les éléments selon l'ordre choisi
            while (j > 0 && (asc ? current < tab[j - 1] : current > tab[j - 1])) {
                tab[j] = tab[j - 1];
                j--;
            }
            tab[j] = current;
        }
        return tab;
    }


    public static void exercise7() {
        System.out.println("**********************************");
        System.out.println("*   Lancement de l'exercice 7    *");
        System.out.println("**********************************");

        String operation;
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur le type d'opération souhaitée
        while (true) {
            System.out.println("Veuillez choisir votre opération (+, -, *, /) : ");
            operation = scanner.nextLine();
            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
                break;
            } else {
                System.out.println("Opération invalide. Veuillez entrer l'une des opérations suivantes : +, -, *, /");
            }
        }

        // Demander les 2 valeurs à l'utilisateur
        System.out.println("Veuillez entrer la valeur de x : ");
        int x = scanner.nextInt();
        System.out.println("Veuillez entrer la valeur de y : ");
        int y = scanner.nextInt();

        scanner.close();

        // Calcul et affichage du résultat
        calculer(x, y, operation);
    }

    /**
     * Effectue une opération arithmétique sur deux entiers et affiche le résultat.
     *
     * @param x         le premier entier
     * @param y         le deuxième entier
     * @param operation une chaîne spécifiant l'opération à effectuer ("+", "-", "*", "/")
     */
    private static void calculer(int x, int y, String operation) {
        int resultat;

        switch (operation) {
            case "+":
                resultat = x + y;
                break;
            case "-":
                resultat = x - y;
                break;
            case "*":
                resultat = x * y;
                break;
            case "/":
                if (y != 0) {
                    resultat = x / y;
                } else {
                    System.out.println("La division par 0 est interdite !");
                    return; // Sortir de la méthode pour éviter l'affichage du résultat
                }
                break;
            default:
                System.out.println("Opération invalide.");
                return; // Sortir de la méthode car l'opération est invalide
        }

        // Affichage du résultat si l'opération est valide
        System.out.println("Le résultat de " + x + " " + operation + " " + y + " = " + resultat);
    }
}

















