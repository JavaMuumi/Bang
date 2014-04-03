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
 * poistaa luettelosta valittuja kortteja vuoron lopuksi.
 */
public class DiscardCards_Discard implements ActionListener {
    
    private VisibleScreen visibleScreen;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DiscardCards_Discard(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (visibleScreen.getIndex() == -1) {
        }
        else {
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getIndex()));
        }
        if(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().size() > visibleScreen.getSetup().getRound().getPlayerInTurn().getCurrentHealth()) {
            visibleScreen.getFrame().getContentPane().removeAll();
            
            visibleScreen.discardCards();
            
            visibleScreen.getFrame().revalidate();
            visibleScreen.getFrame().repaint();
        }
        else {
            visibleScreen.getFrame().getContentPane().removeAll();
            
            visibleScreen.getSetup().getRound().endTurn();
            visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getRound().getPlayerToFollow());
            
            visibleScreen.getFrame().revalidate();
            visibleScreen.getFrame().repaint();
        }
    }
}