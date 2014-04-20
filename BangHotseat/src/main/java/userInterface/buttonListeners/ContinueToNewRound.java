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
 * Luokka on ActionListener, jolla varustettu nappula aloittaa uuden kierroksen
 * ja vie vuorossa olevan pelaajan ruutuun.
 */
public class ContinueToNewRound implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ContinueToNewRound(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getPlayerInTurn().clearListOfLastCheckedCards();
        visibleScreen.getSetup().getRound().playTurn();

        if (visibleScreen.getSetup().getRound().getCheckerForEventsBeforeTurn().thereIsADinamite()) {
            visibleScreen.dinamiteScreen();

        } else if (visibleScreen.getSetup().getRound().getCheckerForEventsBeforeTurn().thereIsAPrigione()) {
            visibleScreen.prigioneScreen();

        } else {
            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Kit Carlson")) {
                visibleScreen.kitCarlsonDrawScreen();

            } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Jesse Jones")) {
                visibleScreen.jesseJonesDrawScreen();

            } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Pedro Ramirez")) {
                visibleScreen.pedroRamirezDrawScreen();

            } else {
                visibleScreen.playerXScreen();
            }
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}