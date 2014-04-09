package GomokuBoard;

/**
 *
 * @author Andre Fabbri
 * Attention ! Le code proposé est loin d'être parfait et est susceptible d'être 
 * amélioré par vos soins. 
 */
public class Coup {
    public Position pos;
    public int id;
    public Coup(Position _pos,int _id)
    {
        pos= _pos;
        id = _id;
    }
    
    @Override
    public String toString()
    {
        return "Coup{" + "pos=" + pos + " id=" + id + '}';
    }
    
}
