package sudoku;

public class Afficheur {

    // Coins
    private static final String COIN_HAUT_GAUCHE = "\u2554";
    private static final String COIN_HAUT_DROIT  = "\u2557";
    private static final String COIN_BAS_GAUCHE  = "\u255A";
    private static final String COIN_BAS_DROIT   = "\u255D";

    // Jonctions du cadre exterieur
    private static final String JONCTION_HAUT    = "\u2566";
    private static final String JONCTION_BAS     = "\u2569";
    private static final String JONCTION_GAUCHE  = "\u2560";
    private static final String JONCTION_DROITE  = "\u2563";

    // Jonction centrale
    private static final String JONCTION_CENTRE  = "\u256C";

    // Lignes
    private static final String LIGNE_H          = "\u2550\u2550\u2550";
    private static final String LIGNE_V          = "\u2551";

    
    public static void afficherGrilleInitiale(Grille grille) {
        System.out.println("\nGRILLE INITIALE");
        afficherGrille(grille);
    }

   
    public static void afficherGrilleResolue(Grille grille) {
        System.out.println("\nGRILLE RESOLUE");
        afficherGrille(grille);
    }

   
    public static void afficherGrille(Grille grille) {
        int[][] cellules = grille.getCellules();

        // 1. Afficher la ligne du haut
        System.out.println(ligneHaute());

        // 2. Pour chaque ligne de la grille
        for (int ligne = 0; ligne < 9; ligne++) {

            // a. Afficher les valeurs separees par LIGNE_V
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < 9; col++) {
                sb.append(LIGNE_V);
                sb.append(" ").append(formaterValeur(cellules[ligne][col])).append(" ");
            }
            sb.append(LIGNE_V);
            System.out.println(sb.toString());

            // b. Apres chaque groupe de 3 lignes (sauf la derniere), afficher une separation
            if (ligne == 8) {
                // 3. Afficher la ligne du bas apres la derniere ligne
                System.out.println(ligneBasse());
            } else if ((ligne + 1) % 3 == 0) {
                // Separation entre sous-grilles (lignes 2 et 5)
                System.out.println(ligneSeparation());
            } else {
                // Separation simple entre deux lignes d'une meme sous-grille
                System.out.println(ligneSeparation());
            }
        }
    }

    
    private static String ligneHaute() {
        StringBuilder sb = new StringBuilder();
        sb.append(COIN_HAUT_GAUCHE);
        for (int col = 0; col < 9; col++) {
            sb.append(LIGNE_H);
            if (col < 8) {
                sb.append(JONCTION_HAUT);
            }
        }
        sb.append(COIN_HAUT_DROIT);
        return sb.toString();
    }

    
    private static String ligneSeparation() {
        StringBuilder sb = new StringBuilder();
        sb.append(JONCTION_GAUCHE);
        for (int col = 0; col < 9; col++) {
            sb.append(LIGNE_H);
            if (col < 8) {
                sb.append(JONCTION_CENTRE);
            }
        }
        sb.append(JONCTION_DROITE);
        return sb.toString();
    }

    
    private static String ligneBasse() {
        StringBuilder sb = new StringBuilder();
        sb.append(COIN_BAS_GAUCHE);
        for (int col = 0; col < 9; col++) {
            sb.append(LIGNE_H);
            if (col < 8) {
                sb.append(JONCTION_BAS);
            }
        }
        sb.append(COIN_BAS_DROIT);
        return sb.toString();
    }

    
    private static String formaterValeur(int valeur) {
        return valeur == 0 ? " " : String.valueOf(valeur);
    }
}
