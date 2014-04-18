/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GomokuBoard.Coup;
import GomokuGame.JeuToriqueDeGomoku;
import GomokuGame.JeuToriqueDeGomokuFactory;
import java.util.ArrayList;

/**
 *
 * @author 4lexandre
 */
public class GomokuTorique {

    private JeuToriqueDeGomoku jeu;
    private JeuToriqueDeGomokuFactory fact;

    public GomokuTorique() {
        this.fact = new JeuToriqueDeGomokuFactory();
        this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieAleatoireVSAleatoire(null);
    }

    public GomokuTorique(int nbJoueurHumain, int typeIA) {
        this.fact = new JeuToriqueDeGomokuFactory();
        switch (nbJoueurHumain) {
            case 1:
                switch (typeIA) {
                    case 1:
                        this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieHumainVSMonteCarlo();
                        break;
                    default:
                        this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieHumainVSMonteCarlo();
                }
                break;
            case 2:
                this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieHumainVSHumain();
                break;
            default:
                switch (typeIA) {
                    case 1:
                        this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieMonteCarloVSMonteCarlo();
                        break;
                    default:
                        this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieMonteCarloVSMonteCarlo();
                }
        }
    }

    public GomokuTorique(int nbJoueurHumain, ArrayList<Coup> situation) {
        this.fact = new JeuToriqueDeGomokuFactory();
        switch (nbJoueurHumain) {
            case 1:
                this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieHumainVSAleatoire(situation);
                break;
            case 2:
                this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieHumainVSHumain(situation);
                break;
            default:
                this.jeu = (JeuToriqueDeGomoku) fact.CreerPartieAleatoireVSAleatoire(situation);
        }
    }

    public void run() {
        jeu.jouerPartie();
    }

    public JeuToriqueDeGomoku getJeuDeGomoku() {
        return this.jeu;
    }
}
