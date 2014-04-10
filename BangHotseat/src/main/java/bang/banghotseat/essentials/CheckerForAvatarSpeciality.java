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
     * Nostaa pakasta pelaajalle yhden kortin kateen, jos pelaajan avatar on
     * Suzy Lafayette.
     *
     * @param playerToCheck pelaaja, joka tulee tarkistaa
     */
    public void checkSuzyLafayetteForEmptyHand(Player playerToCheck) {

        if (playerToCheck.getAvatar().toString().equals("Suzy Lafayette") && playerToCheck.getHandCards().isEmpty()) {
            playerToCheck.putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
        }
    }

    /**
     *
     * Asettaa kaksi pakan paalimmaista korttia vuorossa olevan pelaajan
     * tarkistettujen korttien listaan.
     */
    public void checkTwoCardsForLuckyDuke() {

        for (int i = 0; i < 2; i++) {
            Card topCard = round.getDrawpile().take(round.getDiscardpile());
            round.getPlayerInTurn().setLastCheckedCard(topCard);
            round.getDiscardpile().place(topCard);
        }
    }

    /**
     *
     * Tarkistaa vuorossa olevan pelaajan tarkastettujen korttien listasta, onko
     * kahden viimeisen joukossa herttaa.
     *
     * @return totuusarvo oliko korteissa herttaa
     */
    public boolean checkTwoLastCheckedCardsForLuckyDukeForHearts() {

        boolean thereWasHearts = false;

        for (Card isItHearts : round.getPlayerInTurn().getListOfLastCheckedCards()) {
            if (isItHearts.getSuit().equals("Hearts")) {
                thereWasHearts = true;
            }
        }
        return thereWasHearts;
    }

    /**
     *
     * Tarkistaa kaksi paalimmaista viimeksi tarkastetuista korteista dynamiitin
     * rajayttavia.
     *
     * @return totuusarvo olisivatko molemmat viimeksi tarkistetuista korteista
     * rajayttaneet dynamiitin.
     */
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
     * Asettaa pakan paalimmaisen kortin tarkastettujen pinoon, jos pelaajan
     * avatar on Jourdonnais.
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

    /**
     *
     * Vetaa vastustajalta yhden ja pakasta yhden kortin pelaajan kateen.
     */
    public void drawFromEnemyHandWithJesseJones() {

        Card stolen = round.getPlayerToFollow().drawRandomHangCard();
        round.getPlayerInTurn().setLastCheckedCard(stolen);
        round.getPlayerInTurn().putCardIntoHand(stolen);

        round.getPlayerInTurn().putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
    }
}