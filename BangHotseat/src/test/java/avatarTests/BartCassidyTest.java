/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package avatarTests;

import bang.banghotseat.avatars.BartCassidy;
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
public class BartCassidyTest {
    
    private Player player = new Player();
    
    public BartCassidyTest() {
        player.setAvatar(new BartCassidy());
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
    public void whenTakingDamageBartCassidyDrawsACard() {
        
    }
}