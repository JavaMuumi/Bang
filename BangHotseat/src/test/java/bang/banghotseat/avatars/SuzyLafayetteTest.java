/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.Round;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.cards.Mancato;
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
public class SuzyLafayetteTest {
    
    private Round round;
    
    public SuzyLafayetteTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new SuzyLafayette());
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
    public void suzyDrawsTwoCards() {
        
        round.getDrawpile().createCards();
        
        round.getPlayerInTurn().getAvatar().drawCards(round);
        assertEquals(2, round.getPlayerInTurn().getHandCards().size());
    }
    
    @Test
    public void ifSuzyPlaysHerLastCardOnHerTurnSheWillDrawAnotherone() {
        
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getDrawpile().place(new Mancato("Hearts", 1));
        
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Mancato!", round.getPlayerInTurn().getHandCards().get(0).getName());
    }
}