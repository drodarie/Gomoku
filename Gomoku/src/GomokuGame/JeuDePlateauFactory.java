/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomokuGame;

import GomokuBoard.*;
import java.util.ArrayList;

/**
 *
 * @author 4lexandre
 */
public interface JeuDePlateauFactory {
    JeuDePlateau CreerPartieHumainVSHumain(ArrayList<Coup> situation);
    JeuDePlateau CreerPartieHumainVSAleatoire(ArrayList<Coup> situation);
    JeuDePlateau CreerPartieAleatoireVSAleatoire(ArrayList<Coup> situation);
    void recreerPartie(ArrayList<Coup> situation, JeuDePlateau jeuPlateau);
}
