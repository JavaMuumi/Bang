/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

/**
 *
 * @author Antti Korpi
 */
public interface Card {
    
    void function();
    String getSuit();
    String getType();
    int getNumber();
}