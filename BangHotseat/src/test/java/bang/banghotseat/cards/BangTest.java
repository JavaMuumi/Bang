/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.PedroRamirez;
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
public class BangTest {
    
    private Round round;
    private Card bang;
    
    public BangTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new PedroRamirez());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerToFollow().setAvatar(new PedroRamirez());
        round.getPlayerToFollow().setCurrentHealth();
        bang = new Bang("Hearts", 1);
        round.getPlayerInTurn().putCardIntoHand(bang);
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
//    public void ifEnemyHasNoMancatoHeWillLose1HealthPoint() {
//
//        round.getCheckerForPlayedCard().playingCard(0);
//        
//        assertEquals(3, round.getPlayerToFollow().getCurrentHealth());
//    }
    
    @Test
    public void ifEnemyHasAMancatoHeWontLoseHealth() {
        
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
        round.getPlayerInTurn().getHandCards().get(0).function(round);
        
        assertEquals(4, round.getPlayerToFollow().getCurrentHealth());
    }
    
    @Test
    public void ifEnemyHasNoMancatoHeWillNotLoseAnyCards() {
        
        while (round.getPlayerToFollow().getHandCards().size() < round.getPlayerToFollow().getCurrentHealth()) {
        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        }
        round.getPlayerInTurn().getHandCards().get(0).function(round);
        
        assertEquals(4, round.getPlayerToFollow().getHandCards().size());
    }
    
//    @Test
//    public void ifEnemyHasAMancatoHeWillLoseIt() {
//        
//        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
//        round.getPlayerInTurn().getHandCards().get(0).function(round);
//        
//        assertEquals(0, round.getPlayerToFollow().getHandCards().size());
//    }
    
//    @Test
//    public void ifEnemyHasMultipleMancatosHeWillLoseOnlyOne() {
//        
//        while (round.getPlayerToFollow().getHandCards().size() < round.getPlayerToFollow().getCurrentHealth()) {
//            round.getPlayerToFollow().getHandCards().add(new Mancato("Hearts", 1));
//        }
//        round.getCheckerForPlayedCard().playingCard(0);
//        
//        assertEquals(3, round.getPlayerToFollow().getHandCards().size());
//    }
}