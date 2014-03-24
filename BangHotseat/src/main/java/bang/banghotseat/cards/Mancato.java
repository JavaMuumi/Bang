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
public class Mancato implements Card {
    
    private String suit;
    private int number;
    
    public Mancato(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile, Scanner asker) {
        
        boolean mancatoDone = false;
        while (mancatoDone == false) {
            
            System.out.println("You can dodge, do you want to? Please answer y or n");
            System.out.println("");
            String useMancato = asker.nextLine();
            System.out.println("");
            
            if (useMancato.equals("y")) {
                System.out.println("The shot missed!");
                System.out.println("");
                
                int indexOfMancato = 0;
                
                for (Card aMancato : playerInTurn.getHandCards()) {
                    if (aMancato.getName().contains("Mancato!")) {
                        indexOfMancato = playerInTurn.getHandCards().indexOf(aMancato);
                    }
                }
                playerInTurn.getHandCards().remove(indexOfMancato);
                mancatoDone = true;
            }
            else if (useMancato.equals("n")) {
                System.out.println("The shot hit!");
                System.out.println("");
                playerInTurn.loseHealth(1);
                mancatoDone = true;
            }
            else {
                System.out.println("Sorry, I cannot understand you");
                System.out.println("");
            }
        }
        mancatoDone = false;
        System.out.println(playerToFollow.getAvatar().toString()+ " continues");
        System.out.println("");
    }
    
    @Override
    public String getName() {
        return "Mancato!";
    }
    
    @Override
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String getType() {
        return "Mancato";
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Mancato!: " + number + " of " + suit;
    }
}