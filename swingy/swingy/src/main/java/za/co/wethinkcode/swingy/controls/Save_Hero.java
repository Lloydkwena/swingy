/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.controls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import za.co.wethinkcode.swingy.models.Hero;
import static za.co.wethinkcode.swingy.Main.errors;

public class Save_Hero {
    
    public static String Use;
    public static String nam;
    public static String cla;
    public static int ll;
    public static int ep;
    public static String wp;
    public static String am;
    DrawBoard lv = new DrawBoard();
       
    public void selected(String User,String name,String clas,int lvl,
            int exp,String wep,String a){
        Use = User;
        nam = name;
        cla = clas;
        ll = lvl;
        ep = exp;
        wp = wep;
        am = a;
    }
// Update hero data after the game
    public void file_update(List<String> lines) throws Exception{
        BufferedWriter writer = null;
        try{
            if (writer == null){
                File data = new File("database.txt");
                FileWriter apnd = new FileWriter(data);
                writer = new BufferedWriter(apnd);
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                    writer.flush();
                }
                writer.close();
            }
          
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


   //Write data to file when creating hero
    public void openFile(String n, String na, String c, int l, int ex,String w, String amr) throws Exception{
        BufferedWriter writer = null;
        try{
            Use = n;
            nam = na;
            cla = c;
            ll = l;
            ep = ex;
            wp = w;
            am = amr;
            if (l < 1 || ex < 1000)
                errors.ErrorInput(6);
            lv.level_up(l);
            if (writer == null){
                File data = new File("database.txt");
                FileWriter apnd = new FileWriter(data, true);
                writer = new BufferedWriter(apnd);
                if (data.exists() == true){
                    String message = String.format("%s,%s,%s,%d,%d,%s,%s",n, na, c, l, ex, w, amr);
                    writer.write(message);
                    writer.newLine();
                    writer.flush();
                }else if (data.exists() == false){
                    data.createNewFile();
                    String message = String.format("%s,%s,%s,%d,%d,%s,%s",
                            n, na, c, l, ex, w, amr);
                    writer.write(message);
                    writer.newLine();
                    writer.flush();
                    writer.close();
                }
            }
            else{
                throw new Exception("Could not open the file");
            }
          
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public void chaItem(String name, String item){
       try {
            switch (item) {
                case "Hulk":
                    Hero hulk = Hero.HULK;
                    openFile(name, hulk.getName(), hulk.getClas(), hulk.getLvl(),
                            hulk.getEx(), hulk.getW().getWeapon(), hulk.getA().getBodyArmor());
                    break;
                case "Thor":
                    Hero thor = Hero.THOR;
                    openFile(name, thor.getName(), thor.getClas(), thor.getLvl(),
                            thor.getEx(), thor.getW().getWeapon(), thor.getA().getBodyArmor());
                    break;
                case "Ironman":
                    Hero iron = Hero.IRONMAN;
                    openFile(name, iron.getName(), iron.getClas(), iron.getLvl(),
                            iron.getEx(), iron.getW().getWeapon(), iron.getA().getBodyArmor());
                    break;
                case "Superman":
                    Hero man = Hero.SUPERMAN;
                    openFile(name, man.getName(), man.getClas(), man.getLvl(),
                            man.getEx(), man.getW().getWeapon(), man.getA().getBodyArmor());
                    break;
                default:
                    throw new Exception("Error: Please enter a different name");
            }

       } catch (Exception e) {
            e.printStackTrace();
       }
    }
}
