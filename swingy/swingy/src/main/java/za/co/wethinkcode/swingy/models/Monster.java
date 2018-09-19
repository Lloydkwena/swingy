/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.models;

import lombok.Getter;
import lombok.Setter;

public enum Monster {
    HULK("H", "Big", 1, 1000, Weapon.SMASH, Armor.HEALNFACTOR),
    THOR("T", "God", 1, 1000, Weapon.HAMMBER, Armor.LIGHTNING),
    IRONMAN("I", "IronArmor", 1, 1000, Weapon.HANDGUN, Armor.IRONSUITE),
    SUPERMAN("S", "Hope", 1, 1000, Weapon.LAYZEREYES, Armor.SUN);

    @Getter @Setter private String name;
    @Getter @Setter private String clas;
    @Getter @Setter private int lvl;
    @Getter @Setter private int ex;
    @Getter @Setter private Weapon w;
    @Getter @Setter private Armor a;

    Monster(String name, String clas, int lvl, int ex, Weapon w, Armor a){
        this.name = name;
        this.clas = clas;
        this.lvl = lvl;
        this.ex = ex;
        this.w = w;
        this.a = a;
    }
}
