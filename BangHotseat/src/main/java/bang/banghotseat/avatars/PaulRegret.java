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
public class PaulRegret implements Avatar {

    @Override
    public int getMaxHealth() {
        return 3;
    }

    @Override
    public void drawCards(Deck discardpile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}