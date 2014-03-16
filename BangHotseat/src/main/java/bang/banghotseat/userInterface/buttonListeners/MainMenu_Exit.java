/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.userInterface.MainMenu;
import bang.banghotseat.userInterface.Exit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class MainMenu_Exit implements ActionListener {

    private JFrame frame;
    private MainMenu mainMenu;
    private Exit exit;
    
    public MainMenu_Exit(JFrame frame, MainMenu mainMenu) {
        this.frame = frame;
        exit = new Exit(mainMenu);
    }
    
    @Override
    public void actionPerformed(ActionEvent rulesButton) {
        
        frame.getContentPane().removeAll();
        
        exit.createComponents(frame.getContentPane());
        frame.revalidate();
        frame.repaint();
    }
}