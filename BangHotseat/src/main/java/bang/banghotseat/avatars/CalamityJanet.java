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
public class CalamityJanet implements Avatar {

    @Override
    public int getMaxHealth() {
        return 4;
    }

    @Override
    public String getSpeciality() {
        return "She can play BANG! cards as Missed! cards and vice versa.";
    }

    @Override
    public void drawCards(Deck drawpile, Deck discardpile, Player playerInTurn, Player playerToFollow) {
        playerInTurn.getHandCards().add(drawpile.take(discardpile));
        playerInTurn.getHandCards().add(drawpile.take(discardpile));
    }
    
    @Override
    public String toString() {
        return "Calamity Janet";
    }
}