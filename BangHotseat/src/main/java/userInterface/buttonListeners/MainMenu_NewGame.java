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
 * Luokka on ActionListener, jolla varustettu nappula aloittaa uuden pelin.
 */
public class MainMenu_NewGame implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public MainMenu_NewGame(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getSetup().runSetup();

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.newGameInfo();
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}