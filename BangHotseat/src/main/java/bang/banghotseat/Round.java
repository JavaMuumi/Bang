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
 */
public class Round {
    
    private Player playerInTurn;
    private Player playerToFollow;
    private Deck drawpile;
    private Deck discardpile;
    private CheckerForEventsBeforeTurn checkerForEventsBeforeTurn;
    private CheckerForAvatarSpeciality checkerForAvatarSpeciality;
    private CheckerForPlayedCard checkerForPlayedCard;
    private Player statsDepository = new Player();
    private boolean goOn = false;
    private boolean bangHasBeenPlayed = false;
    
    public Round(Player player1, Player player2, Deck drawpile, Deck discardpile) {
        
        playerInTurn = player1;
        playerToFollow = player2;
        this.drawpile = drawpile;
        this.discardpile = discardpile;
        checkerForEventsBeforeTurn = new CheckerForEventsBeforeTurn(drawpile, discardpile);
        checkerForAvatarSpeciality = new CheckerForAvatarSpeciality();
        checkerForPlayedCard = new CheckerForPlayedCard(this);
    }
    
    public void playTurn() {
        
        checkerForEventsBeforeTurn.setPlayerTurns(playerInTurn, playerToFollow);
        checkerForEventsBeforeTurn.checkDinamite();
        checkerForEventsBeforeTurn.checkPrigione();
        
        playerInTurn.getAvatar().drawCards(drawpile, discardpile, playerInTurn, playerToFollow);
    }
    
    public void endTurn() {
        bangHasBeenPlayed = false;
        statsDepository = playerInTurn;
        playerInTurn = playerToFollow;
        playerToFollow = statsDepository;
    }

    public Player getPlayerInTurn() {
        return playerInTurn;
    }
    
    public Player getPlayerToFollow() {
        return playerToFollow;
    }
    
    public Deck getDrawpile() {
        return drawpile;
    }
    
    public Deck getDiscardpile() {
        return discardpile;
    }
    
    public CheckerForEventsBeforeTurn getCheckerForEventsBeforeTurn() {
        return checkerForEventsBeforeTurn;
    }
    
    public CheckerForAvatarSpeciality getCheckerForAvatarSpeciality() {
        return checkerForAvatarSpeciality;
    }
    
    public CheckerForPlayedCard getCheckerForPlayedCard() {
        return checkerForPlayedCard;
    }
    
    public boolean getBangHasBeenPlayed() {
        return bangHasBeenPlayed;
    }
    
    public void setBangHasBeenPlayed(boolean trueOrFalse) {
        bangHasBeenPlayed = trueOrFalse;
    }
}