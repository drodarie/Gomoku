/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameInterface;

import GomokuBoard.Plateau;

/**
 *
 * @author 4lexandre
 */
public class GameDisplay {

    public static void afficherPlateau(Plateau unPlateau) {
        if (unPlateau.getLargeur() == 0 || unPlateau.getLongueur() == 0) {
            System.out.println("NULL Plateau");
        } else {
            String pla = " x";
            int id;
            for (int j = 0; j < unPlateau.getLargeur(); j++) {
                pla += ' '+String.valueOf(j);
            }
            pla +="\n"
                    +"y.";
            for (int j = 0; j < unPlateau.getLargeur(); j++) {
                pla +="--";
            }
            pla+="\n";
            for (int i = 0; i < unPlateau.getLongueur(); i++) {
                pla+=String.valueOf(i)+'|';
                for (int j = 0; j < unPlateau.getLargeur(); j++) {
                    pla += ' ';
                    id = unPlateau.getIdCase(i, j);
                    if (id == 0) {
                        pla += ' ';
                    } else {
                        pla += String.valueOf(id);
                    }
                }
                pla += '\n';
            }
            System.out.println(pla);
        }

    }
}
