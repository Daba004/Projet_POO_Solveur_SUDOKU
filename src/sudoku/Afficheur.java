package sudoku;

/*
 * Afficheur.java
 * Gere tout l'affichage de la grille en console.
 * Utilise les box-drawing characters pour un rendu structure.
 * Les cases vides (valeur 0) sont affichees comme des espaces.
 */
public class Afficheur {

    // Coins du cadre
    private static final String COIN_HAUT_GAUCHE = "\u2554";
    private static final String COIN_HAUT_DROIT  = "\u2557";
    private static final String COIN_BAS_GAUCHE  = "\u255A";
    private static final String COIN_BAS_DROIT   = "\u255D";

    // Jonctions du cadre exterieur
    private static final String JONCTION_HAUT    = "\u2566";
    private static final String JONCTION_BAS     = "\u2569";
    private static final String JONCTION_GAUCHE  = "\u2560";
    private static final String JONCTION_DROITE  = "\u2563";

    // Jonction centrale (croisement interieur)
    private static final String JONCTION_CENTRE  = "\u256C";

    // Segments de ligne
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
        int[][] cases = grille.getCases();

        System.out.println(ligneHaute());

        for (int ligne = 0; ligne < 9; ligne++) {

            // Construire la ligne de valeurs
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < 9; col++) {
                sb.append(LIGNE_V);
                sb.append(" ").append(formaterValeur(cases[ligne][col])).append(" ");
            }
            sb.append(LIGNE_V);
            System.out.println(sb.toString());

            // Apres la derniere ligne on ferme le cadre,
            // apres les lignes 2 et 5 on separe les sous-grilles,
            // sinon separation simple
            if (ligne == 8) {
                System.out.println(ligneBasse());
            } else {
                System.out.println(ligneSeparation());
            }
        }
    }

    // Bordure du haut : ╔═══╦═══╦ ... ╦═══╗
    private static String ligneHaute() {
        StringBuilder sb = new StringBuilder();
        sb.append(COIN_HAUT_GAUCHE);
        for (int col = 0; col < 9; col++) {
            sb.append(LIGNE_H);
            if (col < 8) sb.append(JONCTION_HAUT);
        }
        sb.append(COIN_HAUT_DROIT);
        return sb.toString();
    }

    // Ligne de separation entre deux rangees : ╠═══╬═══╬ ... ╬═══╣
    private static String ligneSeparation() {
        StringBuilder sb = new StringBuilder();
        sb.append(JONCTION_GAUCHE);
        for (int col = 0; col < 9; col++) {
            sb.append(LIGNE_H);
            if (col < 8) sb.append(JONCTION_CENTRE);
        }
        sb.append(JONCTION_DROITE);
        return sb.toString();
    }

    // Bordure du bas : ╚═══╩═══╩ ... ╩═══╝
    private static String ligneBasse() {
        StringBuilder sb = new StringBuilder();
        sb.append(COIN_BAS_GAUCHE);
        for (int col = 0; col < 9; col++) {
            sb.append(LIGNE_H);
            if (col < 8) sb.append(JONCTION_BAS);
        }
        sb.append(COIN_BAS_DROIT);
        return sb.toString();
    }

    // Retourne un espace pour les cases vides, le chiffre sinon
    private static String formaterValeur(int valeur) {
        return valeur == 0 ? " " : String.valueOf(valeur);
    }
}
