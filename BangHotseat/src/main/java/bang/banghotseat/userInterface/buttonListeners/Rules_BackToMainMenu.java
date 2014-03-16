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
public class Rules_BackToMainMenu implements ActionListener {
    
    private MainMenu mainMenu;
    private JFrame frame;
    
    public Rules_BackToMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
        frame = mainMenu.getFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().removeAll();
        
        mainMenu.createComponents(frame.getContentPane());
        frame.revalidate();
        frame.repaint();
    }
}