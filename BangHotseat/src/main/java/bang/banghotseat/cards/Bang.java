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
 * Luokka mallintaa korttia, jolla ammutaan toista pelaajaa.
 *
 */
public class Bang implements Card {

    private String suit;
    private int number;
    private CardNamer namer;

    /**
     *
     * @param suit kortin maa
     * @param number kortin suuruus
     */
    public Bang(String suit, int number) {
        this.suit = suit;
        this.number = number;
        namer = new CardNamer();
    }

    /**
     *
     * Saa vuorossa seuraavan pelaajan menettamaan yhden keston.
     *
     * @param round pelattava kierros
     */
    @Override
    public void function(Round round) {

        round.getPlayerToFollow().loseHealth(1, round);
    }

    /**
     *
     * @return kortin nimi
     */
    @Override
    public String getName() {
        return "BANG!";
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
        return "Orange";
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