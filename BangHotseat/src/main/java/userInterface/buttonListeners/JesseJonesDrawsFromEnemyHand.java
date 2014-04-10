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
 * Luokka on ActionListener, jolla Jesse Jones haluaa vetaa ensimmaisen
 * korttinsa vihollisen kadesta.
 */
public class JesseJonesDrawsFromEnemyHand implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public JesseJonesDrawsFromEnemyHand(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().drawFromEnemyHandWithJesseJones();
        visibleScreen.randomHandCardWasStolen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}