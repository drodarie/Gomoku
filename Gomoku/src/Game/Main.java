/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import GameInterface.GameDisplay;
import GomokuBoard.Coup;
import GomokuBoard.Position;
import Player.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 4lexandre
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gomoku jeu;
        JoueurHumain humain = new JoueurHumain(1);
        JoueurAleatoire alea = new JoueurAleatoire(2);
        // 1 ---------------
        System.out.print("Tapez sur une touche pour executer l'étape 1\n");
        sc.nextLine();
        jeu = new Gomoku(1);
        System.out.println("Plateau vide généré. Affichage :");
        GameDisplay.afficherPlateau(jeu.getJeuDeGomoku().getPlateau());
        // 2 ---------------
        System.out.print("Tapez sur une touche pour executer l'étape 2\n");
        sc.nextLine();
        ArrayList<Coup> situation = new ArrayList<>();
        situation.add(new Coup(new Position(8,9), 1));
        situation.add(new Coup(new Position(1,1), 2));
        System.out.println("Situation créée.");
        jeu = new Gomoku(1, situation);
        System.out.println("Plateau généré. Affichage :");
        GameDisplay.afficherPlateau(jeu.getJeuDeGomoku().getPlateau());
        // 3 ---------------
        System.out.print("Tapez sur une touche pour executer l'étape 3\n");
        sc.nextLine();
        situation.add(humain.genererCoup(jeu.getJeuDeGomoku().getPlateau()));
        System.out.println("Situation créée.");
        jeu = new Gomoku(1, situation);
        System.out.println("Plateau généré. Affichage :");
        GameDisplay.afficherPlateau(jeu.getJeuDeGomoku().getPlateau());
        // 4 ---------------
        System.out.print("Tapez sur une touche pour executer l'étape 4\n");
        sc.nextLine();
        situation.add(alea.genererCoup(jeu.getJeuDeGomoku().getPlateau()));
        System.out.println("Situation créée.");
        jeu = new Gomoku(1, situation);
        System.out.println("Plateau généré. Affichage :");
        GameDisplay.afficherPlateau(jeu.getJeuDeGomoku().getPlateau());
        // 5 ---------------
        System.out.print("Tapez sur une touche pour executer l'étape 5\n");
        sc.nextLine();
        jeu.run();
    }
}
