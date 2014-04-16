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
        Scanner sc = new Scanner(System.in);
        int x, y;
        System.out.println("x : ");
        x = sc.nextInt();
        System.out.println("y : ");
        y = sc.nextInt();
        return new Position(x-1, y-1);
    }
}
