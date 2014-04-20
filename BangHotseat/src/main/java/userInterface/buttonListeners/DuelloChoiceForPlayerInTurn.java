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
 * Luokka on ActionListener, jolla varustettu nappula vie vuorossa olevan
 * pelaajan Duello-korttiin reagointinakymaan.
 */
public class DuelloChoiceForPlayerInTurn implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DuelloChoiceForPlayerInTurn(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.playerInTurnRepliesToDuello();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}