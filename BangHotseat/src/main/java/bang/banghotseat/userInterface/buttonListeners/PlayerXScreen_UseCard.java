/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.Round;
import bang.banghotseat.userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class PlayerXScreen_UseCard implements ActionListener {
    
    private JFrame frame;
    private VisibleScreen visibleScreen;
    
    public PlayerXScreen_UseCard(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        
        if (visibleScreen.getIndex() == -1) {
        }
        else {
            
            frame.getContentPane().removeAll();
            
            visibleScreen.getSetup().getRound().playCard(visibleScreen.getIndex());
        
            visibleScreen.playerXScreen();
        
            frame.revalidate();
            frame.repaint();
        }
    }
}