/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka tarkastaa useissa eri tilanteissa,
 * tuoko pelaajan avatar kulloinkin mukaan
 * jonkin erikoisominaisuuden.
 */
public class CheckerForAvatarSpeciality {
    
    private Round round;
    
    /**
     *
     * @param round pelattava kierros
     */
    public CheckerForAvatarSpeciality(Round round) {
        this.round = round;
    }
    
    /**
     *
     * @param playerToCheck pelaaja, joka tulee tarkistaa
     */
    public void checkSuzyForEmptyHand(Player playerToCheck) {
        
        if (playerToCheck.getAvatar().toString().equals("Suzy Lafayette") && playerToCheck.getHandCards().isEmpty()) {
            playerToCheck.putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
        }
    }
}