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
public class WellsFargoTest {
    
    private Card wellsFargo;
    private Player player;
    private Deck drawpile;
    private Deck discardpile;
    
    public WellsFargoTest() {
        
        wellsFargo = new WellsFargo("Hearts", 1);
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
    public void afterPlayingWellsFargoPlayerHas3HandCards() {
        wellsFargo.function(player, null, drawpile, discardpile);
        assertEquals(3, player.getHandCards().size());
    }
}