/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;

import GomokuBoard.*;
import java.util.ArrayList;

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
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.getEtatId(0);
        for (Position p: positionsPossibles){
            Coup cCourant = new Coup (p,id);
            Noeud nCourant= new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            
            
            ArrayList <Coup> sit = etatJeu.getSituation();
            
            ArrayList <Integer> ids = etatJeu.getIdJoueurs();
            for (int i=0; i<ids.size();i++){
                if (ids.get(i)==id){
                    ids.set(i, ids.get(ids.size()-1));
                    ids.set(ids.size()-1, id);
                    break;
                }
            }
            
            ArrayList<Position> positionsSimulation = etatJeu.getEtatId(0);
            for (int i=0; i<ids.size()-1;i++){
                for (Position d: positionsSimulation){
                    Coup cSimu = new Coup (d,ids.get(i));
                    
                }
            }
            if (meilleurCoup==null || meilleurCoup.getMoyenne()<nCourant.getMoyenne()){
                meilleurCoup=nCourant;
            }
            etatJeu.annuler();
        }
        return meilleurCoup.getCoup();
    }
}
