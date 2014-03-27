/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.essentials;

import bang.banghotseat.Round;
import bang.banghotseat.cards.Card;

/**
 *
 * @author Antti Korpi
 */
public class CheckerForPlayedCard {
    
    private Card playedCard;
    private Round round;
    private int index;
    
    public CheckerForPlayedCard(Round round) {
        this.round = round;
    }
    
    public void playingCard(int index) {
        
        this.index = index;
        this.playedCard = round.getPlayerInTurn().getHandCards().get(index);
        
        if (playedCard.getType().equals("Orange")) {
            if (playedCard.getName().contains("BANG!")) {
                playingBang();
            }
            else if (playedCard.getName().contains("Mancato!")) {
            }
            else if (playedCard.getName().contains("Cat Balou")) {
                playingCatBalou();
            }
            else if (playedCard.getName().contains("Panico!")) {
                playingPanico();
            }
            else {
            playedCard.function(round.getPlayerInTurn(), round.getPlayerToFollow(), round.getDrawpile(), round.getDiscardpile());
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
            }
        }
        else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Blue")) {
            
//            if (round.getPlayerInTurn().getFrontCards().isEmpty()) {
                round.getPlayerInTurn().getFrontCards().add(round.getPlayerInTurn().drawSpecificHandCard(index));
//            }
//            else {
//                for (Card isTheSameCardAlreadyInFront : round.getPlayerInTurn().getFrontCards()) {
//                    if (isTheSameCardAlreadyInFront.getName().equals(round.getPlayerInTurn().getHandCards().get(index).getName())) {
//                        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificFrontCard(round.getPlayerInTurn().getFrontCards().indexOf(isTheSameCardAlreadyInFront)));
//                        round.getPlayerInTurn().getFrontCards().remove(round.getPlayerInTurn().getFrontCards().indexOf(isTheSameCardAlreadyInFront));
//                        playerInTurn.drawSpecificHandCard(numberOfCard);
//                    }
//                    else {
//                        round.getPlayerInTurn().getFrontCards().add(round.getPlayerInTurn().drawSpecificHandCard(index));
//                    }
//                }
//            }
        }
        else if (round.getPlayerInTurn().getHandCards().get(index).getType().equals("Gun")) {
//            
//            for (Card isAGun : round.getPlayerInTurn().getFrontCards()) {
//                if (isAGun.getType().equals("Gun")) {
//                    round.getDiscardpile().place(isAGun);
//                    round.getPlayerInTurn().getFrontCards().remove(round.getPlayerInTurn().getFrontCards().indexOf(isAGun));
//                }
//            }
            round.getPlayerInTurn().putCardInFront(round.getPlayerInTurn().drawSpecificHandCard(index));
        }
    }
    
    public void playingBang() {
        
        for (Card isThereAVolcanic : round.getPlayerInTurn().getFrontCards()) {
            if (isThereAVolcanic.getName().contains("Volcanic")) {
                round.setBangHasBeenPlayed(false);
            }
        }
        if (round.getPlayerInTurn().getAvatar().toString().equals("Willy The Kid")) {
            round.setBangHasBeenPlayed(false);
        }
        if (round.getPlayerToFollow().getDistance() > round.getPlayerInTurn().getReach()) {
        }
        else if (round.getBangHasBeenPlayed() == true) {
        }
        else {
            round.getPlayerInTurn().getHandCards().get(index).function(round.getPlayerInTurn(), round.getPlayerToFollow(), round.getDrawpile(), round.getDiscardpile());
            round.setBangHasBeenPlayed(true);
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
        }
    }
    
    public void playingCatBalou() {
        
        round.getPlayerInTurn().getHandCards().get(index).function(round.getPlayerInTurn(), round.getPlayerToFollow(), round.getDrawpile(), round.getDiscardpile());
        round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
    }
    
    public void playingPanico() {
        
        if (round.getPlayerToFollow().getDistance() > round.getPlayerInTurn().getReach()) {
        }
        else {
            round.getPlayerInTurn().getHandCards().get(index).function(round.getPlayerInTurn(), round.getPlayerToFollow(), round.getDrawpile(), round.getDiscardpile());
            round.getDiscardpile().place(round.getPlayerInTurn().drawSpecificHandCard(index));
        }
    }
}