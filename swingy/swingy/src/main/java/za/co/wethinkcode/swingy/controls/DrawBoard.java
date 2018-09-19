/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.controls;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.*;

import za.co.wethinkcode.swingy.controllors.Put_Char_OnBoard;
import za.co.wethinkcode.swingy.views.Fight_Flee;

public class DrawBoard {
    public static char[][] battleboard;
    public static String map = "";
    public static void buildbattleboard () {
        for (char[] row : battleboard) {
            Arrays.fill(row, '*');
        }
    }
    public static int center;
    public int level_up(int level){
        int fomula = (level-1)*5+10-(level%2);
        battleboard = new char[fomula][fomula];
        center =  ((level-1)*5+10-(level%2))/2;
        return (fomula);
    }

    public static void try_this(Put_Char_OnBoard mon[])
    {
        int i = 0;
        while ( i < mon.length){
            if (mon[i].xposition == Coordinates.getXs() &&
                    mon[i].yposition == Coordinates.getYs()){
                Fight_Flee f = new Fight_Flee();
                f.setVisible(true);
                f.setLocationRelativeTo(null);
                f.stats();
            }
            if (i == mon.length - 1){
                mon[i].xposition = Coordinates.getXs();
                mon[i].yposition = Coordinates.getYs();
            }
            battleboard[mon[i].yposition][mon[i].xposition] = mon[i].nameChar1;

            i++;
        }
        if (battleboard.length - 1 == mon[i - 1].xposition ||
                battleboard.length - 1 == mon[i - 1].yposition)
        {
            JOptionPane.showMessageDialog(null, "Congrats... you have won");
            System.exit(0);
        }
        if (mon[i - 1].xposition <= 0 || mon[i - 1].yposition <= 0)
        {
            JOptionPane.showMessageDialog(null, "Congrats... you have won");
            System.exit(0);
        }
    }
    public static String redrowBoard (Put_Char_OnBoard mon[]) {
        buildbattleboard ();
        try_this(mon);
        int i = 1;
        map = "";
        while(i <= 27) {map += "-";i++;}//Top line
        map += "\n";
        //Side lines
        for (int y = battleboard.length - 1; y > 0 ;y--) {
            for (int x = 0; x < battleboard[y].length;x++) {
                map += "|" + battleboard[y][x] + "|";
            }
            map += "\n";
        }
        i = 1;
        while(i <= 27) {map += "-";i++;}//Bottom line
        return map;
    }
    public static void console_map(Put_Char_OnBoard mon[]){
        Scanner sc = new Scanner(System.in);
        Monster_chars mon_c = new Monster_chars();
        String map = redrowBoard(mon);
        System.out.println(map);
        System.out.println("Enter Direction : North = n | West = w | South = s | East = e");
        String controls = sc.next();
        mon_c.con_control(controls, mon);
        Update.go_back = mon;
    }
}
