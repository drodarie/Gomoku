/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GomokuBoard.Coup;
import GomokuGame.*;
import java.util.ArrayList;

/**
 *
 * @author 4lexandre
 */
public class Gomoku {

    private JeuDeGomoku jeu = new JeuDeGomoku();
    private JeuDeGomokuFactory fact;

    public Gomoku() {
        this.jeu = (JeuDeGomoku) fact.CreerPartieAleatoireVSAleatoire(null);
    }

    public Gomoku(int nbJoueurHumain) {
        switch (nbJoueurHumain) {
            case 1:
                this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSAleatoire();
                break;
            case 2:this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSHumain();
                break;
            default:this.jeu = (JeuDeGomoku) fact.CreerPartieAleatoireVSAleatoire();
        }
    }
    
    public Gomoku(int nbJoueurHumain, ArrayList<Coup> situation) {
        switch (nbJoueurHumain) {
            case 1:this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSAleatoire(situation);
                break;
            case 2:this.jeu = (JeuDeGomoku) fact.CreerPartieHumainVSHumain(situation);
                break;
            default:this.jeu = (JeuDeGomoku) fact.CreerPartieAleatoireVSAleatoire(situation);
        }
    }

    public void run() {
        jeu.jouerPartie();
    }
    
    public JeuDeGomoku getJeuDeGomoku()
    {
        return this.jeu;
    }
}
