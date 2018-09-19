/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.wethinkcode.swingy.models;

import lombok.Getter;
import lombok.Setter;

public enum Weapon {
    SMASH("Smash", 7),
    HAMMBER("Hammer", 8),
    HANDGUN("HandGun", 6),
    LAYZEREYES("LayzerEyes", 9);

    @Getter @Setter private String weapon;
    @Getter @Setter private int damages;

    Weapon (String weapon, int damages){
        this.weapon = weapon;
        this.damages = damages;
    }
}
