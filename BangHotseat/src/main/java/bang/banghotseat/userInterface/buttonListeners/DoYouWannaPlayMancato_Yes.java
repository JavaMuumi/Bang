/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.cards.Card;
import bang.banghotseat.userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class DoYouWannaPlayMancato_Yes implements ActionListener {
    
    private VisibleScreen visibleScreen;
    private JFrame frame;
    
    public DoYouWannaPlayMancato_Yes(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        frame.getContentPane().removeAll();
        
        int indexOfMancato = 0;
        
        for (Card thisIsAMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
            if (thisIsAMancato.getName().contains("Mancato!")) {
                indexOfMancato = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAMancato);
            }
        }
        visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(indexOfMancato));
        
        visibleScreen.pleaseLookAway();
        
        frame.revalidate();
        frame.repaint();
    }
}
