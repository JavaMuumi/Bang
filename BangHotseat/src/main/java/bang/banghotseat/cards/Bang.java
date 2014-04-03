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

    /**
     *
     * @param suit      kortin maa
     * @param number    kortin suuruus
     */
    public Bang(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }

    /**
     *
     * @param round     pelattava kierros
     */
    @Override
    public void function(Round round) {

        boolean thereWasAMancato = false;
        for (Card isItMancato : round.getPlayerToFollow().getHandCards()) {

            if (isItMancato.getName().contains("Mancato!")) {
                round.getDiscardpile().place(round.getPlayerToFollow().drawSpecificHandCard(round.getPlayerToFollow().getHandCards().indexOf(isItMancato)));
                thereWasAMancato = true;
                break;
            }
        }
        if (thereWasAMancato == false) {
            round.getPlayerToFollow().loseHealth(1);
        }
    }

    /**
     *
     * @return          kortin nimi
     */
    @Override
    public String getName() {
        return "BANG!";
    }

    /**
     *
     * @return          kortin maa
     */
    @Override
    public String getSuit() {
        return suit;
    }

    /**
     *
     * @return          kortin tyyppi
     */
    @Override
    public String getType() {
        return "Orange";
    }

    /**
     *
     * @return          kortin suuruus
     */
    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "BANG!: " + number + " of " + suit;
    }
}