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
 * vie ruutuun, joka ilmoittaa vastustajan olemaan
 * kykenematon vaistamaan, koska hanella ei ole yhtaan
 * kasikorttia.
 */
public class ToYouHaveNoMancato implements ActionListener {
    
    private VisibleScreen visibleScreen;
    private JFrame frame;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public ToYouHaveNoMancato(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        frame.getContentPane().removeAll();
        
        visibleScreen.bangAndNoHandCards();
        visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
        
        frame.revalidate();
        frame.repaint();
    }
}