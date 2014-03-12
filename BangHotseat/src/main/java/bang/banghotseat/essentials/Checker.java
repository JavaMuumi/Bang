/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.cards.Card;
import bang.banghotseat.cards.Deck;

/**
 *
 * @author Antti Korpi
 */
public class Checker {
    
    public Player playerInTurn;
    public Player playerToFollow;
    public Deck drawpile;
    public Deck discardpile;
    
    public Checker(Deck drawpile, Deck discardpile) {
        this.drawpile = drawpile;
        this.discardpile = discardpile;
    }
    
    public void setPlayerTurns(Player playerInTurn, Player playerToFollow) {
        this.playerInTurn = playerInTurn;
        this.playerToFollow = playerToFollow;
    }
    
    public void checkDinamite() {
        
        for (Card cardToCheck : playerInTurn.frontCards) {
            
            if (cardToCheck.toString().contains("Dinamite")) {
                
                Card topCard = drawpile.take(discardpile.getDeck());
                
                if (topCard.getSuit().equals("Spades")) {
                    
                    if (topCard.getNumber() == 2 || topCard.getNumber() == 3 || topCard.getNumber() == 4
                     || topCard.getNumber() == 5 || topCard.getNumber() == 6 || topCard.getNumber() == 7
                     || topCard.getNumber() == 8 || topCard.getNumber() == 9) {
                        
                        playerInTurn.loseHealth(3);

                        discardpile.place(cardToCheck);
                    }
                }
            }
        }
    }
}