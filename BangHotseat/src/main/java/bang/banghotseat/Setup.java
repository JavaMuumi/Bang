/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.avatars.LuckyDuke;
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

    private Player player1 = new Player();
    private Player player2 = new Player();
    private AvatarRandomizer randomizer = new AvatarRandomizer();
    private Deck drawpile;
    private Deck discardpile;
    private Round round;

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
    private void givePlayersAvatarsAndSetMaxHealths() {

        player1.setAvatar(randomizer.giveAvatar());
        player1.setCurrentHealth();
        player2.setAvatar(randomizer.giveAvatar());
        player2.setCurrentHealth();
    }

    /**
     *
     * Luo nosto- ja poistopakan ja lisaa nostopakkaan kortit.
     */
    private void createDecks() {

        this.drawpile = new Deck();
        drawpile.createCards();
        this.discardpile = new Deck();
    }

    /**
     *
     * Jakaa pelaajille maksimikestojen mukaisen maaran kasikortteja.
     */
    private void dealStartingHands() {

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