/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.cards.Card;
import bang.banghotseat.cards.Deck;

/**
 *
 * @author Antti Korpi
 */
public class CheckerForEventsBeforeTurn {

    private Player playerInTurn;
    private Player playerToFollow;
    private Deck drawpile;
    private Deck discardpile;

    public CheckerForEventsBeforeTurn(Deck drawpile, Deck discardpile) {
        this.drawpile = drawpile;
        this.discardpile = discardpile;
    }

    public void setPlayerTurns(Player playerInTurn, Player playerToFollow) {
        this.playerInTurn = playerInTurn;
        this.playerToFollow = playerToFollow;
    }

    public void checkDinamite() {

        boolean thereWasADinamite = false;
        boolean dinamiteDetonated = false;
        int indexOfDinamite = 0;

        for (Card cardToCheck : playerInTurn.getFrontCards()) {

            if (cardToCheck.toString().contains("Dinamite")) {

                indexOfDinamite = playerInTurn.getFrontCards().indexOf(cardToCheck);
                thereWasADinamite = true;

                Card topCard = drawpile.take(discardpile);
                playerInTurn.setLastCheckedCard(topCard);
                discardpile.place(topCard);

                if (topCard.getSuit().equals("Spades") && topCard.getNumber() > 1 && topCard.getNumber() < 10) {
                    cardToCheck.function(playerInTurn, playerToFollow, drawpile, discardpile);
                    dinamiteDetonated = true;
                }
            }
        }
        if (thereWasADinamite) {
            if (dinamiteDetonated) {
                discardpile.place(playerInTurn.drawSpecificFrontCard(indexOfDinamite));
            } else {
                if (playerToFollow.getFrontCards().isEmpty()) {
                    playerToFollow.putCardInFront(playerInTurn.drawSpecificFrontCard(indexOfDinamite));
                } else if (playerToFollow.getFrontCards().get(playerToFollow.getFrontCards().size() - 1).getName().contains("Dinamite")) {
                } else {
                    playerToFollow.putCardInFront(playerInTurn.drawSpecificFrontCard(indexOfDinamite));
                }
            }
        }
    }

    public void checkPrigione() {
    }
}