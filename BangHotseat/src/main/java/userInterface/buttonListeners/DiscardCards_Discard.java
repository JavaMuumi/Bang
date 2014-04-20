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
 * Luokka on ActionListener, jolla varustettu nappula poistaa luettelosta
 * valittuja kortteja vuoron lopuksi.
 */
public class DiscardCards_Discard implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DiscardCards_Discard(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();
        
        if (visibleScreen.getIndex() > -1) {

            visibleScreen.getFrame().getContentPane().removeAll();

            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getIndex(), visibleScreen.getSetup().getRound()));
        }

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().size() > visibleScreen.getSetup().getRound().getPlayerInTurn().getCurrentHealth()) {
            visibleScreen.discardCards();

        } else {
            visibleScreen.getSetup().getRound().endTurn();
            visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getRound().getPlayerToFollow());
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}