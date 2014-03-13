/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.cards.Card;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.Player;

/**
 *
 * @author Antti Korpi
 */
public class BlackJack implements Avatar {

    @Override
    public int getMaxHealth() {
        return 4;
    }

    @Override
    public String getName() {
        return "Black Jack";
    }
    
    @Override
    public void drawCards(Deck drawpile, Deck discardpile, Player playerInTurn, Player playerToFollow) {
        
        playerInTurn.getHandCards().add(drawpile.take(discardpile));
        
        Card drawnCard = drawpile.take(discardpile);
        if (drawnCard.getSuit().equals("Hearts") || drawnCard.getSuit().equals("Diamonds")) {
            playerInTurn.getHandCards().add(drawnCard);
            playerInTurn.getHandCards().add(drawpile.take(discardpile));
        }
        else {
            playerInTurn.getHandCards().add(drawnCard);
        }
    }
}