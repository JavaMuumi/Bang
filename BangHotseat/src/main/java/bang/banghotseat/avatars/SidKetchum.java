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
public class SidKetchum implements Avatar {

    @Override
    public int getMaxHealth() {
        return 4;
    }

    @Override
    public String getSpeciality() {
        return "He may discard 2 cards to regain one life point.";
    }

    @Override
    public void drawCards(Deck drawpile, Deck discardpile, Player playerInTurn, Player playerToFollow) {
        playerInTurn.getHandCards().add(drawpile.take(discardpile));
        playerInTurn.getHandCards().add(drawpile.take(discardpile));
    }
    
    @Override
    public String toString() {
        return "Sid Ketchum";
    }
}