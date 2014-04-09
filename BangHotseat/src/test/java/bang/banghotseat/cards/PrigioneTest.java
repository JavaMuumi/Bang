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
public class PrigioneTest {
    
    private Card prigione;
    
    public PrigioneTest() {
        prigione = new Prigione("Hearts", 1);
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
    public void nameOfPrigioneIsCorrect() {
        assertEquals("Prigione", prigione.getName());
    }

    @Test
    public void typeOfPrigioneIsBlue() {
        assertEquals("Blue", prigione.getType());
    }

    @Test
    public void stringOfPrigioneIsCorrectForNumbers() {
        
        Card thisPrigione = new Prigione("Hearts", 3);
        assertEquals("Prigione: 3 of Hearts", thisPrigione.toString());
    }
    
    @Test
    public void stringOfPrigioneIsCorrectForAces() {
        assertEquals("Prigione: Ace of Hearts", prigione.toString());
    }
    
    @Test
    public void stringOfPrigioneIsCorrectForJacks() {
        
        Card thisPrigione = new Prigione("Hearts", 11);
        assertEquals("Prigione: Jack of Hearts", thisPrigione.toString());
    }
    
    @Test
    public void stringOfPrigioneIsCorrectForQueens() {
        
        Card thisPrigione = new Prigione("Hearts", 12);
        assertEquals("Prigione: Queen of Hearts", thisPrigione.toString());
    }
    
    @Test
    public void stringOfPrigioneIsCorrectForKings() {
        
        Card thisPrigione = new Prigione("Hearts", 13);
        assertEquals("Prigione: King of Hearts", thisPrigione.toString());
    }
}