package sudoku;

/**
 * Classe Solveur
 *
 * Implemente l'algorithme de resolution du Sudoku par backtracking (retour arriere).
 * Le principe : essayer chaque chiffre de 1 a 9 dans chaque case vide,
 * et revenir en arriere si aucun chiffre ne convient.
 *
 * Responsable : Saynabou
 */
public class Solveur {

    // La grille a resoudre
    private Grille grille;

    // Nombre d'etapes effectuees pendant la resolution
    private int nombreEtapes;

    /**
     * Constructeur.
     * Initialise le solveur avec la grille a resoudre.
     *
     * @param grille la grille de Sudoku a resoudre
     */
    public Solveur(Grille grille) {
        // TODO : affecter la grille et initialiser nombreEtapes a 0
    }

    /**
     * Lance la resolution de la grille par backtracking recursif.
     * Modifie la grille directement en remplissant les cases vides.
     *
     * Algorithme :
     * 1. Trouver la prochaine case vide (valeur == 0)
     * 2. Si aucune case vide, la grille est resolue -> retourner true
     * 3. Pour chaque valeur de 1 a 9 :
     *    a. Si grille.estValide(ligne, colonne, valeur) :
     *       - Placer la valeur
     *       - Incrementer nombreEtapes
     *       - Appel recursif a resoudre()
     *       - Si l'appel retourne true -> retourner true
     *       - Sinon -> remettre la case a 0 (backtrack)
     * 4. Aucune valeur ne fonctionne -> retourner false
     *
     * @return true si la grille a ete resolue, false si elle est impossible
     */
    public boolean resoudre() {
        // TODO
        return false;
    }

    /**
     * Retourne le nombre d'etapes effectuees pendant la resolution.
     *
     * @return nombre d'etapes du backtracking
     */
    public int getNombreEtapes() {
        return nombreEtapes;
    }

    /**
     * Retourne la grille (resolue ou non).
     *
     * @return la grille
     */
    public Grille getGrille() {
        return grille;
    }
}
