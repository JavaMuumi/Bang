/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.cards.Dinamite;
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
public class CheckerForEventsBeforeTurnTest {
    
    private Round round;
    
    public CheckerForEventsBeforeTurnTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new SlabTheKiller());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getPlayerToFollow().setCurrentHealth();
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
    
//    @Test
//    public void whenPlayerInTurnDoesNotHaveAnyFrontCardsHeWillNotLoseHealth() {
//        
//        round.getCheckerForEventsBeforeTurn().checkDinamite();
//        
//        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
//    }
//    
//    @Test
//    public void whenPlayerHasDinamiteAndTheTopCardOfDrawPileIsHeartsDinamiteWillBePassedToPlayerToFollow() {
//        
//        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 1));
//        round.getDrawpile().place(new Bang("Hearts", 1));
//        
//        round.getCheckerForEventsBeforeTurn().checkDinamite();
//    }
}