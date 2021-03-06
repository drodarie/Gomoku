package GomokuBoard;

import java.util.ArrayList;
import java.lang.*;

/**
 *
 * @author Andre Fabbri
 * Attention ! Le code proposé est loin d'être parfait et est susceptible d'être 
 * amélioré par vos soins. 
 */
public abstract class Plateau {
    protected int longueur; //longueur = nombre de lignes
    protected int largeur; //largeur = nombre de colonnes
    protected int[][] etatPlateau;
    protected ArrayList<Coup> historique;
    
    public Plateau(int _longueur, int _largeur)
    {
        longueur = _longueur;
        largeur = _largeur;
        etatPlateau = new int[longueur][largeur];
        historique = new ArrayList<Coup>();
        initialiser();
    }
    public final void initialiser()
    {
        for(int i = 0 ; i < longueur ; i++)
        {
            for(int j = 0 ; j < largeur ; j++)
            {
                etatPlateau[i][j] = 0;
            }
        }
        historique.clear();
    }
    
    public final void initialiser(ArrayList<Coup> coupPrecedents)
    {
        initialiser();
        for (Coup c : coupPrecedents)
        {
            jouer(c);
        }
    }
 
    @Override
    public String toString()
    {
        StringBuilder st = new StringBuilder(); 
        for(int i = 0 ; i < longueur ; i++)
        {
            for(int j = 0 ; j < largeur ; j++)
            {
                st.append(etatPlateau[i][j]);
                st.append(" ");
            }
            st.append("\n");
        }         
         return st.toString();         
    }
    
    public void jouer(Coup c) 
    {
        if(c.pos.x >= 0 && c.pos.x < longueur && c.pos.y >= 0 && c.pos.y < largeur)
        {
            etatPlateau[c.pos.x][c.pos.y] = c.id;
            historique.add(c);
        }
        
        else
        {
            System.out.println("Coup en dehors du plateau !");
        }
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }

     public Coup annuler() {
        Coup c = historique.remove(historique.size() -1);
        jouer(new Coup(c.pos,0));
        return c;
    }
    public int getIdCase(int x, int y) throws IndexOutOfBoundsException
    {
        if(x<0||y<0||x>=this.getLongueur()||y>=this.getLargeur()) throw new IndexOutOfBoundsException();
        else return etatPlateau[x][y];
    }
    public ArrayList<Position> getEtatId(int id)
    {
        ArrayList<Position> l = new ArrayList<>();
        for(int i = 0 ; i < longueur ; i++)
        {
            for(int j = 0 ; j < largeur ; j++)
            {
                if (etatPlateau[i][j]==id){
                    l.add(new Position(i,j));
                }
            }
        }         
        return l;
    }

    public ArrayList<Coup> getSituation() {
        return (ArrayList<Coup>) historique.clone();
    }
    
    public ArrayList<Integer> getIdJoueurs(){
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i=0; i<longueur;i++){
            for(int j =0; j<largeur; j++){
                boolean test=true;
                if (etatPlateau[i][j]!=0){
                    for(int k=0; k<ids.size();k++){
                        if (ids.get(k)==etatPlateau[i][j]){
                            test=false;
                            break;
                        }
                    }
                    if (test) ids.add(etatPlateau[i][j]);
                }
            }
        }
        return ids;
    }
    
    public abstract boolean partieTerminee(int id);
}
