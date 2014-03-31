/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.essentials.Player;

/**
 *
 * @author Antti Korpi
 */
public class Gatling implements Card {
    
    private String suit;
    private int number;
    
    public Gatling(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile) {
        
        boolean thereWasAMancato = false;
        for (Card isItMancato : playerToFollow.getHandCards()) {

            if (isItMancato.getName().contains("Mancato!")) {
                discardpile.place(playerToFollow.drawSpecificHandCard(playerToFollow.getHandCards().indexOf(isItMancato)));
                thereWasAMancato = true;
                break;
            }
        }
        if (thereWasAMancato == false) {
            playerToFollow.loseHealth(1);
        }
    }
    
    @Override
    public String getName() {
        return "Gatling";
    }
    
    @Override
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String getType() {
        return "Orange";
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Gatling: " + number + " of " + suit;
    }
}