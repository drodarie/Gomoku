package GameSimulator;
import GomokuBoard.Position;
import GomokuBoard.PlateauGomoku;
import GomokuBoard.Coup;
import java.util.ArrayList;
/**
 *
 * @author Andre Fabbri
 * Attention ! Le code proposé est loin d'être parfait et est susceptible d'être 
 * amélioré par vos soins. 
 */
public class SimulateurDeJeu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlateauGomoku p = new PlateauGomoku(6,7);
        System.out.println(p);
        System.out.println("Chargement d'une configuration initiale");
        ArrayList<Coup> positionInitiale = new ArrayList<>();
        positionInitiale.add(new Coup(new Position(1,1),2));
        positionInitiale.add(new Coup(new Position(1,2),4));
        positionInitiale.add(new Coup(new Position(2,1),2));
        p.initialiser(positionInitiale);
        System.out.println(p);
        System.out.println("Premier coup du joueur 4");
        p.jouer(new Coup(new Position(6, 7),4));
        System.out.println(p);
        System.out.println("Premier coup du joueur 2");
        p.jouer(new Coup(new Position(3, 2),2));
        System.out.println(p);
        System.out.println("Second coup du joueur 4 (invalide)");
        p.jouer(new Coup(new Position(3, 9),4));
        System.out.println("Second coup du joueur 4 (valide)");
        p.jouer(new Coup(new Position(3, 3),4));
        System.out.println(p);
        System.out.println("Annulation du dernier coup joué");
        p.annuler();
        System.out.println(p);
        System.out.println("Nouveau coup du joueur 4");
        p.jouer(new Coup(new Position(6, 6),4));
        System.out.println(p);
        Position p1=new Position(1,1);
        System.out.println("Verification Ligne (sur 2 cases)  pour le joueur 2 à partir de "+p1);
        System.out.println(p.CheckLigneId(p1, 2, 2));
        System.out.println("Verification Colonne (sur 2 cases) pour le joueur 2 à partir de "+p1);
        System.out.println(p.CheckColonneId(p1, 2, 2));
        Position p2=new Position(6,6);
        System.out.println("Verification Ligne (sur 2 cases)  pour le joueur 4 à partir de "+p2);
        System.out.println(p.CheckLigneId(p2, 2, 4));
        Position p3=new Position(6,7);
        System.out.println("Verification Ligne (sur 2 cases) pour le joueur 4 à partir de "+p3);
        System.out.println(p.CheckLigneId(p3, 2, 4));
        System.out.println("Reinitialisation du plateau");
        p.initialiser();
        System.out.println(p);
    }
}
