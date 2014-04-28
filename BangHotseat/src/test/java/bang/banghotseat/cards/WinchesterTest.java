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
public class WinchesterTest {
    
    private Card winchester;
    
    public WinchesterTest() {
        winchester = new Winchester("Hearts", 1);
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
    public void nameOfWinchesterIsCorrect() {
        assertEquals("Winchester", winchester.getName());
    }

    @Test
    public void typeOfWinchesterIsGun() {
        assertEquals("Gun", winchester.getType());
    }

    @Test
    public void stringOfWinchesterIsCorrectForNumbers() {
        
        Card thisWinchester = new Winchester("Hearts", 3);
        assertEquals("Winchester: 3 of Hearts", thisWinchester.toString());
    }
    
    @Test
    public void stringOfWinchesterIsCorrectForAces() {
        assertEquals("Winchester: Ace of Hearts", winchester.toString());
    }
    
    @Test
    public void stringOfWinchesterIsCorrectForJacks() {
        
        Card thisWinchester = new Winchester("Hearts", 11);
        assertEquals("Winchester: Jack of Hearts", thisWinchester.toString());
    }
    
    @Test
    public void stringOfWinchesterIsCorrectForQueens() {
        
        Card thisWinchester = new Winchester("Hearts", 12);
        assertEquals("Winchester: Queen of Hearts", thisWinchester.toString());
    }
    
    @Test
    public void stringOfWinchesterIsCorrectForKings() {
        
        Card thisWinchester = new Winchester("Hearts", 13);
        assertEquals("Winchester: King of Hearts", thisWinchester.toString());
    }

    @Test
    public void methodGetSuitReturnsCorrectString() {

        assertEquals("Hearts", winchester.getSuit());
    }
}