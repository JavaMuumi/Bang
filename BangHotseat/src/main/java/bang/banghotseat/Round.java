/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.CheckerForAvatarSpeciality;
import bang.banghotseat.essentials.CheckerForEventsBeforeTurn;
import bang.banghotseat.essentials.CheckerForPlayedCard;
import bang.banghotseat.essentials.Player;

/**
 *
 * @author Antti Korpi
 *
 * Pelin ydinluokka, joka sisaltaa molemmat pelaajat ja tiedon, kumpi on
 * vuorossa, seka molemmat pakat.
 *
 */
public class Round {

    private Player playerInTurn;
    private Player playerToFollow;
    private Deck drawpile;
    private Deck discardpile;
    private CheckerForEventsBeforeTurn checkerForEventsBeforeTurn;
    private CheckerForPlayedCard checkerForPlayedCard;
    private CheckerForAvatarSpeciality checkerForAvatarSpeciality;
    private Player statsDepository;
    private boolean bangHasBeenPlayed = false;

    /**
     *
     * @param player1 ensimmaisena pelaava pelaaja
     * @param player2 toisena pelaava pelaaja
     * @param drawpile lista korteista, joita nostetaan pelin aikana
     * @param discardpile lista, jolle pelissa poistetut kortit lisataan
     */
    public Round(Player player1, Player player2, Deck drawpile, Deck discardpile) {

        playerInTurn = player1;
        playerToFollow = player2;
        this.drawpile = drawpile;
        this.discardpile = discardpile;
        checkerForEventsBeforeTurn = new CheckerForEventsBeforeTurn(this);
        checkerForPlayedCard = new CheckerForPlayedCard(this);
        checkerForAvatarSpeciality = new CheckerForAvatarSpeciality(this);
        statsDepository = new Player();
    }

    /**
     *
     */
    public void playTurn() {

        checkerForEventsBeforeTurn.setPlayerTurns(playerInTurn, playerToFollow);

        checkerForEventsBeforeTurn.checkDinamite();
        checkerForEventsBeforeTurn.checkPrigione();

        playerInTurn.getAvatar().drawCards(this);
    }

    /**
     *
     */
    public void endTurn() {

        bangHasBeenPlayed = false;
        statsDepository = playerInTurn;
        playerInTurn = playerToFollow;
        playerToFollow = statsDepository;

        playerInTurn.clearListOfLastCheckedCards();
    }

    /**
     *
     * @return vuorossa oleva pelaaja
     */
    public Player getPlayerInTurn() {
        return playerInTurn;
    }

    /**
     *
     * @param playerToSet pelaaja, joka asetetaan vuorossa olevaksi
     */
    public void setPlayerInTurn(Player playerToSet) {
        playerInTurn = playerToSet;
    }

    /**
     *
     * @return seuraavana pelaava pelaaja
     */
    public Player getPlayerToFollow() {
        return playerToFollow;
    }

    /**
     *
     * @param playerToSet pelaaja, joka asetetaan seuraavaksi vuorossa
     */
    public void setPlayerToFollow(Player playerToSet) {
        playerToFollow = playerToSet;
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
     * @return vuoroa edeltavat tapahtumat tarkastava luokka
     */
    public CheckerForEventsBeforeTurn getCheckerForEventsBeforeTurn() {
        return checkerForEventsBeforeTurn;
    }

    /**
     *
     * @return pelatut kortit tarkastava luokka
     */
    public CheckerForPlayedCard getCheckerForPlayedCard() {
        return checkerForPlayedCard;
    }

    /**
     *
     * @return avatarin erikoiskyvyt tarkastava luokka
     */
    public CheckerForAvatarSpeciality getCheckerForAvatarSpeciality() {
        return checkerForAvatarSpeciality;
    }

    /**
     *
     * @return tieto onko BANG! jo pelattu talla vuorolla
     */
    public boolean getBangHasBeenPlayed() {
        return bangHasBeenPlayed;
    }

    /**
     *
     * @param trueOrFalse kertoo asetetaanko bangHasBeenPlayed olemaan tosi vai
     * epatosi
     */
    public void setBangHasBeenPlayed(boolean trueOrFalse) {
        bangHasBeenPlayed = trueOrFalse;
    }
}
