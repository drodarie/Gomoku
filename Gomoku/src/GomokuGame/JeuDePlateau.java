/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomokuGame;

import GameInterface.GameDisplay;
import GomokuBoard.Coup;
import GomokuBoard.Plateau;
import Player.Joueur;
import java.util.ArrayList;

/**
 *
 * @author 4lexandre
 * @param <TPlateau>
 */
public abstract class JeuDePlateau <TPlateau extends Plateau>{
    protected Joueur joueurs[];
    protected Joueur joueurCourant;
    protected TPlateau plateau;
    protected int dernierIndex;
    protected boolean premierCoup;
    
    public abstract void setPlateau(TPlateau plateau);
    public abstract void setJoueur(int _ordre, Joueur _joueur);
    protected Joueur joueurSuivant() {
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
    
    public abstract boolean coupValide(Coup coup);
    
    public Joueur jouerPartie() {
       boolean coupValide;
       while (!plateau.partieTerminee(joueurCourant.getId())) {
           joueurCourant = joueurSuivant();
           plateau.jouer(joueurCourant.genererCoup(plateau));
       }
       return joueurCourant;
    }
    
    public TPlateau getPlateau()
    {
        return this.plateau;
    }
}
