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
 * Luokka mallintaa Paul Regretin ominaisuuksia.
 * 
 */
public class PaulRegret implements Avatar {

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
        return "All players see him at a distance increased by 1.";
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
        return "Paul Regret";
    }
}