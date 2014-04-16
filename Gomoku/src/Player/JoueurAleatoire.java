/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Player;

import GameInterface.GameDisplay;
import GomokuBoard.*;
import java.util.ArrayList;

/**
 *
 * @author Dimitri
 */
public class JoueurAleatoire extends Joueur<Plateau> {

    public JoueurAleatoire(int _id) {
        super(_id);
    }

    /**
     *
     * @param etatJeu
     * @return random coup
     */
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        int col, lig, index;
        GameDisplay.afficherPlateau(etatJeu);
        ArrayList<Position> positionsSimulation = etatJeu.getEtatId(0);
        index = Utilitaire.monRandom(0, positionsSimulation.size()-1);
        System.out.println(String.valueOf(index));
        Position d = positionsSimulation.get(index);
        return new Coup(d, id);
    }
}
