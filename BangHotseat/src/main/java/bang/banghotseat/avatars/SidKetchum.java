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
 * Luokka mallintaa Sid Ketchumin ominaisuuksia.
 * 
 */
public class SidKetchum implements Avatar {

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
        return "He may discard 2 cards to regain one life point.";
    }

   @Override
    public void drawCards(Round round) {
        round.getPlayerInTurn().getHandCards().add(round.getDrawpile().take(round.getDiscardpile()));
        round.getPlayerInTurn().getHandCards().add(round.getDrawpile().take(round.getDiscardpile()));
    }
    
    @Override
    public String toString() {
        return "Sid Ketchum";
    }
}