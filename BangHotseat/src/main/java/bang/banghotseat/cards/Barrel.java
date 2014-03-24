/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.essentials.Player;
import java.util.Scanner;

/**
 *
 * @author Antti Korpi
 */
public class Barrel implements Card {
    
    private String suit;
    private int number;
    
    public Barrel(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile, Scanner asker) {
    }
    
    @Override
    public String getName() {
        return "Barrel";
    }
    
    @Override
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String getType() {
        return "Blue";
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Barrel: " + number + " of " + suit;
    }
}