/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;

/**
 *
 * @author Antti Korpi
 *
 * Luokka mallintaa korttia, joka eteen pelattuna suojaa pelaajaa, jos
 * nostopakasta nousee oikeanlainen kortti.
 */
public class Barrel implements Card {

    private String suit;
    private int number;
    private CardNamer namer;

    /**
     *
     * @param suit kortin maa
     * @param number kortin suuruus
     */
    public Barrel(String suit, int number) {
        this.suit = suit;
        this.number = number;
        namer = new CardNamer();
    }

    /**
     *
     * Tarkastaa nostopakan paalimmaisen kortin ja asettaa sen poistopakkaan.
     * Jos kortti oli herttaa, merkitaan yksi vaisto pelatuksi Slab The Killeria
     * vastaan. Jos vuorossa seuraava pelaaja on Lucky Duke, tarkastetaan kaksi
     * paalimmaista korttia.
     *
     * @param round pelattava kierros
     */
    @Override
    public void function(Round round) {

        if (round.getPlayerToFollow().getAvatar().toString().equals("Lucky Duke")) {
            round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts();

        } else {

            round.getCheckerForEventsBeforeTurn().checkTopCard();

            if (round.getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {
                round.getCheckerForAvatarSpeciality().missHasBeenPlayedAgainstSlabTheKiller();
            }
        }
    }

    /**
     *
     * @return kortin nimi
     */
    @Override
    public String getName() {
        return "Barrel";
    }

    /**
     *
     * @return kortin maa
     */
    @Override
    public String getSuit() {
        return suit;
    }

    /**
     *
     * @return kortin tyyppi
     */
    @Override
    public String getType() {
        return "Blue";
    }

    /**
     *
     * @return kortin suuruus
     */
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {

        if (number < 2 || number > 10) {
            return getName() + ": " + namer.checkNumber(number) + " of " + suit;
        } else {
            return getName() + ": " + number + " of " + suit;
        }
    }
}