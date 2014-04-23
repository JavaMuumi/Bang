/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.CalamityJanet;
import bang.banghotseat.avatars.PaulRegret;
import bang.banghotseat.avatars.PedroRamirez;
import bang.banghotseat.avatars.SuzyLafayette;
import bang.banghotseat.avatars.WillyTheKid;
import bang.banghotseat.cards.*;
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
public class CheckerForPlayedCardTest {

    private Round round;

    public CheckerForPlayedCardTest() {

        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new PedroRamirez());
        round.getPlayerInTurn().setCurrentHealth();
        round.getPlayerToFollow().setAvatar(new PedroRamirez());
        round.getPlayerToFollow().setCurrentHealth();
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
    public void anOrangeCardIsDeletedAfterItHasBeenPlayed() {

        round.getPlayerInTurn().putCardIntoHand(new Saloon("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals(true, round.getPlayerInTurn().getHandCards().isEmpty());
    }

    public void anOrangeCardIsPlacedInDiscardpileAfterItHasBeenPlayed() {

        round.getPlayerInTurn().putCardIntoHand(new Saloon("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Saloon", round.getDiscardpile().getDeck().get(round.getDiscardpile().getDeck().size() - 1).getName());
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
    public void onlyOneBangCanBePlayedInOneTurnIfPlayerAvatarIsNotWillyTheKidOrThePlayerDoesNotHaveAVolcanicInFrontOfHim() {

        for (int i = 0; i < 4; i++) {
            round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        }
        for (int i = 0; i < 4; i++) {
            round.getCheckerForPlayedCard().playingCard(0);
        }
        assertEquals("Player hand cards: 3", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void willyTheKidCanPlayAnyNumberOfBangs() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());

        for (int i = 0; i < 4; i++) {
            round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        }
        for (int i = 0; i < 4; i++) {
            round.getCheckerForPlayedCard().playingCard(0);
        }
        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void playerWithAVolcanicInFrontCanPlayAnyNumberOfBangs() {

        round.getPlayerInTurn().putCardInFront(new Volcanic("Hearts", 1));

        for (int i = 0; i < 4; i++) {
            round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        }
        for (int i = 0; i < 4; i++) {
            round.getCheckerForPlayedCard().playingCard(0);
        }
        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void atTheBeginningOfATurnBooleanBangHasBeenPlayedIsFalse() {

        assertEquals(false, round.getBangHasBeenPlayed());
    }

    @Test
    public void afterPlayingABangBooleanBangHasBeenPlayedIsTrue() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
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

    @Test
    public void afterPlayingADuelloTheCardWillBeInDiscardPile() {

        round.getPlayerInTurn().putCardIntoHand(new Duello("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Discardpile size: 1", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }

    @Test
    public void aBlueCardWillBePutInFrontIfThereAreNoBlueCardsToBeginWith() {

        round.getPlayerInTurn().putCardIntoHand(new Barrel("Hearts", 2));
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Barrel: 2 of Hearts", round.getPlayerInTurn().getFrontCards().get(0).toString());
    }

    @Test
    public void aBlueCardWillBePutInFrontIfThereIsNotAlreadyACardOfSameKind() {

        round.getPlayerInTurn().putCardIntoHand(new Barrel("Hearts", 2));
        round.getPlayerInTurn().putCardIntoHand(new Mirino("Hearts", 2));
        round.getCheckerForPlayedCard().playingCard(0);
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Barrel: 2 of Hearts, Mirino: 2 of Hearts", round.getPlayerInTurn().getFrontCards().get(0).toString() + ", " + round.getPlayerInTurn().getFrontCards().get(1).toString());
    }

    @Test
    public void ifThereIsAlreadyABlueCardOfSameKindInFrontItWillBeReplacedByTheNewOne() {

        round.getPlayerInTurn().putCardIntoHand(new Barrel("Hearts", 1));
        round.getPlayerInTurn().putCardIntoHand(new Barrel("Spades", 10));
        round.getCheckerForPlayedCard().playingCard(0);
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Barrel: 10 of Spades", round.getPlayerInTurn().getFrontCards().get(0).toString());
    }

    @Test
    public void ifABlueCardReplacesASimiliarOneTheOldWillBePutIntoDiscardPile() {

        round.getPlayerInTurn().putCardIntoHand(new Barrel("Hearts", 2));
        round.getPlayerInTurn().putCardIntoHand(new Barrel("Spades", 10));
        round.getCheckerForPlayedCard().playingCard(0);
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Barrel: 2 of Hearts", round.getDiscardpile().getDeck().get(0).toString());
    }

    @Test
    public void aGunCardWillBePutInFrontIfThereAreNoFrontCardsToBeginWith() {

        round.getPlayerInTurn().putCardIntoHand(new Volcanic("Hearts", 2));
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Volcanic: 2 of Hearts", round.getPlayerInTurn().getFrontCards().get(0).toString());
    }

    @Test
    public void aGunCardWillBePutInFrontIfThereIsAlreadyACardOfAnotherKind() {

        round.getPlayerInTurn().putCardIntoHand(new Volcanic("Hearts", 2));
        round.getPlayerInTurn().putCardIntoHand(new Mirino("Hearts", 2));
        round.getCheckerForPlayedCard().playingCard(0);
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Volcanic: 2 of Hearts, Mirino: 2 of Hearts", round.getPlayerInTurn().getFrontCards().get(0).toString() + ", " + round.getPlayerInTurn().getFrontCards().get(1).toString());
    }

    @Test
    public void ifThereIsAlreadyAGunCardInFrontCardsItWillBeReplacedByTheNewOne() {

        round.getPlayerInTurn().putCardIntoHand(new Schofield("Hearts", 2));
        round.getPlayerInTurn().putCardIntoHand(new Volcanic("Spades", 10));
        round.getCheckerForPlayedCard().playingCard(0);
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Volcanic: 10 of Spades", round.getPlayerInTurn().getFrontCards().get(0).toString());
    }

    @Test
    public void ifAGunCardReplacesASimiliarOneTheOldWillBePutIntoDiscardPile() {

        round.getPlayerInTurn().putCardIntoHand(new Schofield("Hearts", 2));
        round.getPlayerInTurn().putCardIntoHand(new Volcanic("Spades", 10));
        round.getCheckerForPlayedCard().playingCard(0);
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Schofield: 2 of Hearts", round.getDiscardpile().getDeck().get(0).toString());
    }

    @Test
    public void ifThereAreNoFrontCardsMethodThereIsABarrelReturnsFalse() {

        assertEquals(false, round.getCheckerForPlayedCard().checkBarrel());
    }

    @Test
    public void ifThereIsOtherFrontCardThanBarrelMethodThereIsABarrelReturnsFalse() {

        round.getPlayerToFollow().putCardInFront(new Mirino("Hearts", 1));
        assertEquals(false, round.getCheckerForPlayedCard().checkBarrel());
    }

    @Test
    public void ifThereIsABarrelMethodThereIsABarrelReturnsTrue() {

        round.getPlayerToFollow().putCardInFront(new Barrel("Hearts", 1));
        assertEquals(true, round.getCheckerForPlayedCard().checkBarrel());
    }

    @Test
    public void ifThereAreNoFrontCardsMethodThereIsABarrelDoesNotSetLastCheckedCard() {

        round.getCheckerForPlayedCard().checkBarrel();

        assertEquals(true, round.getPlayerInTurn().getListOfLastCheckedCards().isEmpty());
    }

    @Test
    public void ifThereIsOtherFrontCardThanBarrelMethodThereIsABarrelDoesNotSetLastCheckedCard() {

        round.getPlayerToFollow().putCardInFront(new Mirino("Hearts", 1));
        round.getCheckerForPlayedCard().checkBarrel();

        assertEquals(true, round.getPlayerInTurn().getListOfLastCheckedCards().isEmpty());
    }

    @Test
    public void ifThereIsABarrelAndPlayerIsNotLuckyDukeMethodThereIsABarrelSetsLastCheckedCard() {

        round.getPlayerToFollow().putCardInFront(new Barrel("Hearts", 1));
        round.getCheckerForPlayedCard().checkBarrel();

        assertEquals(false, round.getPlayerInTurn().getListOfLastCheckedCards().isEmpty());
    }

    @Test
    public void ifPlayedCardIsLastInHandOfSuzyLafayetteSheWillDrawANewOne() {

        round.getPlayerInTurn().setAvatar(new SuzyLafayette());
        round.getPlayerInTurn().putCardIntoHand(new Birra("Hearts", 1));

        round.getPlayerInTurn().getHandCards().get(0).function(round);

        assertEquals("Player hand cards: 1", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void ifLastCardIsDrawnFromHandOfSuzyLafayetteOnRandomSheWillDrawANewOne() {

        round.getPlayerToFollow().setAvatar(new SuzyLafayette());
        round.getPlayerToFollow().putCardIntoHand(new Birra("Hearts", 1));
        round.getPlayerToFollow().drawRandomHandCard(round);

        assertEquals("Player hand cards: 1", "Player hand cards: " + round.getPlayerToFollow().getHandCards().size());
    }

    @Test
    public void ifCalamityJanetUsesAMancatoItWillBeRemovedFromHerHand() {

        round.getPlayerInTurn().setAvatar(new CalamityJanet());
        round.getPlayerInTurn().putCardIntoHand(new Mancato("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Player hand cards: 0", "Player hand cards: " + round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void ifCalamityJanetUsesAMancatoItWillBePlacedInDiscardpile() {

        round.getPlayerInTurn().setAvatar(new CalamityJanet());
        round.getPlayerInTurn().putCardIntoHand(new Mancato("Hearts", 1));
        round.getCheckerForPlayedCard().playingCard(0);

        assertEquals("Discardpile size: 1", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }

    @Test
    public void methodSameKindOfCardIsAlreadyInFrontOfPlayerInTurnReturnsFalseIfThereAreNoCardsInFrontOfPlayerInTurn() {
        assertEquals(false, round.getCheckerForPlayedCard().sameKindOfCardIsAlreadyInFrontOfPlayerInTurn("Mirino"));
    }

    @Test
    public void methodSameKindOfCardIsAlreadyInFrontOfPlayerInTurnReturnsFalseIfThereIsNoCardOfGivenNameInFrontOfPlayerInTurn() {

        round.getPlayerInTurn().putCardInFront(new Barrel("Hearts", 1));

        assertEquals(false, round.getCheckerForPlayedCard().sameKindOfCardIsAlreadyInFrontOfPlayerInTurn("Mirino"));
    }

    @Test
    public void methodSameKindOfCardIsAlreadyInFrontOfPlayerInTurnReturnsTrueIfThereIsACardOfGivenNameInFrontOfPlayerInTurn() {

        round.getPlayerInTurn().putCardInFront(new Barrel("Hearts", 1));

        assertEquals(true, round.getCheckerForPlayedCard().sameKindOfCardIsAlreadyInFrontOfPlayerInTurn("Barrel"));
    }

    @Test
    public void methodSameTypeOfCardIsAlreadyInFrontOfPlayerInTurnReturnsFalseIfThereAreNoCardsInFrontOfPlayerInTurn() {
        assertEquals(false, round.getCheckerForPlayedCard().sameTypeOfCardIsAlreadyInFrontOfPlayerInTurn("Blue"));
    }

    @Test
    public void methodSameTypeOfCardIsAlreadyInFrontOfPlayerInTurnReturnsFalseIfThereIsNoCardOfGivenTypeInFrontOfPlayerInTurn() {

        round.getPlayerInTurn().putCardInFront(new Prigione("Hearts", 1));

        assertEquals(false, round.getCheckerForPlayedCard().sameTypeOfCardIsAlreadyInFrontOfPlayerInTurn("Blue"));
    }

    @Test
    public void methodSameTypeOfCardIsAlreadyInFrontOfPlayerInTurnReturnsTrueIfThereIsACardOfGivenTypeInFrontOfPlayerInTurn() {

        round.getPlayerInTurn().putCardInFront(new Barrel("Hearts", 1));

        assertEquals(true, round.getCheckerForPlayedCard().sameTypeOfCardIsAlreadyInFrontOfPlayerInTurn("Blue"));
    }

    @Test
    public void methodSearchPlayerHandForCertainCardReturnsFalseIfPlayerHasNoHandCards() {

        assertEquals(false, round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "Mancato"));
    }

    @Test
    public void methodSearchPlayerHandForCertainCardReturnsFalseIfPlayerHasNoHandCardOfGivenName() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));

        assertEquals(false, round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "Mancato"));
    }

    @Test
    public void methodSearchPlayerHandForCertainCardReturnsTrueIfPlayerHasAHandCardOfGivenName() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));

        assertEquals(true, round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!"));
    }

    @Test
    public void methodSearchPlayerHandForCertainCardSetsIndexOfHandCardAsIntIndexOfReplyCard() {

        round.getPlayerInTurn().putCardIntoHand(new Mancato("Hearts", 1));
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!");

        assertEquals("Index of reply card: 1", "Index of reply card: " + round.getCheckerForPlayedCard().getIndexOfReplyCard());
    }

    @Test
    public void methodSearchPlayerHandForAnotherCardOfSameKindAddsNothingToDiscardpileIfPlayerOnlyHasOneHandCard() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!");
        round.getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(round.getPlayerInTurn(), "BANG!");

        assertEquals("Discardpile size: 0", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }

    @Test
    public void methodSearchPlayerHandForAnotherCardOfSameKindAddsNothingToDiscardpileIfPlayerDoesNotHaveAnotherHandCardOfSearchedName() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerInTurn().putCardIntoHand(new Mancato("Hearts", 1));

        round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!");
        round.getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(round.getPlayerInTurn(), "BANG!");

        assertEquals("Discardpile size: 0", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }
    
    @Test
    public void methodSearchPlayerHandForAnotherCardOfSameKindAddsTheOtherCardToDiscardpileIfPlayerHasAnotherHandCardOfSearchedName() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));

        round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!");
        round.getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(round.getPlayerInTurn(), "BANG!");

        assertEquals("Discardpile size: 1", "Discardpile size: " + round.getDiscardpile().getDeck().size());
    }
    
    @Test
    public void methodSearchPlayerHandForAnotherCardOfSameKindDoesNotChangeIndexOfReplyCardIfPlayerOnlyHasOneHandCard() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));

        round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!");
        round.getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(round.getPlayerInTurn(), "BANG!");

        assertEquals("Index of reply card: 0", "Index of reply card: " + round.getCheckerForPlayedCard().getIndexOfReplyCard());
    }
    
    @Test
    public void methodSearchPlayerHandForAnotherCardOfSameKindDoesNotChangeIndexOfReplyCardIfPlayerHasAnotherHandCardOfSearchedName() {

        round.getPlayerInTurn().putCardIntoHand(new Mancato("Hearts", 1));
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));

        round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!");
        round.getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(round.getPlayerInTurn(), "BANG!");

        assertEquals("Index of reply card: 1", "Index of reply card: " + round.getCheckerForPlayedCard().getIndexOfReplyCard());
    }
    
    @Test
    public void methodSearchPlayerHandForAnotherCardOfSameKindReducesIndexOfReplyCardByOneIfPlayerHasAnotherHandCardOfSearchedName() {

        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));
        round.getPlayerInTurn().putCardIntoHand(new Bang("Hearts", 1));

        round.getCheckerForPlayedCard().searchPlayerHandForCertainCard(round.getPlayerInTurn(), "BANG!");
        round.getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(round.getPlayerInTurn(), "BANG!");

        assertEquals("Index of reply card: 0", "Index of reply card: " + round.getCheckerForPlayedCard().getIndexOfReplyCard());
    }
}