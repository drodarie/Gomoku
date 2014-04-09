/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;

import GomokuBoard.Coup;
import GomokuBoard.Plateau;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
