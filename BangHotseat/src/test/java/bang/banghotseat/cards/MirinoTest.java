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
public class MirinoTest {
    
    private Card mirino;
    
    public MirinoTest() {
        mirino = new Mirino("Hearts", 1);
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
    public void nameOfMirinoIsCorrect() {
        assertEquals("Mirino", mirino.getName());
    }

    @Test
    public void typeOfMirinoIsBlue() {
        assertEquals("Blue", mirino.getType());
    }

    @Test
    public void stringOfMirinoIsCorrectForNumbers() {
        
        Card thisMirino = new Mirino("Hearts", 3);
        assertEquals("Mirino: 3 of Hearts", thisMirino.toString());
    }
    
    @Test
    public void stringOfMirinoIsCorrectForAces() {
        assertEquals("Mirino: Ace of Hearts", mirino.toString());
    }
    
    @Test
    public void stringOfMirinoIsCorrectForJacks() {
        
        Card thisMirino = new Mirino("Hearts", 11);
        assertEquals("Mirino: Jack of Hearts", thisMirino.toString());
    }
    
    @Test
    public void stringOfMirinoIsCorrectForQueens() {
        
        Card thisMirino = new Mirino("Hearts", 12);
        assertEquals("Mirino: Queen of Hearts", thisMirino.toString());
    }
    
    @Test
    public void stringOfMirinoIsCorrectForKings() {
        
        Card thisMirino = new Mirino("Hearts", 13);
        assertEquals("Mirino: King of Hearts", thisMirino.toString());
    }
}