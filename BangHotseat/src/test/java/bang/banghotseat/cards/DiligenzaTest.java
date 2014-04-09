/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import bang.banghotseat.Round;
import bang.banghotseat.essentials.Player;
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
public class DiligenzaTest {
    
    private Round round;
    private Card diligenza;
    
    public DiligenzaTest() {
        
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getDrawpile().createCards();
        diligenza = new Diligenza("Hearts", 1);
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
    public void nameOfDiligenzaIsCorrect() {
        assertEquals("Diligenza", diligenza.getName());
    }

    @Test
    public void typeOfDiligenzaIsOrange() {
        assertEquals("Orange", diligenza.getType());
    }

    @Test
    public void stringOfDiligenzaIsCorrectForNumbers() {
        
        Card thisDiligenza = new Diligenza("Hearts", 3);
        assertEquals("Diligenza: 3 of Hearts", thisDiligenza.toString());
    }
    
    @Test
    public void stringOfDiligenzaIsCorrectForAces() {
        assertEquals("Diligenza: Ace of Hearts", diligenza.toString());
    }
    
    @Test
    public void stringOfDiligenzaIsCorrectForJacks() {
        
        Card thisDiligenza = new Diligenza("Hearts", 11);
        assertEquals("Diligenza: Jack of Hearts", thisDiligenza.toString());
    }
    
    @Test
    public void stringOfDiligenzaIsCorrectForQueens() {
        
        Card thisDiligenza = new Diligenza("Hearts", 12);
        assertEquals("Diligenza: Queen of Hearts", thisDiligenza.toString());
    }
    
    @Test
    public void stringOfDiligenzaIsCorrectForKings() {
        
        Card thisDiligenza = new Diligenza("Hearts", 13);
        assertEquals("Diligenza: King of Hearts", thisDiligenza.toString());
    }
    
    @Test
    public void afterPlayingDiligenzaPlayerHas2HandCards() {
        diligenza.function(round);
        assertEquals(2, round.getPlayerInTurn().getHandCards().size());
    }
}