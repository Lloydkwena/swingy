
package za.co.wethinkcode.swingy;

import za.co.wethinkcode.swingy.controls.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static String gui_con = "";
    public static Errors errors = new Errors();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Save_Hero info = new Save_Hero();
        DrawBoard b = new DrawBoard();
        Monster_chars mon_c = new Monster_chars();
        try {
            switch (args[0]) {
                case "gui":
                    Landing_Page page = new Landing_Page();
                    page.setVisible(true);
                    page.setLocationRelativeTo(null);
                    break;
                case "console":
                    System.out.println(RED + "Marvel Swingy - console");
                    System.out.println(YELLOW + "Please Enter 1 to Create Hero OR 2 To Select Hero :");
                    int nbr = sc.nextInt();
                    if (nbr == 1) {
                        System.out.println(BLUE + "Please Enter Hero Name :");
                        String name = "";
                        name = sc.next();
                        if (Character.isLetter(name.length()))
                            errors.ErrorInput(2);
                        String str = "";
                        Reader file = new FileReader("database.txt");
                        BufferedReader br = new BufferedReader(file);
                        while ((str = br.readLine()) != null) {
                            String index = str.split(",")[0];
                            if (index.compareTo(name) == 0) {
                                errors.ErrorInput(3);
                            }

                        }
                        System.out.println("Please Choose Avatar :" + " 1)Hulk " + "2)Superman " + "3)Ironman " + "4)Thor");
                        String Item = "";
                        Item = sc.next();
                        if (name.isEmpty() == true || Item.isEmpty() == true)
                            errors.ErrorInput(0);
                        if (Item.compareTo("Hulk") != 0 && Item.compareTo("Superman") != 0 &&
                                Item.compareTo("Ironman") != 0 && Item.equals("Thor") == false)
                            errors.ErrorInput(1);

                        info.chaItem(name, Item);
                        mon_c.con_sole(b, info);
                    }
                    if (nbr == 2) {
                        List<String> lines = new ArrayList<>();
                        System.out.println("Please Choose One Of The Heros Below :");
                        String str = "";
                        String name = null;
                        int i = 0;
                        Reader file = new FileReader("database.txt");
                        BufferedReader br = new BufferedReader(file);
                        while ((str = br.readLine()) != null) {
                            if (str.isEmpty() == true)
                                errors.ErrorInput(5);
                            lines.add(str);
                            System.out.print("Index " + i + ")");
                            System.out.println(name = str.split(",")[0]);
                            i++;
                        }
                        System.out.println("Enter Index of the Hero you want to use :");
                        int index = sc.nextInt();
                        String data = lines.get(index);
                        System.out.println("--- Your hero starts --- :");
                        System.out.println(data);
                        String[] select = data.split(",");
                        if (select.length != 7)
                            errors.ErrorInput(7);
                        int lvl = Integer.parseInt(select[3]);
                        int exp = Integer.parseInt(select[4]);
                        info.selected(select[0], select[1], select[2], lvl, exp, select[5], select[6]);
                        mon_c.con_sole(b, info);

                    } else
                        errors.ErrorInput(4);
                    break;
                default:
                    errors.ErrorInput(4);
               }
            }catch(Exception e){

                if (e.getClass().toString().compareTo("class java.lang.IndexOutOfBoundsException") == 0) {
                    System.out.println("Error : Index Is Out Bound");
                    System.exit(1);
                }
                System.out.println("Error : Unknown argument.. Please input console or gui to run the game");
                System.exit(1);
            }

    }
}


