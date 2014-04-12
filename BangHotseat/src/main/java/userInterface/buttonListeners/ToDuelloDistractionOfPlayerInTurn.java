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
 * vuorossa oleva pelaaja hamaa vastustajaa luulemaan, etta pelaajalla saattaisi
 * olla BANG!.
 */
public class ToDuelloDistractionOfPlayerInTurn implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ToDuelloDistractionOfPlayerInTurn(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getPlayerInTurn().loseHealth(1, visibleScreen.getSetup().getRound());
        visibleScreen.clickToPretendYouCouldReply();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}
