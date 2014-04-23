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
 * Luokka tarkastaa, mika kortti juuri pelattiin, mita se aiheuttaa ja miten
 * sita kasitellaan taman jalkeen.
 */
public class CheckerForPlayedCard {

    private Card playedCard;
    private Round round;
    private int indexOfHandCard;
    private int indexOfSameCard;
    private int indexOfReplyCard;
    private int indexOfSecondReplyCard;

    /**
     *
     * @param round pelattava kierros
     */
    public CheckerForPlayedCard(Round round) {
        this.round = round;
    }

    /**
     *
     * Kasittelee indeksin mukaisen kortin pelaamisen pelaajan kadesta.
     *
     * @param index pelatun kortin indeksi pelaajan kadessa
     */
    public void playingCard(int index) {

        this.indexOfHandCard = index;
        this.playedCard = round.getPlayerInTurn().getHandCards().get(index);

        if (playedCard.getType().equals("Orange") || (round.getPlayerInTurn().getAvatar().toString().equals("Calamity Janet") && playedCard.getType().equals("Mancato"))) {
            playingOrangeCard(round.getPlayerInTurn().getHandCards().get(index));

        } else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Blue")) {
            playingBlueCard();

        } else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Gun")) {
            playingGun();

        } else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Prigione")) {
            playingPrigione();

        } else {
        }
    }

    /**
     *
     * Kasittelee oranssin kortin pelaamisen.
     */
    public void playingOrangeCard(Card playedCard) {
        if (playedCard.getName().equals("BANG!") || playedCard.getName().equals("Mancato!") || playedCard.getName().equals("Gatling")) {
            playingBangOrGatling(playedCard);

        } else if (playedCard.getName().equals("Mancato!")) {
            if (round.getPlayerInTurn().getAvatar().toString().equals("Calamity Janet")) {
                playingBangOrGatling(playedCard);
            }
        } else if (playedCard.getName().equals("Indiani!")) {
            playingIndiani();

        } else if (playedCard.getName().equals("Duello")) {
            playingDuello();

        } else if (playedCard.getName().equals("Cat Balou")) {
            playingCatBalou();

        } else if (playedCard.getName().equals("Panico!")) {
            if (canPlayerInTurnTouchPlayerToFollow()) {
                playingPanico();
            }
        } else if (playedCard.getName().equals("Emporio")) {
            playingEmporio();

        } else {
            playedCard.function(round);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        }
    }

    /**
     *
     * Kasittelee sinisen kortin pelaamisen.
     */
    public void playingBlueCard() {

        if (sameKindOfCardIsAlreadyInFrontOfPlayerInTurn(playedCard.getName())) {
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfSameCard));
            round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));

        } else {
            round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        }
    }

    /**
     *
     * Kasittelee ase-kortin pelaamisen.
     */
    public void playingGun() {

        boolean aGunIsAlreadyInFront = sameTypeOfCardIsAlreadyInFrontOfPlayerInTurn("Gun");

        if (aGunIsAlreadyInFront) {
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfSameCard));
            round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));

        } else {
            round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        }
    }

    /**
     *
     * Kasittelee Prigione-kortin pelaamisen.
     */
    public void playingPrigione() {

        boolean prigioneIsAlreadyInFront = round.getCheckerForEventsBeforeTurn().sameKindOfCardIsAlreadyInFrontOfPlayerToFollow("Prigione");

        if (prigioneIsAlreadyInFront) {
            round.getDiscardpile().place(round.getPlayerToFollow().drawSpecificFrontCard(round.getCheckerForEventsBeforeTurn().getIndexOfSameCard()));
            round.getPlayerToFollow().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        } else {
            round.getPlayerToFollow().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        }
    }

    /**
     *
     * Tarkastaa, onko samanlainen kortti jo vuorossa olevan pelaajan edessa.
     *
     * @return totuusarvo onko vuorossa olevan pelaajan edessa jo samanlainen
     * kortti.
     */
    public boolean sameKindOfCardIsAlreadyInFrontOfPlayerInTurn(String cardName) {

        boolean sameCardIsAlreadyInFront = false;

        for (Card isTheSameCardAlreadyInFront : round.getPlayerInTurn().getFrontCards()) {
            if (isTheSameCardAlreadyInFront.getName().equals(cardName)) {
                indexOfSameCard = round.getPlayerInTurn().getFrontCards().indexOf(isTheSameCardAlreadyInFront);
                sameCardIsAlreadyInFront = true;
            }
        }
        return sameCardIsAlreadyInFront;
    }

    /**
     *
     * Tarkastaa, onko samantyyppinen kortti jo vuorossa olevan pelaajan edessa.
     *
     * @return totuusarvo, onko vuorossa olevan pelaajan edessa jo
     * samantyyppinen kortti.
     */
    public boolean sameTypeOfCardIsAlreadyInFrontOfPlayerInTurn(String cardType) {

        boolean sameTypeOfCardIsAlreadyInFront = false;

        for (Card isOfSameType : round.getPlayerInTurn().getFrontCards()) {
            if (isOfSameType.getType().equals(cardType)) {
                indexOfSameCard = round.getPlayerInTurn().getFrontCards().indexOf(isOfSameType);
                sameTypeOfCardIsAlreadyInFront = true;
            }
        }
        return sameTypeOfCardIsAlreadyInFront;
    }

    /**
     *
     * Kasittelee BANG! tai Gatlin -kortin pelaamisen.
     *
     * @param bangOrGatling pelattu kortti
     */
    public void playingBangOrGatling(Card bangOrGatling) {

        round.getPlayerInTurn().setCardWaitingForAReply(bangOrGatling);
        if ((bangOrGatling.getName().equals("BANG!") || bangOrGatling.getName().equals("Mancato!")) && bangCanBePlayed()) {
            round.setBangHasBeenPlayed(true);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        } else if (bangOrGatling.getName().equals("Gatling")) {
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        }
    }

    /**
     *
     * Tarkistaa, voiko talla vuorolla viela pelata BANG!-kortteja.
     *
     * @return totuusarvo voiko pelaaja enaa talla vuorolla kayttaa BANG!
     */
    public boolean bangCanBePlayed() {

        boolean thereIsAVolcanic = false;

        if (round.getBangHasBeenPlayed() == false) {
            return true;
        } else if (round.getPlayerInTurn().getAvatar().toString().equals("Willy The Kid")) {
            return true;
        }
        for (Card isItVolcanic : round.getPlayerInTurn().getFrontCards()) {
            if (isItVolcanic.getName().equals("Volcanic")) {
                thereIsAVolcanic = true;
            }
        }
        if (thereIsAVolcanic) {
            return true;
        }
        return false;
    }

    /**
     *
     * Tarkistaa onko pelaajan edessa Barrelia ja asettaa pakasta pelaajan
     * viimeksi tarkastetut kortit avatarin mukaisesti.
     *
     * @return totuusarvo onko vastustajan edessa Barrel
     */
    public boolean checkBarrel() {

        boolean thereIsABarrel = false;

        for (Card isItBarrel : round.getPlayerToFollow().getFrontCards()) {
            if (isItBarrel.getName().equals("Barrel")) {
                thereIsABarrel = true;
            }
        }
        if (thereIsABarrel && round.getPlayerToFollow().getAvatar().toString().equals("Lucky Duke")) {
            round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();
            if (round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts()) {
            }
            return true;

        } else if (thereIsABarrel) {
            round.getCheckerForEventsBeforeTurn().checkTopCard();
            if (round.getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {
                round.getCheckerForAvatarSpeciality().missHasBeenPlayedAgainstSlabTheKiller();
            }
            return true;
        }
        return false;
    }

    /**
     *
     * Kasittelee Indiani!-kortin pelaamisen.
     */
    public void playingIndiani() {
        round.getPlayerInTurn().setCardWaitingForAReply(playedCard);
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
    }

    /**
     *
     * Kasittelee Duello-kortin pelaamisen.
     */
    public void playingDuello() {
        round.getPlayerInTurn().setCardWaitingForAReply(playedCard);
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
    }

    /**
     *
     * Kasittelee Cat Balou -kortin pelaamisen.
     */
    public void playingCatBalou() {

        round.getPlayerInTurn().getHandCards().get(indexOfHandCard).function(round);
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
    }

    /**
     *
     * Kasittelee Panico!-kortin pelaamisen.
     */
    public void playingPanico() {

        if (canPlayerInTurnTouchPlayerToFollow() == false) {
        } else {
            round.getPlayerInTurn().getHandCards().get(indexOfHandCard).function(round);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        }
    }

    /**
     *
     * Kasittelee Emporio-kortin pelaamisen.
     */
    public void playingEmporio() {
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(indexOfHandCard, round));
        for (int i = 0; i < 2; i++) {
            round.getCheckerForEventsBeforeTurn().checkTopCard();
        }
    }

    /**
     *
     * Tarkastaa onko pelaajalla kadessa BANG! tai Mancato!
     *
     * @param playerToCheck tarkastettava pelaaja
     * @param bangOrMancato tarkennus etsitaanko BANG! vai Mancato! -korttia
     * @return totuusarvo onko vastustajalla haettu kortti
     */
    public boolean playerHasBangOrMancato(Player playerToCheck, String bangOrMancato) {

        boolean thereWasTheCard = false;

        for (Card isItTheCard : playerToCheck.getHandCards()) {
            if (isItTheCard.getName().equals(bangOrMancato) || (playerToCheck.getAvatar().toString().equals("Calamity Janet") && (isItTheCard.getName().equals("Mancato!") || isItTheCard.getName().equals("BANG!")))) {
                thereWasTheCard = true;
            }
        }
        if (thereWasTheCard) {
            return true;
        }
        return false;
    }

    /**
     *
     * Tarkastaa yltaako pelaajan kantama vastustajaan.
     *
     * @return totuusarvo riittaako pelaajan kantama vastustajaan
     */
    public boolean canPlayerInTurnReachPlayerToFollow() {

        if (round.getPlayerInTurn().getReach() < round.getPlayerToFollow().getDistance()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * Tarkastaa yltaako pelaajan kosketus vastustajaan.
     *
     * @return totuusarvo paaseeko pelaaja koskettamaan vastustajaa
     */
    public boolean canPlayerInTurnTouchPlayerToFollow() {

        if (round.getPlayerInTurn().getTouch() < round.getPlayerToFollow().getDistance()) {
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * Etsii pelaajan kadesta annetun nimista korttia ja merkitsee sen indeksin
     * muistiin.
     *
     * @param playerToCheck tarkastettava pelaaja
     * @param nameOfSearchedCard etsityn kortin nimi
     * @return totuusarvo loytyiko etsittya korttia
     */
    public boolean searchPlayerHandForCertainCard(Player playerToCheck, String nameOfSearchedCard) {

        boolean aCardWasFound = false;

        for (Card thisIsSearchedCard : playerToCheck.getHandCards()) {
            if (thisIsSearchedCard.getName().equals(nameOfSearchedCard)) {
                indexOfReplyCard = playerToCheck.getHandCards().indexOf(thisIsSearchedCard);
                aCardWasFound = true;
            }
        }
        return aCardWasFound;
    }

    /**
     *
     * @return vastauskortin indeksi
     */
    public int getIndexOfReplyCard() {
        return indexOfReplyCard;
    }

    /**
     *
     * Etsii pelaajan kadesta toista annetun nimista korttia ja merkitsee sen
     * indeksin muistiin.
     *
     * @param playerToCheck etsittava pelaaja
     * @param nameOfSearchedCard etsityn kortin nimi
     */
    public void searchPlayerHandForAnotherCardOfSameKind(Player playerToCheck, String nameOfSearchedCard) {

        boolean thereWasAnotherCard = false;

        for (Card thisIsSameCard : playerToCheck.getHandCards()) {

            if (thisIsSameCard.getName().equals(nameOfSearchedCard) && playerToCheck.getHandCards().indexOf(thisIsSameCard) != indexOfReplyCard) {
                indexOfSecondReplyCard = playerToCheck.getHandCards().indexOf(thisIsSameCard);
                thereWasAnotherCard = true;
            }
        }
        if (thereWasAnotherCard) {
            round.getDiscardpile().place(playerToCheck.drawSpecificHandCard(indexOfSecondReplyCard, round));
            if (indexOfReplyCard > indexOfSecondReplyCard) {
                indexOfReplyCard--;
            }
        }
    }

    /**
     *
     * Etsii maaratyn pelaajan kadesta tietyn nimista korttia ja palauttaa sen
     * indeksin.
     *
     * @param playerToCheck pelaaja, jonka kadesta korttia etsitaan
     * @param nameOfSearchedCard etsittavan kortin nimi
     * @return kadessa olevan kortin indeksi
     */
    public int getIndexOfCertainHandCard(Player playerToCheck, String nameOfSearchedCard) {

        int indexOfCard = 0;

        for (Card thisIsIt : playerToCheck.getHandCards()) {
            if (thisIsIt.getName().equals("BANG!")) {
                indexOfCard = playerToCheck.getHandCards().indexOf(thisIsIt);
            }
        }
        return indexOfCard;
    }
}