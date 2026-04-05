package sudoku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/*
 * GrilleLoader.java
 * Gere le chargement de la grille, que ce soit depuis un fichier
 * ou depuis la saisie manuelle. Toutes les erreurs de format
 * sont detectees ici avant que le reste du programme ne demarre.
 */
public class GrilleLoader {

    /*
     * Lit un fichier texte et construit la grille a partir de son contenu.
     * Le fichier doit avoir exactement 9 lignes de 9 chiffres separes par des espaces.
     * Leve FileNotFoundException si le fichier n'existe pas,
     * et FormatGrilleException si le contenu ne respecte pas le format attendu.
     */
    public static Grille chargerDepuisFichier(String cheminFichier)
            throws FileNotFoundException, FormatGrilleException {

        int[][] cases = new int[9][9];
        int numeroLigne = 0;

        BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));

        try {
            String ligne;
            while ((ligne = reader.readLine()) != null) {

                // On ignore les lignes vides
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

    /*
     * Demande a l'utilisateur de saisir la grille ligne par ligne.
     * Si une ligne est mal saisie, on redemande uniquement cette ligne
     * sans repartir du debut.
     */
    public static Grille chargerDepuisSaisie() throws FormatGrilleException {

        int[][] cases = new int[9][9];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Saisie manuelle de la grille");
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

    /*
     * Decoupe une ligne de texte et verifie que les 9 valeurs
     * sont bien des chiffres entre 0 et 9.
     * Le parametre numeroLigne sert uniquement a produire des messages d'erreur clairs.
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

    // Exception personnalisee pour signaler un probleme de format dans la grille
    public static class FormatGrilleException extends Exception {
        public FormatGrilleException(String message) {
            super(message);
        }
    }
}
