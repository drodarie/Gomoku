package DefaultGomokuBoard;

/**
 *
 * @author Andre Fabbri
 * Attention ! Le code proposé est loin d'être parfait et est susceptible d'être 
 * amélioré par vos soins. 
 */
public class Position {
    public int x;
    public int y;
    
    public Position(int _x, int _y)
    {
        x = _x;
        y = _y;
      
    }

    @Override
    public String toString() {
        return "Position{" + "x=" + x + " y=" + y + '}';
    }
    
}
