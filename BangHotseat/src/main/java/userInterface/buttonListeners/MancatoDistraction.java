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
 * vie ruutuun, jolla hamataan vastustajaa luulemaan,
 * etta pelaajalla saattaisi olla vaistokortti.
 */
public class MancatoDistraction implements ActionListener {
    
    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public MancatoDistraction(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        visibleScreen.getFrame().getContentPane().removeAll();
        
        visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
        visibleScreen.clickToPretendYouHadMancato();
        
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}
