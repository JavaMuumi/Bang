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
public class SchofieldTest {
    
    private Card schofield;
    
    public SchofieldTest() {
        schofield = new Schofield("Hearts", 1);
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
    public void nameOfSchofieldIsCorrect() {
        assertEquals("Schofield", schofield.getName());
    }

    @Test
    public void typeOfSchofieldIsGun() {
        assertEquals("Gun", schofield.getType());
    }

    @Test
    public void stringOfSchofieldIsCorrectForNumbers() {
        
        Card thisSchofield = new Schofield("Hearts", 3);
        assertEquals("Schofield: 3 of Hearts", thisSchofield.toString());
    }
    
    @Test
    public void stringOfSchofieldIsCorrectForAces() {
        assertEquals("Schofield: Ace of Hearts", schofield.toString());
    }
    
    @Test
    public void stringOfSchofieldIsCorrectForJacks() {
        
        Card thisSchofield = new Schofield("Hearts", 11);
        assertEquals("Schofield: Jack of Hearts", thisSchofield.toString());
    }
    
    @Test
    public void stringOfSchofieldIsCorrectForQueens() {
        
        Card thisSchofield = new Schofield("Hearts", 12);
        assertEquals("Schofield: Queen of Hearts", thisSchofield.toString());
    }
    
    @Test
    public void stringOfSchofieldIsCorrectForKings() {
        
        Card thisSchofield = new Schofield("Hearts", 13);
        assertEquals("Schofield: King of Hearts", thisSchofield.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", schofield.getSuit());
    }
}