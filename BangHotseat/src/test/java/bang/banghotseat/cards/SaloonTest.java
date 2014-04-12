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
public class SaloonTest {
    
    private Round round;
    private Card saloon;
    
    public SaloonTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new SlabTheKiller());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getPlayerToFollow().setCurrentHealth();
        saloon = new Saloon("Hearts", 1);
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
    public void nameOfSaloonIsCorrect() {
        assertEquals("Saloon", saloon.getName());
    }

    @Test
    public void typeOfSaloonIsOrange() {
        assertEquals("Orange", saloon.getType());
    }

    @Test
    public void stringOfSaloonIsCorrectForNumbers() {
        
        Card thisSaloon = new Saloon("Hearts", 3);
        assertEquals("Saloon: 3 of Hearts", thisSaloon.toString());
    }
    
    @Test
    public void stringOfSaloonIsCorrectForAces() {
        assertEquals("Saloon: Ace of Hearts", saloon.toString());
    }
    
    @Test
    public void stringOfSaloonIsCorrectForJacks() {
        
        Card thisSaloon = new Saloon("Hearts", 11);
        assertEquals("Saloon: Jack of Hearts", thisSaloon.toString());
    }
    
    @Test
    public void stringOfSaloonIsCorrectForQueens() {
        
        Card thisSaloon = new Saloon("Hearts", 12);
        assertEquals("Saloon: Queen of Hearts", thisSaloon.toString());
    }
    
    @Test
    public void stringOfSaloonIsCorrectForKings() {
        
        Card thisSaloon = new Saloon("Hearts", 13);
        assertEquals("Saloon: King of Hearts", thisSaloon.toString());
    }
    
    @Test
    public void whenPlayerIsWoundedAndEnemyIsAtFullHealthSaloonHealsOnlyPlayerForOneHealthPoint() {
        
        round.getPlayerInTurn().loseHealth(3, round);
        saloon.function(round);
        
        String healthCheck = "Player: " + round.getPlayerInTurn().getCurrentHealth() + ", Enemy: " + round.getPlayerToFollow().getCurrentHealth();
        assertEquals("Player: 2, Enemy: 4", healthCheck);
    }
    
    @Test
    public void whenEnemyIsWoundedAndPlayerIsAtFullHealthSaloonHealsOnlyEnemyForOneHealthPoint() {
        
        round.getPlayerToFollow().loseHealth(3, round);
        saloon.function(round);
        
        String healthCheck = "Player: " + round.getPlayerInTurn().getCurrentHealth() + ", Enemy: " + round.getPlayerToFollow().getCurrentHealth();
        assertEquals("Player: 4, Enemy: 2", healthCheck);
    }
    
    @Test
    public void whenBothPlayersAreAtFullHealthSaloonHealsNeither() {
        
        saloon.function(round);
        
        String healthCheck = "Player: " + round.getPlayerInTurn().getCurrentHealth() + ", Enemy: " + round.getPlayerToFollow().getCurrentHealth();
        assertEquals("Player: 4, Enemy: 4", healthCheck);
    }
    
    @Test
    public void whenBothPlayersAreWoundedSaloonHealsBothForOneHealthPoint() {
        
        round.getPlayerInTurn().loseHealth(3, round);
        round.getPlayerToFollow().loseHealth(3, round);
        saloon.function(round);
        
        String healthCheck = "Player: " + round.getPlayerInTurn().getCurrentHealth() + ", Enemy: " + round.getPlayerToFollow().getCurrentHealth();
        assertEquals("Player: 2, Enemy: 2", healthCheck);
    }
}