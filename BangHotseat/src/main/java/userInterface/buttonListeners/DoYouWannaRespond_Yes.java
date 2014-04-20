/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

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

        if (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {

            boolean bangWasFound = false;
            boolean mancatoWasFound = visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerToFollow(), "Mancato!");

            if (!mancatoWasFound) {
                bangWasFound = visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerToFollow(), "BANG!");
            }
            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer") && visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().equals("BANG!") && visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0) {

                if (mancatoWasFound) {
                    visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(visibleScreen.getSetup().getRound().getPlayerToFollow(), "Mancato!");

                } else if (bangWasFound) {
                    visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(visibleScreen.getSetup().getRound().getPlayerToFollow(), "BANG!");
                }
            }
        } else {

            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().equals("BANG!") || visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().equals("Gatling!")) {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerToFollow(), "Mancato!");

                if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer") && visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().equals("BANG!") && visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0) {
                    visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForAnotherCardOfSameKind(visibleScreen.getSetup().getRound().getPlayerToFollow(), "Mancato!");
                }

            } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().equals("Indiani!")) {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerToFollow(), "BANG!");
            }
        }
        visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(visibleScreen.getSetup().getRound().getCheckerForPlayedCard().getIndexOfReplyCard(), visibleScreen.getSetup().getRound()));

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().equals("Duello")) {
            visibleScreen.getSetup().getRound().setPlayerInTurnIsNextToReactToDuello(true);
            visibleScreen.attackingPlayerPleaseLookAway();

        } else {
            visibleScreen.pleaseLookAway();
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}