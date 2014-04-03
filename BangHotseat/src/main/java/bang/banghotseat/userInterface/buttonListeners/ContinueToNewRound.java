/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.cards.Card;
import bang.banghotseat.userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka on ActionListener, jolla varustettu nappula
 * aloittaa uuden kierroksen ja vie vuorossa olevan
 * pelaajan ruutuun.
 */
public class ContinueToNewRound implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ContinueToNewRound(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.getContentPane().removeAll();

        boolean thereIsADinamite = false;

        for (Card isItDinamite : visibleScreen.getSetup().getRound().getPlayerInTurn().getFrontCards()) {
            if (isItDinamite.getName().contains("Dinamite")) {
                thereIsADinamite = true;
            }
        }
        visibleScreen.getSetup().getRound().playTurn();
        if (thereIsADinamite) {
            visibleScreen.dinamiteScreen();
        } else {
            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Kit Carlson")) {
                visibleScreen.kitCarlsonDrawScreen();
            } else {
                visibleScreen.playerXScreen();
            }
        }
        frame.revalidate();
        frame.repaint();
    }
}