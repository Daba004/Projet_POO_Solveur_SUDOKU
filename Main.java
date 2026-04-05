package sudoku;
 
import java.io.FileNotFoundException;
 
/**
* Main - Point d'entree du programme.
* @author Saynabou
*/
public class Main {
 
   public static void main(String[] args) {
 
       try {
           Grille grille;
 
           // Charger depuis fichier ou saisie manuelle
           if (args.length > 0) {
               grille = GrilleLoader.chargerDepuisFichier(args[0]);
           } else {
               grille = GrilleLoader.chargerDepuisSaisie();
           }
 
           // Verifier qu'il n'y a pas de doublons dans la grille de depart
           if (!grille.grilleInitialeValide()) {
               System.out.println("Erreur : la grille initiale contient des doublons.");
               return;
           }
 
           // Afficher la grille avant resolution
           Afficheur.afficherGrilleInitiale(grille);
 
           // Lancer le solveur et mesurer le temps
           Solveur solveur = new Solveur(grille);
           long debut = System.currentTimeMillis();
           boolean resolu = solveur.resoudre();
           long duree = System.currentTimeMillis() - debut;
 
           // Afficher le resultat
           if (resolu) {
               Afficheur.afficherGrilleResolue(solveur.getGrille());
               System.out.println("Resolu en " + solveur.getNombreEtapes()
                   + " etapes | Temps : " + duree + " ms");
           } else {
               System.out.println("Aucune solution trouvee pour cette grille.");
           }
 
       } catch (FileNotFoundException e) {
           System.out.println("Erreur : fichier introuvable.");
       } catch (GrilleLoader.FormatGrilleException e) {
           System.out.println("Erreur de format : " + e.getMessage());
       }
   }
}
