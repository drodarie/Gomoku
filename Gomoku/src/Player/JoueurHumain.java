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
public class JoueurHumain extends Joueur<Plateau> {

    public JoueurHumain(int _id) {
        super(_id);
    }

    @Override
    public Coup genererCoup(Plateau etatJeu) {
        GameDisplay.afficherPlateau(etatJeu);
        boolean valide = false;
        int _id;
        Position p;
        do {
            p = GameScanner.scanPosition(etatJeu);
            try {
                _id = etatJeu.getIdCase(p.x, p.y);
                if (_id == 0) {
                    valide = true;
                } else {
                    System.out.println("La case (" + p.x + "," + p.y + ") n'est pas vide !");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("La position (" + p.x + "," + p.y + ") est en dehors du plateau !");
            }
        } while (!valide);
        return new Coup(p, id);
    }
}
