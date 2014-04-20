/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import userInterface.VisibleScreen;

/**
 *
 * @author Antti Korpi
 *
 * Luokka on ActionListener, jolla varustettu nappula lopettaa pelaajan vuoron
 * ja siirtyy joko korttien hylkaamiseen tai kehotukseen katsoa pois.
 */
public class PlayerXScreen_EndTurn implements ActionListener {

    private VisibleScreen visibleScreen;
    private JFrame frame;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public PlayerXScreen_EndTurn(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().size() > visibleScreen.getSetup().getRound().getPlayerInTurn().getCurrentHealth()) {
            frame.getContentPane().removeAll();

            visibleScreen.discardCards();

        } else {
            frame.getContentPane().removeAll();

            visibleScreen.getSetup().getRound().endTurn();
            visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getRound().getPlayerToFollow());
        }
        frame.revalidate();
        frame.repaint();
    }
}