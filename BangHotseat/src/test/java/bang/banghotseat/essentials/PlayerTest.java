/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.avatars.PaulRegret;
import bang.banghotseat.avatars.RoseDoolan;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Mirino;
import bang.banghotseat.cards.Mustang;
import bang.banghotseat.cards.Remington;
import bang.banghotseat.cards.RevCarabine;
import bang.banghotseat.cards.Schofield;
import bang.banghotseat.cards.Winchester;
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
    public void methodDrawSpecificHandCardWillReturnTheCorrectHandCard() {
        
        for (int i = 0; i < 5; i++) {
            player.putCardIntoHand(new Bang("Hearts", i));
        }
        assertEquals("BANG!: 3 of Hearts", player.drawSpecificHandCard(3).toString());
    }
    
    @Test
    public void methodDrawSpecificHandCardWillRemoveTheDrawnCardFromPlayersHand() {
        
        player.putCardIntoHand(new Bang("Hearts", 1));
        player.drawSpecificHandCard(0);
        
        assertEquals("Player hand cards: 0", "Player hand cards: " + player.getHandCards().size());
    }
    
    @Test
    public void methodDrawSpecificFrontCardWillReturnTheCorrectHandCard() {
        
        for (int i = 0; i < 5; i++) {
            player.putCardInFront(new Bang("Hearts", i));
        }
        assertEquals("BANG!: 3 of Hearts", player.drawSpecificFrontCard(3).toString());
    }
    
    @Test
    public void methodDrawSpecificFrontCardWillRemoveTheDrawnCardFromPlayerFront() {
        
        player.putCardInFront(new Bang("Hearts", 1));
        player.drawSpecificFrontCard(0);
        
        assertEquals("Player front cards: 0", "Player front cards: " + player.getFrontCards().size());
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