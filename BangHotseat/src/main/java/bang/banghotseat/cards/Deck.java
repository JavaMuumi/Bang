/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Antti Korpi
 */
public class Deck {
                    
    List<Card> deck = new ArrayList<>();
    
    public void createCards() {
        
        deck.add(new Bang("Hearts", 1));
        deck.add(new Bang("Hearts", 12));
        deck.add(new Bang("Hearts", 13));
        deck.add(new Bang("Diamonds", 1));
        deck.add(new Bang("Diamonds", 2));
        deck.add(new Bang("Diamonds", 3));
        deck.add(new Bang("Diamonds", 4));
        deck.add(new Bang("Diamonds", 5));
        deck.add(new Bang("Diamonds", 6));
        deck.add(new Bang("Diamonds", 7));
        deck.add(new Bang("Diamonds", 8));
        deck.add(new Bang("Diamonds", 9));
        deck.add(new Bang("Diamonds", 10));
        deck.add(new Bang("Diamonds", 11));
        deck.add(new Bang("Diamonds", 12));
        deck.add(new Bang("Diamonds", 13));
        deck.add(new Bang("Spades", 1));
        deck.add(new Bang("Clubs", 2));
        deck.add(new Bang("Clubs", 3));
        deck.add(new Bang("Clubs", 4));
        deck.add(new Bang("Clubs", 5));
        deck.add(new Bang("Clubs", 6));
        deck.add(new Bang("Clubs", 7));
        deck.add(new Bang("Clubs", 8));
        deck.add(new Bang("Clubs", 9));
        
        deck.add(new Gatling("Hearts", 10));
        
        deck.add(new Duello("Diamonds", 12));
        deck.add(new Duello("Spades", 11));
        deck.add(new Duello("Clubs", 8));
        
        deck.add(new Indiani("Diamonds", 1));
        deck.add(new Indiani("Diamonds", 13));
        
        deck.add(new Mancato("Spades", 2));
        deck.add(new Mancato("Spades", 3));
        deck.add(new Mancato("Spades", 4));
        deck.add(new Mancato("Spades", 5));
        deck.add(new Mancato("Spades", 6));
        deck.add(new Mancato("Spades", 7));
        deck.add(new Mancato("Spades", 8));
        deck.add(new Mancato("Clubs", 1));
        deck.add(new Mancato("Clubs", 10));
        deck.add(new Mancato("Clubs", 11));
        deck.add(new Mancato("Clubs", 12));
        deck.add(new Mancato("Clubs", 13));
        
        deck.add(new Birra("Hearts", 6));
        deck.add(new Birra("Hearts", 7));
        deck.add(new Birra("Hearts", 8));
        deck.add(new Birra("Hearts", 9));
        deck.add(new Birra("Hearts", 10));
        deck.add(new Birra("Hearts", 11));
        deck.add(new Saloon("Hearts", 5));
        
        deck.add(new WellsFargo("Hearts", 3));
        deck.add(new Diligenza("Spades", 9));
        deck.add(new Diligenza("Spades", 9));
        
        deck.add(new Prigione("Hearts", 4));
        deck.add(new Prigione("Spades", 10));
        deck.add(new Prigione("Spades", 11));
        
        deck.add(new Mustang("Hearts", 8));
        deck.add(new Mustang("Hearts", 9));
        
        deck.add(new Barrel("Spades", 12));
        deck.add(new Barrel("Spades", 13));
        
        deck.add(new Emporio("Spades", 12));
        deck.add(new Emporio("Clubs", 9));
        
        deck.add(new CatBalou("Diamonds", 9));
        deck.add(new CatBalou("Diamonds", 10));
        deck.add(new CatBalou("Diamonds", 11));
        deck.add(new CatBalou("Diamonds", 13));
        deck.add(new Panico("Hearts", 1));
        deck.add(new Panico("Hearts", 11));
        deck.add(new Panico("Hearts", 12));
        deck.add(new Panico("Diamonds", 8));
        
        deck.add(new Schofield("Spades", 13));
        deck.add(new Schofield("Clubs", 11));
        deck.add(new Schofield("Clubs", 12));
        deck.add(new Remington("Clubs", 13));
        deck.add(new RevCarabine("Spades", 8));
        deck.add(new Volcanic("Spades", 10));
        deck.add(new Volcanic("Clubs", 10));
        
        deck.add(new Dinamite("Hearts", 2));
        
        deck.add(new Mirino("Diamonds", 5));
    }
    
    public List<Card> getDeck() {
        return deck;
    }
    
    public Card take(Deck discardpile) {
        
        if (deck.isEmpty()) {
            for (Card toBePlaced : discardpile.getDeck()) {
                place(toBePlaced);
            }
            Collections.shuffle(deck);
        }
        Card cardToBeGiven = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return cardToBeGiven;
    }

    public void place(Card toBePlaced) {
        deck.add(toBePlaced);
    }
}
