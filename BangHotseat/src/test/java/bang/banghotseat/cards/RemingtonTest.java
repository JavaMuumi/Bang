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
public class RemingtonTest {
    
    private Card remington;
    
    public RemingtonTest() {
        remington = new Remington("Hearts", 1);
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
    public void nameOfRemingtonIsCorrect() {
        assertEquals("Remington", remington.getName());
    }

    @Test
    public void typeOfRemingtonIsGun() {
        assertEquals("Gun", remington.getType());
    }

    @Test
    public void stringOfRemingtonIsCorrectForNumbers() {
        
        Card thisRemington = new Remington("Hearts", 3);
        assertEquals("Remington: 3 of Hearts", thisRemington.toString());
    }
    
    @Test
    public void stringOfRemingtonIsCorrectForAces() {
        assertEquals("Remington: Ace of Hearts", remington.toString());
    }
    
    @Test
    public void stringOfRemingtonIsCorrectForJacks() {
        
        Card thisRemington = new Remington("Hearts", 11);
        assertEquals("Remington: Jack of Hearts", thisRemington.toString());
    }
    
    @Test
    public void stringOfRemingtonIsCorrectForQueens() {
        
        Card thisRemington = new Remington("Hearts", 12);
        assertEquals("Remington: Queen of Hearts", thisRemington.toString());
    }
    
    @Test
    public void stringOfRemingtonIsCorrectForKings() {
        
        Card thisRemington = new Remington("Hearts", 13);
        assertEquals("Remington: King of Hearts", thisRemington.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", remington.getSuit());
    }
}