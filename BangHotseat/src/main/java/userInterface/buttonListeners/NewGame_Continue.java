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
 * Luokka on ActionListener, jolla varustettu nappula vie ruutuun, joka kehottaa
 * toista pelaajaa katsomaan poispain ja uuden vuoron aloitustoimet suoritetaan.
 */
public class NewGame_Continue implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public NewGame_Continue(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getPlayer2());

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}