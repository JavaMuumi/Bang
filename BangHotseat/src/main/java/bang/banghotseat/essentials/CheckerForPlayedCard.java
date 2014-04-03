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
 * Luokka tarkastaa, mika kortti juuri pelattiin,
 * mita se aiheuttaa ja miten sita kasitellaan
 * taman jalkeen.
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
     * @param index pelatun kortin indeksi pelaajan kadessa
     */
    public void playingCard(int index) {

        this.index = index;
        this.playedCard = round.getPlayerInTurn().getHandCards().get(index);

        if (playedCard.getType().equals("Orange")) {
            if (playedCard.getName().contains("BANG!") || playedCard.getName().contains("Gatling")) {
                playingBangOrGatling(playedCard);

            } else if (playedCard.getName().contains("Mancato!")) {
            } else if (playedCard.getName().contains("Cat Balou")) {
                playingCatBalou();
            } else if (playedCard.getName().contains("Panico!")) {
                if (canPlayerInTurnTouchPlayerToFollow()) {
                    playingPanico();
                }
            } else {
                playedCard.function(round);
                round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
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
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index));

            } else {
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index));
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
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index));

            } else {
                round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index));
            }
        }
        round.getCheckerForAvatarSpeciality().checkSuzyForEmptyHand(round.getPlayerInTurn());
    }

    /**
     *
     * @param bangOrGatling pelattu kortti
     */
    public void playingBangOrGatling(Card bangOrGatling) {

        if (bangOrGatling.getName().contains("BANG!") && bangCanBePlayed()) {
            round.setBangHasBeenPlayed(true);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
        }
        else if (bangOrGatling.getName().contains("Gatling")) {
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
        }
    }

    /**
     *
     * @return  totuusarvo voiko pelaaja enaa talla vuorolla kayttaa BANG!
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
     * @return  totuusarvo onko vastustajan edessa Barrel
     */
    public boolean thereIsABarrel() {

        boolean thereIsABarrel = false;

        for (Card isItBarrel : round.getPlayerToFollow().getFrontCards()) {
            if (isItBarrel.getName().contains("Barrel")) {
                thereIsABarrel = true;
            }
        }
        if (thereIsABarrel) {
            Card topCard = round.getDrawpile().take(round.getDiscardpile());
            round.getPlayerInTurn().setLastCheckedCard(topCard);
            round.getDiscardpile().place(topCard);
            return true;
        }
        return false;
    }

    /**
     *
     */
    public void playingCatBalou() {

        round.getPlayerInTurn().getHandCards().get(index).function(round);
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
    }

    /**
     *
     */
    public void playingPanico() {

        if (canPlayerInTurnTouchPlayerToFollow() == false) {
        } else {
            round.getPlayerInTurn().getHandCards().get(index).function(round);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
        }
    }

    /**
     *
     * @return  totuusarvo onko vastustajalla Mancato!
     */
    public boolean playerToFollowHasMancato() {

        boolean thereWasAMancato = false;

        for (Card isItMancato : round.getPlayerToFollow().getHandCards()) {
            if (isItMancato.getName().contains("Mancato!")) {
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
     * @return  totuusarvo riittaako pelaajan kantama vastustajaan
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
     * @return  totuusarvo paaseeko pelaaja koskettamaan vastustajaa
     */
    public boolean canPlayerInTurnTouchPlayerToFollow() {

        if (round.getPlayerInTurn().getTouch() < round.getPlayerToFollow().getDistance()) {
            return false;
        } else {
            return true;
        }
    }
}