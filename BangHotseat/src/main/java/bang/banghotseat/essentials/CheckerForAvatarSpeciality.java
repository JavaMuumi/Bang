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
 * Luokka tarkastaa useissa eri tilanteissa, tuoko pelaajan avatar kulloinkin
 * mukaan jonkin erikoisominaisuuden.
 */
public class CheckerForAvatarSpeciality {

    private Round round;

    /**
     *
     * @param round pelattava kierros
     */
    public CheckerForAvatarSpeciality(Round round) {
        this.round = round;
    }

    /**
     *
     * @param playerToCheck pelaaja, joka tulee tarkistaa
     */
    public void checkSuzyLafayetteForEmptyHand(Player playerToCheck) {

        if (playerToCheck.getAvatar().toString().equals("Suzy Lafayette") && playerToCheck.getHandCards().isEmpty()) {
            playerToCheck.putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
        }
    }

    public void checkTwoCardsForLuckyDuke() {

        for (int i = 0; i < 2; i++) {
            Card topCard = round.getDrawpile().take(round.getDiscardpile());
            round.getPlayerInTurn().setLastCheckedCard(topCard);
            round.getDiscardpile().place(topCard);
        }
    }

    public boolean checkTwoLastCheckedCardsForLuckyDukeForHearts() {

        boolean thereWasHearts = false;

        for (Card isItHearts : round.getPlayerInTurn().getListOfLastCheckedCards()) {
            if (isItHearts.getSuit().equals("Hearts")) {
                thereWasHearts = true;
            }
        }
        return thereWasHearts;
    }

    public boolean checkIfDinamiteExplodesOnLuckyDuke() {

        boolean didDinamiteExplode = true;

        for (Card willThisDetonateDinamite : round.getPlayerInTurn().getListOfLastCheckedCards()) {
            if (!willThisDetonateDinamite.getSuit().equals("Spades") || willThisDetonateDinamite.getNumber() < 2 || willThisDetonateDinamite.getNumber() > 9) {
                didDinamiteExplode = false;
            }
        }
        return didDinamiteExplode;
    }

    /**
     *
     * @return totuusarvo onko vastustajan avatar Jourdonnais
     */
    public boolean checkJourdonnais() {

        if (round.getPlayerToFollow().getAvatar().toString().equals("Jourdonnais")) {
            round.getCheckerForEventsBeforeTurn().checkTopCard();
            return true;
        }
        return false;
    }
}
