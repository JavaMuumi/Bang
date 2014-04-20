/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import bang.banghotseat.cards.Card;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userInterface.VisibleScreen;

/**
 *
 * @author Antti Korpi
 *
 * Luokka on ActionListener, jolla varustettu nappula siirtaa kortin kadesta
 * poistettavien listaan. Jos Listalla on jo toinen kortti, molemmat poistetaan.
 */
public class SidKetchumCancel implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public SidKetchumCancel(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        for (Card toBePutBackIntoHand : visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getSidKetchumDiscardList()) {
            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(toBePutBackIntoHand);
        }
        visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getSidKetchumDiscardList().clear();

        visibleScreen.playerXScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}