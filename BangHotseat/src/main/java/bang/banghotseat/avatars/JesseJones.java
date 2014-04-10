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
 * Luokka mallintaa Jesse Jonesin ominaisuuksia.
 * 
 */
public class JesseJones implements Avatar {

    /**
     *
     * @return hahmon maksimikestot
     */
    @Override
    public int getMaxHealth() {
        return 4;
    }

    /**
     *
     * @return kuvaus avatarin kyvysta
     */
    @Override
    public String getSpeciality() {
        return "He may draw his first card from the hand of a player.";
    }

    /**
     *
     * @param round pelattava kierros
     */
    @Override
    public void drawCards(Round round) {
    }
    
    @Override
    public String toString() {
        return "Jesse Jones";
    }
}