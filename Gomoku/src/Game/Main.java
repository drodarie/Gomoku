/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 4lexandre
 */
public class Main {

    public static void main(String[] args) {
        String titreMenu = "Bienvenue sur le jeu de Gomoku !\nQue voulez-vous faire ? (appuyez sur entrée pour valider)";
        ArrayList<String> menu = new ArrayList<>();
        menu.add("0. Lancer le test");
        menu.add("1. Lancer une partie humain contre IA aléatoire");
        menu.add("2. Lancer une partie humain contre IA Monte-Carlo");
        menu.add("3. Lancer une partie humain contre humain sur un plateau torique");
        Scanner sc = new Scanner(System.in);
        int choix;
        System.out.println(titreMenu);
        for (String str : menu) {
            System.out.println(str);
        }
        do {
            choix = sc.nextInt();
        } while (choix < 0 || choix > menu.size());
        switch (choix) {
            case 1:
                Gomoku jeu1 = new Gomoku(1, 0);
                jeu1.run();
                break;
            case 2:
                Gomoku jeu2 = new Gomoku(1, 1);
                jeu2.run();
                break;
            case 3:
                GomokuTorique jeu3 = new GomokuTorique(2, 0);
                jeu3.run();
                break;
            default: {
                Gomoku.testGomoku();
            }
        }
    }
}
