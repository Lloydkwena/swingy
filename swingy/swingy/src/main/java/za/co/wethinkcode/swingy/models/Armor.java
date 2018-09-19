/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.models;

import lombok.Getter;
import lombok.Setter;

public enum Armor {
    HEALNFACTOR("Healing factor", 80),
    LIGHTNING("Lightning", 80),
    IRONSUITE("IronSuit", 80),
    SUN("Sun", 80);

    @Getter @Setter String BodyArmor;
    @Getter @Setter int defence;

    Armor (String BodyArmor, int defence){
        this.BodyArmor = BodyArmor;
        this.defence = defence;
    }
}
