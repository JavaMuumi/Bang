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
public class PlayerXScreen_EndTurn implements ActionListener {
    
    private VisibleScreen visibleScreen;
    private JFrame frame;
    
    public PlayerXScreen_EndTurn(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().size() > visibleScreen.getSetup().getRound().getPlayerInTurn().getCurrentHealth()) {
            frame.getContentPane().removeAll();
            
            visibleScreen.discardCards();
            
            frame.revalidate();
            frame.repaint();
        }
        else {
            frame.getContentPane().removeAll();
            
            visibleScreen.getSetup().getRound().endTurn();
            visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getRound().getPlayerToFollow());
            
            frame.revalidate();
            frame.repaint();
        }
    }
}