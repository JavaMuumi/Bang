/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

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
public class DiligenzaTest {
    
    private Card diligenza;
    private Player player;
    private Deck drawpile;
    private Deck discardpile;
    
    public DiligenzaTest() {
        
        diligenza = new Diligenza("Hearts", 1);
        player = new Player();
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
    public void afterPlayingDiligenzaPlayerHas2HandCards() {
        diligenza.function(player, null, drawpile, discardpile, null);
        assertEquals(2, player.getHandCards().size());
    }
}