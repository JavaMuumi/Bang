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
 * Luokka on ActionListener, jolla varustettu nappula vie takaisin
 * alkuvalikko-ruutuun.
 */
public class CancelCardDiscard implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public CancelCardDiscard(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        if (!visibleScreen.getSetup().getRound().getPlayerInTurn().getListOfDiscardedCards().isEmpty()) {

            for (int i = 0; i < visibleScreen.getSetup().getRound().getPlayerInTurn().getListOfDiscardedCards().size(); i++) {
                visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getDiscardpile().take(visibleScreen.getSetup().getRound().getDiscardpile()));
            }
        }
        visibleScreen.getSetup().getRound().getPlayerInTurn().clearListOfDiscardedCards();

        visibleScreen.playerXScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}