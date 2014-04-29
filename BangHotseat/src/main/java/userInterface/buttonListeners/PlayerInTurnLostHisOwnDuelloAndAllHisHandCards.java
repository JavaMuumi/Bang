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
 * taman havittya kaikki korttinsa ja eran Duellossa ja asettaa tasta kertovan
 * infonakyman.
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
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getIndexOfABangOrMancatoInHandOfCalamityJanet(visibleScreen.getSetup().getRound().getPlayerToFollow()), visibleScreen.getSetup().getRound()));
        } else {
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(visibleScreen.getSetup().getRound().getCheckerForPlayedCard().getIndexOfCertainHandCard(visibleScreen.getSetup().getRound().getPlayerToFollow(), "Bang"), visibleScreen.getSetup().getRound()));
        }
        visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().function(visibleScreen.getSetup().getRound());

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Suzy Lafayette")) {
            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getDrawpile().take(visibleScreen.getSetup().getRound().getDiscardpile()));
        }

        if (visibleScreen.getSetup().getRound().gameIsOver()) {
            visibleScreen.gameIsOver();

        } else {
            visibleScreen.playerInTurnLostEverythingInDuello();

            if (!visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Bart Cassidy") && !visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Suzy Lafayette")) {
                visibleScreen.getSetup().getRound().endTurn();
            }
        }
        frame.revalidate();
        frame.repaint();
    }
}
