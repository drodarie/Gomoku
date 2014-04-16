/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GomokuGame;

import GomokuBoard.*;
import Player.*;
import java.util.ArrayList;

/**
 *
 * @author 4lexandre
 */
public class JeuDeGomokuFactory implements JeuDePlateauFactory {

    @Override
    @SuppressWarnings("empty-statement")
    public JeuDePlateau CreerPartieHumainVSHumain() {
        Joueur joueur1 = new JoueurHumain(1);
        Joueur joueur2 = new JoueurHumain(2);
        JeuDeGomoku jeu = new JeuDeGomoku(joueur1, joueur2);
        return jeu;
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire() {
        Joueur joueur1 = new JoueurHumain(1);
        Joueur joueur2 = new JoueurAleatoire(2);
        JeuDeGomoku jeu = new JeuDeGomoku(joueur1, joueur2);
        return jeu;
    }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire() {
        Joueur joueur1 = new JoueurAleatoire(1);
        Joueur joueur2 = new JoueurAleatoire(2);
        JeuDeGomoku jeu = new JeuDeGomoku(joueur1, joueur2);
        return jeu;
    }
    
    @Override
    public JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation) {
        JeuDeGomoku jeuGomo = new JeuDeGomoku(new JoueurHumain(1), new JoueurHumain(2));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

    @Override
    public JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation) {
        JeuDeGomoku jeuGomo = new JeuDeGomoku(new JoueurHumain(1), new JoueurAleatoire(2));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

    @Override
    public JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation) {
        JeuDeGomoku jeuGomo = new JeuDeGomoku(new JoueurAleatoire(1), new JoueurAleatoire(2));
        recreerPartie(situation, jeuGomo);
        return jeuGomo;
    }

    @Override
    public void recreerPartie(ArrayList<Coup> situation, JeuDePlateau jeuPlateau) {
        int idCourant = situation.get(situation.lastIndexOf(situation)).id;
        jeuPlateau.setPlateau(recreerPlateau(situation));
        for (int i = 0; i < jeuPlateau.joueurs.length; i++) {
            if (idCourant == jeuPlateau.joueurs[i].getId()) {
                jeuPlateau.dernierIndex = i;
                jeuPlateau.joueurCourant = jeuPlateau.joueurs[i];
                i = jeuPlateau.joueurs.length;
            }
        }
    }

    private PlateauGomoku recreerPlateau(ArrayList<Coup> situation) {
        PlateauGomoku plateauGomo = new PlateauGomoku();
        plateauGomo.initialiser(situation);
        return plateauGomo;
    }

}
