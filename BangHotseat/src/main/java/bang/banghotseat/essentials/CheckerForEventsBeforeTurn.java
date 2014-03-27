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
public class CheckerForEventsBeforeTurn {
    
    private int counter = 1;
    private Player playerInTurn;
    private Player playerToFollow;
    private Deck drawpile;
    private Deck discardpile;
    
    public CheckerForEventsBeforeTurn(Deck drawpile, Deck discardpile) {
        this.drawpile = drawpile;
        this.discardpile = discardpile;
    }
    
    public void setPlayerTurns(Player playerInTurn, Player playerToFollow) {
        this.playerInTurn = playerInTurn;
        this.playerToFollow = playerToFollow;
    }
    
    public void checkDinamite() {
//        
//        for (Card cardToCheck : playerInTurn.getFrontCards()) {
//            if (cardToCheck.toString().contains("Dinamite")) {
//                Card topCard = drawpile.take(discardpile);
//                if (topCard.getSuit().equals("Spades")) {
//                    if (topCard.getNumber() == 2 || topCard.getNumber() == 3 || topCard.getNumber() == 4
//                     || topCard.getNumber() == 5 || topCard.getNumber() == 6 || topCard.getNumber() == 7
//                     || topCard.getNumber() == 8 || topCard.getNumber() == 9) {
//                        System.out.println("The dynamite detonated!");
//                        System.out.println("");
//                        playerInTurn.loseHealth(3);
//                        discardpile.place(cardToCheck);
//                    }
//                    else {
//                        System.out.println("The dynamite didn't explode");
//                        System.out.println("");
//                    }
//                }
//                else {
//                    System.out.println("The dynamite didn't explode");
//                    System.out.println("");
//                }
//            }
//        }
    }
    
    public void checkPrigione() {
    }
}