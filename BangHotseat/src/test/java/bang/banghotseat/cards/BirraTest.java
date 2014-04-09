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
public class BirraTest {
    
    private Card birra;
    
    public BirraTest() {
        birra = new Birra("Hearts", 1);
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
    public void nameOfBirraIsCorrect() {
        assertEquals("Birra", birra.getName());
    }

    @Test
    public void typeOfBirraIsOrange() {
        assertEquals("Orange", birra.getType());
    }

    @Test
    public void stringOfBirraIsCorrectForNumbers() {
        
        Card thisBirra = new Birra("Hearts", 3);
        assertEquals("Birra: 3 of Hearts", thisBirra.toString());
    }
    
    @Test
    public void stringOfBirraIsCorrectForAces() {
        assertEquals("Birra: Ace of Hearts", birra.toString());
    }
    
    @Test
    public void stringOfBirraIsCorrectForJacks() {
        
        Card thisBirra = new Birra("Hearts", 11);
        assertEquals("Birra: Jack of Hearts", thisBirra.toString());
    }
    
    @Test
    public void stringOfBirraIsCorrectForQueens() {
        
        Card thisBirra = new Birra("Hearts", 12);
        assertEquals("Birra: Queen of Hearts", thisBirra.toString());
    }
    
    @Test
    public void stringOfBirraIsCorrectForKings() {
        
        Card thisBirra = new Birra("Hearts", 13);
        assertEquals("Birra: King of Hearts", thisBirra.toString());
    }
}