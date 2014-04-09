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
public class DuelloTest {
    
    private Card duello;
    
    public DuelloTest() {
        duello = new Duello("Hearts", 1);
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
    public void nameOfDuelloIsCorrect() {
        assertEquals("Duello", duello.getName());
    }

    @Test
    public void typeOfDuelloIsOrange() {
        assertEquals("Orange", duello.getType());
    }

    @Test
    public void stringOfDuelloIsCorrectForNumbers() {
        
        Card thisDuello = new Duello("Hearts", 3);
        assertEquals("Duello: 3 of Hearts", thisDuello.toString());
    }
    
    @Test
    public void stringOfDuelloIsCorrectForAces() {
        assertEquals("Duello: Ace of Hearts", duello.toString());
    }
    
    @Test
    public void stringOfDuelloIsCorrectForJacks() {
        
        Card thisDuello = new Duello("Hearts", 11);
        assertEquals("Duello: Jack of Hearts", thisDuello.toString());
    }
    
    @Test
    public void stringOfDuelloIsCorrectForQueens() {
        
        Card thisDuello = new Duello("Hearts", 12);
        assertEquals("Duello: Queen of Hearts", thisDuello.toString());
    }
    
    @Test
    public void stringOfDuelloIsCorrectForKings() {
        
        Card thisDuello = new Duello("Hearts", 13);
        assertEquals("Duello: King of Hearts", thisDuello.toString());
    }
}