/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameInterface;

import GomokuBoard.Plateau;
import GomokuBoard.Position;
import java.util.Scanner;

/**
 *
 * @author 4lexandre
 */
public class GameScanner {

    public static Position scanPosition(Plateau unPlateau) {
        boolean valide = false;
        Scanner sc = new Scanner(System.in);
        int x, y, id;
        System.out.println("x : ");
        x = sc.nextInt();
        System.out.println("y : ");
        y = sc.nextInt();
        try {
            id = unPlateau.getIdCase(x, y);
            if (id == 0) {
                valide = true;
            } else {
                System.out.println("La case (" + x + "," + y + ") n'est pas vide !");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La position (" + x + "," + y + ") est en dehors du plateau !");
        }

        return new Position(x, y);
    }
}
