package sudoku;

import java.io.FileNotFoundException;

/**
 * Classe Main
 *
 * Point d'entree du programme Solveur de Sudoku.
 * Gere les arguments de la ligne de commande, orchestre le chargement,
 * l'affichage et la resolution de la grille.
 *
 * Usage :
 *   Avec fichier  -> java sudoku.Main grille.txt
 *   Sans fichier  -> java sudoku.Main  (saisie manuelle)
 *
 * Responsable : Saynabou
 */
public class Main {

    public static void main(String[] args) {

        Grille grille = null;

        try {

            if (args.length > 0) {
                // Chargement depuis le fichier passe en argument
                grille = GrilleLoader.chargerDepuisFichier(args[0]);
            } else {
                // Aucun fichier fourni : saisie manuelle
                grille = GrilleLoader.chargerDepuisSaisie();
            }

            // Verifier que la grille initiale ne contient pas de doublons
            if (!grille.grilleInitialeValide()) {
                System.err.println("Erreur : la grille initiale contient des doublons.");
                return;
            }

            // Afficher la grille avant resolution
            Afficheur.afficherGrilleInitiale(grille);

            // Lancer la resolution et mesurer le temps
            long debut = System.currentTimeMillis();
            Solveur solveur = new Solveur(grille);
            boolean resolue = solveur.resoudre();
            long fin = System.currentTimeMillis();

            if (resolue) {
                Afficheur.afficherGrilleResolue(solveur.getGrille());
                System.out.println("Resolution en " + (fin - debut) + " ms ("
                        + solveur.getNombreEtapes() + " etapes).");
            } else {
                System.err.println("Erreur : cette grille n'a pas de solution.");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Erreur : fichier introuvable -> " + e.getMessage());
        } catch (GrilleLoader.FormatGrilleException e) {
            System.err.println("Erreur de format : " + e.getMessage());
        }
    }
}
