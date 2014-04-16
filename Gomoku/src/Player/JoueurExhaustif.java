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
public class JoueurExhaustif extends Joueur <Plateau>{
    
    public boolean simuler(int id, Plateau etatJeu){
        boolean test=false;
        ArrayList<Position> positionsSimulation = etatJeu.getEtatId(0);
        for (Position d: positionsSimulation){
            Coup cSimu = new Coup (d,id);
            etatJeu.jouer(cSimu);
            if (etatJeu.partieTerminee(id)){
                
                test=true;
                break;
            }
        }
        return test;
    }
    
    public JoueurExhaustif (int _id, int _nbSimulation){
        super (_id);
    }
    
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.getEtatId(0);
        ArrayList <Integer> ids = etatJeu.getIdJoueurs();
        for (int i=0; i<ids.size();i++){
            if (ids.get(i)==id){
                ids.set(i, ids.get(ids.size()-1));
                ids.set(ids.size()-1, id);
                break;
            }
        }
        
        for (Position p: positionsPossibles){
            Coup cCourant = new Coup (p,id);
            Noeud nCourant= new Noeud(cCourant);
            etatJeu.jouer(cCourant);
            
            
            ArrayList <Coup> sit = etatJeu.getSituation();
            int i=0;
            boolean test=true;
            
            while (i<ids.size()-1){
                ArrayList<Position> positionsSimulation = etatJeu.getEtatId(0);
                
                if (simuler(ids.get(i),etatJeu)){
                    test=false;
                    break;
                }
                i++;
            }
            if (test){
                if (simuler(id,etatJeu)){
                    nCourant.ajouterVictoire();
                }
                else{
                    nCourant.ajouterDefaite();
                }
            }
            etatJeu.initialiser(sit);
            if (meilleurCoup==null || meilleurCoup.getMoyenne()<nCourant.getMoyenne()){
                meilleurCoup=nCourant;
            }
            etatJeu.annuler();
        }
        return meilleurCoup.getCoup();
    }
}
