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
public class PanicoTest {
    
    private Card panico;
    
    public PanicoTest() {
        panico = new Panico("Hearts", 1);
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
    public void nameOfPanicoIsCorrect() {
        assertEquals("Panico!", panico.getName());
    }

    @Test
    public void typeOfPanicoIsOrange() {
        assertEquals("Orange", panico.getType());
    }

    @Test
    public void stringOfPanicoIsCorrectForNumbers() {
        
        Card thisPanico = new Panico("Hearts", 3);
        assertEquals("Panico!: 3 of Hearts", thisPanico.toString());
    }
    
    @Test
    public void stringOfPanicoIsCorrectForAces() {
        assertEquals("Panico!: Ace of Hearts", panico.toString());
    }
    
    @Test
    public void stringOfPanicoIsCorrectForJacks() {
        
        Card thisPanico = new Panico("Hearts", 11);
        assertEquals("Panico!: Jack of Hearts", thisPanico.toString());
    }
    
    @Test
    public void stringOfPanicoIsCorrectForQueens() {
        
        Card thisPanico = new Panico("Hearts", 12);
        assertEquals("Panico!: Queen of Hearts", thisPanico.toString());
    }
    
    @Test
    public void stringOfPanicoIsCorrectForKings() {
        
        Card thisPanico = new Panico("Hearts", 13);
        assertEquals("Panico!: King of Hearts", thisPanico.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", panico.getSuit());
    }
}