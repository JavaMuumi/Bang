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
public class PedroRamirez implements Avatar {

    @Override
    public int getMaxHealth() {
        return 4;
    }

    @Override
    public void drawCards(Deck discardpile) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}