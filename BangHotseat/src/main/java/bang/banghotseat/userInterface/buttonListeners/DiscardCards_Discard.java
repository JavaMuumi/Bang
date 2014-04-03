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
 * poistaa luettelosta valittuja kortteja vuoron lopuksi.
 */
public class DiscardCards_Discard implements ActionListener {
    
    private VisibleScreen visibleScreen;
    private JFrame frame;
    
    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DiscardCards_Discard(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (visibleScreen.getIndex() == -1) {
        }
        else {
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(visibleScreen.getIndex()));
        }
        if(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().size() > visibleScreen.getSetup().getRound().getPlayerInTurn().getCurrentHealth()) {
            frame.getContentPane().removeAll();
            
            visibleScreen.discardCards();
            
            frame.revalidate();
            frame.repaint();
        }
        else {
            frame.getContentPane().removeAll();
            
            visibleScreen.getSetup().getRound().endTurn();
            visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getRound().getPlayerToFollow());
            
            frame.revalidate();
            frame.repaint();
        }
    }
}