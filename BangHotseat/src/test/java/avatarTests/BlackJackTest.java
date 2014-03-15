/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avatarTests;

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
    
    private Player player = new Player();
    private Deck drawpile = new Deck();
    private Deck discardpile = new Deck();
    
    public BlackJackTest() {
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
        
        player.getHandCards();
        
        assertEquals(2, player.getHandCards().size());
    }
}