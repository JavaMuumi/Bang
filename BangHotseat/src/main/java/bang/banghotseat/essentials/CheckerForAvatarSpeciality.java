/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.cards.Card;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Antti Korpi
 *
 * Luokka tarkastaa useissa eri tilanteissa, tuoko pelaajan avatar kulloinkin
 * mukaan jonkin erikoisominaisuuden.
 */
public class CheckerForAvatarSpeciality {

    private Round round;
    private List<Card> sidKetchumDiscardList;
    private int howManyMissesHaveBeenUsedAgainstSlabTheKiller;
    private Card secondDrawnCardOfBlackJack;

    /**
     *
     * @param round pelattava kierros
     */
    public CheckerForAvatarSpeciality(Round round) {

        this.round = round;
        sidKetchumDiscardList = new ArrayList<>();
        howManyMissesHaveBeenUsedAgainstSlabTheKiller = 0;
    }

    /**
     *
     * Vetaa kortin pakasta pelaajan kateen, jos vahingoittuva pelaaja on Bart
     * Cassidy
     */
    public void drawCardForBartCassidyWhenHeTakesAHit(Player possibleBartCassidy) {

        if (possibleBartCassidy.getAvatar().toString().equals("Bart Cassidy")) {
            possibleBartCassidy.putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
        }
    }

    /**
     *
     * Asettaa Black Jackin toisen vedetyn kortin muistilistaan.
     *
     * @param secondCard toinen vedetty kortti
     */
    public void setSecondDrawnCardOfBlackJack(Card secondCard) {
        secondDrawnCardOfBlackJack = secondCard;
    }

    /**
     *
     * @return toinen vedetty kortti
     */
    public Card getSecondDrawnCardOfBlackJack() {
        return secondDrawnCardOfBlackJack;
    }

    /**
     *
     * Tarkastaa, onko Calamity Janetilla BANG! tai Mancato! kadessa.
     */
    public boolean checkCalamityJanetForBangsOrMancatos() {

        boolean calamityJanetHasBangOrMancato = false;

        for (Card isItBangOrMancato : round.getPlayerToFollow().getHandCards()) {
            if (isItBangOrMancato.getName().contains("BANG!") || isItBangOrMancato.getName().contains("Mancato!")) {

                calamityJanetHasBangOrMancato = true;
            }
        }
        return calamityJanetHasBangOrMancato;
    }

    /**
     *
     * Etsii Calamity Janetin kadesta BANG! tai Mancato! -korttia ja palauttaa
     * sen indeksin.
     *
     * @param playerToCheck pelaaja, jonka kadesta BANG! tai Mancato! -korttia
     * etsitaan
     * @return kadessa olevan BANG! tai Mancato! -kortin indeksi
     */
    public int getIndexOfABangOrMancatoInHandOfCalamityJanet(Player playerToCheck) {

        int indexOfBangOrMancato = 0;

        for (Card thisIsBangOrMancato : playerToCheck.getHandCards()) {
            if (thisIsBangOrMancato.getName().contains("BANG!") || thisIsBangOrMancato.getName().contains("Mancato!")) {
                indexOfBangOrMancato = playerToCheck.getHandCards().indexOf(thisIsBangOrMancato);
            }
        }
        return indexOfBangOrMancato;
    }

    /**
     *
     * Vetaa sattumanvaraisen kortin vastustajan kadesta omaan kateen, jos
     * pelaaja on El Gringo ja vastustajalla on kasikortteja.
     */
    public void drawCardFromEnemyHandWhenElGringoTakesAHit() {

        if (round.getPlayerToFollow().getAvatar().toString().equals("El Gringo") && !round.getPlayerInTurn().getAvatar().toString().equals("El Gringo") && !round.getPlayerInTurn().getHandCards().isEmpty()) {

            Card drawnCard = round.getPlayerInTurn().drawRandomHandCard(round);
            round.getCheckerForPlayedCard().setLastStolenCard(drawnCard);
            round.getPlayerToFollow().putCardIntoHand(drawnCard);
        }
    }

    /**
     *
     * Vetaa vastustajalta yhden ja pakasta toisen kortin pelaajan kateen.
     */
    public void drawFromEnemyHandWithJesseJones() {

        Card stolen = round.getPlayerToFollow().drawRandomHandCard(round);
        round.getPlayerInTurn().setLastCheckedCard(stolen);
        round.getPlayerInTurn().putCardIntoHand(stolen);

        round.getPlayerInTurn().putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
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
            if (round.getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {
                missHasBeenPlayedAgainstSlabTheKiller();
            }
            return true;
        }
        return false;
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
     * Tarkistaa pakan kahdesta paalimmaisesta kortista, onko toinen niista
     * herttaa.
     *
     * @return totuusarvo oliko korteissa herttaa
     */
    public boolean checkTwoTopCardsForLuckyDukeForHearts() {

        boolean thereWasHearts = false;

        checkTwoCardsForLuckyDuke();

        if (round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 2).getSuit().equals("Hearts") || round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 1).getSuit().equals("Hearts")) {
            thereWasHearts = true;
            missHasBeenPlayedAgainstSlabTheKiller();
        }
        return thereWasHearts;
    }

    /**
     *
     * Tarkistaa vuorossa olevan pelaajan tarkastettujen korttien listasta, onko
     * toinen kahdesta viimeksi tarkastetusta herttaa.
     *
     * @return totuusarvo oliko korteissa herttaa
     */
    public boolean checkTwoLastCheckedCardsForLuckyDukeForHearts() {

        boolean thereWasHearts = false;

        if (round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 2).getSuit().equals("Hearts") || round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 1).getSuit().equals("Hearts")) {
            thereWasHearts = true;
        }
        return thereWasHearts;
    }

    /**
     *
     * Tarkistaa ovatko kaksi paalimmaista viimeksi tarkastetuista korteista
     * dynamiitin rajayttavia.
     *
     * @return totuusarvo olisivatko molemmat viimeksi tarkistetuista korteista
     * rajayttaneet dynamiitin.
     */
    public boolean checkIfDinamiteExplodesOnLuckyDuke() {

        boolean dinamiteExploded = true;

        checkTwoCardsForLuckyDuke();

        for (Card willThisDetonateDinamite : round.getPlayerInTurn().getListOfLastCheckedCards()) {
            if (!round.getCheckerForEventsBeforeTurn().dinamiteBlowsUp(willThisDetonateDinamite)) {
                dinamiteExploded = false;
            }
        }
        return dinamiteExploded;
    }

    /**
     *
     * Tarkastaa, rajayttavatko molemmat annetut kortit Dinamite-kortin.
     *
     * @param first ensimmainen tarkastettava kortti
     * @param second toinen tarkastettava kortti
     * @return totuusarvo rajauttavatko molemmat kortit Dinamite-kortin
     */
    public boolean checkTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDuke(Card first, Card second) {

        boolean dinamiteBlowsUpOnLuckyDuke = true;

        if (!round.getCheckerForEventsBeforeTurn().dinamiteBlowsUp(first)) {
            dinamiteBlowsUpOnLuckyDuke = false;
        } else if (!round.getCheckerForEventsBeforeTurn().dinamiteBlowsUp(second)) {
            dinamiteBlowsUpOnLuckyDuke = false;
        }
        return dinamiteBlowsUpOnLuckyDuke;
    }

    /**
     *
     * Tarkistaa ovatko neljanneksi ja kolmanneksi paalimmaiset viimeksi
     * tarkastetuista korteista dynamiitin rajayttavia.
     *
     * @return totuusarvo olisivatko molemmat tarkistetuista korteista
     * rajayttaneet dynamiitin.
     */
    public boolean checkIfDinamiteExplodedOnLuckyDukeWhenHeHasBothDinamiteAndPrigione() {

        boolean dinamiteExploded = true;

        Card willThisDetonateDinamite = round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 4);

        for (int i = 0; i < 2; i++) {
            if (!round.getCheckerForEventsBeforeTurn().dinamiteBlowsUp(willThisDetonateDinamite)) {
                dinamiteExploded = false;
            }
            willThisDetonateDinamite = round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 3);
        }
        return dinamiteExploded;
    }

    /**
     *
     * Tarkistaa menettaisiko Lucky Duke vuoron Prigione-kortin vuoksi.
     *
     * @return totuusarvo ettei Lucky Duke menettanyt vuoroa.
     */
    public boolean luckyDukeStaysInPrigione(int indexOfPrigione) {

        boolean luckyDukeDidNotLoseTurn = true;

        if (!round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts()) {
            luckyDukeDidNotLoseTurn = false;
        }
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfPrigione));

        return luckyDukeDidNotLoseTurn;
    }

    /**
     *
     * Vetaa poistopakasta yhden ja pakasta toisen kortin pelaajan kateen.
     */
    public void drawFromDiscardpileWithPedroRamirez() {

        round.getPlayerInTurn().putCardIntoHand(round.getDiscardpile().take(round.getDiscardpile()));
        round.getPlayerInTurn().putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
    }

    /**
     *
     * Lisaa poistettavaksi valitun kortin Sid Ketchumin uhrattavien korttien
     * listalle.
     *
     * @param roBeAdded Sid Ketchumin uhrattavien korttien listalle lisattava
     * kortti
     */
    public void addToSidKetchumDiscardList(Card toBeAdded) {
        sidKetchumDiscardList.add(toBeAdded);
    }

    /**
     *
     * @return Sid Ketchumin uhrattavien korttien lista
     */
    public List<Card> getSidKetchumDiscardList() {
        return sidKetchumDiscardList;
    }

    /**
     *
     * Tarkastaa, onko seuraavana vuorossa olevan pelaajan kadessa kahta
     * vaistokorttia.
     *
     * @return totuusarvo onko vuorossa seuraavana olevalla pelaajalla kahta
     * vaistokorttia kadessa
     */
    public boolean checkThatEnemyHasTwoMancatosAgainstSlabTheKiller() {

        int indexOfFirstMancato = 0;
        boolean thereWereTwoMancatos = false;

        for (Card isItMancato : round.getPlayerToFollow().getHandCards()) {
            if (isItMancato.getName().contains("Mancato!") || (round.getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && isItMancato.getName().contains("BANG!"))) {
                indexOfFirstMancato = round.getPlayerToFollow().getHandCards().indexOf(isItMancato);
            }
        }
        for (Card isItMancato : round.getPlayerToFollow().getHandCards()) {
            if ((isItMancato.getName().contains("Mancato!") && round.getPlayerToFollow().getHandCards().indexOf(isItMancato) != indexOfFirstMancato) || ((round.getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && isItMancato.getName().contains("BANG!") && round.getPlayerToFollow().getHandCards().indexOf(isItMancato) != indexOfFirstMancato))) {
                indexOfFirstMancato = round.getPlayerToFollow().getHandCards().indexOf(isItMancato);
                thereWereTwoMancatos = true;
            }
        }
        if (thereWereTwoMancatos) {
            return true;
        }
        return false;
    }

    /**
     *
     * Lisaa yhden listaan siita, montako vaistoa vuorossa seuraava pelaaja on
     * jo kayttanyt.
     */
    public void missHasBeenPlayedAgainstSlabTheKiller() {
        howManyMissesHaveBeenUsedAgainstSlabTheKiller++;
    }

    /**
     *
     * Tarkastaa montako vaistoa vuorossa seuraava pelaaja on jo kayttanyt.
     */
    public int howManyMissesHaveBeenUsedAgainstSlabTheKiller() {
        return howManyMissesHaveBeenUsedAgainstSlabTheKiller;
    }

    /**
     *
     * Tyhjentaa listan siita, montako vaistoa vuorossa seuraava pelaaja on jo
     * kayttanyt.
     */
    public void eraseHowManyMissesHaveBeenUsedAgainstSlabTheKiller() {
        howManyMissesHaveBeenUsedAgainstSlabTheKiller = 0;
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
}