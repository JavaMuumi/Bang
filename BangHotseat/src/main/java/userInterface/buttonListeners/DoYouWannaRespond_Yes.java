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

        if (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {
            for (Card thisIsBangOrMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                if (thisIsBangOrMancato.getName().contains("BANG!") || thisIsBangOrMancato.getName().contains("Mancato!")) {
                    indexOfReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsBangOrMancato);
                }
            }
        } else {
            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") || visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Mancato!") || visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Gatling!")) {
                for (Card thisIsAMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                    if (thisIsAMancato.getName().contains("Mancato!")) {
                        indexOfReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAMancato);
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
