/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatarTests;

import bang.banghotseat.avatars.BlackJack;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antti Korpi
 */
public class BlackJackTest {
    
    private Player player;
    private Player enemy;
    private Deck drawpile;
    private Deck discardpile;
    
    public BlackJackTest() {
        player = new Player();
        enemy = new Player();
        drawpile = new Deck();
        discardpile = new Deck();
        player.setAvatar(new BlackJack());
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void whenSecondCardIsSpadesBlackJackGetsFirstAndSecondCardButNotThird() {
        drawpile.getDeck().add(new Bang("Hearts", 1));
        drawpile.getDeck().add(new Bang("Spades", 1));
        drawpile.getDeck().add(new Bang("Hearts", 1));
        
        player.getAvatar().drawCards(drawpile, discardpile, player, enemy);
        
        assertEquals(2, player.getHandCards().size());
    }
    
    @Test
    public void whenSecondCardIsClubsBlackJackGetsFirstAndSecondCardButNotThird() {
        drawpile.getDeck().add(new Bang("Hearts", 1));
        drawpile.getDeck().add(new Bang("Clubs", 1));
        drawpile.getDeck().add(new Bang("Hearts", 1));
        
        player.getAvatar().drawCards(drawpile, discardpile, player, enemy);
        
        assertEquals(2, player.getHandCards().size());
    }
    
    @Test
    public void whenSecondCardIsHeartsBlackJackGetsFirstAndSecondCardAndOneMore() {
        drawpile.getDeck().add(new Bang("Hearts", 1));
        drawpile.getDeck().add(new Bang("Hearts", 1));
        drawpile.getDeck().add(new Bang("Hearts", 1));
        
        player.getAvatar().drawCards(drawpile, discardpile, player, enemy);
        
        assertEquals(3, player.getHandCards().size());
    }
    
    @Test
    public void whenSecondCardIsDiamondsBlackJackGetsFirstAndSecondCardAndOneMore() {
        drawpile.getDeck().add(new Bang("Hearts", 1));
        drawpile.getDeck().add(new Bang("Diamonds", 1));
        drawpile.getDeck().add(new Bang("Hearts", 1));
        
        player.getAvatar().drawCards(drawpile, discardpile, player, enemy);
        
        assertEquals(3, player.getHandCards().size());
    }
}