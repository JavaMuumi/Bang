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
 * Luokka on ActionListener, jolla varustettu nappula poistaa vihollisen kortit
 * luettelevasta listasta valitun kortin ja siirtyy pelaajan ruutuun.
 */
public class CatBalouScreen_RemoveNow implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public CatBalouScreen_RemoveNow(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (visibleScreen.getPanicoOrCatBalouIndex() == -1) {
        } else if (visibleScreen.getPanicoOrCatBalouIndex() == -2) {

            visibleScreen.getFrame().getContentPane().removeAll();

            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawRandomHandCard(visibleScreen.getSetup().getRound()));
            visibleScreen.catBalouRemovedRandomHandCard();

        } else {
            visibleScreen.getFrame().getContentPane().removeAll();

            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificFrontCard(visibleScreen.getPanicoOrCatBalouIndex()));
            visibleScreen.playerXScreen();
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}