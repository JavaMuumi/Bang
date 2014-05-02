/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.avatars.SuzyLafayette;
import bang.banghotseat.avatars.WillyTheKid;
import bang.banghotseat.cards.Bang;
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
public class RoundTest {

    private Setup setup;

    public RoundTest() {
        
        setup = new Setup();
        setup.runSetup();
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
    public void player1InSetupIsPlayerInTurnWhenRoundIsConstructed() {
        assertEquals(setup.getPlayer1(), setup.getRound().getPlayerInTurn());
    }

    @Test
    public void player2InSetupIsPlayerToFollowWhenRoundIsConstructed() {
        assertEquals(setup.getPlayer2(), setup.getRound().getPlayerToFollow());
    }

    @Test
    public void whenPlayTurnMethodIsPlayedPlayerDrawsCards() {

        setup.getRound().getPlayerInTurn().setAvatar(new WillyTheKid());
        setup.getRound().getPlayerInTurn().setCurrentHealth();

        setup.getRound().playTurn();

        assertEquals(6, setup.getRound().getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void whenEndTurnMethodIsPlayedPlayerInTurnAndPlayerToFollowAreSwitched() {

        setup.getRound().getPlayerInTurn().setAvatar(new SuzyLafayette());
        setup.getRound().getPlayerToFollow().setAvatar(new WillyTheKid());

        setup.getRound().endTurn();

        assertEquals("Willy The Kid, Suzy Lafayette", setup.getRound().getPlayerInTurn().getAvatar().toString() + ", " + setup.getRound().getPlayerToFollow().getAvatar().toString());
    }

    @Test
    public void methodEndTurnClearsListOfLastCheckedCards() {

        for (int i = 0; i < 5; i++) {
            setup.getRound().getPlayerInTurn().setLastCheckedCard(new Bang("Hearts", 1));
        }
        setup.getRound().endTurn();

        assertEquals("Last checked cards: 0", "Last checked cards: " + setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void playerInTurnIsNextToReachToDuelloIsFalseWhenRoundBegins() {

        assertEquals(false, setup.getRound().playerInTurnIsNextToReactToDuello());
    }

    @Test
    public void methodSetPlayerInTurnIsNextToReactToDuelloSetsGivenBoolean() {

        setup.getRound().setPlayerInTurnIsNextToReactToDuello(true);

        assertEquals(true, setup.getRound().playerInTurnIsNextToReactToDuello());
    }

    @Test
    public void ifNeitherPlayerIsDeadMethodGameIsOverReturnsFalse() {

        setup.getRound().getPlayerInTurn().setAvatar(new SlabTheKiller());
        setup.getRound().getPlayerInTurn().setCurrentHealth();
        setup.getRound().getPlayerToFollow().setAvatar(new SlabTheKiller());
        setup.getRound().getPlayerToFollow().setCurrentHealth();

        assertEquals(false, setup.getRound().gameIsOver());
    }

    @Test
    public void ifPlayerInTurnIsDeadMethodGameIsOverReturnsTrue() {

        setup.getRound().getPlayerInTurn().setAvatar(new SlabTheKiller());
        setup.getRound().getPlayerInTurn().setCurrentHealth();
        setup.getRound().getPlayerToFollow().setAvatar(new SlabTheKiller());
        setup.getRound().getPlayerToFollow().setCurrentHealth();

        setup.getRound().getPlayerInTurn().loseHealth(4, setup.getRound());

        assertEquals(true, setup.getRound().gameIsOver());
    }

    @Test
    public void ifPlayerToFollowIsDeadMethodGameIsOverReturnsTrue() {

        setup.getRound().getPlayerInTurn().setAvatar(new SlabTheKiller());
        setup.getRound().getPlayerInTurn().setCurrentHealth();
        setup.getRound().getPlayerToFollow().setAvatar(new SlabTheKiller());
        setup.getRound().getPlayerToFollow().setCurrentHealth();

        setup.getRound().getPlayerToFollow().loseHealth(4, setup.getRound());


        assertEquals(true, setup.getRound().gameIsOver());
    }
       
    @Test
    public void whenGameIsFinishedAndNewBeginsDrawpileHas79CardsAndDiscardpileIsEmpty() {
        
        setup.runSetup();
        
        assertEquals("Drawpile: 79 cards, discardpile: 0 cards", "Drawpile: " + (setup.getRound().getDrawpile().getDeck().size() + setup.getRound().getPlayerInTurn().getHandCards().size() + setup.getRound().getPlayerToFollow().getHandCards().size()) + " cards, discardpile: " + setup.getRound().getDiscardpile().getDeck().size() + " cards");
    }
    
    @Test
    public void whenGameIsFinishedAndNewBeginsNeitherPlayerHasAnyFrontCards() {
        
        setup.getRound().getPlayerInTurn().putCardInFront(setup.getRound().getDrawpile().take(setup.getRound().getDiscardpile()));
        setup.getRound().getPlayerToFollow().putCardInFront(setup.getRound().getDrawpile().take(setup.getRound().getDiscardpile()));
        
        setup.runSetup();
        
        assertEquals("Player in turn front cards: 0, player to follow front cards: 0", "Player in turn front cards: " + setup.getRound().getPlayerInTurn().getFrontCards().size() + ", player to follow front cards: " + setup.getRound().getPlayerToFollow().getFrontCards().size());
    }
}