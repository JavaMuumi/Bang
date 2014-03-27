/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.PaulRegret;
import bang.banghotseat.avatars.PedroRamirez;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.CatBalou;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.cards.Mancato;
import bang.banghotseat.cards.Panico;
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
public class CheckerForPlayedCardTest {
    
    private Round round;
    
    public CheckerForPlayedCardTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new PedroRamirez());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerToFollow().setAvatar(new PedroRamirez());
        round.getPlayerToFollow().setCurrentHealth();
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
    public void whenPlayingBangAgainstEnemyOutOfReachEnemyWillNotLoseHealth() {
        
        round.getPlayerToFollow().setAvatar(new PaulRegret());
        round.getPlayerToFollow().setCurrentHealth();
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
        
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Enemy health: 3", "Enemy health: " + round.getPlayerToFollow().getCurrentHealth());
    }
    
    @Test
    public void whenPlayingBangAgainstEnemyOutOfReachNeitherWillLoseCards() {
        
        round.getPlayerToFollow().setAvatar(new PaulRegret());
        round.getPlayerToFollow().setCurrentHealth();
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
        
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Player hand cards: 1, Enemy hand cards: 1", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size() + ", Enemy hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }
    
    @Test
    public void onlyOneBangCanBePlayedInOneTurnIfPlayerAvatarIsNotWillyTheKidOrThePlayerDoesNotHaveAVolcanicInFrontOfHim() {
        
        for (int i = 0; i < 3; i++) {
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);
        }
        assertEquals("Player hand cards: 2", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }
    
    @Test
    public void atTheBeginningOfATurnBooleanBangHasBeenPlayedIsFalse() {
        
        assertEquals(false, round.getBangHasBeenPlayed());
    }
    
    @Test
    public void afterPlayingABangBooleanBangHasBeenPlayedIsTrue() {
        
        round.getPlayerInTurn().putCardIntoHand(new Bang ("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals(true, round.getBangHasBeenPlayed());
    }
    
    @Test
    public void afterPlayingABangTheBangCardWillBeInDiscardPile() {
        
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Discardpile size: 1", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }
    
    @Test
    public void afterPlayingABangAndEnemyHasPlayedAMancatoBothWillBeInDiscardPile() {
        
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Discardpile size: 2", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }
    
    @Test
    public void whenPlayingPanicoAgainstEnemyOutOfReachNeitherWillLoseCards() {
        
        round.getPlayerToFollow().setAvatar(new PaulRegret());
        round.getPlayerToFollow().setCurrentHealth();
        round.getPlayerInTurn().putCardIntoHand(new Panico("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
        
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Player hand cards: 1, Enemy hand cards: 1", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size() + ", Enemy hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }
    
    @Test
    public void afterPlayingAPanicoTheCardWillBeInDiscardPile() {
        
        round.getPlayerInTurn().putCardIntoHand(new Panico("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Discardpile size: 1", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }
    
    @Test
    public void afterPlayingACatBalouTheCardWillBeInDiscardPile() {
        
        round.getPlayerInTurn().putCardIntoHand(new CatBalou("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);
        
        assertEquals("Discardpile size: 1", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }
}