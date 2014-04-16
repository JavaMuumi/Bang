/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import bang.banghotseat.cards.Card;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userInterface.VisibleScreen;

/**
 *
 * @author Antti Korpi
 *
 * Luokka on ActionListener, jolla varustettu nappula suostuu kauttamaan
 * vastauskortin, jolloin pelaaja ei meneta kestoja.
 */
public class DoYouWannaRespond_Yes implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DoYouWannaRespond_Yes(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        int indexOfReplyCard = 0;
        int indexOfSecondReplyCard = 0;

        if (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {
            for (Card thisIsBangOrMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                if (thisIsBangOrMancato.getName().contains("BANG!") || thisIsBangOrMancato.getName().contains("Mancato!")) {
                    indexOfReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsBangOrMancato);
                }
            }
            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer") && visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") && visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0) {
                for (Card thisIsAlsoBangOrMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                    if ((thisIsAlsoBangOrMancato.getName().contains("BANG!") || thisIsAlsoBangOrMancato.getName().contains("Mancato!")) && visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAlsoBangOrMancato) != indexOfReplyCard) {
                        indexOfSecondReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAlsoBangOrMancato);
                    }
                }
                visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(indexOfSecondReplyCard, visibleScreen.getSetup().getRound()));
                if (indexOfReplyCard > indexOfSecondReplyCard) {
                    indexOfReplyCard = indexOfReplyCard - 1;
                }
            }
        } else {
            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") || visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Mancato!") || visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Gatling!")) {
                for (Card thisIsAMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                    if (thisIsAMancato.getName().contains("Mancato!")) {
                        indexOfReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAMancato);
                    }
                }
                if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer") && visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") && visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0) {
                    for (Card thisIsAlsoAMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                        if (thisIsAlsoAMancato.getName().contains("Mancato!") && visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAlsoAMancato) != indexOfReplyCard) {
                            indexOfSecondReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAlsoAMancato);
                        }
                    }
                    visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(indexOfSecondReplyCard, visibleScreen.getSetup().getRound()));
                    if (indexOfReplyCard > indexOfSecondReplyCard) {
                        indexOfReplyCard = indexOfReplyCard - 1;
                    }
                }
            } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Indiani!")) {
                for (Card thisIsABang : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                    if (thisIsABang.getName().contains("BANG!")) {
                        indexOfReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsABang);
                    }
                }
            }
        }
        visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(indexOfReplyCard, visibleScreen.getSetup().getRound()));

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Duello")) {
            visibleScreen.getSetup().getRound().setPlayerInTurnIsNextToReactToDuello(true);
            visibleScreen.attackingPlayerPleaseLookAway();

        } else {
            visibleScreen.pleaseLookAway();
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}