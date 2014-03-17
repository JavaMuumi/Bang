/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Card;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.AvatarRandomizer;
import bang.banghotseat.essentials.Player;
import java.util.Scanner;

/**
 *
 * @author Antti Korpi
 */
public class Setup {

    private Scanner asker;
    private Player player1 = new Player();
    private Player player2 = new Player();
    private AvatarRandomizer randomizer = new AvatarRandomizer();
    private Deck drawpile;
    private Deck discardpile;
    
    public Setup() {
    }
    
    public void runSetup() {
        
        givePlayersAvatarsAndSetMaxHealths();
        createDecks();
        dealStartingHands();
    }
    
    private void givePlayersAvatarsAndSetMaxHealths() {
        player1.setAvatar(randomizer.giveAvatar());
        player1.setCurrentHealth();
        player2.setAvatar(randomizer.giveAvatar());
        player2.setCurrentHealth();
    }
    
    private void createDecks() {
        this.drawpile = new Deck();
        drawpile.createCards();
        this.discardpile = new Deck();
    }
    
        private void dealStartingHands() {
        
        while (player1.getHandCards().size() < player1.getAvatar().getMaxHealth()) {
            Card cardToBeGiven = drawpile.take(discardpile);
            player1.putCardIntoHand(cardToBeGiven);
        }
        
        while (player2.getHandCards().size() < player2.getAvatar().getMaxHealth()) {
            Card cardToBeGiven = drawpile.take(discardpile);
            player2.putCardIntoHand(cardToBeGiven);
        }
    }
        
        public Player getPlayer1() {
            return player1;
        }
    
        public Player getPlayer2() {
            return player2;
        }
        
        public Deck getDrawpile() {
            return drawpile;
        }
        
        public Deck getDiscardpile() {
            return discardpile;
        }
        
        public Scanner getAsker() {
            return asker;
        }
}