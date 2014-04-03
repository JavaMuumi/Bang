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
 * suostuu lopettamaan ohjelman ja se suljetaan.
 */
public class Exit_ReallyExit implements ActionListener {

    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public Exit_ReallyExit(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        visibleScreen.getFrame().setVisible(false);
        visibleScreen.getFrame().dispose();
    }
}