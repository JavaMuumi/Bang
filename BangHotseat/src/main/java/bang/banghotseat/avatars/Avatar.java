/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.Round;

/**
 *
 * @author Antti Korpi
 *
 * Luokka on kaikkien avatarien rajapinta
 *
 */
public interface Avatar {

    /**
     *
     * @return hahmon maksimikestot
     */
    int getMaxHealth();

    /**
     *
     * @return kuvaus avatarin kyvysta
     */
    String getSpeciality();

    /**
     *
     * Vetaa vuorokortit kateen avatarin mukaan.
     *
     * @param round pelattava kierros
     */
    void drawCards(Round round);
}