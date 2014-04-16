/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;

import GameInterface.GameDisplay;
import GomokuBoard.*;

/**
 *
 * @author Dimitri
 */
public class JoueurAleatoire extends Joueur <Plateau>{
    public JoueurAleatoire (int _id){
        super (_id);
    }

    /**
     *
     * @param etatJeu
     * @return random coup
     */
    @Override 
    public Coup genererCoup (Plateau etatJeu){
        GameDisplay.afficherPlateau(etatJeu);
        int col=Utilitaire.monRandom(0,etatJeu.getLargeur()-1);
        int lig=Utilitaire.monRandom(0,etatJeu.getLongueur()-1);
        Position position = new Position (lig,col);
        return new Coup (position, id);
    }
}
