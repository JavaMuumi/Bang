/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

/**
 *
 * @author Antti Korpi
 */
public class Saloon implements Card {
    
    private String suit;
    private int number;
    
    public Saloon(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function() {
    }
    
    @Override
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String getType() {
        return "Orange";
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Saloon: " + number + " of " + suit;
    }
}