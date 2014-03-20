/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.avatars.PaulRegret;
import bang.banghotseat.avatars.RoseDoolan;
import bang.banghotseat.cards.Mirino;
import bang.banghotseat.cards.Mustang;
import bang.banghotseat.cards.Remington;
import bang.banghotseat.cards.RevCarabine;
import bang.banghotseat.cards.Schofield;
import bang.banghotseat.cards.Winchester;
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
public class PlayerTest {
    
    private Player player;
    
    public PlayerTest() {
        player = new Player();
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
    public void playerWithoutFrontCardsOrDistanceAffectingAvatarIsAtDistanceOf1() {
        player.setAvatar(new RoseDoolan());
        assertEquals(1, player.getDistance());
    }
    
    @Test
    public void playerWithoutFrontCardsAsPaulRegretIsAtDistanceOf2() {
        player.setAvatar(new PaulRegret());
        assertEquals(2, player.getDistance());
    }
    
    @Test
    public void playerOnAMustangIsAtDistanceOf2() {
        player.setAvatar(new RoseDoolan());
        player.getFrontCards().add(new Mustang("Hearts", 1));
        assertEquals(2, player.getDistance());
    }
    
    @Test
    public void playerWithoutFrontCardsOrReachAffectingAvatarHasReachOf1() {
        player.setAvatar(new PaulRegret());
        assertEquals(1, player.getReach());
    }
    
    @Test
    public void playerWithoutFrontCardsAsRoseDoolanHasReachOf2() {
        player.setAvatar(new RoseDoolan());
        assertEquals(2, player.getReach());
    }
    
    @Test
    public void playerWithSchofieldHasReachOf2() {
        player.setAvatar(new PaulRegret());
        player.getFrontCards().add(new Schofield("Hearts", 1));
        assertEquals(2, player.getReach());
    }
    
    @Test
    public void playerWithRemingtonHasReachOf3() {
        player.setAvatar(new PaulRegret());
        player.getFrontCards().add(new Remington("Hearts", 1));
        assertEquals(3, player.getReach());
    }
    
    @Test
    public void playerWithRevCarabineHasReachOf4() {
        player.setAvatar(new PaulRegret());
        player.getFrontCards().add(new RevCarabine("Hearts", 1));
        assertEquals(4, player.getReach());
    }
    
    @Test
    public void playerWithWinchesterHasReachOf5() {
        player.setAvatar(new PaulRegret());
        player.getFrontCards().add(new Winchester("Hearts", 1));
        assertEquals(5, player.getReach());
    }
    
    @Test
    public void playerWithMirinoHasReachOf2() {
        player.setAvatar(new PaulRegret());
        player.getFrontCards().add(new Mirino("Hearts", 1));
        assertEquals(2, player.getReach());
    }
    
    @Test
    public void playerWithoutFrontCardsOrTouchAffectingAvatarHasTouchOf1() {
        player.setAvatar(new PaulRegret());
        assertEquals(1, player.getTouch());
    }
    
    @Test
    public void playerWithoutFrontCardsAsRoseDoolanHasTouchOf2() {
        player.setAvatar(new RoseDoolan());
        assertEquals(2, player.getTouch());
    }
    
    @Test
    public void playerWithMirinoHasTouchOf2() {
        player.setAvatar(new PaulRegret());
        player.getFrontCards().add(new Mirino("Hearts", 1));
        assertEquals(2, player.getTouch());
    }
}