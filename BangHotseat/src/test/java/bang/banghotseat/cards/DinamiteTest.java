/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

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
public class DinamiteTest {

    Card dinamite;
    
    public DinamiteTest() {
        dinamite = new Dinamite("Hearts", 1);
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
    public void nameOfDinamiteIsCorrect() {
        assertEquals("Dinamite", dinamite.getName());
    }

    @Test
    public void typeOfDinamiteIsBlue() {
        assertEquals("Blue", dinamite.getType());
    }

    @Test
    public void stringOfDinamiteIsCorrectForNumbers() {

        Card thisDinamite = new Dinamite("Hearts", 3);
        assertEquals("Dinamite: 3 of Hearts", thisDinamite.toString());
    }

    @Test
    public void stringOfDinamiteIsCorrectForAces() {
        assertEquals("Dinamite: Ace of Hearts", dinamite.toString());
    }

    @Test
    public void stringOfDinamiteIsCorrectForJacks() {

        Card thisDinamite = new Dinamite("Hearts", 11);
        assertEquals("Dinamite: Jack of Hearts", thisDinamite.toString());
    }

    @Test
    public void stringOfDinamiteIsCorrectForQueens() {

        Card thisDinamite = new Dinamite("Hearts", 12);
        assertEquals("Dinamite: Queen of Hearts", thisDinamite.toString());
    }

    @Test
    public void stringOfDinamiteIsCorrectForKings() {

        Card thisDinamite = new Dinamite("Hearts", 13);
        assertEquals("Dinamite: King of Hearts", thisDinamite.toString());
    }
}