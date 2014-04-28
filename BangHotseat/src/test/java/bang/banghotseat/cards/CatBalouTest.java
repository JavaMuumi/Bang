/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

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
public class CatBalouTest {

    private Card catBalou;

    public CatBalouTest() {
        catBalou = new CatBalou("Hearts", 1);
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
    public void nameOfCatBalouIsCorrect() {
        assertEquals("Cat Balou", catBalou.getName());
    }

    @Test
    public void typeOfCatBalouIsOrange() {
        assertEquals("Orange", catBalou.getType());
    }

    @Test
    public void stringOfCatBalouIsCorrectForNumbers() {

        Card thisBirra = new CatBalou("Hearts", 3);
        assertEquals("Cat Balou: 3 of Hearts", thisBirra.toString());
    }

    @Test
    public void stringOfCatBalouIsCorrectForAces() {
        assertEquals("Cat Balou: Ace of Hearts", catBalou.toString());
    }

    @Test
    public void stringOfCatBalouIsCorrectForJacks() {

        Card thisCatBalou = new CatBalou("Hearts", 11);
        assertEquals("Cat Balou: Jack of Hearts", thisCatBalou.toString());
    }

    @Test
    public void stringOfCatBalouIsCorrectForQueens() {

        Card thisCatBalou = new CatBalou("Hearts", 12);
        assertEquals("Cat Balou: Queen of Hearts", thisCatBalou.toString());
    }

    @Test
    public void stringOfCatBalouIsCorrectForKings() {

        Card thisCatBalou = new CatBalou("Hearts", 13);
        assertEquals("Cat Balou: King of Hearts", thisCatBalou.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", catBalou.getSuit());
    }
}