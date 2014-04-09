/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antti Korpi
 */
public class WellsFargoTest {
    
    private Card wellsFargo;
    
    public WellsFargoTest() {
        wellsFargo = new WellsFargo("Hearts", 1);
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
    public void nameOfWellsFargoIsCorrect() {
        assertEquals("Wells Fargo", wellsFargo.getName());
    }

    @Test
    public void typeOfWellsFargoIsOrange() {
        assertEquals("Orange", wellsFargo.getType());
    }

    @Test
    public void stringOfWellsFargoIsCorrectForNumbers() {
        
        Card thisWellsFargo = new WellsFargo("Hearts", 3);
        assertEquals("Wells Fargo: 3 of Hearts", thisWellsFargo.toString());
    }
    
    @Test
    public void stringOfWellsFargoIsCorrectForAces() {
        assertEquals("Wells Fargo: Ace of Hearts", wellsFargo.toString());
    }
    
    @Test
    public void stringOfWellsFargoIsCorrectForJacks() {
        
        Card thisWellsFargo = new WellsFargo("Hearts", 11);
        assertEquals("Wells Fargo: Jack of Hearts", thisWellsFargo.toString());
    }
    
    @Test
    public void stringOfWellsFargoIsCorrectForQueens() {
        
        Card thisWellsFargo = new WellsFargo("Hearts", 12);
        assertEquals("Wells Fargo: Queen of Hearts", thisWellsFargo.toString());
    }
    
    @Test
    public void stringOfWellsFargoIsCorrectForKings() {
        
        Card thisWellsFargo = new WellsFargo("Hearts", 13);
        assertEquals("Wells Fargo: King of Hearts", thisWellsFargo.toString());
    }
}