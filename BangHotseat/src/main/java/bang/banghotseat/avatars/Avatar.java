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
     * @param drawpile lista korteista, joita nostetaan pelin aikana
     * @param discardpile lista, jolle pelissa poistetut kortit lisataan
     * @param playerInTurn vuorossa oleva pelaaja
     * @param playerToFollow seuraavana vuorossa oleva pelaaja
     */
    void drawCards(Round round);
}