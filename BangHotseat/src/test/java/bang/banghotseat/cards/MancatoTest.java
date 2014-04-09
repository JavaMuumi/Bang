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
public class MancatoTest {
    
    private Card mancato;
    
    public MancatoTest() {
        mancato = new Mancato("Hearts", 1);
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
    public void nameOfMancatoIsCorrect() {
        assertEquals("Mancato!", mancato.getName());
    }

    @Test
    public void typeOfMancatoIsMancato() {
        assertEquals("Mancato", mancato.getType());
    }

    @Test
    public void stringOfMancatoIsCorrectForNumbers() {
        
        Card thisMancato = new Mancato("Hearts", 3);
        assertEquals("Mancato!: 3 of Hearts", thisMancato.toString());
    }
    
    @Test
    public void stringOfMancatoIsCorrectForAces() {
        assertEquals("Mancato!: Ace of Hearts", mancato.toString());
    }
    
    @Test
    public void stringOfMancatoIsCorrectForJacks() {
        
        Card thisMancato = new Mancato("Hearts", 11);
        assertEquals("Mancato!: Jack of Hearts", thisMancato.toString());
    }
    
    @Test
    public void stringOfMancatoIsCorrectForQueens() {
        
        Card thisMancato = new Mancato("Hearts", 12);
        assertEquals("Mancato!: Queen of Hearts", thisMancato.toString());
    }
    
    @Test
    public void stringOfMancatoIsCorrectForKings() {
        
        Card thisMancato = new Mancato("Hearts", 13);
        assertEquals("Mancato!: King of Hearts", thisMancato.toString());
    }
}