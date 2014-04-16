/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GomokuGame;

import Player.*;
import GomokuBoard.*;

/**
 *
 * @author 4lexandre
 */
public class JeuDeGomoku extends JeuDePlateau<PlateauGomoku>{

    public JeuDeGomoku() {
        joueurs = new Joueur[2];
        joueurs[0] = new JoueurAleatoire(1);
        joueurs[1] = new JoueurAleatoire(2);
        plateau = new PlateauGomoku();
        premierCoup = true;
        dernierIndex = Utilitaire.monRandom(0, 1);
        joueurCourant = joueurs[dernierIndex];
    }

    public JeuDeGomoku(Joueur joueur1, Joueur joueur2) {
        joueurs = new Joueur[2];
        joueurs[0] = joueur1;
        joueurs[1] = joueur2;
        plateau = new PlateauGomoku();
        premierCoup = true;
        dernierIndex = Utilitaire.monRandom(0, 1);
        joueurCourant = joueurs[dernierIndex];
    }

    @Override
    public void setJoueur(int _ordre, Joueur _joueur) throws java.lang.IndexOutOfBoundsException {
        if (_ordre < 0 || _ordre >= joueurs.length) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            joueurs[_ordre] = _joueur;
        }
    }

    @Override
    public void setPlateau(PlateauGomoku _plateau) {
        plateau = _plateau;
    }

    @Override
    public boolean coupValide(Coup coup) {
        return plateau.getIdCase(coup.pos)==0;
    }
}
