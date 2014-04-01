/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.Player;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Antti Korpi
 */
public class JourdonnaisTest {

    private Player player;
    private Player enemy;
    private Deck drawpile;
    private Deck discardpile;
    
    public JourdonnaisTest() {
        player = new Player();
        player.setAvatar(new Jourdonnais());
        enemy = new Player();
        drawpile = new Deck();
        drawpile.createCards();
        discardpile = new Deck();
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
    public void jourdonnaisDrawsTwoCards() {
        player.getAvatar().drawCards(drawpile, discardpile, player, enemy);
        assertEquals(2, player.getHandCards().size());
    }
}