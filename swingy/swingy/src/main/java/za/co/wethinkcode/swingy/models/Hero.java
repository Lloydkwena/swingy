/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.models;

import lombok.Getter;
import lombok.Setter;

public enum Hero {
    HULK("Hulk", "Big", 1, 1000, Weapon.SMASH, Armor.HEALNFACTOR),
    THOR("Thor", "God", 1, 1000, Weapon.HAMMBER, Armor.LIGHTNING),
    IRONMAN("Ironman", "IronArmor", 1, 1000, Weapon.HANDGUN, Armor.IRONSUITE),
    SUPERMAN("Superman", "Hope", 1, 1000, Weapon.LAYZEREYES, Armor.SUN);

    @Getter @Setter private String name;
    @Getter @Setter private String clas;
    @Getter @Setter private int lvl;
    @Getter @Setter private int ex;
    @Getter @Setter private Weapon w;
    @Getter @Setter private Armor a;
    @Getter @Setter private int Hitpoints;
    @Getter @Setter private int attack;
    @Getter @Setter private int defence;

    Hero(String name, String clas, int lvl, int ex, Weapon w, Armor a){
        this.name = name;
        this.clas = clas;
        this.lvl = lvl;
        this.ex = ex;
        this.w = w;
        this.a = a;
        //Updates below
        this.Hitpoints = Helm.SKYRIM.getLive() + 100;
        this.attack = Weapon.HAMMBER.getDamages() + 100;
        this.defence = Armor.LIGHTNING.getDefence() + 100;
    }
}