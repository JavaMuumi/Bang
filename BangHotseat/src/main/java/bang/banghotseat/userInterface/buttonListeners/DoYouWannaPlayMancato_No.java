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
 * kieltaytyy kayttamasta vaistokorttia vaikka siihen
 * olisi mahdollisuus, jolloin pelaaja menettaa yhden
 * keston.
 */
public class DoYouWannaPlayMancato_No implements ActionListener{

    private VisibleScreen visibleScreen;
    private JFrame frame;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DoYouWannaPlayMancato_No(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        frame.getContentPane().removeAll();
        
        visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
        
        visibleScreen.pleaseLookAway();
        
        frame.revalidate();
        frame.repaint();
    }
}