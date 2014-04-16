package GomokuBoard;

/**
 *
 * @author Andre Fabbri
 * Attention ! Le code proposé est loin d'être parfait et est susceptible d'être 
 * amélioré par vos soins. 
 */
public class PlateauGomoku extends Plateau{
    
    public PlateauGomoku()
    {
        super(9,9);
    }
    
    public PlateauGomoku(int _longueur, int _largeur)
    {
        super(_longueur,_largeur);
    }
    public int getIdCase(Position pos) throws java.lang.IndexOutOfBoundsException
    {
        if(pos.x>=0&&pos.x<getLargeur()&&pos.y>=0&&pos.y<getLongueur()) {
            return etatPlateau[pos.x][pos.y];
        } 
        else throw new java.lang.IndexOutOfBoundsException();           
    }
    public boolean CheckLigneId(Position pos, int n,int id)
    {
        int x=pos.x;
        int y=pos.y;
        int y_end=y + n;  
        while(y <= largeur && y< y_end && etatPlateau[x-1][y-1] == id)
        {
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
    
    public boolean CheckColonneId(Position pos, int n,int id)
    {
        int x=pos.x;
        int y=pos.y;
        int x_end=x + n;  
        while(x <= longueur && x< x_end && etatPlateau[x-1][y-1] == id)
        {
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
        for(int i=0;i<longueur-5;i++)
        {
            pos.x=i+1;
            for(int j=0;j<largeur;j++)
            {
                pos.y=j+1;
                if(CheckColonneId(pos, 5, id))
                    return true;     
            }
        }
        for(int i=0;i<longueur;i++)
        {
            pos.x=i+1;
            for(int j=0;j<largeur-5;j++)
            {
                pos.y=j+1;
                if(CheckLigneId(pos, 5,id))
                    return true;     
            }
        }
        return false;
    }
}
