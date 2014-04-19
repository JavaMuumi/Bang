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
    private boolean thereIsADinamite;
    private boolean dinamiteDetonated;
    private int indexOfDinamite;
    private boolean thereIsAPrigione;
    private int indexOfPrigione;
    private int indexOfSameCard;

    /**
     *
     * @param round pelattava kierros
     */
    public CheckerForEventsBeforeTurn(Round round) {

        this.round = round;
        thereIsADinamite = false;
        dinamiteDetonated = false;
        thereIsAPrigione = false;
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

        for (Card cardToCheck : round.getPlayerInTurn().getFrontCards()) {
            if (cardToCheck.toString().contains("Dinamite")) {

                indexOfDinamite = round.getPlayerInTurn().getFrontCards().indexOf(cardToCheck);
                thereIsADinamite = true;

                if (round.getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {

                    if (round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke()) {
                        cardToCheck.function(round);
                        dinamiteDetonated = true;
                    }
                } else {
                    checkTopCard();

                    if (dinamiteBlowsUp(round.getPlayerInTurn().getLastCheckedCard())) {
                        cardToCheck.function(round);
                        dinamiteDetonated = true;
                    }
                }
            }
        }
        if (thereIsADinamite) {
            moveDinamite();
        }
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

    /**
     *
     * Kasittelee Dinamite-kortin siirtymisen sen tarkastamisen jalkeen.
     */
    public void moveDinamite() {

        boolean enemyAlreadyHasADinamite = sameKindOfCardIsAlreadyInFrontOfPlayerToFollow("Dinamite");

        if (dinamiteDetonated) {
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfDinamite));

        } else {
            if (enemyAlreadyHasADinamite) {
            } else {
                round.getPlayerToFollow().putCardInFront(round.getPlayerInTurn().drawSpecificFrontCard(indexOfDinamite));
            }
        }
    }

    /**
     *
     * @return totuusarvo onko vuorossa olevan pelaajan edessa Dinamite.
     */
    public boolean thereIsADinamite() {
        return thereIsADinamite;
    }

    /**
     *
     * Tarkastaa onko pelaajan edessa vankilaa ja muiden metodien kautta
     * menettaako pelaaja sen vuoksi vuoronsa, Lucky Duke huomioidaan erikseen.
     */
    public boolean checkPrigione() {

        boolean prigioneDidNotStopTurn = true;

        for (Card isThisPrigione : round.getPlayerInTurn().getFrontCards()) {
            if (isThisPrigione.getName().equals("Prigione")) {

                indexOfPrigione = round.getPlayerInTurn().getFrontCards().indexOf(isThisPrigione);
                thereIsAPrigione = true;
            }
        }
        if (thereIsAPrigione && round.getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {
            prigioneDidNotStopTurn = round.getCheckerForAvatarSpeciality().luckyDukeStaysInPrigione(indexOfPrigione);

        } else if (thereIsAPrigione) {
            prigioneDidNotStopTurn = removePrigione();
        }
        return prigioneDidNotStopTurn;
    }

    /**
     *
     * Poistaa Prigione-kortin vuorossa olevan pelaajan edesta ja palauttaa
     * tottusarvon, ettei se estanyt taman vuoroa.
     *
     * @return totuusarvo ettei Prigione estanyt vuoroa
     */
    public boolean removePrigione() {

        boolean prigioneDidNotStopTurn = true;

        round.getCheckerForEventsBeforeTurn().checkTopCard();

        if (!round.getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {
            prigioneDidNotStopTurn = false;
        }
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfPrigione));

        return prigioneDidNotStopTurn;
    }

    /**
     *
     * @return totuusarvo onko vuorossa olevan pelaajan edessa Prigione.
     */
    public boolean thereIsAPrigione() {
        return thereIsAPrigione;
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
     * Tarkastaa, onko seuraavana vuorossa olevan pelaajan edessa jo samanlainen
     * kortti.
     *
     * @return totuusarvo onko seuraavana vuorossa olevan pelaajan edessa jo
     * samanlainen kortti
     */
    public boolean sameKindOfCardIsAlreadyInFrontOfPlayerToFollow(String nameOfCard) {

        boolean sameCardIsAlreadyInFront = false;

        for (Card isTheSameCardAlreadyInFront : round.getPlayerToFollow().getFrontCards()) {
            if (isTheSameCardAlreadyInFront.getName().equals(nameOfCard)) {
                indexOfSameCard = round.getPlayerToFollow().getFrontCards().indexOf(isTheSameCardAlreadyInFront);
                sameCardIsAlreadyInFront = true;
            }
        }
        return sameCardIsAlreadyInFront;
    }

    /**
     *
     * @return kortin, joka oli samanlainen kuin pelattu kortti, indeksi
     */
    public int getIndexOfSameCard() {
        return indexOfSameCard;
    }

    /**
     *
     * Nollaa tiedon siita, onko vuorossa olevan pelaajan edessa Dinamite tai
     * Prigione.
     */
    public void forgetDinamiteAndPrigione() {
        thereIsADinamite = false;
        thereIsAPrigione = false;
    }
}