package sudoku;

import java.io.FileNotFoundException;
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
        // TODO :
        // 1. Ouvrir le fichier (lever FileNotFoundException si absent)
        // 2. Lire 9 lignes, chacune avec 9 valeurs
        // 3. Verifier le nombre de lignes et de colonnes
        // 4. Verifier que chaque valeur est entre 0 et 9
        // 5. Retourner un objet Grille
        return null;
    }

    /**
     * Charge une grille depuis la saisie manuelle de l'utilisateur.
     * Invite l'utilisateur a entrer 9 lignes de 9 chiffres separes par des espaces.
     *
     * @return un objet Grille initialise avec les donnees saisies
     * @throws FormatGrilleException si la saisie ne respecte pas le format
     */
    public static Grille chargerDepuisSaisie() throws FormatGrilleException {
        // TODO :
        // 1. Afficher un message d'invite a l'utilisateur
        // 2. Lire 9 lignes depuis System.in
        // 3. Valider chaque ligne (9 valeurs entre 0 et 9)
        // 4. Retourner un objet Grille
        return null;
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
        // TODO :
        // 1. Decouper la ligne par espaces
        // 2. Verifier qu'il y a exactement 9 valeurs
        // 3. Convertir en entiers et verifier que chaque valeur est entre 0 et 9
        return null;
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
