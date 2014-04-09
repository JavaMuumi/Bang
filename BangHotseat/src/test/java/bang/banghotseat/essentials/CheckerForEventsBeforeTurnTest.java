/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.LuckyDuke;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Barrel;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.cards.Dinamite;
import bang.banghotseat.cards.Mirino;
import bang.banghotseat.cards.Mustang;
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
public class CheckerForEventsBeforeTurnTest {

    private Round round;

    public CheckerForEventsBeforeTurnTest() {

        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new SlabTheKiller());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getPlayerToFollow().setCurrentHealth();
        round.getCheckerForEventsBeforeTurn().setPlayerTurns(round.getPlayerInTurn(), round.getPlayerToFollow());
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
    public void ifTopCardIsHeartsDinamiteWillNotExplode() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifTopCardIsDiamondsDinamiteWillNotExplode() {

        round.getDrawpile().place(new Bang("Diamonds", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifTopCardIsClubsDinamiteWillNotExplode() {

        round.getDrawpile().place(new Bang("Clubs", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifTopCardIs1OfSpadesDinamiteWillNotExplode() {

        round.getDrawpile().place(new Bang("Spades", 1));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifTopCardIs2OfSpadesDinamiteWillExplode() {

        round.getDrawpile().place(new Bang("Spades", 2));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 1", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifTopCardIs9OfSpadesDinamiteWillExplode() {

        round.getDrawpile().place(new Bang("Spades", 9));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 1", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifTopCardIs10OfSpadesDinamiteWillNotExplode() {

        round.getDrawpile().place(new Bang("Spades", 10));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifPlayerIsLuckyDukeAndTheFirstCardHeDrawsWouldNotBlowDinamiteUpButSecondWouldDinamiteWillNotExplode() {

        round.getPlayerInTurn().setAvatar(new LuckyDuke());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getDrawpile().place(new Bang("Hearts", 1));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }

    @Test
    public void ifPlayerIsLuckyDukeAndTheFirstCardHeDrawsWouldBlowDinamiteUpButSecondWouldNotDinamiteWillNotExplode() {

        round.getPlayerInTurn().setAvatar(new LuckyDuke());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 3));
        
        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }
    
    @Test
    public void ifPlayerIsLuckyDukeAndNeitherOfTheDrawnCardsWouldBlowDinamiteUpDinamiteWillNotExplode() {

        round.getPlayerInTurn().setAvatar(new LuckyDuke());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 4", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }
    
    @Test
    public void ifPlayerIsLuckyDukeAndBothOfTheDrawnCardsWouldBlowDinamiteUpDinamiteWillExplode() {

        round.getPlayerInTurn().setAvatar(new LuckyDuke());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getDrawpile().place(new Bang("Spades", 3));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Player health: 1", "Player health: " + round.getPlayerInTurn().getCurrentHealth());
    }
    
    @Test
    public void ifDinamiteDoesNotExplodeAndPlayerToFollowHasNoFrontCardsItWillBePassedOn() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Dinamite", round.getPlayerToFollow().getFrontCards().get(0).getName());
    }

    @Test
    public void ifDinamiteDoesNotExplodeAndPlayerToFollowHasNoDinamiteInFrontCardsItWillBePassedOn() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));
        round.getPlayerToFollow().putCardInFront(new Mirino("Hearts", 2));
        round.getPlayerToFollow().putCardInFront(new Mustang("Hearts", 2));
        round.getPlayerToFollow().putCardInFront(new Barrel("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Dinamite", round.getPlayerToFollow().getFrontCards().get(round.getPlayerToFollow().getFrontCards().size() - 1).getName());
    }

    @Test
    public void ifDinamiteDoesNotExplodeAndPlayerToFollowAlreadyHasADinamiteInFrontItWillStayWithPlayerInTurn() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));
        round.getPlayerToFollow().putCardInFront(new Dinamite("Spades", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Dinamite: 2 of Hearts", round.getPlayerInTurn().getFrontCards().get(0).toString());
    }

    @Test
    public void ifDinamiteDoesNotExplodeAndPlayerToFollowAlreadyHasADinamiteInFrontThisOldDinamiteStaysUnaffected() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));
        round.getPlayerToFollow().putCardInFront(new Dinamite("Spades", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Dinamite: 2 of Spades", round.getPlayerToFollow().getFrontCards().get(0).toString());
    }

    @Test
    public void ifDinamiteExplodesItWillBeRemovedFromHandCardsOfPlayerInTurn() {

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals(true, round.getPlayerInTurn().getFrontCards().isEmpty());
    }

    @Test
    public void ifDinamiteExplodesItWillNotBePassedToPlayerToFollow() {

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals(true, round.getPlayerToFollow().getFrontCards().isEmpty());
    }

    @Test
    public void ifDinamiteExplodesItWillBePlacedInDiscardpile() {

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("Dinamite", round.getDiscardpile().getDeck().get(round.getDiscardpile().getDeck().size() - 1).getName());
    }

    @Test
    public void checkedCardWillBePlacedInDiscardpile() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("BANG!", round.getDiscardpile().getDeck().get(0).getName());
    }

    @Test
    public void checkedCardWillBeRemovedFromDrawpile() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals(true, round.getDrawpile().getDeck().isEmpty());
    }

    @Test
    public void checkedCardWillBeMarkedAsLastCheckedCard() {

        round.getDrawpile().place(new Bang("Hearts", 3));
        round.getPlayerInTurn().putCardInFront(new Dinamite("Hearts", 2));

        round.getCheckerForEventsBeforeTurn().checkDinamite();

        assertEquals("BANG!", round.getPlayerInTurn().getLastCheckedCard().getName());
    }
}