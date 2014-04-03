/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.Round;
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
public class RoseDoolanTest {

    private Round round;

    public RoseDoolanTest() {
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new RoseDoolan());
        round.getDrawpile().createCards();
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
    public void roseDoolanSetsMaxHealthTo4() {
        assertEquals(4, round.getPlayerInTurn().getAvatar().getMaxHealth());
    }
    
    @Test
    public void getSpecialityReturnsCorrectDescriptionForRoseDoolan() {
        assertEquals("She sees all players at a distance decreased by 1.", round.getPlayerInTurn().getAvatar().getSpeciality());
    }

    @Test
    public void roseDoolanDrawsTwoCards() {
        round.getPlayerInTurn().getAvatar().drawCards(round);
        assertEquals(2, round.getPlayerInTurn().getHandCards().size());
    }
    
    @Test
    public void roseDoolanHasNormallyReachOf2() {
        assertEquals(2, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void roseDoolanHasNormallyTouchOf2() {
        assertEquals(2, round.getPlayerInTurn().getTouch());
    }
}