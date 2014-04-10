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
 * Luokka mallintaa Pedro Ramirezin ominaisuuksia.
 * 
 */
public class PedroRamirez implements Avatar {

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
        return "He may draw his first card from the discard pile.";
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
        return "Pedro Ramirez";
    }
}