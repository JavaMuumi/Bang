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
public interface Avatar {
    
    int getMaxHealth();
    String getSpeciality();
    void drawCards(Deck drawpile, Deck discardpile, Player playerInTurn, Player playerToFollow);
}