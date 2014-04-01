/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class PanicoScreen_StealNow implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;

    public PanicoScreen_StealNow(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (visibleScreen.getPanicoIndex() == -1) {
        } else if (visibleScreen.getPanicoIndex() == -2) {
            frame.getContentPane().removeAll();
            visibleScreen.getSetup().getRound().getPlayerInTurn().setLastCheckedCard(visibleScreen.getSetup().getRound().getPlayerToFollow().drawRandomHangCard());
            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getPlayerInTurn().getLastCheckedCard());
            visibleScreen.panicoStoleRandomHandCard();
        } else {
            frame.getContentPane().removeAll();
            visibleScreen.getSetup().getRound().getPlayerInTurn().putCardIntoHand(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificFrontCard(visibleScreen.getPanicoIndex()));
            visibleScreen.playerXScreen();
        }
        frame.revalidate();
        frame.repaint();
    }
}
