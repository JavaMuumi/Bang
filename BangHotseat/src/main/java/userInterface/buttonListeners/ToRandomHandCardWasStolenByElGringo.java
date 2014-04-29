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
 * Luokka on ActionListener, jolla varustettu nappula vie nakymaan jossa
 * kerrotaan, minka kasikortin El Gringo juuri varasti.
 */
public class ToRandomHandCardWasStolenByElGringo implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ToRandomHandCardWasStolenByElGringo(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.handCardWasStolenByElGringo();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}