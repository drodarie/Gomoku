/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GomokuBoard;

/**
 *
 * @author 4lexandre
 */
public class PlateauToriqueGomoku extends PlateauGomoku {
    @Override
    public boolean CheckLigneId(Position pos, int n,int id)
    {
        int x=pos.x;
        int y=pos.y;
        int y_end=y + n;  
        while(y <= largeur && y< y_end && etatPlateau[x-1][y-1] == id)
        {
            y%=largeur;
            y++;
        }
        if(y == y_end )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public boolean CheckColonneId(Position pos, int n,int id)
    {
        int x=pos.x;
        int y=pos.y;
        int x_end=x + n;  
        while(x< x_end && etatPlateau[x-1][y-1] == id)
        {
            x%=longueur;
            x++;
        }
        if(x == x_end )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public boolean partieTerminee(int id) {
        Position pos = new Position(0,0);
        for(int i=0;i<longueur;i++)
        {
            pos.x=i+1;
            for(int j=0;j<largeur;j++)
            {
                pos.y=j+1;
                if(CheckColonneId(pos, 5, id)||CheckLigneId(pos, 5,id))
                    return true;     
            }
        }
        return false;
    }
}
