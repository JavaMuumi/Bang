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
public class RevCarabine implements Card {
    
    private String suit;
    private int number;
    
    public RevCarabine(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile, Scanner asker) {
    }
    
    @Override
    public String getName() {
        return "Rev.Carabine";
    }
    
    @Override
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String getType() {
        return "Gun";
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Rev.Carabine: " + number + " of " + suit;
    }
}