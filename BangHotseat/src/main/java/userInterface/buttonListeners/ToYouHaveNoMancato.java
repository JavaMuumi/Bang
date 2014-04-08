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
 * vie ruutuun, joka ilmoittaa vastustajan olemaan
 * kykenematon vaistamaan, koska hanella ei ole yhtaan
 * kasikorttia.
 */
public class ToYouHaveNoMancato implements ActionListener {
    
    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ToYouHaveNoMancato(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        visibleScreen.getFrame().getContentPane().removeAll();
        
        visibleScreen.takingDamageAndNoHandCards();
        visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
        
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}