/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.PaulRegret;
import bang.banghotseat.avatars.RoseDoolan;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Deck;
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
    
    private Round round;
    
    public PlayerTest() {
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new SlabTheKiller());
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
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
            round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", i));
        }
        assertEquals("BANG!: 3 of Hearts", round.getPlayerInTurn().drawSpecificHandCard(3, round).toString());
    }
    
    @Test
    public void methodDrawSpecificHandCardWillRemoveTheDrawnCardFromPlayersHand() {
        
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerInTurn().drawSpecificHandCard(0, round);
        
        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }
    
    @Test
    public void methodDrawSpecificFrontCardWillReturnTheCorrectHandCard() {
        
        for (int i = 0; i < 5; i++) {
            round.getPlayerInTurn().putCardInFront(new Bang("Hearts", i));
        }
        assertEquals("BANG!: 3 of Hearts", round.getPlayerInTurn().drawSpecificFrontCard(3).toString());
    }
    
    @Test
    public void methodDrawSpecificFrontCardWillRemoveTheDrawnCardFromPlayerFront() {
        
        round.getPlayerInTurn().putCardInFront(new Bang("Hearts", 1));
        round.getPlayerInTurn().drawSpecificFrontCard(0);
        
        assertEquals("Player front cards: 0", "Player front cards: " + round.getPlayerInTurn().getFrontCards().size());
    }
    
    @Test
    public void playerWithoutFrontCardsOrDistanceAffectingAvatarIsAtDistanceOf1() {
        round.getPlayerInTurn().setAvatar(new RoseDoolan());
        assertEquals(1, round.getPlayerInTurn().getDistance());
    }
    
    @Test
    public void playerWithoutFrontCardsAsPaulRegretIsAtDistanceOf2() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        assertEquals(2, round.getPlayerInTurn().getDistance());
    }
    
    @Test
    public void playerOnAMustangIsAtDistanceOf2() {
        round.getPlayerInTurn().setAvatar(new RoseDoolan());
        round.getPlayerInTurn().getFrontCards().add(new Mustang("Hearts", 1));
        assertEquals(2, round.getPlayerInTurn().getDistance());
    }
    
    @Test
    public void playerWithoutFrontCardsOrReachAffectingAvatarHasReachOf1() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        assertEquals(1, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void playerWithoutFrontCardsAsRoseDoolanHasReachOf2() {
        round.getPlayerInTurn().setAvatar(new RoseDoolan());
        assertEquals(2, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void playerWithSchofieldHasReachOf2() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        round.getPlayerInTurn().getFrontCards().add(new Schofield("Hearts", 1));
        assertEquals(2, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void playerWithRemingtonHasReachOf3() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        round.getPlayerInTurn().getFrontCards().add(new Remington("Hearts", 1));
        assertEquals(3, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void playerWithRevCarabineHasReachOf4() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        round.getPlayerInTurn().getFrontCards().add(new RevCarabine("Hearts", 1));
        assertEquals(4, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void playerWithWinchesterHasReachOf5() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        round.getPlayerInTurn().getFrontCards().add(new Winchester("Hearts", 1));
        assertEquals(5, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void playerWithMirinoHasReachOf2() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        round.getPlayerInTurn().getFrontCards().add(new Mirino("Hearts", 1));
        assertEquals(2, round.getPlayerInTurn().getReach());
    }
    
    @Test
    public void playerWithoutFrontCardsOrTouchAffectingAvatarHasTouchOf1() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        assertEquals(1, round.getPlayerInTurn().getTouch());
    }
    
    @Test
    public void playerWithoutFrontCardsAsRoseDoolanHasTouchOf2() {
        round.getPlayerInTurn().setAvatar(new RoseDoolan());
        assertEquals(2, round.getPlayerInTurn().getTouch());
    }
    
    @Test
    public void playerWithMirinoHasTouchOf2() {
        round.getPlayerInTurn().setAvatar(new PaulRegret());
        round.getPlayerInTurn().getFrontCards().add(new Mirino("Hearts", 1));
        assertEquals(2, round.getPlayerInTurn().getTouch());
    }
}