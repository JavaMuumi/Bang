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
 * Luokka on ActionListener, jolla varustettu nappula lisaa valitun kortin Sid
 * Ketchumin uhrattavien korttien listaan tai poistaa listassa olevat kortit.
 */
public class SidKetchumDiscardClick implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public SidKetchumDiscardClick(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getSidKetchumDiscardList().size() < 2) {
            visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().addToSidKetchumDiscardList(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getIndex(), visibleScreen.getSetup().getRound()));
            visibleScreen.sidKetchumCardDiscard();

        } else {
            visibleScreen.getSetup().getRound().getPlayerInTurn().gainHealth();

            for (Card toBeDiscarded : visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getSidKetchumDiscardList()) {
                visibleScreen.getSetup().getRound().getDiscardpile().place(toBeDiscarded);
            }
            visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getSidKetchumDiscardList().clear();
            visibleScreen.playerXScreen();
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}