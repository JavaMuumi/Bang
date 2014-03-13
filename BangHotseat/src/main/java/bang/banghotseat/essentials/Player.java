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
    
    private Avatar avatar;
    private int currentHealth;
    private List<Card> handCards = new ArrayList<>();
    private List<Card> frontCards = new ArrayList<>();
    private int counter = 1;
    
    public void setAvatar(AvatarRandomizer randomizer) {
        avatar = randomizer.giveAvatar();
    }
    
    public Avatar getAvatar() {
        return avatar;
    }

    public void setCurrentHealth() {
        currentHealth = avatar.getMaxHealth();
    }
    
    public int getCurrentHealth() {
        return currentHealth;
    }
    
    public void loseHealth(int amountToBeLost) {
        while (counter <= amountToBeLost) {
        currentHealth--;
        counter++;
        }
        counter = 1;
    }
    
    public List<Card> getHandCards() {
        return handCards;
    }
    
    public Card drawSpecificHandCard(int index) {
        Card toBeGiven = handCards.get(index);
        handCards.remove(index);
        return toBeGiven;
    }
    
    public void putCardIntoHand(Card cardToPutIn) {
        handCards.add(cardToPutIn);
    }
    
    public List<Card> getFrontCards() {
        return frontCards;
    }
    
    public void putCardInFront(Card toBePlaced) {
        frontCards.add(toBePlaced);
    }
    
    public void gainHealth() {
        if (currentHealth < avatar.getMaxHealth()) {
            currentHealth++;
        }
    }
}