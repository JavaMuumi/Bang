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
 * Luokka on ActionListener, jolla varustettu nappula ottaa vihollisen kortit
 * luettelevasta listasta valitun kortin pelaajan kateen ja siirtyy pelaajan
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

        if (visibleScreen.getPanicoOrCatBalouIndex() != -1) {
            visibleScreen.getFrame().getContentPane().removeAll();
        }

        if (visibleScreen.getPanicoOrCatBalouIndex() == -2) {

            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().setLastStolenCard(visibleScreen.getSetup().getRound().getPlayerToFollow().drawRandomHandCard(visibleScreen.getSetup().getRound()));
            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getCheckerForPlayedCard().getLastStolenCard());
            visibleScreen.randomHandCardWasStolen();

        } else if (visibleScreen.getPanicoOrCatBalouIndex() > -1) {

            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificFrontCard(visibleScreen.getPanicoOrCatBalouIndex()));
            visibleScreen.playerXScreen();
        }

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}