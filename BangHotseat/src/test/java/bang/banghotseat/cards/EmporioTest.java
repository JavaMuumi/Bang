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
public class EmporioTest {
    
    private Card emporio;
    
    public EmporioTest() {
        emporio = new Emporio("Hearts", 1);
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
    public void nameOfEmporioIsCorrect() {
        assertEquals("Emporio", emporio.getName());
    }

    @Test
    public void typeOfEmporioIsOrange() {
        assertEquals("Orange", emporio.getType());
    }

    @Test
    public void stringOfEmporioIsCorrectForNumbers() {
        
        Card thisEmporio = new Emporio("Hearts", 3);
        assertEquals("Emporio: 3 of Hearts", thisEmporio.toString());
    }
    
    @Test
    public void stringOfEmporioIsCorrectForAces() {
        assertEquals("Emporio: Ace of Hearts", emporio.toString());
    }
    
    @Test
    public void stringOfEmporioIsCorrectForJacks() {
        
        Card thisEmporio = new Emporio("Hearts", 11);
        assertEquals("Emporio: Jack of Hearts", thisEmporio.toString());
    }
    
    @Test
    public void stringOfEmporioIsCorrectForQueens() {
        
        Card thisEmporio = new Emporio("Hearts", 12);
        assertEquals("Emporio: Queen of Hearts", thisEmporio.toString());
    }
    
    @Test
    public void stringOfEmporioIsCorrectForKings() {
        
        Card thisEmporio = new Emporio("Hearts", 13);
        assertEquals("Emporio: King of Hearts", thisEmporio.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", emporio.getSuit());
    }
}