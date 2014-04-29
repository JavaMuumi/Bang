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
 * Luokka on ActionListener, jolla varustettu nappula vie ruutuun, jolla
 * hamataan vastustajaa luulemaan, etta pelaajalla saattaisi olla vaistokortti.
 */
public class DistractionReply implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DistractionReply(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().function(visibleScreen.getSetup().getRound());

        visibleScreen.clickToPretendYouCouldReply();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}