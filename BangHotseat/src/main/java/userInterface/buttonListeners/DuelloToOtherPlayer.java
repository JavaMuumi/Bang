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
 * Luokka on ActionListener, jolla varustettu nappula vie nakymaan, joka pyytaa
 * Duelloon vastannutta pelaajaa katsomaan pois.
 */
public class DuelloToOtherPlayer implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DuelloToOtherPlayer(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        boolean playerHadABang = false;

        if (visibleScreen.getSetup().getRound().playerInTurnIsNextToReactToDuello()) {

            playerHadABang = visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerInTurn(), "BANG!");

            if (!playerHadABang && visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Calamity Janet")) {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerInTurn(), "Mancato!");
            }
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCardWithoutGivingReplacingOne(visibleScreen.getSetup().getRound().getCheckerForPlayedCard().getIndexOfReplyCard(), visibleScreen.getSetup().getRound()));
            visibleScreen.getSetup().getRound().setPlayerInTurnIsNextToReactToDuello(false);

        } else {

            playerHadABang = visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerToFollow(), "BANG!");

            if (!playerHadABang && visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().searchPlayerHandForCertainCard(visibleScreen.getSetup().getRound().getPlayerToFollow(), "Mancato!");
            }

            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(visibleScreen.getSetup().getRound().getCheckerForPlayedCard().getIndexOfReplyCard(), visibleScreen.getSetup().getRound()));
            visibleScreen.getSetup().getRound().setPlayerInTurnIsNextToReactToDuello(true);
        }
        visibleScreen.duelloToOtherPlayerScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}