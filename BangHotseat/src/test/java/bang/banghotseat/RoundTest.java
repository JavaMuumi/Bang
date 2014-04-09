/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.avatars.SuzyLafayette;
import bang.banghotseat.avatars.WillyTheKid;
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
public class RoundTest {
    
    private Setup setup = new Setup();
    private Round round;
    
    public RoundTest() {
        setup.runSetup();
        round = new Round(setup.getPlayer1(), setup.getPlayer2(), setup.getDrawpile(), setup.getDiscardpile());
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
    public void player1InSetupIsPlayerInTurnWhenRoundIsConstructed() {
        assertEquals(setup.getPlayer1(), round.getPlayerInTurn());
    }
    
    @Test
    public void player2InSetupIsPlayerToFollowWhenRoundIsConstructed() {
        assertEquals(setup.getPlayer2(), round.getPlayerToFollow());
    }
    
    @Test
    public void whenPlayTurnMethodIsPlayedPlayerDrawsCards() {
        
        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getPlayerInTurn().setCurrentHealth();
        
        round.playTurn();
        
        assertEquals(6, round.getPlayerInTurn().getHandCards().size());
    }
    
    @Test
    public void whenEndTurnMethodIsPlayedPlayerInTurnAndPlayerToFollowAreSwitched() {
        
        round.getPlayerInTurn().setAvatar(new SuzyLafayette());
        round.getPlayerToFollow().setAvatar(new WillyTheKid());
        
        round.endTurn();
        
        assertEquals("Willy The Kid, Suzy Lafayette", round.getPlayerInTurn().getAvatar().toString() + ", " + round.getPlayerToFollow().getAvatar().toString());
    }
}