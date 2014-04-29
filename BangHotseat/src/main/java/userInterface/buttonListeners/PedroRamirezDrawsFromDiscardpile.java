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
 * Luokka on ActionListener, jolla Pedro Ramirez haluaa vetaa ensimmaisen
 * korttinsa poistopakasta ja siirtyy pelaajan ruutuun.
 */
public class PedroRamirezDrawsFromDiscardpile implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public PedroRamirezDrawsFromDiscardpile(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().drawFromDiscardpileWithPedroRamirez();

        visibleScreen.playerXScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}