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
 * aloittaa uuden pelin.
 */
public class MainMenu_NewGame implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public MainMenu_NewGame(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        visibleScreen.getSetup().runSetup();

        frame.getContentPane().removeAll();
        
        visibleScreen.newGameInfo();
        frame.revalidate();
        frame.repaint();
    }
}