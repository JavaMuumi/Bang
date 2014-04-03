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
 * 
 * Luokka on ActionListener, jolla varustettu nappula 
 * vie vuorossa olevan pelaajan ruutuun.
 */
public class ContinueToPlayerXScreen implements ActionListener {
    
    private JFrame frame;
    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ContinueToPlayerXScreen(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        frame.getContentPane().removeAll();
        
        visibleScreen.playerXScreen();
        
        frame.revalidate();
        frame.repaint();
    }
}