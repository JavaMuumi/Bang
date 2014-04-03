/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.avatars;

import bang.banghotseat.Round;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.Player;
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
public class BlackJackTest {

    private Round round;

    public BlackJackTest() {
        round = new Round(new Player(), new Player(), new Deck(), new Deck());
        round.getPlayerInTurn().setAvatar(new BlackJack());
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
    public void blackJackSetsMaxHealthTo4() {
        assertEquals(4, round.getPlayerInTurn().getAvatar().getMaxHealth());
    }
    
    @Test
    public void getSpecialityReturnsCorrectDescriptionForBlackJack() {
        assertEquals("He shows the second card he draws. On Heart or Diamonds, he draws one more card.", round.getPlayerInTurn().getAvatar().getSpeciality());
    }

    @Test
    public void whenSecondCardIsSpadesBlackJackGetsFirstAndSecondCardButNotThird() {

        round.getDrawpile().place(new Bang("Hearts", 1));
        round.getDrawpile().place(new Bang("Spades", 1));
        round.getDrawpile().place(new Bang("Hearts", 1));

        round.getPlayerInTurn().getAvatar().drawCards(round);

        assertEquals(2, round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void whenSecondCardIsClubsBlackJackGetsFirstAndSecondCardButNotThird() {

        round.getDrawpile().getDeck().add(new Bang("Hearts", 1));
        round.getDrawpile().getDeck().add(new Bang("Clubs", 1));
        round.getDrawpile().getDeck().add(new Bang("Hearts", 1));

        round.getPlayerInTurn().getAvatar().drawCards(round);

        assertEquals(2, round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void whenSecondCardIsHeartsBlackJackGetsFirstAndSecondCardAndOneMore() {

        round.getDrawpile().getDeck().add(new Bang("Hearts", 1));
        round.getDrawpile().getDeck().add(new Bang("Hearts", 1));
        round.getDrawpile().getDeck().add(new Bang("Hearts", 1));

        round.getPlayerInTurn().getAvatar().drawCards(round);

        assertEquals(3, round.getPlayerInTurn().getHandCards().size());
    }

    @Test
    public void whenSecondCardIsDiamondsBlackJackGetsFirstAndSecondCardAndOneMore() {

        round.getDrawpile().getDeck().add(new Bang("Hearts", 1));
        round.getDrawpile().getDeck().add(new Bang("Diamonds", 1));
        round.getDrawpile().getDeck().add(new Bang("Hearts", 1));

        round.getPlayerInTurn().getAvatar().drawCards(round);

        assertEquals(3, round.getPlayerInTurn().getHandCards().size());
    }
}