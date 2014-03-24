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
public class WellsFargo implements Card {
    
    private String suit;
    private int number;
    
    public WellsFargo(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile, Scanner asker) {
        playerInTurn.putCardIntoHand(drawpile.take(discardpile));
        playerInTurn.putCardIntoHand(drawpile.take(discardpile));
        playerInTurn.putCardIntoHand(drawpile.take(discardpile));
    }
    
    @Override
    public String getName() {
        return "Wells Fargo";
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
        return "Wells Fargo: " + number + " of " + suit;
    }
}