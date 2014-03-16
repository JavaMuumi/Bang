/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.userInterface.MainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class Exit_ReallyExit implements ActionListener {
    private JFrame frame;
    private MainMenu mainMenu;
    
    public Exit_ReallyExit(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        frame = mainMenu.getFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        frame.dispose();
    }
}