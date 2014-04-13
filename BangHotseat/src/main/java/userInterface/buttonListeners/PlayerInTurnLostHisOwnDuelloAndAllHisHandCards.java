/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import userInterface.VisibleScreen;

/**
 *
 * @author Antti Korpi
 *
 * Luokka on ActionListener, jolla varustettu nappula lopettaa pelaajan vuoron
 * taman havittya kaikki korttinsa ja eran Duellossa ja seuraavan pelaajan
 * vuoroon.
 */
public class PlayerInTurnLostHisOwnDuelloAndAllHisHandCards implements ActionListener {

    private VisibleScreen visibleScreen;
    private JFrame frame;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public PlayerInTurnLostHisOwnDuelloAndAllHisHandCards(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.getContentPane().removeAll();

        if (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().get(visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getIndexOfABangOrMancatoInHandOfCalamityJanet(visibleScreen.getSetup().getRound().getPlayerToFollow())));
        } else {
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().get(visibleScreen.getSetup().getRound().getCheckerForPlayedCard().getIndexOfABangInHand(visibleScreen.getSetup().getRound().getPlayerToFollow())));
        }
        visibleScreen.getSetup().getRound().getPlayerInTurn().loseHealth(1, visibleScreen.getSetup().getRound());

        visibleScreen.playerInTurnLostEverythingInDuello();

        visibleScreen.getSetup().getRound().endTurn();

        frame.revalidate();
        frame.repaint();
    }
}