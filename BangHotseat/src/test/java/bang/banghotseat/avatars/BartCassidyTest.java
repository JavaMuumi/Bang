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
public class BartCassidyTest {

    private Round round;

    public BartCassidyTest() {
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new BartCassidy());
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
    public void bartCassidySetsMaxHealthTo4() {
        assertEquals(4, round.getPlayerInTurn().getAvatar().getMaxHealth());
    }
    
    @Test
    public void getSpecialityReturnsCorrectDescriptionForBartCassidy() {
        assertEquals("Each time he is hit, he draws a card.", round.getPlayerInTurn().getAvatar().getSpeciality());
    }

    @Test
    public void bartCassidyDrawsTwoCards() {
        round.getPlayerInTurn().getAvatar().drawCards(round);
        assertEquals(2, round.getPlayerInTurn().getHandCards().size());
    }
}