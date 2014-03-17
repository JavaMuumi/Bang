/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.Setup;
import bang.banghotseat.userInterface.InfoScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class NewGame_Continue implements ActionListener {

    private JFrame frame;
    private InfoScreen newGameContinue;
    private Setup setup;
    
    public NewGame_Continue(JFrame frame, Setup setup) {
        this.frame = frame;
        this.setup = setup;
        newGameContinue = new InfoScreen(frame, setup);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        frame.getContentPane().removeAll();
        
        newGameContinue.player2PleaseLookAwayScreen(frame.getContentPane());
        frame.revalidate();
        frame.repaint();
    }
}