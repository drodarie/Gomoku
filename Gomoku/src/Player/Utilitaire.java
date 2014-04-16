/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;

/**
 *
 * @author Dimitri
 */
public class Utilitaire {

    /**
     *
     * @param min
     * @param max
     * @return rand number between min and max
     */
    public static int monRandom (int min, int max){
        return min+(int) (Math.random()*(max-min));
    }
}
