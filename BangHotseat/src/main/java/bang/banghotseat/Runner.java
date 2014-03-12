/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.Checker;
import bang.banghotseat.essentials.Player;

/**
 *
 * @author Antti Korpi
 */
public class Runner {
    
    Player playerInTurn;
    Player playerToFollow;
    
    public Runner(Player player1, Player player2, Deck drawpile, Deck discardpile) {
        
        playerInTurn = player1;
        playerToFollow = player2;
        Checker checker = new Checker(drawpile, discardpile);
        
//        while (playerInTurn.currentHealth > 0 && playerToFollow.currentHealth > 0) {
            
            checker.setPlayerTurns(playerInTurn, playerToFollow);
            
            checker.checkDinamite();
//        }
    }
}