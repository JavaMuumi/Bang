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
 * Luokka on ActionListener, jolla varustettu nappula vie vankilanakymasta
 * toisen pelaajan vuoroon.
 */
public class Prigione_ToNextPlayer implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public Prigione_ToNextPlayer(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();
        
        visibleScreen.getSetup().getRound().endTurn();

        visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getRound().getPlayerToFollow());

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}
