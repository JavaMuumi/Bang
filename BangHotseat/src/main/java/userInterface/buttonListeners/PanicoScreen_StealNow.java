/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka on ActionListener, jolla varustettu nappula
 * ottaa vihollisen kortit luettelevasta listasta
 * valitun kortin pelaajan kateen ja siirtyy pelaajan
 * ruutuun.
 */
public class PanicoScreen_StealNow implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public PanicoScreen_StealNow(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (visibleScreen.getPanicoIndex() == -1) {
        } else if (visibleScreen.getPanicoIndex() == -2) {
            visibleScreen.getFrame().getContentPane().removeAll();
            visibleScreen.getSetup().getRound().getPlayerInTurn().setLastCheckedCard(visibleScreen.getSetup().getRound().getPlayerToFollow().drawRandomHangCard());
            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getPlayerInTurn().getLastCheckedCard());
            visibleScreen.panicoStoleRandomHandCard();
        } else {
            visibleScreen.getFrame().getContentPane().removeAll();
            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificFrontCard(visibleScreen.getPanicoIndex()));
            visibleScreen.playerXScreen();
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}
