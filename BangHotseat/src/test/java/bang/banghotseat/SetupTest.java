/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.avatars.Avatar;
import bang.banghotseat.cards.Deck;
import java.util.ArrayList;
import java.util.List;
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
public class SetupTest {

    private Setup setup = new Setup();

    public SetupTest() {
        setup.runSetup();
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
    public void player1HasAnAvatar() {

        List<Avatar> avatarAmountTest = new ArrayList<>();
        avatarAmountTest.add(setup.getPlayer1().getAvatar());

        assertEquals(1, avatarAmountTest.size());
    }

    @Test
    public void player2HasAnAvatar() {

        List<Avatar> avatarAmountTest = new ArrayList<>();
        avatarAmountTest.add(setup.getPlayer2().getAvatar());

        assertEquals(1, avatarAmountTest.size());
    }

    @Test
    public void playersAlwaysHaveDifferentAvatars() {

        boolean playersHaveDifferentAvatars = true;
        setup.givePlayersAvatarsAndSetMaxHealths();

        if (setup.getPlayer1().getAvatar().toString().equals(setup.getPlayer2().getAvatar().toString())) {
            playersHaveDifferentAvatars = false;
        }
        assertEquals(true, playersHaveDifferentAvatars);
    }

    @Test
    public void player1HasCorrectAmountOfHealth() {

        if (setup.getPlayer1().getAvatar().toString().equals("El Gringo") || setup.getPlayer1().getAvatar().toString().equals("Paul Regret")) {
            assertEquals(3, setup.getPlayer1().getCurrentHealth());
        } else {
            assertEquals(4, setup.getPlayer1().getCurrentHealth());
        }
    }

    @Test
    public void player2HasCorrectAmountOfHealth() {

        if (setup.getPlayer2().getAvatar().toString().equals("El Gringo") || setup.getPlayer2().getAvatar().toString().equals("Paul Regret")) {
            assertEquals(3, setup.getPlayer2().getCurrentHealth());
        } else {
            assertEquals(4, setup.getPlayer2().getCurrentHealth());
        }
    }

    @Test
    public void player1HasHisMaxHealthAmountOfHandCards() {

        int numberOfPlayer1HandCards = setup.getPlayer1().getHandCards().size();
        assertEquals(setup.getPlayer1().getCurrentHealth(), numberOfPlayer1HandCards);
    }

    @Test
    public void player2HasHisMaxHealthAmountOfHandCards() {

        int numberOfPlayer2HandCards = setup.getPlayer2().getHandCards().size();
        assertEquals(setup.getPlayer2().getCurrentHealth(), numberOfPlayer2HandCards);
    }

    @Test
    public void drawpileHasBeenCreated() {

        List<Deck> drawpileexistsTest = new ArrayList<>();
        drawpileexistsTest.add(setup.getDrawpile());
        assertEquals(1, drawpileexistsTest.size());
    }

    @Test
    public void discardpileHasBeenCreated() {

        List<Deck> discardpileexistsTest = new ArrayList<>();
        discardpileexistsTest.add(setup.getDiscardpile());
        assertEquals(1, discardpileexistsTest.size());
    }

    @Test
    public void justCreatedDrawpileHas79Cards() {

        int cardsOnJustCreatedDeck = setup.getDrawpile().getDeck().size() + setup.getPlayer1().getHandCards().size() + setup.getPlayer2().getHandCards().size();
        assertEquals(79, cardsOnJustCreatedDeck);
    }

    public void justCreatedDiscardpileIsEmpty() {

        assertEquals(0, setup.getDiscardpile().getDeck().size());
    }

    @Test
    public void dealtCardsAreRemovedFromDrawpile() {

        int amountOfPlayerHandCards = setup.getPlayer1().getHandCards().size() + setup.getPlayer2().getHandCards().size();
        assertEquals(79 - amountOfPlayerHandCards, setup.getDrawpile().getDeck().size());
    }
}