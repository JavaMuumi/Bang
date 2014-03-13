/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

/**
 *
 * @author Antti Korpi
 */
public class Winchester implements Card {
    
    private String suit;
    private int number;
    
    public Winchester(String suit, int number) {
        this.suit = suit;
        this.number = number;
    }
    
    @Override
    public void function() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public String getSuit() {
        return suit;
    }
    
    @Override
    public String getType() {
        return "Gun";
    }
    
    @Override
    public int getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return "Winchester: " + number + " of " + suit;
    }
}