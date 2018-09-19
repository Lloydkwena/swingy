package za.co.wethinkcode.swingy.controls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import za.co.wethinkcode.swingy.models.Hero;

public class Database {
    
    private static BufferedWriter writer = null;

    public void openFile(String n, String na, String c, int l, int ex,
            String w, String a) throws Exception{
        try{
            if (writer == null){
                File data = new File("database.txt");
                FileWriter apnd = new FileWriter(data, true);
                writer = new BufferedWriter(apnd);
                if (data.exists() == true){
                    String message = String.format("%s,%s,%s,%d,%d,%s,%s",
                            n, na, c, l, ex, w, a);
                    writer.write(message);
                    writer.newLine();
                    writer.flush();
                }else if (data.exists() == false)
                    data.deleteOnExit();
            }
            else
                throw new Exception("Could not open the file");
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void chaItem(String name, String item){
        try{
            if (item.equals("Hulk")){
                Hero hulk = Hero.HULK;
                openFile(name, hulk.getName(), hulk.getClas(), hulk.getLvl(),
                        hulk.getEx(), hulk.getW().getWeapon(), hulk.getA().getBodyArmor());
            }else if (item.equals("Thor")){
                Hero thor = Hero.THOR;
                openFile(name, thor.getName(), thor.getClas(), thor.getLvl(),
                        thor.getEx(), thor.getW().getWeapon(), thor.getA().getBodyArmor());
            }else if (item.equals("Ironman")){
                Hero iron = Hero.IRONMAN;
                openFile(name, iron.getName(), iron.getClas(), iron.getLvl(),
                        iron.getEx(), iron.getW().getWeapon(), iron.getA().getBodyArmor());
            }else if (item.equals("Superman")){
                Hero man = Hero.SUPERMAN;
                openFile(name, man.getName(), man.getClas(), man.getLvl(),
                        man.getEx(), man.getW().getWeapon(), man.getA().getBodyArmor());
            }else
                throw new Exception("Error : Character unknown");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}