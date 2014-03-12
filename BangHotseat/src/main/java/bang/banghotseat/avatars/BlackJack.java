/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

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
    public void drawCards(Deck drawpile, Deck discardpile, Player playerInTurn, Player playerToFollow) {
        playerInTurn.handCards.add(drawpile.take(discardpile));
        playerInTurn.handCards.add(drawpile.take(discardpile));
    } 
}