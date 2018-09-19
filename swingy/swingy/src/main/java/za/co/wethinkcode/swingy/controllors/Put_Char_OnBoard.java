package za.co.wethinkcode.swingy.controllors;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;
import za.co.wethinkcode.swingy.controls.Coordinates;
import za.co.wethinkcode.swingy.controls.DrawBoard;

public class Put_Char_OnBoard {

    @Getter @Setter private String name;
    @Getter @Setter private String clas;
    @Getter @Setter private int lvl;
    @Getter @Setter private int ex;
    @Getter @Setter private String wep;
    @Getter @Setter private String am;

    public int xposition = 0;
    public int yposition = 0;
    public char nameChar1 = 'B';
    DrawBoard b = new DrawBoard();

    public char[][] battleboard;

    public Put_Char_OnBoard(String name, String clas, int lvl, int ex, String w, String a){
        Random rand = new Random();
        this.name = name;
        this.clas = clas;
        this.lvl = lvl;
        this.ex = ex;
        this.wep = w;
        this.am = a;

        int fomula = b.level_up(lvl);
        this.battleboard = new char[fomula][fomula];
        int randomX = battleboard.length, randomY = battleboard.length;
        while (randomX == battleboard.length && randomY == battleboard.length)
        {
            randomX = rand.nextInt(battleboard.length) + 1;
            randomY = rand.nextInt(battleboard.length) + 1;
            if (randomX == Coordinates.getXs() &&  randomY == Coordinates.getYs())
                randomX += 1;
        }
        this.xposition = randomX - 1;
        this.yposition = randomY - 1;
        this.nameChar1 = this.name.charAt(0);
        battleboard[yposition][xposition] = this.nameChar1;
    }
}