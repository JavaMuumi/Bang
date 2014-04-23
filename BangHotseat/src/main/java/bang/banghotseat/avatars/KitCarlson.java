/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.Round;

/**
 *
 * @author Antti Korpi
 *
 * Luokka mallintaa Kit Carlsonin ominaisuuksia.
 *
 */
public class KitCarlson implements Avatar {

    /**
     *
     * @return hahmon maksimikestot
     */
    @Override
    public int getMaxHealth() {
        return 4;
    }

    /**
     *
     * @return kuvaus avatarin kyvysta
     */
    @Override
    public String getSpeciality() {
        return "He looks at the top three cards of the deck and chooses the 2 to draw.";
    }

    /**
     *
     * @param round pelattava kierros
     */
    @Override
    public void drawCards(Round round) {
        
        for (int i = 0; i < 3; i++) {
            round.getPlayerInTurn().putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
        }
    }
    
    @Override
    public String toString() {
        return "Kit Carlson";
    }
}
