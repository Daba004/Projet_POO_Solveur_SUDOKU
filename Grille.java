package sudoku;

/**
 * Classe Grille
 *
 * Represente le modele de donnees d'une grille de Sudoku 9x9.
 * Contient les donnees de la grille et les methodes de validation
 * des regles du Sudoku (ligne, colonne, sous-grille 3x3).
 *
 * Responsable : Daba
 */
public class Grille {

    // Taille standard d'une grille de Sudoku
    public static final int TAILLE = 9;

    // La grille de jeu : 0 represente une case vide
    private int[][] cases;

    /**
     * Constructeur par defaut.
     * Initialise une grille vide (toutes les cases a 0).
     */
    public Grille() {
        // TODO : initialiser le tableau cases de taille TAILLE x TAILLE
    }

    /**
     * Constructeur avec parametre.
     * Initialise la grille a partir d'un tableau existant.
     *
     * @param cases tableau 9x9 representant la grille
     */
    public Grille(int[][] cases) {
        // TODO : copier le tableau passe en parametre dans this.cases
    }

    /**
     * Retourne la valeur d'une case.
     *
     * @param ligne   indice de la ligne (0 a 8)
     * @param colonne indice de la colonne (0 a 8)
     * @return la valeur de la case (0 si vide)
     */
    public int getCase(int ligne, int colonne) {
        // TODO
        return 0;
    }

    /**
     * Modifie la valeur d'une case.
     *
     * @param ligne   indice de la ligne (0 a 8)
     * @param colonne indice de la colonne (0 a 8)
     * @param valeur  valeur a placer (1 a 9, ou 0 pour vider)
     */
    public void setCase(int ligne, int colonne, int valeur) {
        // TODO
    }

    /**
     * Verifie si une valeur peut etre placee a une position donnee
     * sans violer les regles du Sudoku.
     *
     * @param ligne   indice de la ligne
     * @param colonne indice de la colonne
     * @param valeur  valeur a tester (1 a 9)
     * @return true si le placement est valide, false sinon
     */
    public boolean estValide(int ligne, int colonne, int valeur) {
        // TODO : verifier ligne, colonne et sous-grille 3x3
        return false;
    }

    /**
     * Verifie si la valeur est deja presente dans la ligne donnee.
     *
     * @param ligne  indice de la ligne
     * @param valeur valeur a chercher
     * @return true si la valeur est en double, false sinon
     */
    private boolean valeurDansLigne(int ligne, int valeur) {
        // TODO
        return false;
    }

    /**
     * Verifie si la valeur est deja presente dans la colonne donnee.
     *
     * @param colonne indice de la colonne
     * @param valeur  valeur a chercher
     * @return true si la valeur est en double, false sinon
     */
    private boolean valeurDansColonne(int colonne, int valeur) {
        // TODO
        return false;
    }

    /**
     * Verifie si la valeur est deja presente dans la sous-grille 3x3
     * contenant la case (ligne, colonne).
     *
     * @param ligne   indice de la ligne
     * @param colonne indice de la colonne
     * @param valeur  valeur a chercher
     * @return true si la valeur est en double, false sinon
     */
    private boolean valeurDansSousGrille(int ligne, int colonne, int valeur) {
        // TODO
        return false;
    }

    /**
     * Verifie si la grille initiale est coherente, c'est-a-dire qu'aucun
     * doublon n'existe sur les cases deja remplies.
     * A appeler avant de lancer la resolution.
     *
     * @return true si la grille initiale est valide, false sinon
     */
    public boolean grilleInitialeValide() {
        // TODO
        return true;
    }

    /**
     * Retourne le tableau brut de la grille.
     *
     * @return tableau 9x9
     */
    public int[][] getCases() {
        // TODO
        return cases;
    }
}
