/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.avatars.Avatar;
import bang.banghotseat.cards.Card;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antti Korpi
 */
public class Player {
    
    public Avatar avatar;
    public int currentHealth;
    public List<Card> handCards = new ArrayList<>();
    public List<Card> frontCards = new ArrayList<>();
    public int counter = 1;
    
    public void setAvatar(AvatarRandomizer randomizer) {
        avatar = randomizer.giveAvatar();
    }
    
    public void setCurrentHealth() {
        currentHealth = avatar.getMaxHealth();
    }
    
    public void loseHealth(int amountToBeLost) {
        while (counter <= amountToBeLost) {
        currentHealth--;
        counter++;
        }
        counter = 1;
    }
    
    public void gainHealth() {
        if (currentHealth < avatar.getMaxHealth()) {
            currentHealth++;
        }
    }
}