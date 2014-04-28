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
public class CardNamerTest {
    
    CardNamer namer;
    
    public CardNamerTest() {
        namer = new CardNamer();
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
    public void ifCardNumberIs2MethodCheckNumberReturnsNull() {  
        assertEquals(null, namer.checkNumber(2));
    }
    
    @Test
    public void ifCardNumberIs10MethodCheckNumberReturnsNull() {  
        assertEquals(null, namer.checkNumber(10));
    }
    
    @Test
    public void ifCardNumberIs1MethodCheckNumberReturnsAce() {  
        assertEquals("Ace", namer.checkNumber(1));
    }
    
    @Test
    public void ifCardNumberIs11MethodCheckNumberReturnsJack() {  
        assertEquals("Jack", namer.checkNumber(11));
    }
    
    @Test
    public void ifCardNumberIs12MethodCheckNumberReturnsQueen() {  
        assertEquals("Queen", namer.checkNumber(12));
    }
    
    @Test
    public void ifCardNumberIs13MethodCheckNumberReturnsKing() {  
        assertEquals("King", namer.checkNumber(13));
    }
}