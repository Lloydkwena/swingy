/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.models;

import lombok.Getter;
import lombok.Setter;

public enum Helm {
    LOAF("Loaf", 20),
    HOUNDS("Hounds", 20),
    DRAGONPLATE("Dragonplate", 20),
    SKYRIM("Skyrim", 20);

    @Getter @Setter private String helms;
    @Getter @Setter private int live;

    Helm(String helms, int live){
        this.helms = helms;
        this.live = live;
    }
}
