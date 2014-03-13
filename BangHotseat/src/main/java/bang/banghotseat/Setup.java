/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.AvatarRandomizer;
import bang.banghotseat.essentials.Player;
import bang.banghotseat.userInterface.TextInterface;
import java.util.Scanner;

/**
 *
 * @author Antti Korpi
 */
public class Setup {

    private Scanner asker;
    private TextInterface text;
    private Player player1 = new Player();
    private Player player2 = new Player();
    private AvatarRandomizer randomizer = new AvatarRandomizer();
    private Deck drawpile;
    private Deck discardpile;
    
    public Setup(TextInterface text) {
        this.text = text;
    }
    
    public void runSetup(Scanner asker) {
        
        this.asker = asker;
        givePlayersAvatarsAndSetMaxHealths();
        createDecks();
        
        System.out.println("Player1, your character is " + player1.getAvatar().getName());
        System.out.println("Player2, your character is " + player2.getAvatar().getName());
        System.out.println("");
        
        Round round = new Round(player1, player2, drawpile, discardpile, asker, text);
    }
    
    private void givePlayersAvatarsAndSetMaxHealths() {
        player1.setAvatar(randomizer);
        player1.setCurrentHealth();
        player2.setAvatar(randomizer);
        player2.setCurrentHealth();
    }
    
    private void createDecks() {
        this.drawpile = new Deck();
        drawpile.createCards();
        this.discardpile = new Deck();
    }
}