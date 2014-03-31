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
public class KitCarlsonPutCardBack implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;

    public KitCarlsonPutCardBack(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.getContentPane().removeAll();

        if (visibleScreen.getIndex() == -1) {
        } else {
            visibleScreen.getSetup().getRound().getDrawpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().size() - 3 + visibleScreen.getIndex()));
        }
        visibleScreen.playerXScreen();
        
        frame.revalidate();
        frame.repaint();
    }
}