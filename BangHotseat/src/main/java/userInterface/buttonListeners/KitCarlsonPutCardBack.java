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
 * Luokka on ActionListener, jolla varustettu nappula asettaa tarjotuista
 * vaihtoehdoista valitun kortin takaisin nostopakkaan ja siirtyy pelaajan
 * ruutuun.
 */
public class KitCarlsonPutCardBack implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public KitCarlsonPutCardBack(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        if (visibleScreen.getIndex() == -1) {
        } else {
            visibleScreen.getSetup().getRound().getDrawpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().size() - 3 + visibleScreen.getIndex(), visibleScreen.getSetup().getRound()));
        }
        visibleScreen.playerXScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}