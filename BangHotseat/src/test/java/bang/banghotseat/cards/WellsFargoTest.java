/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;
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
    
    private Round round;
    private Card wellsFargo;
    
    public WellsFargoTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getDrawpile().createCards();
        wellsFargo = new WellsFargo("Hearts", 1);
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
        wellsFargo.function(round);
        assertEquals(3, round.getPlayerInTurn().getHandCards().size());
    }
}