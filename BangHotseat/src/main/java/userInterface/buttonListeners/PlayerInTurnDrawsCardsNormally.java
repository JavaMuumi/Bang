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
 * Luokka on ActionListener, jolla pelaaja, jonka avatarin erikoiskyky sallii
 * hanen valita miten nostaa vuorokorttinsa, nostaa normaalisti kaksi korttia
 * nostopakasta ja siirtyy pelaajan ruutuun.
 */
public class PlayerInTurnDrawsCardsNormally implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public PlayerInTurnDrawsCardsNormally(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Pedro Ramirez")) {
            for (int i = 0; i < 2; i++) {
                visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getDrawpile().take(visibleScreen.getSetup().getRound().getDiscardpile()));
            }
        }
        visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().drawCards(visibleScreen.getSetup().getRound());
        visibleScreen.playerXScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}