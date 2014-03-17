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
public class MainMenu_NewGame implements ActionListener {

    private JFrame frame;
    private Setup setup;
    private InfoScreen newGame;
    
    public MainMenu_NewGame(JFrame frame, Setup setup) {
        this.frame = frame;
        this.setup = setup;
        this.newGame = new InfoScreen(frame, setup);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        setup.runSetup();

        frame.getContentPane().removeAll();
        
        newGame.newGameInfo(frame.getContentPane(), setup);
        frame.revalidate();
        frame.repaint();
    }
}