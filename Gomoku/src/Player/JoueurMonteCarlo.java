/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;

import GomokuBoard.*;
import java.util.ArrayList;

/**
 *
 * @author Dimitri
 */
public class JoueurMonteCarlo extends Joueur <Plateau>{
    
    public JoueurMonteCarlo (int _id, int _nbSimulation){
        super (_id);
    }
    
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Noeud meilleurCoup = new Noeud();
        ArrayList<Position> positionsPossibles = etatJeu.getEtatId();
        for (i:)
    }
}
