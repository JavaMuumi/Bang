/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.LuckyDuke;
import bang.banghotseat.avatars.SlabTheKiller;
import bang.banghotseat.avatars.WillyTheKid;
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
public class BarrelTest {

    private Round round;
    private Card barrel;

    public BarrelTest() {

        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getDrawpile().createCards();
        barrel = new Barrel("Hearts", 1);
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
    public void nameOfBarrelIsCorrect() {
        assertEquals("Barrel", barrel.getName());
    }

    @Test
    public void typeOfBarrelIsBlue() {
        assertEquals("Blue", barrel.getType());
    }

    @Test
    public void stringOfBarrelIsCorrectForNumbers() {

        Card thisBarrel = new Barrel("Hearts", 3);
        assertEquals("Barrel: 3 of Hearts", thisBarrel.toString());
    }

    @Test
    public void stringOfBarrelIsCorrectForAces() {
        assertEquals("Barrel: Ace of Hearts", barrel.toString());
    }

    @Test
    public void stringOfBarrelIsCorrectForJacks() {

        Card thisBarrel = new Barrel("Hearts", 11);
        assertEquals("Barrel: Jack of Hearts", thisBarrel.toString());
    }

    @Test
    public void stringOfBarrelIsCorrectForQueens() {

        Card thisBarrel = new Barrel("Hearts", 12);
        assertEquals("Barrel: Queen of Hearts", thisBarrel.toString());
    }

    @Test
    public void stringOfBarrelIsCorrectForKings() {

        Card thisBarrel = new Barrel("Hearts", 13);
        assertEquals("Barrel: King of Hearts", thisBarrel.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", barrel.getSuit());
    }

    @Test
    public void methodFunctionOfBarrelSetsTwoCardsIntoListOfLastCheckedCardsIfPlayerToFollowIsLuckyDuke() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getPlayerToFollow().setAvatar(new LuckyDuke());
        barrel.function(round);

        assertEquals("List of last checked cards: 2", "List of last checked cards: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void methodFunctionOfBarrelDoesNotSetMissHasBeenUsedAgainstSlabTheKillerIfPlayerToFollowIsLuckyDukeAndHeartsIsNotDrawn() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getPlayerToFollow().setAvatar(new LuckyDuke());
        round.getDrawpile().place(new Barrel("Spades", 1));
        round.getDrawpile().place(new Barrel("Spades", 1));
        barrel.function(round);

        assertEquals("Misses used against Slab The Killer: 0", "Misses used against Slab The Killer: " + round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void methodFunctionOfBarrelSetsMissHasBeenUsedAgainstSlabTheKillerIfPlayerToFollowIsLuckyDukeAndHeartsIsDrawn() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getPlayerToFollow().setAvatar(new LuckyDuke());
        round.getDrawpile().place(new Barrel("Hearts", 1));
        barrel.function(round);

        assertEquals("Misses used against Slab The Killer: 1", "Misses used against Slab The Killer: " + round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void methodFunctionOfBarrelSetsOneCardIntoListOfLastCheckedCardsIfPlayerToFollowIsNotLuckyDuke() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        barrel.function(round);

        assertEquals("List of last checked cards: 1", "List of last checked cards: " + round.getPlayerInTurn().getListOfLastCheckedCards().size());
    }

    @Test
    public void methodFunctionOfBarrelDoesNotSetMissHasBeenUsedAgainstSlabTheKillerIfPlayerToFollowIsNotLuckyDukeAndHeartsIsNotDrawn() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getDrawpile().place(new Barrel("Spades", 1));
        barrel.function(round);

        assertEquals("Misses used against Slab The Killer: 0", "Misses used against Slab The Killer: " + round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }

    @Test
    public void methodFunctionOfBarrelSetsMissHasBeenUsedAgainstSlabTheKillerIfPlayerToFollowIsNotLuckyDukeAndHeartsIsDrawn() {

        round.getPlayerInTurn().setAvatar(new WillyTheKid());
        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getDrawpile().place(new Barrel("Hearts", 1));
        barrel.function(round);

        assertEquals("Misses used against Slab The Killer: 1", "Misses used against Slab The Killer: " + round.getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller());
    }
}