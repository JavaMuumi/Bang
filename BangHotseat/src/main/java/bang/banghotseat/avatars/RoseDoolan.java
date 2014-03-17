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
public class RoseDoolan implements Avatar {

    @Override
    public int getMaxHealth() {
        return 4;
    }

    @Override
    public String getSpeciality() {
        return "She sees all players at a distance decreased by 1.";
    }

    @Override
    public void drawCards(Deck drawpile, Deck discardpile, Player playerInTurn, Player playerToFollow) {
        playerInTurn.getHandCards().add(drawpile.take(discardpile));
        playerInTurn.getHandCards().add(drawpile.take(discardpile));
    }
    
    @Override
    public String toString() {
        return "Rose Doolan";
    }
}