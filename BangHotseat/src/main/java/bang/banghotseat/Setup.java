/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Card;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.AvatarRandomizer;
import bang.banghotseat.essentials.Player;

/**
 *
 * @author Antti Korpi
 *
 * Uuden pelin valmisteleva luokka, joka luo pelaajat ja pakat.
 */
public class Setup {

    private Player player1;
    private Player player2;
    private AvatarRandomizer randomizer;
    private Deck drawpile;
    private Deck discardpile;
    private Round round;

    public Setup() {

        player1 = new Player();
        player2 = new Player();
        randomizer = new AvatarRandomizer();
    }

    /**
     *
     * Suorittaa pelia edeltavat toimenpiteet.
     */
    public void runSetup() {

        givePlayersAvatarsAndSetMaxHealths();
        createDecks();
        dealStartingHands();
        round = new Round(player1, player2, drawpile, discardpile);
    }

    /**
     *
     * Antaa pelaajille avatarit ja niiden mukaiset kestot.
     */
    public void givePlayersAvatarsAndSetMaxHealths() {

        player1.setAvatar(randomizer.giveAvatar());
        player1.setCurrentHealth();

        player2.setAvatar(randomizer.giveAvatar());
        while (player2.getAvatar().toString().equals(player1.getAvatar().toString())) {
            player2.setAvatar(randomizer.giveAvatar());
        }
        player2.setCurrentHealth();
    }

    /**
     *
     * Luo nosto- ja poistopakan ja lisaa nostopakkaan kortit.
     */
    private void createDecks() {

        drawpile = new Deck();
        discardpile = new Deck();

        drawpile.createCards();
    }

    /**
     *
     * Jakaa pelaajille maksimikestojen mukaisen maaran kasikortteja.
     */
    private void dealStartingHands() {

        player1.getHandCards().clear();
        player1.getFrontCards().clear();
        player2.getHandCards().clear();
        player2.getFrontCards().clear();

        while (player1.getHandCards().size() < player1.getAvatar().getMaxHealth()) {
            Card cardToBeGiven = drawpile.take(discardpile);
            player1.putCardIntoHand(cardToBeGiven);
        }
        while (player2.getHandCards().size() < player2.getAvatar().getMaxHealth()) {
            Card cardToBeGiven = drawpile.take(discardpile);
            player2.putCardIntoHand(cardToBeGiven);
        }
    }

    /**
     *
     * @return ensimmaisena pelaava pelaaja
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     *
     * @return toisena pelaava pelaaja
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     *
     * @return pakka, josta nostetaan
     */
    public Deck getDrawpile() {
        return drawpile;
    }

    /**
     *
     * @return pakka, johon poistetaan
     */
    public Deck getDiscardpile() {
        return discardpile;
    }

    /**
     *
     * @return kierroksen tiedot sisaltava luokka
     */
    public Round getRound() {
        return round;
    }
}