/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameInterface.GameDisplay;
import GomokuBoard.Coup;
import GomokuBoard.Position;
import GomokuGame.*;
import Player.JoueurAleatoire;
import Player.JoueurHumain;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 4lexandre
 */
public class Gomoku {

    private JeuDeGomoku jeu;
    private JeuDeGomokuFactory fact;

    public Gomoku() {
        this.fact = new JeuDeGomokuFactory();
        this.jeu = (JeuDeGomoku) fact.CreerPartieAleatoireVSAleatoire(null);
    }

    public Gomoku(int nbJoueurHumain, int typeIA) {
        this.fact = new JeuDeGomokuFactory();
        switch (nbJoueurHumain) {
            case 1:
                switch (typeIA) {
                    case 1:
                        this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSMonteCarlo();
                        break;
                    default:
                        this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSAleatoire();
                }
                break;
            case 2:
                this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSHumain();
                break;
            default:
                switch (typeIA) {
                    case 1:
                        this.jeu = (JeuDeGomoku) fact.CreerPartieMonteCarloVSMonteCarlo();
                        break;
                    default:
                        this.jeu = (JeuDeGomoku) fact.CreerPartieAleatoireVSAleatoire();
                }
        }
    }

    public Gomoku(int nbJoueurHumain, ArrayList<Coup> situation) {
        this.fact = new JeuDeGomokuFactory();
        switch (nbJoueurHumain) {
            case 1:
                this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSAleatoire(situation);
                break;
            case 2:
                this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSHumain(situation);
                break;
            default:
                this.jeu = (JeuDeGomoku) fact.CreerPartieAleatoireVSAleatoire(situation);
        }
    }

    public void run() {
        jeu.jouerPartie();
    }

    public JeuDeGomoku getJeuDeGomoku() {
        return this.jeu;
    }

    public static void testGomoku() {
        Scanner sc = new Scanner(System.in);
        Gomoku jeu;
        JoueurHumain humain = new JoueurHumain(1);
        JoueurAleatoire alea = new JoueurAleatoire(2);
        // 1 ---------------
        System.out.print("Tapez sur une touche pour executer l'étape 1\n");
        sc.nextLine();
        jeu = new Gomoku(1, 0);
        System.out.println("Plateau vide généré. Affichage :");
        GameDisplay.afficherPlateau(jeu.getJeuDeGomoku().getPlateau());
        // 2 ---------------
        System.out.print("Tapez sur une touche pour executer l'étape 2\n");
        sc.nextLine();
        ArrayList<Coup> situation = new ArrayList<>();
        situation.add(new Coup(new Position(8 - 1, 9 - 1), 1));
        situation.add(new Coup(new Position(1 - 1, 1 - 1), 2));
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
