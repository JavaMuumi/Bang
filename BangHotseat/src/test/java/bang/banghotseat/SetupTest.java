/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.essentials.Player;
import bang.banghotseat.userInterface.TextInterface;
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
public class SetupTest {
    
    private TextInterface text = new TextInterface();
    private Setup setup = new Setup(text);
    
    public SetupTest() {
        text.go(setup);
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
    public void player1HasHisMaxHealthAmountOfHandCards() {
        
        int numberOfPlayer1HandCards = setup.getPlayer1().getHandCards().size();
        assertEquals(setup.getPlayer1().getCurrentHealth(), numberOfPlayer1HandCards);
    }
    
    @Test
    public void player2HasHisMaxHealthAmountOfHandCards() {     
        int numberOfPlayer2HandCards = setup.getPlayer2().getHandCards().size();
        assertEquals(setup.getPlayer2().getCurrentHealth(), numberOfPlayer2HandCards);
    }
    
    @Test
    public void player1hasAnAvatar() {
    }
}