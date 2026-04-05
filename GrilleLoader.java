package sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Classe GrilleLoader
 *
 * Responsable du chargement de la grille de Sudoku, soit depuis un fichier
 * texte, soit depuis la saisie manuelle de l'utilisateur.
 * Gere toutes les erreurs liees au chargement : fichier absent,
 * mauvais format, valeurs invalides.
 *
 * Responsable : Yvonne
 */
public class GrilleLoader {

    /**
     * Charge une grille depuis un fichier texte.
     * Le fichier doit contenir 9 lignes de 9 chiffres separes par des espaces.
     *
     * @param cheminFichier chemin vers le fichier a lire
     * @return un objet Grille initialise avec les donnees du fichier
     * @throws FileNotFoundException  si le fichier est introuvable
     * @throws FormatGrilleException  si le format du fichier est invalide
     */
    public static Grille chargerDepuisFichier(String cheminFichier)
            throws FileNotFoundException, FormatGrilleException {

        int[][] cases = new int[9][9];
        int numeroLigne = 0;

        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));

        try {
            String ligne;
            while ((ligne = reader.readLine()) != null) {

                if (ligne.trim().isEmpty()) continue;

                if (numeroLigne >= 9) {
                    throw new FormatGrilleException(
                        "Le fichier contient plus de 9 lignes.");
                }

                cases[numeroLigne] = analyserLigne(ligne, numeroLigne + 1);
                numeroLigne++;
            }
        } catch (java.io.IOException e) {
            throw new FormatGrilleException("Erreur de lecture du fichier : " + e.getMessage());
        } finally {
            try { reader.close(); } catch (java.io.IOException e) {}
        }

        if (numeroLigne < 9) {
            throw new FormatGrilleException(
                "Le fichier contient seulement " + numeroLigne + " ligne(s) au lieu de 9.");
        }

        return new Grille(cases);
    }

    /**
     * Charge une grille depuis la saisie manuelle de l'utilisateur.
     * Invite l'utilisateur a entrer 9 lignes de 9 chiffres separes par des espaces.
     *
     * @return un objet Grille initialise avec les donnees saisies
     * @throws FormatGrilleException si la saisie ne respecte pas le format
     */
    public static Grille chargerDepuisSaisie() throws FormatGrilleException {

        int[][] cases = new int[9][9];
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Saisie manuelle de la grille ===");
        System.out.println("Entrez 9 lignes de 9 chiffres separes par des espaces.");
        System.out.println("Le chiffre 0 represente une case vide.");
        System.out.println();

        for (int i = 0; i < 9; i++) {
            boolean ligneValide = false;
            while (!ligneValide) {
                System.out.print("Ligne " + (i + 1) + " : ");
                String saisie = scanner.nextLine();
                try {
                    cases[i] = analyserLigne(saisie, i + 1);
                    ligneValide = true;
                } catch (FormatGrilleException e) {
                    System.out.println("  -> " + e.getMessage() + " Reessayez.");
                }
            }
        }

        return new Grille(cases);
    }

    /**
     * Analyse une ligne de texte et retourne un tableau de 9 entiers.
     *
     * @param ligne       la ligne de texte a analyser
     * @param numeroLigne le numero de la ligne (pour les messages d'erreur)
     * @return tableau de 9 entiers (valeurs 0 a 9)
     * @throws FormatGrilleException si la ligne est mal formee ou contient des valeurs invalides
     */
    private static int[] analyserLigne(String ligne, int numeroLigne)
            throws FormatGrilleException {

        String[] parties = ligne.trim().split("\\s+");

        if (parties.length != 9) {
            throw new FormatGrilleException(
                "Ligne " + numeroLigne + " : attendu 9 valeurs, trouve " + parties.length + ".");
        }

        int[] resultat = new int[9];

        for (int j = 0; j < 9; j++) {
            try {
                int valeur = Integer.parseInt(parties[j]);
                if (valeur < 0 || valeur > 9) {
                    throw new FormatGrilleException(
                        "Ligne " + numeroLigne + ", colonne " + (j + 1)
                        + " : valeur invalide '" + valeur + "'. Doit etre entre 0 et 9.");
                }
                resultat[j] = valeur;
            } catch (NumberFormatException e) {
                throw new FormatGrilleException(
                    "Ligne " + numeroLigne + ", colonne " + (j + 1)
                    + " : '" + parties[j] + "' n'est pas un chiffre.");
            }
        }

        return resultat;
    }

    /**
     * Exception personnalisee pour les erreurs de format de la grille.
     */
    public static class FormatGrilleException extends Exception {
        /**
         * Constructeur.
         *
         * @param message description de l'erreur
         */
        public FormatGrilleException(String message) {
            super(message);
        }
    }
}