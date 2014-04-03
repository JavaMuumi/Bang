/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.Round;
import bang.banghotseat.cards.Card;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka mallintaa Black Jackin ominaisuuksia.
 * 
 */
public class BlackJack implements Avatar {

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
        return "He shows the second card he draws. On Heart or Diamonds, he draws one more card.";
    }
    
    @Override
    public void drawCards(Round round) {
        
        round.getPlayerInTurn().getHandCards().add(round.getDrawpile().take(round.getDiscardpile()));
        
        Card drawnCard = round.getDrawpile().take(round.getDiscardpile());
        if (drawnCard.getSuit().equals("Hearts") || drawnCard.getSuit().equals("Diamonds")) {
            round.getPlayerInTurn().getHandCards().add(drawnCard);
            round.getPlayerInTurn().getHandCards().add(round.getDrawpile().take(round.getDiscardpile()));
        }
        else {
            round.getPlayerInTurn().getHandCards().add(drawnCard);
        }
    }
    
    @Override
    public String toString() {
        return "Black Jack";
    }
}