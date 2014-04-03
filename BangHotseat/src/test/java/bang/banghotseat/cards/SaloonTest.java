/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.avatars.SuzyLafayette;
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
    public void whenPlayerIsWoundedAndEnemyIsAtFullHealthSaloonHealsOnlyPlayerForOneHealthPoint() {
        
        round.getPlayerInTurn().loseHealth(3);
        saloon.function(round);
        
        String healthCheck = "Player: " + round.getPlayerInTurn().getCurrentHealth() + ", Enemy: " + round.getPlayerToFollow().getCurrentHealth();
        assertEquals("Player: 2, Enemy: 4", healthCheck);
    }
    
    @Test
    public void whenEnemyIsWoundedAndPlayerIsAtFullHealthSaloonHealsOnlyEnemyForOneHealthPoint() {
        
        round.getPlayerToFollow().loseHealth(3);
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
        
        round.getPlayerInTurn().loseHealth(3);
        round.getPlayerToFollow().loseHealth(3);
        saloon.function(round);
        
        String healthCheck = "Player: " + round.getPlayerInTurn().getCurrentHealth() + ", Enemy: " + round.getPlayerToFollow().getCurrentHealth();
        assertEquals("Player: 2, Enemy: 2", healthCheck);
    }
}