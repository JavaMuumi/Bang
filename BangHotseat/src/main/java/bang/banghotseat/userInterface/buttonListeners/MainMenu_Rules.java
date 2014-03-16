/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.userInterface.MainMenu;
import bang.banghotseat.userInterface.Rules;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class MainMenu_Rules implements ActionListener {
    
    private JFrame frame;
    private MainMenu mainMenu;
    private Rules rules;
    
    public MainMenu_Rules(JFrame frame, MainMenu mainMenu) {
        this.frame = frame;
        rules = new Rules(mainMenu);
    }
    
    @Override
    public void actionPerformed(ActionEvent rulesButton) {
        
        frame.getContentPane().removeAll();
        
        rules.createComponents(frame.getContentPane());
        frame.revalidate();
        frame.repaint();
    }
}