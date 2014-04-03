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
 * vie pelin saantoihin.
 */
public class MainMenu_Rules implements ActionListener {
    
    private JFrame frame;
    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public MainMenu_Rules(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent rulesButton) {
        
        frame.getContentPane().removeAll();
        
        visibleScreen.rules();
        frame.revalidate();
        frame.repaint();
    }
}