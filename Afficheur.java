package sudoku;

/**
 * Classe Afficheur
 *
 * Responsable de l'affichage de la grille de Sudoku dans la console,
 * en utilisant les caracteres speciaux de dessin de boite (box-drawing characters)
 * pour une presentation claire et structuree.
 * Les cases vides (valeur 0) sont affichees comme des espaces.
 *
 * Responsable : Amina
 */
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

    /**
     * Affiche la grille initiale avec un titre, avant resolution.
     *
     * @param grille la grille a afficher
     */
    public static void afficherGrilleInitiale(Grille grille) {
        System.out.println("\nGRILLE INITIALE");
        afficherGrille(grille);
    }

    /**
     * Affiche la grille resolue avec un titre.
     *
     * @param grille la grille resolue a afficher
     */
    public static void afficherGrilleResolue(Grille grille) {
        System.out.println("\nGRILLE RESOLUE");
        afficherGrille(grille);
    }

    /**
     * Affiche la grille en console avec les box-drawing characters.
     * Les sous-grilles 3x3 sont visuellement separees.
     * Les cases vides (0) sont affichees comme des espaces.
     *
     * @param grille la grille a afficher
     */
    public static void afficherGrille(Grille grille) {
        // TODO :
        // 1. Afficher la ligne du haut
        // 2. Pour chaque ligne de la grille :
        //    a. Afficher les valeurs separees par LIGNE_V
        //    b. Apres chaque groupe de 3 lignes (sauf la derniere),
        //       afficher une ligne de separation
        // 3. Afficher la ligne du bas
        // 4. Remplacer 0 par un espace dans l'affichage
    }

    /**
     * Construit la ligne du haut de la grille.
     * Exemple : ccc===ccc===ccc===ccc===ccc===ccc===ccc===ccc===ccc===ccc
     *
     * @return la chaine representant la bordure haute
     */
    private static String ligneHaute() {
        // TODO
        return "";
    }

    /**
     * Construit une ligne de separation entre sous-grilles.
     *
     * @return la chaine representant la separation
     */
    private static String ligneSeparation() {
        // TODO
        return "";
    }

    /**
     * Construit la ligne du bas de la grille.
     *
     * @return la chaine representant la bordure basse
     */
    private static String ligneBasse() {
        // TODO
        return "";
    }

    /**
     * Formate une valeur de case pour l'affichage.
     * Retourne un espace si la valeur est 0, sinon le chiffre.
     *
     * @param valeur la valeur de la case (0 a 9)
     * @return la chaine formatee
     */
    private static String formaterValeur(int valeur) {
        return valeur == 0 ? " " : String.valueOf(valeur);
    }
}
