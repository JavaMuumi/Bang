/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.essentials.Player;
import java.util.Scanner;

/**
 *
 * @author Antti Korpi
 */
public interface Card {
    
    void function(Player playerInTurn, Player playerToFollow, Deck drawpile, Deck discardpile, Scanner asker);
    String getName();
    String getSuit();
    String getType();
    int getNumber();
}