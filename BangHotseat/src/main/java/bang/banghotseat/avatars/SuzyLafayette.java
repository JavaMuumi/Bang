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
 * Luokka mallintaa Suzy Lafayetten ominaisuuksia.
 *
 */
public class SuzyLafayette implements Avatar {

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
        return "As soon as she has no cards in hand, she draws a card.";
    }

    /**
     *
     * Vetaa vuorokortit kateen.
     *
     * @param round pelattava kierros
     */
    @Override
    public void drawCards(Round round) {
        round.getPlayerInTurn().getHandCards().add(round.getDrawpile().take(round.getDiscardpile()));
        round.getPlayerInTurn().getHandCards().add(round.getDrawpile().take(round.getDiscardpile()));
    }

    @Override
    public String toString() {
        return "Suzy Lafayette";
    }
}