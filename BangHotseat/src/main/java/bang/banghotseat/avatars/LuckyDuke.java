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
 * Luokka mallintaa Lucky Duken ominaisuuksia.
 *
 */
public class LuckyDuke implements Avatar {

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
        return "Each time he 'draws!', he flips the top two cards and chooses one.";
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
        return "Lucky Duke";
    }
}