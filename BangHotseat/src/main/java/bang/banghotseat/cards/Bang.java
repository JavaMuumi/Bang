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
    public void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile, Scanner asker) {

        int distance = playerToFollow.getDistance();
        int reach = playerInTurn.getReach();
        
        if (distance > reach) {
            System.out.println("The other player is out of reach! You cannot play a BANG!");
            System.out.println("");
        }
        else {
            System.out.println(playerToFollow.getAvatar().toString() + ", a BANG! has been aimed at you!");
            System.out.println("Will it hit?");
            System.out.println(playerInTurn.getAvatar().toString() + ", please look away now");
            System.out.println("");
            
            boolean mancatoHasBeenPlayed = false;
            
            for (Card isItMancato : playerToFollow.getHandCards()) {
                
                if (isItMancato.getName().contains("Mancato!")) {
                    isItMancato.function(playerToFollow, playerInTurn, drawpile, discardpile, asker);
                    mancatoHasBeenPlayed = true;
                    break;
                }
            }
            if (mancatoHasBeenPlayed == false) {
                
                System.out.println("You have no Mancato! cards and you cannot cannot dodge");
                System.out.println("You take a hit!");
                
                playerToFollow.loseHealth(1);
        
                System.out.println("Enter any letter so the enemy won't know if you have Mancato! or not");
                System.out.println("");
        
                String mancatoDistractor = asker.nextLine();
                System.out.println("");

                System.out.println(playerInTurn.getAvatar().toString() + " continues");
                System.out.println("");
            }
        }
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