/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GomokuGame;

import GomokuBoard.Coup;
import GomokuBoard.PlateauToriqueGomoku;
import Player.*;
import java.util.ArrayList;

/**
 *
 * @author 4lexandre
 */
public class JeuToriqueDeGomokuFactory implements JeuDePlateauFactory {

    @Override
    @SuppressWarnings("empty-statement")
    public JeuDePlateau CreerPartieHumainVSHumain() {
        return new JeuToriqueDeGomoku(new JoueurHumain(1), new JoueurHumain(2));
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire() {
        return new JeuToriqueDeGomoku(new JoueurHumain(1), new JoueurAleatoire(2));
    }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire() {
        return new JeuToriqueDeGomoku(new JoueurAleatoire(1), new JoueurAleatoire(2));
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation) {
        JeuToriqueDeGomoku jeuGomo = new JeuToriqueDeGomoku(new JoueurHumain(1), new JoueurHumain(2));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation) {
        JeuToriqueDeGomoku jeuGomo = new JeuToriqueDeGomoku(new JoueurHumain(1), new JoueurAleatoire(2));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation) {
        JeuToriqueDeGomoku jeuGomo = new JeuToriqueDeGomoku(new JoueurAleatoire(1), new JoueurAleatoire(2));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

    @Override
    public void recreerPartie(ArrayList<Coup> situation, JeuDePlateau jeuPlateau) {
        int idCourant = situation.get(situation.lastIndexOf(situation) + 1).id;
        jeuPlateau.setPlateau(recreerPlateau(situation));
        for (int i = 0; i < jeuPlateau.joueurs.length; i++) {
            if (idCourant == jeuPlateau.joueurs[i].getId()) {
                jeuPlateau.dernierIndex = i;
                jeuPlateau.joueurCourant = jeuPlateau.joueurs[i];
                i = jeuPlateau.joueurs.length;
            }
        }
    }

    private PlateauToriqueGomoku recreerPlateau(ArrayList<Coup> situation) {
        PlateauToriqueGomoku plateauGomo = new PlateauToriqueGomoku();
        plateauGomo.initialiser(situation);
        return plateauGomo;
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSMonteCarlo() {
        return new JeuToriqueDeGomoku(new JoueurHumain(1), new JoueurMonteCarlo(2, 20));
    }

    @Override
    public JeuDePlateau CreerPartieMonteCarloVSMonteCarlo() {
        return new JeuToriqueDeGomoku(new JoueurMonteCarlo(1, 20), new JoueurMonteCarlo(2, 20));
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSMonteCarlo(ArrayList<Coup> situation) {
        JeuToriqueDeGomoku jeuGomo = new JeuToriqueDeGomoku(new JoueurHumain(1), new JoueurMonteCarlo(2, 20));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

    @Override
    public JeuDePlateau CreerPartieMonteCarloVSMonteCarlo(ArrayList<Coup> situation) {
        JeuToriqueDeGomoku jeuGomo = new JeuToriqueDeGomoku(new JoueurMonteCarlo(1, 20), new JoueurMonteCarlo(2, 20));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

}
