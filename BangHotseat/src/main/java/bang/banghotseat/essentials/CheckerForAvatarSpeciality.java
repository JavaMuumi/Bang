/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;

/**
 *
 * @author Antti Korpi
 */
public class CheckerForAvatarSpeciality {
    
    private Round round;
    
    public CheckerForAvatarSpeciality(Round round) {
        this.round = round;
    }
    
    public void checkSuzyForEmptyHand(Player playerToCheck) {
        
        if (playerToCheck.getAvatar().toString().equals("Suzy Lafayette") && playerToCheck.getHandCards().isEmpty()) {
            playerToCheck.putCardIntoHand(round.getDrawpile().take(round.getDiscardpile()));
        }
    }
}