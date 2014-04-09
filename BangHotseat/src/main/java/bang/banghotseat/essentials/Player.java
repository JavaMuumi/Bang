/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.avatars.Avatar;
import bang.banghotseat.cards.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka sisaltaa pelaajan tiedot ja hanen
 * korttiensa hallinnoinnin.
 */
public class Player {

    private Avatar avatar;
    private int currentHealth;
    private List<Card> handCards = new ArrayList<>();
    private List<Card> frontCards = new ArrayList<>();
    private List<Card> lastCheckedCards = new ArrayList<>();
    private Card cardWaitingForAReply;

    /**
     *
     * @param avatar    pelaajalle asetettava avatar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return  pelaajan avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     *
     */
    public void setCurrentHealth() {
        currentHealth = avatar.getMaxHealth();
    }

    /**
     *
     * @return  pelaajan tuonhetkiset kestot
     */
    public int getCurrentHealth() {
        return currentHealth;
    }

    /**
     *
     * @param amountToBeLost    menetettavien kestojen maara
     */
    public void loseHealth(int amountToBeLost) {

        int counter = 1;

        while (counter <= amountToBeLost) {
            currentHealth--;
            counter++;
        }
    }

    /**
     *
     * @return  lista pelaajan kasikorteista
     */
    public List<Card> getHandCards() {
        return handCards;
    }

    /**
     *
     * @param index vedettavan kasikortin indeksi
     * @return  vedetty kortti
     */
    public Card drawSpecificHandCard(int index) {

        Card toBeGiven = handCards.get(index);
        handCards.remove(index);
        return toBeGiven;
    }

    /**
     *
     * @return  vedetty kortti
     */
    public Card drawRandomHangCard() {
        
        Collections.shuffle(handCards);
        Card toBeGiven = drawSpecificHandCard(0);
        return toBeGiven;
    }

    /**
     *
     * @param cardToPutIn   asetettava kortti
     */
    public void putCardIntoHand(Card cardToPutIn) {
        handCards.add(cardToPutIn);
    }

    /**
     *
     * @return  lista pelaajan etukorteista
     */
    public List<Card> getFrontCards() {
        return frontCards;
    }

    /**
     *
     * @param index vedettavan kortin indeksi
     * @return  vedetty kortti
     */
    public Card drawSpecificFrontCard(int index) {
        Card toBeGiven = frontCards.get(index);
        frontCards.remove(index);
        return toBeGiven;
    }

    /**
     *
     * @param toBePlaced    asetettava kortti
     */
    public void putCardInFront(Card toBePlaced) {
        frontCards.add(toBePlaced);
    }

    /**
     *
     */
    public void gainHealth() {
        if (currentHealth < avatar.getMaxHealth()) {
            currentHealth++;
        }
    }

    /**
     *
     * @return  pelaajan etaisyys vastustajaan
     */
    public int getDistance() {

        int distance = 1;

        for (Card frontCard : frontCards) {
            if (frontCard.toString().contains("Mustang")) {
                distance++;
            }
        }
        if (avatar.toString().equals("Paul Regret")) {
            distance++;
        }
        return distance;
    }

    /**
     *
     * @return  pelaajan kantama
     */
    public int getReach() {
        int reach = 1;

        for (Card frontCard : frontCards) {
            if (frontCard.toString().contains("Schofield")) {
                reach++;
            } else if (frontCard.toString().contains("Remington")) {
                reach = reach + 2;
            } else if (frontCard.toString().contains("Rev.Carabine")) {
                reach = reach + 3;
            } else if (frontCard.toString().contains("Winchester")) {
                reach = reach + 4;
            } else if (frontCard.toString().contains("Mirino")) {
                reach++;
            }
        }
        if (avatar.toString().equals("Rose Doolan")) {
            reach++;
        }
        return reach;
    }

    /**
     *
     * @return  pelaajan kosketuksen kantama
     */
    public int getTouch() {
        int touch = 1;

        for (Card frontCard : frontCards) {
            if (frontCard.toString().contains("Mirino")) {
                touch++;
            }
        }
        if (avatar.toString().equals("Rose Doolan")) {
            touch++;
        }
        return touch;
    }

    /**
     *
     * @param lastCheckedCard   pakasta viimeksi taskistettu kortti
     */
    public void setLastCheckedCard(Card lastCheckedCard) {
        lastCheckedCards.add(lastCheckedCard);
    }

    /**
     *
     * @return  pakasta viimeksi tarkistettu kortti
     */
    public Card getLastCheckedCard() {
        return lastCheckedCards.get(lastCheckedCards.size() - 1);
    }
    
    /**
     *
     * @param lastCheckedCard   pakasta viimeksi taskistettu kortti
     */
    public void setCardWaitingForAReply(Card cardWaitingForAReply) {
        this.cardWaitingForAReply = cardWaitingForAReply;
    }
    
    /**
     * 
     * @return  pakasta viimeksi tarkastetut kortit
     */
    public List<Card> getListOfLastCheckedCards() {
        return lastCheckedCards;
    }

    /**
     *
     * @return  pakasta viimeksi tarkistettu kortti
     */
    public Card getCardWaitingForAReply() {
        return cardWaitingForAReply;
    }
    
    /**
     * 
     */
    public void clearListOfLastCheckedCards() {
        lastCheckedCards.clear();
    }
}