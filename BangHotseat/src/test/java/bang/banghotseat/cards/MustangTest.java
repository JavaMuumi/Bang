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
public class MustangTest {
    
    private Card mustang;
    
    public MustangTest() {
        mustang = new Mustang("Hearts", 1);
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
    public void nameOfMustangIsCorrect() {
        assertEquals("Mustang", mustang.getName());
    }

    @Test
    public void typeOfMustangIsBlue() {
        assertEquals("Blue", mustang.getType());
    }

    @Test
    public void stringOfMustangIsCorrectForNumbers() {
        
        Card thisMustang = new Mustang("Hearts", 3);
        assertEquals("Mustang: 3 of Hearts", thisMustang.toString());
    }
    
    @Test
    public void stringOfMustangIsCorrectForAces() {
        assertEquals("Mustang: Ace of Hearts", mustang.toString());
    }
    
    @Test
    public void stringOfMustangIsCorrectForJacks() {
        
        Card thisMustang = new Mustang("Hearts", 11);
        assertEquals("Mustang: Jack of Hearts", thisMustang.toString());
    }
    
    @Test
    public void stringOfMustangIsCorrectForQueens() {
        
        Card thisMustang = new Mustang("Hearts", 12);
        assertEquals("Mustang: Queen of Hearts", thisMustang.toString());
    }
    
    @Test
    public void stringOfMustangIsCorrectForKings() {
        
        Card thisMustang = new Mustang("Hearts", 13);
        assertEquals("Mustang: King of Hearts", thisMustang.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", mustang.getSuit());
    }
}