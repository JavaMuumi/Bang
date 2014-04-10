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
 * Luokka mallintaa korttia, joka pelataan eteen ja se lahtee vuorottelemaan
 * pelaajien kesken. Vuoron alussa nostetaan pakasta kortti, jonka ollessa
 * oikeaa maata ja suuruutta, dynamiitti rajahtaa aiheuttaen kolme pistetta
 * vahinkoa pelaajalle, jonka edessa se tuolloin on.
 */
public class Dinamite implements Card {

    private String suit;
    private int number;
    private CardNamer namer;

    /**
     *
     * @param suit kortin maa
     * @param number kortin suuruus
     */
    public Dinamite(String suit, int number) {
        this.suit = suit;
        this.number = number;
        namer = new CardNamer();
    }

    /**
     *
     * Antaa kolme pistetta vahinkoa pelaajalle, jonka edessa dynamiitti on.
     *
     * @param round pelattava kierros
     */
    @Override
    public void function(Round round) {
        round.getPlayerInTurn().loseHealth(3);
    }

    /**
     *
     * @return kortin nimi
     */
    @Override
    public String getName() {
        return "Dinamite";
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