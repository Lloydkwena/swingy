/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.controls;

import za.co.wethinkcode.swingy.Main;
import za.co.wethinkcode.swingy.controllors.Put_Char_OnBoard;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Update {

    public static Put_Char_OnBoard go_back[];

    //update and fight
    public void changes(String use, String nam,String cla,String ll,String ep,String wp,String am){

        Random rand = new Random();
        String con_gui = Main.gui_con;
        int win = rand.nextInt(10) + 1;
        if (win < 5){
            if (con_gui.equals("gui"))
                JOptionPane.showMessageDialog(null, "You lost");
            if (con_gui.equals("console"))
                System.out.println("YOU LOST...GAME OVER");
            System.exit(0);
        }
        else{
            try{
            	Save_Hero updata = new Save_Hero();
            	int lvl = Integer.parseInt(ll);
            	int xp = Integer.parseInt(ep);
            	if (xp >= 2450 && xp <= 4799)
            		lvl = 2;
            	if (xp >= 4800 && xp <= 8040)
            		lvl = 3;
            	if (xp >= 8050 && xp <= 12199)
            		lvl = 4;
            	if (xp >= 12200)
            		lvl = 5;
            	int exp = xp + 100;
            	String str = "";
                Reader file = new FileReader("database.txt");
                BufferedReader br = new BufferedReader(file);
                List<String> lines = new ArrayList<>();
                int index = 0;
                int index2 = 0;

                while ((str = br.readLine()) != null){
                    if (use.equals(str.split(",")[0])) {
                    	index2 = index;
                    }
                    lines.add(str);
                    index++;
                }
                str = use+"," + nam+"," + cla+"," +  Integer.toString(lvl)+"," + Integer.toString(exp)+"," + wp+"," + am;
                lines.set(index2, str);
                updata.file_update(lines);
                if (con_gui.equals("gui")){
                    JOptionPane.showMessageDialog(null, "You win");
                    System.exit(0);
                }
                if (con_gui.equals("console")){
                    System.out.println("You win");
                    System.exit(0);
                }


            }catch (Exception e){}

        }
    }
    // run away
    public  void flee(){
        String User = Save_Hero.Use;
        String name = Save_Hero.nam;
        String clas = Save_Hero.cla;
        String lvl = Integer.toString(Save_Hero.ll);
        String expi = Integer.toString(Save_Hero.ep);
        String weap = Save_Hero.wp;
        String arm = Save_Hero.am;
        String con_gui = Main.gui_con;
        Random rand = new Random();
        int win = rand.nextInt(3) + 1;
        if (con_gui.equals("gui")){
            if (win != 1){
                JOptionPane.showMessageDialog(null, "You cannot run away");
                changes(User,name,clas,lvl,expi,weap,arm);
            }
            else{
                JOptionPane.showMessageDialog(null, "You lucky bastard");
                System.exit(0);
            }
        }
        if (con_gui.equals("console")) {
            if (win != 1){
                System.out.println("You cannot run away");
                changes(User,name,clas,lvl,expi,weap,arm);
            }
            else{
                System.out.println("You lucky bastard");
                System.exit(0);
            }
        }
    }
}
