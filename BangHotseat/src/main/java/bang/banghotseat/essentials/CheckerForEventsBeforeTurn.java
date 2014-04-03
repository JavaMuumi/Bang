/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.cards.Card;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka tarkastaa, tapahtuuko ennen vuoron
 * aloittamista jotakin erikoista.
 */
public class CheckerForEventsBeforeTurn {

    private Round round;

    /**
     *
     * @param round pelattava kierros
     */
    public CheckerForEventsBeforeTurn(Round round) {
        this.round = round;
    }

    /**
     *
     * @param playerInTurn      vuorossa oleva pelaaja
     * @param playerToFollow    seuraavana vuorossa oleva pelaaja
     */
    public void setPlayerTurns(Player playerInTurn, Player playerToFollow) {
        round.setPlayerInTurn(playerInTurn);
        round.setPlayerToFollow(playerToFollow);
    }

    /**
     *
     */
    public void checkDinamite() {

        boolean thereWasADinamite = false;
        boolean dinamiteDetonated = false;
        int indexOfDinamite = 0;

        for (Card cardToCheck : round.getPlayerInTurn().getFrontCards()) {

            if (cardToCheck.toString().contains("Dinamite")) {

                indexOfDinamite = round.getPlayerInTurn().getFrontCards().indexOf(cardToCheck);
                thereWasADinamite = true;

                Card topCard = round.getDrawpile().take(round.getDiscardpile());
                round.getPlayerInTurn().setLastCheckedCard(topCard);
                round.getDiscardpile().place(topCard);

                if (topCard.getSuit().equals("Spades") && topCard.getNumber() > 1 && topCard.getNumber() < 10) {
                    cardToCheck.function(round);
                    dinamiteDetonated = true;
                }
            }
        }
        if (thereWasADinamite) {
            if (dinamiteDetonated) {
                round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfDinamite));
            } else {
                if (round.getPlayerToFollow().getFrontCards().isEmpty()) {
                    round.getPlayerToFollow().putCardInFront(round.getPlayerInTurn().drawSpecificFrontCard(indexOfDinamite));
                } else if (round.getPlayerToFollow().getFrontCards().get(round.getPlayerToFollow().getFrontCards().size() - 1).getName().contains("Dinamite")) {
                } else {
                    round.getPlayerToFollow().putCardInFront(round.getPlayerInTurn().drawSpecificFrontCard(indexOfDinamite));
                }
            }
        }
    }

    /**
     *
     */
    public void checkPrigione() {
    }
}