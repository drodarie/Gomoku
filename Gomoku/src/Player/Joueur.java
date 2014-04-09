/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;
import GomokuBoard.*;

/**
 *
 * @author Alexandre Galdéano
 * @param <T>
 */
public abstract class Joueur <T extends Plateau>  {
    protected int id;
    
    public Joueur(int _id)
    {
        id=_id;
    }
    public int getId()
    {
        return id;
    }
    public abstract Coup genererCoup(T etatJeu);
}
