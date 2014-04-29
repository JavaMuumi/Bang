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
 * Luokka on ActionListener, jolla varustettu nappula vie ruutuun, joka
 * ilmoittaa vastustajan olemaan kykenematon vaistamaan, koska hanella ei ole
 * tarpeeksi kasikortteja.
 */
public class ToYouDoNotHaveEnoughHandCardsAndCannotReply implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ToYouDoNotHaveEnoughHandCardsAndCannotReply(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().function(visibleScreen.getSetup().getRound());
        visibleScreen.takingDamageAndNoHandCards();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}