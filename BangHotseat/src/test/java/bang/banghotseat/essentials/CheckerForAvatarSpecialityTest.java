/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.BartCassidy;
import bang.banghotseat.avatars.CalamityJanet;
import bang.banghotseat.avatars.ElGringo;
import bang.banghotseat.avatars.Jourdonnais;
import bang.banghotseat.avatars.LuckyDuke;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.avatars.SuzyLafayette;
import bang.banghotseat.avatars.WillyTheKid;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Barrel;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.cards.Mancato;
import bang.banghotseat.cards.Prigione;
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
    public void methodSetSecondDrawnCardOfBlackJackReallySetsGivenCard() {

        round.getCheckerForAvatarSpeciality().setSecondDrawnCardOfBlackJack(new Bang("Hearts", 1));

        assertEquals("BANG!: Ace of Hearts", round.getCheckerForAvatarSpeciality().getSecondDrawnCardOfBlackJack().toString());
    }

    @Test
    public void ifCalamityJanetHasABangItWillBeAccountedForWhenSearchingForBangsOrMancatos() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());
        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkCalamityJanetForBangsOrMancatos());
    }

    @Test
    public void ifCalamityJanetHasAMancatoItWillBeAccountedForWhenSearchingForBangsOrMancatos() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkCalamityJanetForBangsOrMancatos());
    }

    @Test
    public void methodGetIndexOfABangOrMancatoInHandOfCalamityJanetReturnsIndexOfMancatoIfPlayerHasOne() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));

        assertEquals("Index of Mancato!: 0", "Index of Mancato!: " + round.getCheckerForAvatarSpeciality().getIndexOfABangOrMancatoInHandOfCalamityJanet(round.getPlayerToFollow()));
    }

    @Test
    public void methodGetIndexOfABangOrMancatoInHandOfCalamityJanetReturnsIndexOfBangIfPlayerOne() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());
        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));

        assertEquals("Index of BANG!: 0", "Index of BANG!: " + round.getCheckerForAvatarSpeciality().getIndexOfABangOrMancatoInHandOfCalamityJanet(round.getPlayerToFollow()));
    }

    @Test
    public void methodGetIndexOfABangOrMancatoInHandOfCalamityJanetReturnsCorrectIndex() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());
        round.getPlayerToFollow().putCardIntoHand(new Barrel("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Barrel("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Barrel("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Barrel("Hearts", 1));

        assertEquals("Index of BANG!: 2", "Index of BANG!: " + round.getCheckerForAvatarSpeciality().getIndexOfABangOrMancatoInHandOfCalamityJanet(round.getPlayerToFollow()));
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
    public void ifElGringoStealsACardItWillBeAddedToTheListOfLastCheckedCardsOfPlayerInTurn() {

        round.getPlayerToFollow().setAvatar(new ElGringo());
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().loseHealth(1, round);

        assertEquals("BANG!: Ace of Hearts", round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 1).toString());
    }

    @Test
    public void ifElGringoCannotStealACardNothingWillBeAddedToTheListOfLastCheckedCardsOfPlayerInTurn() {

        round.getPlayerToFollow().setAvatar(new ElGringo());
        round.getPlayerToFollow().loseHealth(1, round);

        assertEquals("List size: 0", "List size: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
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
    public void ifJesseJonesDrawsACardFromEnemyHandItWillBeAddedToTheListOfLastCheckedCardsOfPlayerInTurn() {

        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().drawFromEnemyHandWithJesseJones();

        assertEquals("BANG!: Ace of Hearts", round.getPlayerInTurn().getListOfLastCheckedCards().get(round.getPlayerInTurn().getListOfLastCheckedCards().size() - 1).toString());
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
    public void ifPlayerToFollowIsJourdonnaisAndHeartsIsDrawnWithMethodCheckJourdonnaisAMissHasBeenPlayedAgainstSlabTheKillerWillBeSet() {

        round.getPlayerToFollow().setAvatar(new Jourdonnais());
        round.getDrawpile().place(new Bang("Hearts", 1));

        round.getCheckerForAvatarSpeciality().checkJourdonnais();

        assertEquals("Number of misses used against Slab The Killer: 1", "Number of misses used against Slab The Killer: " + round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void methodCheckTwoCardsForLuckyDukeMarksTwoCardsToListOfLastCheckedCardsOfPlayerInTurn() {

        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals("List of last checked cards: 2", "List of last checked cards: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void methodCheckTwoCardsForLuckyDukePutsTwoDrawnCardsToDiscardpile() {

        round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();

        assertEquals("Discardpile: 2", "Discardpile: " + round.getDiscardpile().getDeck().size());
    }

    @Test
    public void ifFirstDrawnCardIsHeartsButSecondIsNotMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsTrue() {

        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifFirstDrawnCardIsNotHeartsButSecondIsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsTrue() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifBothDrawnCardsAreHeartsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsTrue() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifNeitherDrawnCardIsHeartsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsReturnsFalse() {

        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Spades", 1));

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts());
    }

    @Test
    public void ifFirstDrawnCardIsHeartsButSecondIsNotMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsSetsMissHasBeenPlayedAgainstSlabTheKillerTo1() {

        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts();

        assertEquals(1, round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void ifFirstDrawnCardIsNotHeartsButSecondIsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsSetsMissHasBeenPlayedAgainstSlabTheKillerTo1() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts();

        assertEquals(1, round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void ifBothDrawnCardsAreHeartsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsSetsMissHasBeenPlayedAgainstSlabTheKillerTo1() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts();

        assertEquals(1, round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void ifNeitherDrawnCardsAreHeartsMethodCheckTwoLastCheckedCardsForLuckyDukeForHeartsDoesNotSetMissHasBeenPlayedAgainstSlabTheKiller() {

        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts();

        assertEquals(0, round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void ifFirstDrawnCardWouldNotBlowDinamiteUpButSecondWouldMehtodCheckIfDinamiteExplodesOnLuckyDukeReturnsFalse() {

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getDrawpile().place(new Bang("Hearts", 1));

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifFirstDrawnCardWouldBlowDinamiteUpButSecondWouldNotMehtodCheckIfDinamiteExplodesOnLuckyDukeReturnsFalse() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 3));

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifNeitherDrawnCardsWouldBlowDinamiteUpMethodCheckIfDinamiteExplodesOnLuckyDukeReturnsFalse() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifBothDrawnCardsWouldBlowDinamiteUpMethodCheckIfDinamiteExplodesOnLuckyDukeReturnsTrue() {

        round.getDrawpile().place(new Bang("Spades", 3));
        round.getDrawpile().place(new Bang("Spades", 3));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke());
    }

    @Test
    public void ifFirstDrawnCardWouldBlowDinamiteUpButSecondWouldNotMethodcheckIfDinamiteExplodesOnLuckyDukeWhenHeHasBothDinamiteAndPrigioneReturnsFalse() {

        for (int i = 0; i < 3; i++) {
            round.getDrawpile().place(new Bang("Hearts", 1));
        }
        round.getDrawpile().place(new Bang("Spades", 3));

        for (int i = 0; i < 2; i++) {
            round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();
        }

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodedOnLuckyDukeWhenHeHasBothDinamiteAndPrigione());
    }

    @Test
    public void ifFirstDrawnCardWouldNotBlowDinamiteUpButSecondWouldMethodcheckIfDinamiteExplodesOnLuckyDukeWhenHeHasBothDinamiteAndPrigioneReturnsFalse() {

        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                round.getDrawpile().place(new Bang("Spades", 3));
            } else {
                round.getDrawpile().place(new Bang("Hearts", 1));
            }
        }

        for (int i = 0; i < 2; i++) {
            round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();
        }
        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodedOnLuckyDukeWhenHeHasBothDinamiteAndPrigione());
    }

    @Test
    public void ifNeitherDrawnCardWouldBlowDinamiteUpMethodcheckIfDinamiteExplodesOnLuckyDukeWhenHeHasBothDinamiteAndPrigioneReturnsFalse() {

        for (int i = 0; i < 4; i++) {
            round.getDrawpile().place(new Bang("Hearts", 1));
        }
        for (int i = 0; i < 2; i++) {
            round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();
        }
        assertEquals(false, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodedOnLuckyDukeWhenHeHasBothDinamiteAndPrigione());
    }

    @Test
    public void ifBothDrawnCardWouldBlowDinamiteUpMethodcheckIfDinamiteExplodesOnLuckyDukeWhenHeHasBothDinamiteAndPrigioneReturnsTrue() {

        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                round.getDrawpile().place(new Bang("Hearts", 1));
            } else {
                round.getDrawpile().place(new Bang("Spades", 3));
            }
        }
        for (int i = 0; i < 2; i++) {
            round.getCheckerForAvatarSpeciality().checkTwoCardsForLuckyDuke();
        }
        assertEquals(true, round.getCheckerForAvatarSpeciality().checkIfDinamiteExplodedOnLuckyDukeWhenHeHasBothDinamiteAndPrigione());
    }

    @Test
    public void methodCheckTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDukePutsNoCardsIntoListOfLastCheckedCards() {

        round.getCheckerForAvatarSpeciality().checkTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDuke(new Bang("Hearts", 1), new Bang("Hearts", 1));

        assertEquals("Last checked cards: 0", "Last checked cards: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void methodCheckTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDukeReturnsFalseIfFirstCardWouldDetoniteDinamiteButOtherWouldNot() {

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDuke(new Bang("Spades", 3), new Bang("Hearts", 1)));
    }

    @Test
    public void methodCheckTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDukeReturnsFalseIfFirstCardWouldNotDetoniteDinamiteButOtherWould() {

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDuke(new Bang("Hearts", 1), new Bang("Spades", 3)));
    }

    @Test
    public void methodCheckTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDukeReturnsFalseIfNeitherCardWouldNotDetoniteDinamite() {

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDuke(new Bang("Hearts", 1), new Bang("Hearts", 1)));
    }

    @Test
    public void methodCheckTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDukeReturnsTrueIfBothCardWouldNotDetoniteDinamite() {

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDuke(new Bang("Spades", 3), new Bang("Spades", 3)));
    }

    @Test
    public void methodLuckyDukeStaysInPrigioneReturnsTrueIfFirstCheckedCardIsHeartsButOtherIsNot() {

        round.getPlayerInTurn().putCardInFront(new Prigione("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().luckyDukeStaysInPrigione(0));
    }

    @Test
    public void methodLuckyDukeStaysInPrigioneReturnsTrueIfFirstCheckedCardIsNotHeartsButOtherIs() {

        round.getPlayerInTurn().putCardInFront(new Prigione("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().luckyDukeStaysInPrigione(0));
    }

    @Test
    public void methodLuckyDukeStaysInPrigioneReturnsTrueIfBothCheckedCardsAreHearts() {

        round.getPlayerInTurn().putCardInFront(new Prigione("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().luckyDukeStaysInPrigione(0));
    }

    @Test
    public void methodLuckyDukeStaysInPrigioneReturnsFalseIfNeitherCheckedCardsIsHearts() {

        round.getPlayerInTurn().putCardInFront(new Prigione("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Spades", 1));

        assertEquals(false, round.getCheckerForAvatarSpeciality().luckyDukeStaysInPrigione(0));
    }

    @Test
    public void ifPedroRamirezDrawsFromDiscardpileHeGetsTwoCards() {

        round.getDiscardpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().drawFromDiscardpileWithPedroRamirez();

        assertEquals("Player hand cards: 2", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void ifPedroRamirezDrawsFromDiscardPileACardWillBeRemovedFromThere() {

        round.getDiscardpile().place(new Bang("Hearts", 1));
        round.getCheckerForAvatarSpeciality().drawFromDiscardpileWithPedroRamirez();

        assertEquals("Discardpile size: 0", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }

    @Test
    public void methodAddToSidKetchumDiscardListReallyAddsGivenCard() {

        round.getCheckerForAvatarSpeciality().addToSidKetchumDiscardList(new Bang("Hearts", 1));

        assertEquals("BANG!: Ace of Hearts", round.getCheckerForAvatarSpeciality().getSidKetchumDiscardList().get(0).toString());
    }

    @Test
    public void methodGetSidKetchumDiscardListReallyReturnsTheList() {

        for (int i = 0; i < 5; i++) {
            round.getCheckerForAvatarSpeciality().addToSidKetchumDiscardList(new Bang("Hearts", 1));
        }
        assertEquals("List size: 5", "List size: " + round.getCheckerForAvatarSpeciality().getSidKetchumDiscardList().size());
    }

    @Test
    public void ifPlayerToFollowIsNotCalamityJanetAndHasNoMancatoCardsMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerToFollowIsNotCalamityJanetAndHasOneMancatoMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerToFollowIsNotCalamityJanetAndHasTwoMancatoCardsMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerToFollowIsCalamityJanetAndHasNoMancatoCardsMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerToFollowIsCalamityJanetAndHasOneMancatoMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());

        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerToFollowIsCalamityJanetAndHasOneBangMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());

        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));

        assertEquals(false, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerToFollowIsCalamityJanetAndHasTwoMancatoCardsMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());

        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Mancato("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerToFollowIsCalamityJanetAndHasTwoBangCardsMethodCheckThatEnemyHasTwoMancatosAgainstSlabTheKillerReturnsFalse() {

        round.getPlayerToFollow().setAvatar(new CalamityJanet());

        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerToFollow().putCardIntoHand(new Bang("Hearts", 1));

        assertEquals(true, round.getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller());
    }

    @Test
    public void methodEraseHowManyMissesHaveBeenUsedAgainstSlabTheKillerReallyErasesTheNumber() {

        round.getCheckerForAvatarSpeciality().missHasBeenPlayedAgainstSlabTheKiller();
        round.getCheckerForAvatarSpeciality().eraseHowManyMissesHaveBeenUsedAgainstSlabTheKiller();

        assertEquals("Misses used against Slab The Killer: 0", "Misses used against Slab The Killer: " + round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void ifPlayerIsNotSuzyLafayetteMethodCheckSuzyLafayetteForEmptyHandDoesNotGiveHimCards() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getCheckerForAvatarSpeciality().checkSuzyLafayetteForEmptyHand(round.getPlayerInTurn());

        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void ifPlayerIsSuzyLafayetteMethodCheckSuzyLafayetteForEmptyHandGivesHerACard() {

        round.getPlayerInTurn().setAvatar(new SuzyLafayette());
        round.getCheckerForAvatarSpeciality().checkSuzyLafayetteForEmptyHand(round.getPlayerInTurn());

        assertEquals("Player hand cards: 1", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }
}
