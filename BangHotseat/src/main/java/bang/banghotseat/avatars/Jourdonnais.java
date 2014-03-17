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
public class Jourdonnais implements Avatar {

    @Override
    public int getMaxHealth() {
        return 4;
    }

    @Override
    public String getSpeciality() {
        return "Whenever he is the target of a BANG!, he may 'draw!': on a Heart, he is missed.";
    }

    @Override
    public void drawCards(Deck drawpile, Deck discardpile, Player playerInTurn, Player playerToFollow) {
        playerInTurn.getFrontCards().add(drawpile.take(discardpile));
        playerInTurn.getFrontCards().add(drawpile.take(discardpile));
    }
    
    @Override
    public String toString() {
        return "Jourdonnais";
    }
}