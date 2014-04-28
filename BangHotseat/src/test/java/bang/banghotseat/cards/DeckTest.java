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
public class DeckTest {
    
    private Deck deck;
    
    public DeckTest() {
        
        deck = new Deck();
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
    public void methodCreateCardsCreates79Cards() {
        
        deck.createCards();
        assertEquals(79, deck.getDeck().size());
    }
    
    
    @Test
    public void ifACardIsPlacedOnDeckItWillBeTheTopOne() {
        
        deck.createCards();
        deck.place(new Bang("Hearts" , 1));
        
        assertEquals("BANG!: Ace of Hearts", deck.getDeck().get(deck.getDeck().size() - 1).toString());
    }
    
    @Test
    public void methodTakeReturnsTheTopCard() {
        
        deck.createCards();
        deck.place(new Bang("Hearts", 1));
        
        assertEquals("BANG!: Ace of Hearts", deck.take(deck).toString());
    }
    
    @Test
    public void ifACardIsTakenFromDeckItWillBeRemoved() {
        
        deck.place(new Bang("Hearts", 1));
        deck.take(deck);
        
        assertEquals("Deck size: 0", "Deck size: " + deck.getDeck().size());
    }
    
    @Test
    public void ifDeckIsNotEmptyGivenDeckWillNotBeAddedToItWhenMethodTakeIsUsed() {
        
        deck.place(new Bang("Hearts" , 1));
        Deck discarpile = new Deck();
        discarpile.createCards();
        
        deck.take(discarpile);
        
        assertEquals("Deck size: 0", "Deck size: " + deck.getDeck().size());
    }
    
    @Test
    public void ifMethodTakeIsUsedOnEmptyDeckGivenDeckWillBeAddedToIt() {
        
        Deck discardpile = new Deck();
        discardpile.createCards();
        
        deck.take(discardpile);
        
        assertEquals("Deck size: 78", "Deck size: " + deck.getDeck().size());
    }
    
    @Test
    public void ifMethodTakeIsUsedOnEmptyDeckGivenDeckWillBeCleared() {
        
        Deck discardpile = new Deck();
        discardpile.createCards();
        
        deck.take(discardpile);
        
        assertEquals(true, discardpile.getDeck().isEmpty());
    }
    
    @Test
    public void ifMethodTakeIsUsedOnDeckThatIsNotEmptyGivenDeckWillNotBeCleared() {
        
        deck.place(new Bang("Hearts", 1));
        Deck discardpile = new Deck();
        discardpile.createCards();
        
        deck.take(discardpile);
        
        assertEquals(false, discardpile.getDeck().isEmpty());
    }
    
    @Test
    public void methodClearDeckRemovesEverythingFromDeck() {
        
        deck.createCards();
        deck.clearDeck();
        
        assertEquals(true, deck.getDeck().isEmpty());
    }
}