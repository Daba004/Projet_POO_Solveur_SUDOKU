package sudoku;

/*
 * Grille.java
 * Modele de donnees de la grille de Sudoku 9x9.
 * C'est la classe centrale du projet : toutes les autres classes
 * passent par elle pour lire ou modifier les cases.
 */
public class Grille {

    // Taille fixe d'une grille de Sudoku
    public static final int TAILLE = 9;

    // Le tableau qui stocke les valeurs. 0 = case vide.
    private int[][] cases;

    // Cree une grille completement vide
    public Grille() {
        this.cases = new int[TAILLE][TAILLE];
    }

    /*
     * Cree une grille a partir d'un tableau existant.
     * On fait une copie case par case pour ne pas partager
     * le meme tableau en memoire avec l'appelant.
     */
    public Grille(int[][] cases) {
        this.cases = new int[TAILLE][TAILLE];
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                this.cases[i][j] = cases[i][j];
            }
        }
    }

    public int getCase(int ligne, int colonne) {
        return cases[ligne][colonne];
    }

    public void setCase(int ligne, int colonne, int valeur) {
        cases[ligne][colonne] = valeur;
    }

    /*
     * Verifie si on peut placer "valeur" en (ligne, colonne)
     * sans violer les trois regles du Sudoku.
     * Retourne false des qu'une des trois conditions echoue.
     */
    public boolean estValide(int ligne, int colonne, int valeur) {
        return !valeurDansLigne(ligne, valeur)
            && !valeurDansColonne(colonne, valeur)
            && !valeurDansSousGrille(ligne, colonne, valeur);
    }

    // Parcourt la ligne et cherche si la valeur y est deja presente
    private boolean valeurDansLigne(int ligne, int valeur) {
        for (int j = 0; j < TAILLE; j++) {
            if (cases[ligne][j] == valeur) {
                return true;
            }
        }
        return false;
    }

    // Pareil mais sur la colonne
    private boolean valeurDansColonne(int colonne, int valeur) {
        for (int i = 0; i < TAILLE; i++) {
            if (cases[i][colonne] == valeur) {
                return true;
            }
        }
        return false;
    }

    /*
     * Cherche si la valeur existe deja dans le bloc 3x3
     * qui contient la case (ligne, colonne).
     * On calcule le coin superieur gauche du bloc avec une division entiere.
     */
    private boolean valeurDansSousGrille(int ligne, int colonne, int valeur) {
        int debutLigne   = (ligne / 3) * 3;
        int debutColonne = (colonne / 3) * 3;

        for (int i = debutLigne; i < debutLigne + 3; i++) {
            for (int j = debutColonne; j < debutColonne + 3; j++) {
                if (cases[i][j] == valeur) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * Verifie que la grille de depart ne contient pas deja des doublons.
     * A appeler avant de lancer le solveur.
     * Astuce : on vide temporairement la case testee pour qu'elle
     * ne se detecte pas elle-meme comme doublon.
     */
    public boolean grilleInitialeValide() {
        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {
                int valeur = cases[i][j];
                if (valeur != 0) {
                    cases[i][j] = 0;
                    if (!estValide(i, j, valeur)) {
                        cases[i][j] = valeur;
                        return false;
                    }
                    cases[i][j] = valeur;
                }
            }
        }
        return true;
    }

    public int[][] getCases() {
        return cases;
    }
}
