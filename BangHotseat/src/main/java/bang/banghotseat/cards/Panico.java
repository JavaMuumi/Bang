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
public class Panico implements Card {
    
    private String suit;
    private int number;
    
    public Panico(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile) {
    }
    
    @Override
    public String getName() {
        return "Panico!";
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
        return "Panico!: " + number + " of " + suit;
    }
}