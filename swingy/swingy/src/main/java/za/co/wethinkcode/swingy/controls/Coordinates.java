/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.controls;

import lombok.Getter;
import lombok.Setter;

public class Coordinates {
    @Getter @Setter private static int xs = DrawBoard.center;
    @Getter @Setter private static int ys = DrawBoard.center;
    
    public Coordinates(int x, int y){
        xs = x;
        ys = y;
    }
}
