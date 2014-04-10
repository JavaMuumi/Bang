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

        boolean thereIsADinamite = false;
        boolean thereIsAPrigione = false;

        for (Card isItDinamiteOrPrigione : visibleScreen.getSetup().getRound().getPlayerInTurn().getFrontCards()) {
            if (isItDinamiteOrPrigione.getName().contains("Dinamite")) {
                thereIsADinamite = true;
            } else if (isItDinamiteOrPrigione.getName().contains("Prigione")) {
                thereIsAPrigione = true;
            }
        }
        visibleScreen.getSetup().getRound().playTurn();
        if (thereIsADinamite) {
            visibleScreen.dinamiteScreen();
        } else if (thereIsAPrigione) {
            visibleScreen.prigioneScreen();
        } else {
            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Kit Carlson")) {
                visibleScreen.kitCarlsonDrawScreen();

            } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Jesse Jones")) {
                visibleScreen.jesseJonesDrawScreen();

            } else {
                visibleScreen.playerXScreen();
            }
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}