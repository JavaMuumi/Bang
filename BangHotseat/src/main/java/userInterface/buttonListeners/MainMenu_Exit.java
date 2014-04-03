/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka on ActionListener, jolla varustettu nappula
 * vie ohjelman lopettamisen varmistavaan ruutuun.
 */
public class MainMenu_Exit implements ActionListener {

    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public MainMenu_Exit(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }
    
    @Override
    public void actionPerformed(ActionEvent rulesButton) {
        
        visibleScreen.getFrame().getContentPane().removeAll();
        
        visibleScreen.exit();
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}