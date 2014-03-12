/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.AvatarRandomizer;
import bang.banghotseat.essentials.Player;

/**
 *
 * @author Antti Korpi
 */
public class Setup {
    
    public Player player1 = new Player();
    public Player player2 = new Player();
    public AvatarRandomizer randomizer = new AvatarRandomizer();
    public Deck drawpile;
    public Deck discardpile;
    
    public Setup() {
        givePlayersAvatarsAndSetMaxHealths();
        createDecks();
    }
    
    public void givePlayersAvatarsAndSetMaxHealths() {
        player1.setAvatar(randomizer);
        player1.setCurrentHealth();
        player2.setAvatar(randomizer);
        player2.setCurrentHealth();
    }
    
    public void createDecks() {
        this.drawpile = new Deck();
        drawpile.createCards();
        this.discardpile = new Deck();
    }
}