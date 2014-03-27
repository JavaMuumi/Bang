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
public class Bang implements Card {

    private String suit;
    private int number;

    public Bang(String suit, int number) {
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
    
    public void theBangWasDodged() {
        
    }

    @Override
    public String getName() {
        return "BANG!";
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
        return "BANG!: " + number + " of " + suit;
    }
}