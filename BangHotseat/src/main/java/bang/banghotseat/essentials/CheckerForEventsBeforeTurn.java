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
 * Luokka tarkastaa, tapahtuuko ennen vuoron aloittamista jotakin erikoista.
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
     * Asettaa kierroksella vuorossa olevan ja seuraavan pelaajan.
     *
     * @param playerInTurn vuorossa oleva pelaaja
     * @param playerToFollow seuraavana vuorossa oleva pelaaja
     */
    public void setPlayerTurns(Player playerInTurn, Player playerToFollow) {
        round.setPlayerInTurn(playerInTurn);
        round.setPlayerToFollow(playerToFollow);
    }

    /**
     *
     * Tarkastaa onko vuorossa olevan pelaajan edessa dynamiitti ja muiden
     * metodien kautta rajahtaako se, Lucky Duke huomioidaan erikseen.
     */
    public void checkDinamite() {

        boolean thereWasADinamite = false;
        boolean dinamiteDetonated = false;
        int indexOfDinamite = 0;

        for (Card cardToCheck : round.getPlayerInTurn().getFrontCards()) {

            if (cardToCheck.toString().contains("Dinamite")) {

                indexOfDinamite = round.getPlayerInTurn().getFrontCards().indexOf(cardToCheck);
                thereWasADinamite = true;

                if (round.getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {

                    round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

                    if (round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke()) {
                        cardToCheck.function(round);
                        dinamiteDetonated = true;
                    }
                } else {
                    checkTopCard();

                    if (round.getPlayerInTurn().getLastCheckedCard().getSuit().equals("Spades") && round.getPlayerInTurn().getLastCheckedCard().getNumber() > 1 && round.getPlayerInTurn().getLastCheckedCard().getNumber() < 10) {
                        cardToCheck.function(round);
                        dinamiteDetonated = true;
                    }
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
     * Tarkastaa onko pelaajan edessa vankilaa ja muiden metodien kautta
     * menettaako pelaaja sen vuoksi vuoronsa, Lucky Duke huomioidaan erikseen.
     */
    public boolean checkPrigione() {

        boolean prigioneDidNotStopTurn = true;
        boolean thereIsAPrigione = false;
        int indexOfPrigione = 0;

        for (Card isThisPrigione : round.getPlayerInTurn().getFrontCards()) {
            if (isThisPrigione.getName().contains("Prigione")) {
                indexOfPrigione = round.getPlayerInTurn().getFrontCards().indexOf(isThisPrigione);
                thereIsAPrigione = true;
            }
        }
        if (thereIsAPrigione && round.getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {
            round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();
            if (!round.getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts()) {
                round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfPrigione));
                prigioneDidNotStopTurn = false;
            } else {
                round.getPlayerInTurn().drawSpecificFrontCard(indexOfPrigione);
            }
        } else if (thereIsAPrigione) {
            round.getCheckerForEventsBeforeTurn().checkTopCard();
            if (!round.getPlayerInTurn().getLastCheckedCard().getType().equals("Hearts")) {
                round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfPrigione));
                prigioneDidNotStopTurn = false;
            } else {
                round.getPlayerInTurn().drawSpecificFrontCard(indexOfPrigione);
            }
        }
        return prigioneDidNotStopTurn;
    }

    /**
     *
     * Asettaa pakan paalimmaisen kortin pelaajan viimeksi tarkastettujen
     * korttien listaan.
     */
    public void checkTopCard() {

        Card topCard = round.getDrawpile().take(round.getDiscardpile());
        round.getPlayerInTurn().setLastCheckedCard(topCard);
        round.getDiscardpile().place(topCard);
    }

    /**
     *
     * Tarkastaa, rajahtaako dynamiitti annetulla kortilla.
     *
     * @param cardToCheck tarkastettava kortti
     * @return totuusarvo rajahtaako dynamiitti annetulla kortilla
     */
    public boolean dinamiteBlowsUp(Card cardToCheck) {
        
        boolean willDinamiteExplode = false;
        
        if (cardToCheck.getSuit().equals("Spades") && cardToCheck.getNumber() > 1 && cardToCheck.getNumber() < 10) {
            willDinamiteExplode = true;
        }
                
        return willDinamiteExplode;
    }
}