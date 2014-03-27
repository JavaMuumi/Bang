/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.avatars.PaulRegret;
import bang.banghotseat.avatars.PedroRamirez;
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
public class BangTest {
    
    private Card bang;
    private Player player;
    private Player enemy;
    private Deck drawpile;
    private Deck discardpile;
    
    public BangTest() {
        
        player = new Player();
        player.setAvatar(new PedroRamirez());
        player.setCurrentHealth();
        enemy = new Player();
        enemy.setAvatar(new PedroRamirez());
        enemy.setCurrentHealth();
        drawpile = new Deck();
        discardpile = new Deck();
        bang = new Bang("Hearts", 1);
        player.putCardIntoHand(bang);
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
    public void ifEnemyHasNoMancatoHeWillLose1HealthPoint() {
        
        player.getHandCards().get(0).function(player, enemy, drawpile, discardpile);
        
        assertEquals(3, enemy.getCurrentHealth());
    }
    
    @Test
    public void ifEnemyHasAMancatoHeWontLoseHealth() {
        
        enemy.putCardIntoHand(new Mancato("Hearts", 1));
        player.getHandCards().get(0).function(player, enemy, drawpile, discardpile);
        
        assertEquals(4, enemy.getCurrentHealth());
    }
    
    @Test
    public void ifEnemyHasNoMancatoHeWillNotLoseAnyCards() {
        
        while (enemy.getHandCards().size() < enemy.getCurrentHealth()) {
        enemy.putCardIntoHand(new Bang("Hearts", 1));
        }
        player.getHandCards().get(0).function(player, enemy, drawpile, discardpile);
        
        assertEquals(4, enemy.getHandCards().size());
    }
    
    @Test
    public void ifEnemyHaAMancatoHeWillLoseIt() {
        
        enemy.putCardIntoHand(new Mancato("Hearts", 1));
        player.getHandCards().get(0).function(player, enemy, drawpile, discardpile);
        
        assertEquals(0, enemy.getHandCards().size());
    }
    
    @Test
    public void ifEnemyHasMultipleMancatosHeWillLoseOnlyOne() {
        
        while (enemy.getHandCards().size() < enemy.getCurrentHealth()) {
            enemy.getHandCards().add(new Mancato("Hearts", 1));
        }
        player.getHandCards().get(0).function(player, enemy, drawpile, discardpile);
        
        assertEquals(3, enemy.getHandCards().size());
    }
}