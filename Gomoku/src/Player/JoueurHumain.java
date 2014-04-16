/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;

import GameInterface.GameDisplay;
import GameInterface.GameScanner;
import GomokuBoard.*;
import java.util.*;
/**
 *
 * @author Dimitri
 */
public class JoueurHumain extends Joueur <Plateau>{
    
    public JoueurHumain (int _id){
        super (_id);
    }
    
    @Override
    public Coup genererCoup (Plateau etatJeu){
        GameDisplay.afficherPlateau(etatJeu);
        Position p = GameScanner.scanPosition(etatJeu);
        return new Coup (p, id);
    }
}
