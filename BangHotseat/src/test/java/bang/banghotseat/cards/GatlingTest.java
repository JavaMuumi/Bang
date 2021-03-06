/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.SlabTheKiller;
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
public class GatlingTest {
    
    private Round round;
    private Card gatling;
    
    public GatlingTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        gatling = new Gatling("Hearts", 1);
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
    public void nameOfGatlingIsCorrect() {
        assertEquals("Gatling", gatling.getName());
    }

    @Test
    public void typeOfGatlingIsOrange() {
        assertEquals("Orange", gatling.getType());
    }

    @Test
    public void stringOfGatlingIsCorrectForNumbers() {
        
        Card thisGatling = new Gatling("Hearts", 3);
        assertEquals("Gatling: 3 of Hearts", thisGatling.toString());
    }
    
    @Test
    public void stringOfGatlingIsCorrectForAces() {
        assertEquals("Gatling: Ace of Hearts", gatling.toString());
    }
    
    @Test
    public void stringOfGatlingIsCorrectForJacks() {
        
        Card thisGatling = new Gatling("Hearts", 11);
        assertEquals("Gatling: Jack of Hearts", thisGatling.toString());
    }
    
    @Test
    public void stringOfGatlingIsCorrectForQueens() {
        
        Card thisGatling = new Gatling("Hearts", 12);
        assertEquals("Gatling: Queen of Hearts", thisGatling.toString());
    }
    
    @Test
    public void stringOfGatlingIsCorrectForKings() {
        
        Card thisGatling = new Gatling("Hearts", 13);
        assertEquals("Gatling: King of Hearts", thisGatling.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", gatling.getSuit());
    }
    
    @Test
    public void metfodFunctionOfGatlingMakesPlayerToFollowLoseOneHealthPoint() {
        
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getPlayerToFollow().setCurrentHealth();
        gatling.function(round);
        
        assertEquals("Player to follow health: 3", "Player to follow health: " + round.getPlayerToFollow().getCurrentHealth());
    }
}