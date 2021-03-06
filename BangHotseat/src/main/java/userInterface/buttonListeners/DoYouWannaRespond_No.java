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
 * Luokka on ActionListener, jolla varustettu nappula kieltaytyy kayttamasta
 * vastauskorttia vaikka siihen olisi mahdollisuus, jolloin pelaaja menettaa
 * yhden keston.
 */
public class DoYouWannaRespond_No implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DoYouWannaRespond_No(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().function(visibleScreen.getSetup().getRound());

        if (visibleScreen.getSetup().getRound().gameIsOver()) {
            visibleScreen.gameIsOver();

        } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("El Gringo")) {

            if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().isEmpty()) {
                visibleScreen.targetedPlayerHasNoCardsSoTheyCannotBeTaken();
            } else {
                visibleScreen.handCardWasStolenByElGringo();
            }
        } else {
            visibleScreen.pleaseLookAway();
        }
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}