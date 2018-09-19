/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.controls;

import za.co.wethinkcode.swingy.controllors.Put_Char_OnBoard;
import za.co.wethinkcode.swingy.models.Hero;
import za.co.wethinkcode.swingy.models.Monster;
import za.co.wethinkcode.swingy.views.BattleBoard;
import java.util.Scanner;

public class Monster_chars {
    //gets a list of monsters and hero for gui
    public void monster_char(BattleBoard b, Save_Hero info){
        try{
            Put_Char_OnBoard size[] = new Put_Char_OnBoard[5];
            Monster[] mon = Monster.values();
            for (int i = 0; i < mon.length;i++){
                size[i] = new Put_Char_OnBoard(mon[i].getName(),mon[i].getClas(),
                        mon[i].getLvl(),mon[i].getEx(),mon[i].getW().getWeapon(),
                        mon[i].getA().getBodyArmor());   
            }
            size[4] = new Put_Char_OnBoard(info.nam,info.cla,info.ll,info.ep,
                        info.wp,info.am);
            b.map(size);
        }catch (Exception e){
            System.out.println("Error : Cant put monsters on battleboard: " + e.getMessage());
            System.exit(1);
        }
    }
    //gets a list of monsters and hero for console
    public static Put_Char_OnBoard size[] = new Put_Char_OnBoard[5];
    public void con_sole(DrawBoard b, Save_Hero info){
        try{

            Monster[] mon = Monster.values();
            for (int i = 0; i < mon.length;i++){
                size[i] = new Put_Char_OnBoard(mon[i].getName(),mon[i].getClas(),
                        mon[i].getLvl(),mon[i].getEx(),mon[i].getW().getWeapon(),
                        mon[i].getA().getBodyArmor());
            }
            size[4] = new Put_Char_OnBoard(info.nam,info.cla,info.ll,info.ep,
                    info.wp,info.am);
            b.console_map(size);
        }catch (Exception e){
            System.out.println("Error : Cant put monsters on battleboard: " + e.getMessage());
            System.exit(1);
        }
    }

    // control hero
    public void con_control(String controls, Put_Char_OnBoard mon[]){
        Scanner sc = new Scanner(System.in);
        try{
            if (controls.equals("s")){
                Coordinates.setYs(Coordinates.getYs() - 1);
                String map = DrawBoard.redrowBoard(mon);
                System.out.println(map);
                System.out.println("Enter Direction : North = n | West = w | South = s | East = e");
                String cont = sc.next();
                con_control(cont, mon);
            }else if (controls.equals("n")){
                Coordinates.setYs(Coordinates.getYs() + 1);
                String map = DrawBoard.redrowBoard(mon);
                System.out.println(map);
                System.out.println("Enter Direction : North = n | West = w | South = s | East = e");
                String cont = sc.next();
                con_control(cont, mon);
            }else if (controls.equals("w")){
                Coordinates.setXs(Coordinates.getXs() - 1);
                String map = DrawBoard.redrowBoard(mon);
                System.out.println(map);
                System.out.println("Enter Direction : North = n | West = w | South = s | East = e");
                String cont = sc.next();
                con_control(cont, mon);
            }else if (controls.equals("e")){
                Coordinates.setXs(Coordinates.getXs() + 1);
                String map = DrawBoard.redrowBoard(mon);
                System.out.println(map);
                System.out.println("Enter Direction : North = n | West = w | South = s | East = e");
                String cont = sc.next();
                con_control(cont, mon);
            }else
                throw new Exception("Error : Drirection unknown");
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    // print out hero stats on console
    public void statistics(){
        String User = Save_Hero.Use;
        String name = Save_Hero.nam;
        String clas = Save_Hero.cla;
        String lvl = Integer.toString(Save_Hero.ll);
        String expi = Integer.toString(Save_Hero.ep);
        String weap = Save_Hero.wp;
        String arm = Save_Hero.am;

        Scanner sc = new Scanner(System.in);
        Update update = new Update();
        Hero h = Hero.THOR;
        String newLine = "";
        String[] data = {name,clas,lvl,expi,weap,arm,Integer.toString(h.getHitpoints()),
                Integer.toString(h.getAttack()),Integer.toString(h.getDefence())};
        String titles[] = {"Name \t: ","Class \t: ","Level \t: ","Exp \t: ",
                "Weapon \t: ","Armor \t: ","Hitpoints \t: ","Attack \t: ","Defence \t: "};
        for(int i = 0; i < data.length; i++) {
            newLine += titles[i] + data[i] + "\n";
        }
        System.out.println("HERO STATISTIC :");
        System.out.println(newLine);
        System.out.println("RUN = r | Fight = f");
        String run = sc.next();
        if (run.equals("f")){
            update.changes(User,name,clas,lvl,expi,weap,arm);
        }else if (run.equals("r"))
            update.flee();
        else{
            System.out.println("Error : Unknown command");
            System.exit(1);
        }

    }
}