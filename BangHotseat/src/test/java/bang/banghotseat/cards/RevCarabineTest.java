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
public class RevCarabineTest {
    
    private Card revCarabine;
    
    public RevCarabineTest() {
        revCarabine = new RevCarabine("Hearts", 1);
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
    public void nameOfRevCarabineIsCorrect() {
        assertEquals("Rev.Carabine", revCarabine.getName());
    }

    @Test
    public void typeOfRevCarabineIsGun() {
        assertEquals("Gun", revCarabine.getType());
    }

    @Test
    public void stringOfRevCarabineIsCorrectForNumbers() {
        
        Card thisRevCarabine = new RevCarabine("Hearts", 3);
        assertEquals("Rev.Carabine: 3 of Hearts", thisRevCarabine.toString());
    }
    
    @Test
    public void stringOfRevCarabineIsCorrectForAces() {
        assertEquals("Rev.Carabine: Ace of Hearts", revCarabine.toString());
    }
    
    @Test
    public void stringOfRevCarabineIsCorrectForJacks() {
        
        Card thisRevCarabine = new RevCarabine("Hearts", 11);
        assertEquals("Rev.Carabine: Jack of Hearts", thisRevCarabine.toString());
    }
    
    @Test
    public void stringOfRevCarabineIsCorrectForQueens() {
        
        Card thisRevCarabine = new RevCarabine("Hearts", 12);
        assertEquals("Rev.Carabine: Queen of Hearts", thisRevCarabine.toString());
    }
    
    @Test
    public void stringOfRevCarabineIsCorrectForKings() {
        
        Card thisRevCarabine = new RevCarabine("Hearts", 13);
        assertEquals("Rev.Carabine: King of Hearts", thisRevCarabine.toString());
    }
}