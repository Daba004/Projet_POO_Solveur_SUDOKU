package sudoku;

import java.io.FileNotFoundException;

/*
 * Main.java
 * Point d'entree du programme. Orchestre le chargement,
 * la validation, la resolution et l'affichage de la grille.
 *
 * Usage :
 *   java sudoku.Main grille.txt   -> charge depuis un fichier
 *   java sudoku.Main              -> saisie manuelle
 */
public class Main {

    public static void main(String[] args) {

        try {
            Grille grille;

            // Si un fichier est passe en argument on le charge, sinon saisie manuelle
            if (args.length > 0) {
                grille = GrilleLoader.chargerDepuisFichier(args[0]);
            } else {
                grille = GrilleLoader.chargerDepuisSaisie();
            }

            // On verifie qu'il n'y a pas de doublons dans la grille de depart
            if (!grille.grilleInitialeValide()) {
                System.out.println("Erreur : la grille initiale contient des doublons.");
                return;
            }

            Afficheur.afficherGrilleInitiale(grille);

            // Resolution avec mesure du temps
            Solveur solveur = new Solveur(grille);
            long debut = System.currentTimeMillis();
            boolean resolu = solveur.resoudre();
            long duree = System.currentTimeMillis() - debut;

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
