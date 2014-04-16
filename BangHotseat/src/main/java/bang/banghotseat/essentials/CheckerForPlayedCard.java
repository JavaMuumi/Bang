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
    private int index;

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

        this.index = index;
        this.playedCard = round.getPlayerInTurn().getHandCards().get(index);

        if (playedCard.getType().equals("Orange") || (round.getPlayerInTurn().getAvatar().toString().equals("Calamity Janet") && playedCard.getType().equals("Mancato"))) {
            if (playedCard.getName().contains("BANG!") || playedCard.getName().contains("Gatling")) {
                playingBangOrGatling(playedCard);

            } else if (playedCard.getName().contains("Mancato!")) {
                if (round.getPlayerInTurn().getAvatar().toString().equals("Calamity Janet")) {
                    playingBangOrGatling(playedCard);
                }
            } else if (playedCard.getName().contains("Indiani!")) {
                playingIndiani();

            } else if (playedCard.getName().contains("Duello")) {
                playingDuello();

            } else if (playedCard.getName().contains("Cat Balou")) {
                playingCatBalou();

            } else if (playedCard.getName().contains("Panico!")) {
                if (canPlayerInTurnTouchPlayerToFollow()) {
                    playingPanico();
                }
            } else if (playedCard.getName().equals("Emporio")) {
                playingEmporio();

            } else {
                playedCard.function(round);
                round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
            }
        } else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Blue")) {

            int indexOfTheSameCard = 0;
            boolean sameCardIsAlreadyInFront = false;

            for (Card isTheSameCardAlreadyInFront : round.getPlayerInTurn().getFrontCards()) {
                if (isTheSameCardAlreadyInFront.getName().equals(round.getPlayerInTurn().getHandCards().get(index).getName())) {
                    indexOfTheSameCard = round.getPlayerInTurn().getFrontCards().indexOf(isTheSameCardAlreadyInFront);
                    sameCardIsAlreadyInFront = true;
                }
            }
            if (sameCardIsAlreadyInFront) {
                round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfTheSameCard));
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index, round));

            } else {
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index, round));
            }
        } else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Prigione")) {

            int indexOfOldPrigione = 0;
            boolean prigioneIsAlreadyInFront = false;

            for (Card isPrigioneAlreadyInFront : round.getPlayerToFollow().getFrontCards()) {
                if (isPrigioneAlreadyInFront.getName().equals("Prigione")) {
                    indexOfOldPrigione = round.getPlayerToFollow().getFrontCards().indexOf(isPrigioneAlreadyInFront);
                    prigioneIsAlreadyInFront = true;
                }
            }
            if (prigioneIsAlreadyInFront) {
                round.getDiscardpile().place(round.getPlayerToFollow().drawSpecificFrontCard(indexOfOldPrigione));
                round.getPlayerToFollow().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index, round));
            } else {
                round.getPlayerToFollow().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index, round));
            }
        } else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Gun")) {

            int indexOfGun = 0;
            boolean aGunIsAlreadyInFront = false;

            for (Card isAGun : round.getPlayerInTurn().getFrontCards()) {
                if (isAGun.getType().equals("Gun")) {
                    indexOfGun = round.getPlayerInTurn().getFrontCards().indexOf(isAGun);
                    aGunIsAlreadyInFront = true;
                }
            }
            if (aGunIsAlreadyInFront) {
                round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(indexOfGun));
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index, round));

            } else {
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index, round));
            }
        }
    }

    /**
     *
     * Kasittelee BANG! tai Gatlin -kortin pelaamisen.
     *
     * @param bangOrGatling pelattu kortti
     */
    public void playingBangOrGatling(Card bangOrGatling) {

        round.getPlayerInTurn().setCardWaitingForAReply(bangOrGatling);
        if ((bangOrGatling.getName().contains("BANG!") || bangOrGatling.getName().contains("Mancato!")) && bangCanBePlayed()) {
            round.setBangHasBeenPlayed(true);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
        } else if (bangOrGatling.getName().contains("Gatling")) {
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
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
            if (isItVolcanic.getName().contains("Volcanic")) {
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
            if (isItBarrel.getName().contains("Barrel")) {
                thereIsABarrel = true;
            }
        }
        if (thereIsABarrel && round.getPlayerToFollow().getAvatar().toString().equals("Lucky Duke")) {
            round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();
            if (round.getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts()) {
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
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
    }

    /**
     *
     * Kasittelee Duello-kortin pelaamisen.
     */
    public void playingDuello() {
        round.getPlayerInTurn().setCardWaitingForAReply(playedCard);
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
    }

    /**
     *
     * Kasittelee Cat Balou -kortin pelaamisen.
     */
    public void playingCatBalou() {

        round.getPlayerInTurn().getHandCards().get(index).function(round);
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
    }

    /**
     *
     * Kasittelee Panico!-kortin pelaamisen.
     */
    public void playingPanico() {

        if (canPlayerInTurnTouchPlayerToFollow() == false) {
        } else {
            round.getPlayerInTurn().getHandCards().get(index).function(round);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
        }
    }

    /**
     *
     * Kasittelee Emporio-kortin pelaamisen.
     */
    public void playingEmporio() {
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index, round));
        for (int i = 0; i < 2; i++) {
            round.getCheckerForEventsBeforeTurn().checkTopCard();
        }
    }

    /**
     *
     * Tarkastaa onko vastustajalla kadessa Mancato!
     *
     * @return totuusarvo onko vastustajalla Mancato!
     */
    public boolean playerToFollowHasMancato() {

        boolean thereWasAMancato = false;

        for (Card isItMancato : round.getPlayerToFollow().getHandCards()) {
            if (isItMancato.getName().contains("Mancato!") || (round.getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && isItMancato.getName().contains("Mancato!"))) {
                thereWasAMancato = true;
            }
        }
        if (thereWasAMancato) {
            return true;
        }
        return false;
    }

    /**
     *
     * Tarkastaa onko vastustajalla kadessa BANG!
     *
     * @return totuusarvo onko vastustajalla BANG!
     */
    public boolean playerToFollowHasBang() {

        boolean thereWasABang = false;

        for (Card isItBang : round.getPlayerToFollow().getHandCards()) {
            if (isItBang.getName().contains("BANG!") || (round.getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && isItBang.getName().contains("Mancato!"))) {
                thereWasABang = true;
            }
        }
        if (thereWasABang) {
            return true;
        }
        return false;
    }

    /**
     *
     * Tarkastaa onko vuorossa olevalla pelaajalla kadessa BANG!
     *
     * @return totuusarvo onko vuorossa olevalla pelaajalla BANG!
     */
    public boolean playerInTurnHasBang() {

        boolean thereWasABang = false;

        for (Card isItBang : round.getPlayerInTurn().getHandCards()) {
            if (isItBang.getName().contains("BANG!") || (round.getPlayerInTurn().getAvatar().toString().equals("Calamity Janet") && isItBang.getName().contains("Mancato!"))) {
                thereWasABang = true;
            }
        }
        if (thereWasABang) {
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
     * Etsii maaratyn pelaajan kadesta Mancato!-korttia ja palauttaa sen
     * indeksin.
     *
     * @param playerToCheck pelaaja, jonka kadesta Mancato!-korttia etsitaan
     * @return kadessa olevan Mancato!-kortin indeksi
     */
    public int getIndexOfAMancatoInHand(Player playerToCheck) {

        int indexOfMancato = 0;

        for (Card thisIsMancato : playerToCheck.getHandCards()) {
            if (thisIsMancato.getName().contains("Mancato!")) {
                indexOfMancato = playerToCheck.getHandCards().indexOf(thisIsMancato);
            }
        }
        return indexOfMancato;
    }

    /**
     *
     * Etsii maaratyn pelaajan kadesta BANG!-korttia ja palauttaa sen indeksin.
     *
     * @param playerToCheck pelaaja, jonka kadesta BANG!-korttia etsitaan
     * @return kadessa olevan BANG!-kortin indeksi
     */
    public int getIndexOfABangInHand(Player playerToCheck) {

        int indexOfBang = 0;

        for (Card thisIsBang : playerToCheck.getHandCards()) {
            if (thisIsBang.getName().contains("BANG!")) {
                indexOfBang = playerToCheck.getHandCards().indexOf(thisIsBang);
            }
        }
        return indexOfBang;
    }
}
