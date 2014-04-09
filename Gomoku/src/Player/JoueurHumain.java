/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Player;

import GomokuBoard.*;
import java.util.Scanner;
/**
 *
 * @author Dimitri
 */
public class JoueurHumain extends Joueur <Plateau>{
    
    public JoueurHumain (int _id){
        super (_id);
    }
    
    @Override
    public Coup genererCoup (Plateau etatJeu){
        int col = -1, lig = -1;
        Scanner scan = new Scanner(System.in);
        
        while (col<1 || col>etatJeu.getLongueur()){
            System.out.println("Entrez la colonne de la case.");
            col = Integer.parseInt(scan.nextLine());
        }
        while (lig<1 || lig>etatJeu.getLongueur()){
            System.out.println("Entrez la colonne de la case.");
            lig = Integer.parseInt(scan.nextLine());
        }
        
        Position position = new Position (lig,col);
        return new Coup (position, id);
    }
}
