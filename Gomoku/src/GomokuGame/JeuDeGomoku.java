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
public class JeuDeGomoku {

    private Joueur joueurs[];
    private Joueur joueurCourant;
    private PlateauGomoku plateau;
    private int dernierIndex;
    private boolean premierCoup;

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

    public void setJoueur(int _ordre, Joueur _joueur) throws java.lang.IndexOutOfBoundsException {
        if (_ordre < 0 || _ordre >= joueurs.length) {
            throw new java.lang.IndexOutOfBoundsException();
        } else {
            joueurs[_ordre] = _joueur;
        }
    }

    public void setPlateau(PlateauGomoku _plateau) {
        plateau = _plateau;
    }

    private Joueur joueurSuivant() {
        int _idCourant = getDernierId();
        if (_idCourant == 0) {
            return joueurCourant;
        } else {
            dernierIndex = (dernierIndex + 1) % joueurs.length;
            return joueurs[dernierIndex];
        }
    }

    public int getDernierId() {
        if (premierCoup) {
            premierCoup = false;
            return 0;
        }
        return joueurCourant.getId();
    }

    public boolean partieTerminee() {
        Position pos = new Position(0,0);
        for(int i=0;i<plateau.getLongueur()-5;i++)
        {
            pos.x=i+1;
            for(int j=0;j<plateau.getLargeur();j++)
            {
                pos.y=j+1;
                if(plateau.CheckColonneId(pos, 5, joueurCourant.getId()))
                    return true;     
            }
        }
        for(int i=0;i<plateau.getLongueur();i++)
        {
            pos.x=i+1;
            for(int j=0;j<plateau.getLargeur()-5;j++)
            {
                pos.y=j+1;
                if(plateau.CheckLigneId(pos, 5, joueurCourant.getId()))
                    return true;     
            }
        }
        return false;
    }

    public boolean coupValide(Coup coup) {
        return plateau.getIdCase(coup.pos)==0;
    }

    public Joueur jouerPartie() {
        boolean coupValide;
        while (!partieTerminee()) {
            joueurCourant = joueurSuivant();
            Coup c;
            do {
                c = joueurCourant.genererCoup(plateau);
                coupValide = coupValide(c);
            } while (!coupValide);
            plateau.jouer(c);
        }
        return joueurCourant;
    }

}
