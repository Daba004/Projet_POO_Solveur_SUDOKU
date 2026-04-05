package sudoku;
 
/**
* Solveur - Resout la grille par backtracking recursif.
* @author Saynabou
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
 
       // 1. Chercher une case vide
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
 
       // 2. Plus de cases vides = grille terminee
       if (!trouveVide) return true;
 
       // 3. Essayer les chiffres 1 a 9
       for (int valeur = 1; valeur <= 9; valeur++) {
           nombreEtapes++;
           if (grille.estValide(ligne, colonne, valeur)) {
               grille.setCase(ligne, colonne, valeur);
               if (resoudre()) return true;
               grille.setCase(ligne, colonne, 0);
           }
       }
 
       // 4. Rien n'a marche
       return false;
   }
}
