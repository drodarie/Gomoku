/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import GameInterface.GameDisplay;

/**
 *
 * @author 4lexandre
 */
public class Main {
    public static void main(String[] args) {
        Gomoku jeu = new Gomoku(1);
        GameDisplay.afficherPlateau(jeu.getJeuDeGomoku().getPlateau());
        jeu.run();
    }
}
