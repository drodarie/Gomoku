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
    private boolean premierCoup;
    public JeuDeGomoku(){};
    public void setJoueur(int ordre, Joueur joueur)
    {
        
    }
    public void setPlateau(PlateauGomoku plateau)
    {
        
    }
    private Joueur joueurSuivant()
    {
        return new JoueurAleatoire(0);
    }
    public int getDernierId()
    {
        if(premierCoup)
        {
            premierCoup=false;
            return 0;
        }
        return joueurCourant.getId();
    }
    public boolean partieTerminee()
    {
        return false;
    }
    public boolean coupValide(Coup coup)
    {
        return true;
    }
    public Joueur jouerPartie()
    {
        boolean coupValide;
        while(!partieTerminee())
        {
            joueurCourant = joueurSuivant();
            Coup c;
            do
            {
                c = joueurCourant.genererCoup(plateau);
                coupValide = coupValide(c);
            }while(!coupValide);
            plateau.jouer(c);
            return joueurCourant;
        }
        return new JoueurAleatoire(0);
    }
    
    
    
    
}
