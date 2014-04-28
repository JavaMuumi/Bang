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
public class BarrelTest {
    
    private Card barrel;

    public BarrelTest() {
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
}