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
public class VolcanicTest {
    
    private Card volcanic;
    
    public VolcanicTest() {
        volcanic = new Volcanic("Hearts", 1);
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
    public void nameOfVolcanicIsCorrect() {
        assertEquals("Volcanic", volcanic.getName());
    }

    @Test
    public void typeOfVolcanicIsGun() {
        assertEquals("Gun", volcanic.getType());
    }

    @Test
    public void stringOfVolcanicIsCorrectForNumbers() {
        
        Card thisVolcanic = new Volcanic("Hearts", 3);
        assertEquals("Volcanic: 3 of Hearts", thisVolcanic.toString());
    }
    
    @Test
    public void stringOfVolcanicIsCorrectForAces() {
        assertEquals("Volcanic: Ace of Hearts", volcanic.toString());
    }
    
    @Test
    public void stringOfVolcanicIsCorrectForJacks() {
        
        Card thisVolcanic = new Volcanic("Hearts", 11);
        assertEquals("Volcanic: Jack of Hearts", thisVolcanic.toString());
    }
    
    @Test
    public void stringOfVolcanicIsCorrectForQueens() {
        
        Card thisVolcanic = new Volcanic("Hearts", 12);
        assertEquals("Volcanic: Queen of Hearts", thisVolcanic.toString());
    }
    
    @Test
    public void stringOfVolcanicIsCorrectForKings() {
        
        Card thisVolcanic = new Volcanic("Hearts", 13);
        assertEquals("Volcanic: King of Hearts", thisVolcanic.toString());
    }
}