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
 * Luokka mallintaa El Gringon ominaisuuksia.
 *
 */
public class ElGringo implements Avatar {

    /**
     *
     * @return hahmon maksimikestot
     */
    @Override
    public int getMaxHealth() {
        return 3;
    }

    /**
     *
     * @return kuvaus avatarin kyvysta
     */
    @Override
    public String getSpeciality() {
        return "<html>Each time he is hit by a player,"
                + "<br>he draws a card from the hand of that player.</html>";
    }

    /**
     *
     * Vetaa vuorokortit kateen.
     *
     * @param round pelattava kierros
     */
    @Override
    public void drawCards(Round round) {
        
        for (int i = 0; i < 2; i++) {
            round.getPlayerInTurn().getHandCards().add(round.getDrawpile().take(round.getDiscardpile()));
        }
    }

    @Override
    public String toString() {
        return "El Gringo";
    }
}