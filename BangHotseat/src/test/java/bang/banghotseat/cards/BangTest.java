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
public class BangTest {

    private Card bang;

    public BangTest() {
        bang = new Bang("Hearts", 1);
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
    public void nameOfBangIsCorrect() {
        assertEquals("BANG!", bang.getName());
    }

    @Test
    public void typeOfBangIsOrange() {
        assertEquals("Orange", bang.getType());
    }

    @Test
    public void stringOfBangIsCorrectForNumbers() {
        
        Card thisBang = new Bang("Hearts", 3);
        assertEquals("BANG!: 3 of Hearts", thisBang.toString());
    }
    
    @Test
    public void stringOfBangIsCorrectForAces() {
        assertEquals("BANG!: Ace of Hearts", bang.toString());
    }
    
    @Test
    public void stringOfBangIsCorrectForJacks() {
        
        Card thisBang = new Bang("Hearts", 11);
        assertEquals("BANG!: Jack of Hearts", thisBang.toString());
    }
    
    @Test
    public void stringOfBangIsCorrectForQueens() {
        
        Card thisBang = new Bang("Hearts", 12);
        assertEquals("BANG!: Queen of Hearts", thisBang.toString());
    }
    
    @Test
    public void stringOfBangIsCorrectForKings() {
        
        Card thisBang = new Bang("Hearts", 13);
        assertEquals("BANG!: King of Hearts", thisBang.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", bang.getSuit());
    }
}