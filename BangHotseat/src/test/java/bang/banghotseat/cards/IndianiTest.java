/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;
import bang.banghotseat.avatars.SlabTheKiller;
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
public class IndianiTest {

    private Round round;
    private Card indiani;

    public IndianiTest() {

        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        indiani = new Indiani("Hearts", 1);
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
    public void nameOfIndianiIsCorrect() {
        assertEquals("Indiani!", indiani.getName());
    }

    @Test
    public void typeOfIndianiIsOrange() {
        assertEquals("Orange", indiani.getType());
    }

    @Test
    public void stringOfIndianiIsCorrectForNumbers() {

        Card thisIndiani = new Indiani("Hearts", 3);
        assertEquals("Indiani!: 3 of Hearts", thisIndiani.toString());
    }

    @Test
    public void stringOfIndianiIsCorrectForAces() {
        assertEquals("Indiani!: Ace of Hearts", indiani.toString());
    }

    @Test
    public void stringOfIndianiIsCorrectForJacks() {

        Card thisIndiani = new Indiani("Hearts", 11);
        assertEquals("Indiani!: Jack of Hearts", thisIndiani.toString());
    }

    @Test
    public void stringOfIndianiIsCorrectForQueens() {

        Card thisIndiani = new Indiani("Hearts", 12);
        assertEquals("Indiani!: Queen of Hearts", thisIndiani.toString());
    }

    @Test
    public void stringOfIndianiIsCorrectForKings() {

        Card thisIndiani = new Indiani("Hearts", 13);
        assertEquals("Indiani!: King of Hearts", thisIndiani.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", indiani.getSuit());
    }

    @Test
    public void metfodFunctionOfIndianiMakesPlayerToFollowLoseOneHealthPoint() {

        round.getPlayerToFollow().setAvatar(new SlabTheKiller());
        round.getPlayerToFollow().setCurrentHealth();
        indiani.function(round);

        assertEquals("Player to follow health: 3", "Player to follow health: " + round.getPlayerToFollow().getCurrentHealth());
    }
}