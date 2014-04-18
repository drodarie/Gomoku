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
public class JoueurMonteCarlo extends Joueur<Plateau> {

    public boolean simuler(int id, Plateau etatJeu) {
        boolean test = false;
        ArrayList<Position> positionsSimulation = etatJeu.getEtatId(0);
        Position d = positionsSimulation.get(Utilitaire.monRandom(0, positionsSimulation.size() - 1));
        Coup cSimu = new Coup(d, id);
        etatJeu.jouer(cSimu);
        if (etatJeu.partieTerminee(id)) {

            test = true;
        }

        return test;
    }

    public JoueurMonteCarlo(int _id, int _nbSimulation) {
        super(_id);
    }
    
    public boolean simulerAdversaires (Plateau etatJeu,ArrayList<Integer> ids){
        int i=0;
        while (i < ids.size() - 1) {
                if (simuler(ids.get(i), etatJeu)) {
                    return false;
                }
                i++;
        }
        return true;
    }
    
    public boolean tourMonteCarlo (Noeud n, Plateau etatJeu, ArrayList<Integer> ids){
        Coup coup = null;
        ArrayList<Coup> sit = etatJeu.getSituation();
        boolean res;
        if (simuler(id, etatJeu)){
            res = true;
        }
        else if (simulerAdversaires(etatJeu, ids)) {
            res = tourMonteCarlo(n,etatJeu,ids);
        } 
        else {
            res = false;
        }
        etatJeu.initialiser(sit);
        return res;
    }
    
    @Override
    public Coup genererCoup(Plateau etatJeu) {
        Noeud meilleurCoup = null;
        ArrayList<Position> positionsPossibles = etatJeu.getEtatId(0);
        
        ArrayList<Integer> ids = etatJeu.getIdJoueurs();
        for (int i = 0; i < ids.size(); i++) {
            if (ids.get(i) == id) {
                ids.set(i, ids.get(ids.size() - 1));
                ids.set(ids.size() - 1, id);
                break;
            }
        }
        
        ArrayList<Coup> sit = etatJeu.getSituation();
        for (Position p : positionsPossibles) {
            Coup cCourant = new Coup(p, id);
            Noeud nCourant = new Noeud(cCourant);
            
            etatJeu.jouer(cCourant);
            if (etatJeu.partieTerminee(id)) {
                nCourant.ajouterVictoire();
            }
            else if (simulerAdversaires(etatJeu, ids)) {
                for (int i=0; i<100; i++){
                    if (tourMonteCarlo(nCourant,etatJeu,ids)){
                        nCourant.ajouterVictoire();
                    }
                    else{
                        nCourant.ajouterDefaite();
                    }
                }    
            } 
            else {
                nCourant.ajouterDefaite();
            }
            etatJeu.initialiser(sit);
            if (meilleurCoup == null || meilleurCoup.getMoyenne() < nCourant.getMoyenne()) {
                meilleurCoup = nCourant;
            }
        }
        return meilleurCoup.getCoup();
    }
}
