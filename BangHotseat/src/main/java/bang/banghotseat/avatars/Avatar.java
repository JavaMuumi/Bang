/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.cards.Deck;

/**
 *
 * @author Antti Korpi
 */
public interface Avatar {
    
    int getMaxHealth();
    void drawCards(Deck discardpile);
}