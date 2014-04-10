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
 * Luokka on kaikkien korttien rajapinta.
 */
public interface Card {

    /**
     *
     * Suorittaa kortin toiminnon.
     *
     * @param round pelattava kierros
     */
    void function(Round round);

    /**
     *
     * @return kortin nimi
     */
    String getName();

    /**
     *
     * @return kortin maa
     */
    String getSuit();

    /**
     *
     * @return kortin tyyppi
     */
    String getType();

    /**
     *
     * @return kortin suuruus
     */
    int getNumber();
}