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
 * Luokka on ActionListener, jolla varustettu nappula antaa vuorossa olevalle
 * pelaajalle toisena Emporiosta tarjotun kortin ja seuraavalle pelaajalle
 * ensimmaisen ja palaa pelaajan pelinakymaan.
 */
public class EmporioPlayerChoseSecondCard implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public EmporioPlayerChoseSecondCard(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getDiscardpile().take(visibleScreen.getSetup().getRound().getDiscardpile()));
        visibleScreen.getSetup().getRound().getPlayerToFollow().putCardIntoHand(visibleScreen.getSetup().getRound().getDiscardpile().take(visibleScreen.getSetup().getRound().getDiscardpile()));

        visibleScreen.playerXScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}