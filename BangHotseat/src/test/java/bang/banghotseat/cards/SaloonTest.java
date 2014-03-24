/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

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
    
    private Card saloon;
    private Player player;
    private Player enemy;
    
    public SaloonTest() {
        saloon = new Saloon("Hearts", 1);
        player = new Player();
        player.setAvatar(new SuzyLafayette());
        player.setCurrentHealth();
        enemy = new Player();
        enemy.setAvatar(new SuzyLafayette());
        enemy.setCurrentHealth();
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
        
        player.loseHealth(3);
        saloon.function(player, enemy, null, null, null);
        
        String healthCheck = "Player: " + player.getCurrentHealth() + ", Enemy: " + enemy.getCurrentHealth();
        assertEquals("Player: 2, Enemy: 4", healthCheck);
    }
    
    @Test
    public void whenEnemyIsWoundedAndPlayerIsAtFullHealthSaloonHealsOnlyEnemyForOneHealthPoint() {
        
        enemy.loseHealth(3);
        saloon.function(player, enemy, null, null, null);
        
        String healthCheck = "Player: " + player.getCurrentHealth() + ", Enemy: " + enemy.getCurrentHealth();
        assertEquals("Player: 4, Enemy: 2", healthCheck);
    }
    
    @Test
    public void whenBothPlayersAreAtFullHealthSaloonHealsNeither() {
        
        saloon.function(player, enemy, null, null, null);
        
        String healthCheck = "Player: " + player.getCurrentHealth() + ", Enemy: " + enemy.getCurrentHealth();
        assertEquals("Player: 4, Enemy: 4", healthCheck);
    }
    
    @Test
    public void whenBothPlayersAreWoundedSaloonHealsBothForOneHealthPoint() {
        
        player.loseHealth(3);
        enemy.loseHealth(3);
        saloon.function(player, enemy, null, null, null);
        
        String healthCheck = "Player: " + player.getCurrentHealth() + ", Enemy: " + enemy.getCurrentHealth();
        assertEquals("Player: 2, Enemy: 2", healthCheck);
    }
}