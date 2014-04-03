/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import bang.banghotseat.cards.Card;
import userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka on ActionListener, jolla varustettu nappula
 * suostuu kauttamaan vaistokortin, jolloin pelaaja
 * ei meneta kestoja.
 */
public class DoYouWannaPlayMancato_Yes implements ActionListener {
    
    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DoYouWannaPlayMancato_Yes(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        visibleScreen.getFrame().getContentPane().removeAll();
        
        int indexOfMancato = 0;
        
        for (Card thisIsAMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
            if (thisIsAMancato.getName().contains("Mancato!")) {
                indexOfMancato = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAMancato);
            }
        }
        visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(indexOfMancato));
        
        visibleScreen.pleaseLookAway();
        
        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}
