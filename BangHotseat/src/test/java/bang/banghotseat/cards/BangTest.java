/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.avatars.PaulRegret;
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
public class BangTest {
    
    private Card bang;
    private Player player;
    private Player enemy;
    private Deck drawpile;
    private Deck discardpile;
    
    public BangTest() {
        
        player = new Player();
        player.setAvatar(new SuzyLafayette());
        player.setCurrentHealth();
        enemy = new Player();
        enemy.setAvatar(new SuzyLafayette());
        enemy.setCurrentHealth();
        drawpile = new Deck();
        discardpile = new Deck();
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
    public void ifEnemyIsOutOfRangePlayerCannotShootABang() {
        
//        enemy.setAvatar(new PaulRegret());
//        bang.function(player, enemy, null, null, null);
//        
//        assertEquals(4, enemy.getCurrentHealth());
    }
    
}