/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomokuBoard;

/**
 *
 * @author Dimitri
 */
public class Noeud {
    private int nbVictoire;
    private int nbSimulation;
    private Coup coup;
    
    public Noeud (Coup _coup){
        coup=_coup;
        nbVictoire=0;
        nbSimulation=0;
    }

    public int getNbVictoire() {
        return nbVictoire;
    }

    public int getNbSimulation() {
        return nbSimulation;
    }
    
    public Coup getCoup() {
        return coup;
    }
    
    public void ajouterVictoire (){
        nbVictoire++;
        nbSimulation++;
    }
    
    public void ajouterDefaite (){
        nbSimulation++;
    }
    
    public int getMoyenne (){
        return (int) (nbVictoire/nbSimulation);
    }
}
