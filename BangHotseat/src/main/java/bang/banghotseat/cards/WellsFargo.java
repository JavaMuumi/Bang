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
 * Luokka mallintaa korttia, jonka pelaamalla saa nostaa kolme uutta korttia
 * kateen.
 */
public class WellsFargo implements Card {

    private String suit;
    private int number;
    private CardNamer namer;

    /**
     *
     * @param suit kortin maa
     * @param number kortin suuruus
     */
    public WellsFargo(String suit, int number) {
        this.suit = suit;
        this.number = number;
        namer = new CardNamer();
    }

    /**
     *
     * Nostaa kolme korttia pelaajan kateen.
     *
     * @param round pelattava kierros
     */
    @Override
    public void function(Round round) {

        for (int i = 0; i < 3; i++) {
            round.getPlayerInTurn().putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
        }
    }

    /**
     *
     * @return kortin nimi
     */
    @Override
    public String getName() {
        return "Wells Fargo";
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