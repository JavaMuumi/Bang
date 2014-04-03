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
public class ElGringoTest {
    
    private Round round;

    public ElGringoTest() {
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new ElGringo());
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
    public void elGringoDrawsTwoCards() {
        round.getPlayerInTurn().getAvatar().drawCards(round);
        assertEquals(2, round.getPlayerInTurn().getHandCards().size());
    }
}