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
 * Luokka on ActionListener, jolla varustettu nappula siirtyy nakymaan joka
 * kertoo vastustajan pelanneen kaikki korttinsa Duellossa.
 */
public class PlayerToFollowLostDuelloAndAllHisHandCards implements ActionListener {

    private VisibleScreen visibleScreen;
    private JFrame frame;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public PlayerToFollowLostDuelloAndAllHisHandCards(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.getContentPane().removeAll();

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Calamity Janet")) {
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().getIndexOfABangOrMancatoInHandOfCalamityJanet(visibleScreen.getSetup().getRound().getPlayerInTurn()), visibleScreen.getSetup().getRound()));
        } else {
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getSetup().getRound().getCheckerForPlayedCard().getIndexOfCertainHandCard(visibleScreen.getSetup().getRound().getPlayerInTurn(), "Bang"), visibleScreen.getSetup().getRound()));
        }
        visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().function(visibleScreen.getSetup().getRound());

        if (visibleScreen.getSetup().getRound().gameIsOver()) {
            visibleScreen.gameIsOver();

        } else {
            visibleScreen.playerToFollowLostEverythingInDuello();
        }
        frame.revalidate();
        frame.repaint();
    }
}