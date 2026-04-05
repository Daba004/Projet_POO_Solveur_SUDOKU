# Projet_POO_Solveur_SUDOKU

Projet de fin d'etude - Programmation Orientee Objet en Java
Licence 3 GLSI - Ecole Superieure Polytechnique de Dakar

---

## Groupe

| Membre            | Classe(s)                | Role                                            |
|-------------------|--------------------------|-------------------------------------------------|
| Daba SENE         | Grille.java              | Modele de donnees, validation des regles Sudoku |
| Arame Yvonne DIOP | GrilleLoader.java        | Chargement fichier/saisie, gestion des erreurs  |
| Aminata NDIAYE    | Afficheur.java           | Affichage console avec box-drawing characters   |
| Saynabou GUEYE    | Solveur.java + Main.java | Algorithme backtracking, point d'entree         |

---

## Structure du projet

    Projet_POO_Solveur_SUDOKU/
    |
    +-- src/
    |   +-- sudoku/
    |       +-- Grille.java
    |       +-- GrilleLoader.java
    |       +-- Afficheur.java
    |       +-- Solveur.java
    |       +-- Main.java
    |
    +-- test/
    |   +-- grille.txt
    |   +-- grille_invalide.txt
    |   +-- grille_impossible.txt
    |
    +-- .gitignore
    +-- README.md

---

## Compilation et execution

Compiler :

    cd src
    javac sudoku/*.java

Executer avec un fichier :

    java sudoku.Main ../test/grille.txt

Executer sans fichier (saisie manuelle) :

    java sudoku.Main

---

## Format du fichier d'entree

Le fichier doit contenir 9 lignes de 9 chiffres separes par des espaces.
Le chiffre 0 represente une case vide.

    5 3 0 0 7 0 0 0 0
    6 0 0 1 9 5 0 0 0
    0 9 8 0 0 0 0 6 0
    8 0 0 0 6 0 0 0 3
    4 0 0 8 0 3 0 0 1
    7 0 0 0 2 0 0 0 6
    0 6 0 0 0 0 2 8 0
    0 0 0 4 1 9 0 0 5
    0 0 0 0 8 0 0 7 9

---

## Erreurs gerees

| Erreur                            | Message affiche                                   |
|-----------------------------------|---------------------------------------------------|
| Fichier introuvable               | Erreur : fichier introuvable                      |
| Mauvais nombre de lignes/colonnes | Erreur de format : ...                            |
| Valeurs hors 0-9                  | Erreur de format : valeur invalide                |
| Grille initiale incoherente       | Erreur : la grille initiale contient des doublons |
| Grille sans solution              | Erreur : cette grille n'a pas de solution         |


