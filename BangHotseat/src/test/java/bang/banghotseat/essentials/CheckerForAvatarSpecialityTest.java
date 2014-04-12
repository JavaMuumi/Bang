/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.BartCassidy;
import bang.banghotseat.avatars.ElGringo;
import bang.banghotseat.avatars.Jourdonnais;
import bang.banghotseat.avatars.LuckyDuke;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.avatars.SuzyLafayette;
import bang.banghotseat.avatars.WillyTheKid;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Deck;
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
public class CheckerForAvatarSpecialityTest {

    private Round round;

    public CheckerForAvatarSpecialityTest() {

        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new SlabTheKiller());
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getDrawpile().createCards();
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
    public void ifPlayerIsNotSuzyLafayetteMethodCheckSuzyLafayetteForEmptyHandDoesNotGiveHimCards() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getCheckerForAvatarSpeciality().checkSuzyLafayetteForEmptyHand(round.getPlayerInTurn());

        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void ifPlayerIsSuzyLafayetteMethodCheckSuzyLafayetteForEmptyHandDoesNotGiveHimCards() {

        round.getPlayerInTurn().setAvatar(new SuzyLafayette());
        round.getCheckerForAvatarSpeciality().checkSuzyLafayetteForEmptyHand(round.getPlayerInTurn());

        assertEquals("Player hand cards: 1", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void methodCheckTwoCardsForLuckyDukeMarksTwoCardsToListOfLastCheckedCardsOfPlayerInTurn() {

        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals("List of last checked cards: 2", "List of last checked cards: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void ifFirstDrawnCardIsHeartsButSecondIsNotMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsTrue() {

        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifFirstDrawnCardIsNotHeartsButSecondIsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsTrue() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifBothDrawnCardsAreHeartsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsTrue() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifNeitherDrawnCardIsHeartsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsFalse() {

        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifFirstDrawnCardWouldNotBlowDinamiteUpButSecondWouldMehtodCheckIfDinamiteExplodesOnLuckyDukeReturnsFalse() {

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifFirstDrawnCardWouldBlowDinamiteUpButSecondWouldNotMehtodCheckIfDinamiteExplodesOnLuckyDukeReturnsFalse() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 3));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifNeitherDrawnCardsWouldBlowDinamiteUpMethodCheckIfDinamiteExplodesOnLuckyDukeReturnsFalse() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifBothDrawnCardsWouldBlowDinamiteUpMethodCheckIfDinamiteExplodesOnLuckyDukeReturnsTrue() {

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getDrawpile().place(new Bang("Spades", 3));
        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifPlayerToFollowIsNotJourdonnaisCheckJourdonnaisDoesNotSetLastCheckedCardOfPlayerInTurn() {

        round.getPlayerToFollow().setAvatar(new LuckyDuke());
        round.getCheckerForAvatarSpeciality().checkJourdonnais();

        assertEquals("List of last checked cards: 0", "List of last checked cards: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void ifPlayerToFollowIsJourdonnaisCheckJourdonnaisSetsLastCheckedCardOfPlayerInTurn() {

        round.getPlayerToFollow().setAvatar(new Jourdonnais());
        round.getCheckerForAvatarSpeciality().checkJourdonnais();

        assertEquals("List of last checked cards: 1", "List of last checked cards: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void ifPlayerToFollowIsNotJourdonnaisCheckJourdonnaisReturnsFalse() {

        round.getPlayerToFollow().setAvatar(new LuckyDuke());

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkJourdonnais());
    }

    @Test
    public void ifPlayerToFollowIsJourdonnaisCheckJourdonnaisReturnsTrue() {

        round.getPlayerToFollow().setAvatar(new Jourdonnais());

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkJourdonnais());
    }

    @Test
    public void methodDrawFromEnemyHandWithJesseJonesGivesPlayer2Cards() {

        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().drawFromEnemyHandWithJesseJones();

        assertEquals("Hand cards: 2", "Hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void methodDrawFromEnemyHandWithJesseJonesDrawsFirstCardFromEnemyHand() {

        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().drawFromEnemyHandWithJesseJones();

        assertEquals("BANG!: Ace of Hearts", round.getPlayerInTurn().getHandCards().get(round.getPlayerInTurn().getHandCards().size() - 2).toString());
    }

    @Test
    public void methodDrawFromEnemyHandWithJesseJonesDrawsSecondCardFromDeck() {

        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getCheckerForAvatarSpeciality().drawFromEnemyHandWithJesseJones();

        assertEquals("BANG!: Ace of Spades", round.getPlayerInTurn().getHandCards().get(round.getPlayerInTurn().getHandCards().size() - 1).toString());
    }

    @Test
    public void methodDrawFromEnemyHandWithJesseJonesDrawsOnlyOneCardFromEnemyHand() {

        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().drawFromEnemyHandWithJesseJones();

        assertEquals("Enemy hand cards: 1", "Enemy hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }

    @Test
    public void whenBartCassidyLosesOneHealthPointHeDrawsACardFromDrawpile() {

        round.getPlayerToFollow().setAvatar(new BartCassidy());
        round.getPlayerToFollow().loseHealth(1, round);

        assertEquals("Player hand cards: 1", "Player hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }

    @Test
    public void whenBartCassidyLosesThreeHealthPointsHeWillDrawThreeCards() {

        round.getPlayerToFollow().setAvatar(new BartCassidy());
        round.getPlayerToFollow().loseHealth(3, round);

        assertEquals("Player hand cards: 3", "Player hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }

    @Test
    public void ifElGringoTakesAHitAndEnemyHasNoHandCardsHeGetsNoCards() {

        round.getPlayerToFollow().setAvatar(new ElGringo());
        round.getPlayerToFollow().loseHealth(1, round);

        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }

    @Test
    public void ifElGringoTakesAHitAndEnemyHasHandCardsHeStealsOne() {

        round.getPlayerToFollow().setAvatar(new ElGringo());
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().loseHealth(1, round);

        assertEquals("Player hand cards: 1", "Player hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }

    @Test
    public void ifElGringoTakesAHitAndEnemyHasHandCardsHeStealsOnlyOne() {

        round.getPlayerToFollow().setAvatar(new ElGringo());
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().loseHealth(1, round);

        assertEquals("Player hand cards: 1", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void ifElGringoLosesThreeHealthPointsHeWillNotDrawEnemyCards() {

        round.getPlayerToFollow().setAvatar(new ElGringo());
        round.getPlayerToFollow().loseHealth(3, round);

        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }
}