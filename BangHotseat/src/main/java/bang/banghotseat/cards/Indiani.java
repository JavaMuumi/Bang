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
 * Luokka mallintaa korttia, joka pelattaessa
 * toisen on pelattava BANG! tai menetettava
 * yksi kesto.
 */
public class Indiani implements Card {
    
    private String suit;
    private int number;
    
    /**
     *
     * @param suit      kortin maa
     * @param number    kortin suuruus
     */
    public Indiani(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    /**
     *
     * @param round     pelattava kierros
     */
    @Override
    public void function(Round round) {
    }
    
    /**
     *
     * @return  kortin nimi
     */
    @Override
    public String getName() {
        return "Indiani!";
    }
    
    /**
     *
     * @return  kortin maa
     */
    @Override
    public String getSuit() {
        return suit;
    }
    
    /**
     *
     * @return  kortin tyyppi
     */
    @Override
    public String getType() {
        return "Orange";
    }
    
    /**
     *
     * @return  kortin suuruus
     */
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Indiani!: " + number + " of " + suit;
    }
}