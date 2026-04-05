package sudoku;

/*
 * Solveur.java
 * Resout la grille par backtracking recursif.
 * Principe : on cherche une case vide, on essaie les chiffres 1 a 9,
 * et on revient en arriere si aucun ne fonctionne.
 */
public class Solveur {

    private Grille grille;
    private int nombreEtapes;

    public Solveur(Grille grille) {
        this.grille = grille;
        this.nombreEtapes = 0;
    }

    public int getNombreEtapes() {
        return nombreEtapes;
    }

    public Grille getGrille() {
        return grille;
    }

    public boolean resoudre() {

        // Chercher la prochaine case vide
        int ligne = -1, colonne = -1;
        boolean trouveVide = false;

        boucle:
        for (int i = 0; i < Grille.TAILLE; i++) {
            for (int j = 0; j < Grille.TAILLE; j++) {
                if (grille.getCase(i, j) == 0) {
                    ligne = i;
                    colonne = j;
                    trouveVide = true;
                    break boucle;
                }
            }
        }

        // Plus aucune case vide : la grille est complete
        if (!trouveVide) return true;

        // On essaie chaque chiffre de 1 a 9
        for (int valeur = 1; valeur <= 9; valeur++) {
            nombreEtapes++;
            if (grille.estValide(ligne, colonne, valeur)) {
                grille.setCase(ligne, colonne, valeur);
                if (resoudre()) return true;
                // Ca n'a pas marche, on remet la case a vide et on essaie le suivant
                grille.setCase(ligne, colonne, 0);
            }
        }

        // Aucun chiffre ne convient : on remonte (backtrack)
        return false;
    }
}
