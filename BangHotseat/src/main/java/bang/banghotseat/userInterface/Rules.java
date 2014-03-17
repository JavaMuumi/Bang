/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.userInterface.buttonListeners.MainMenu_Exit;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_NewGame;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_Rules;
import bang.banghotseat.userInterface.buttonListeners.Rules_BackToMainMenu;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Antti Korpi
 */
public class Rules {
    
    private ActionListener rules_BackToMainMenu;
    
    public Rules(MainMenu mainMenu) {
        rules_BackToMainMenu = new Rules_BackToMainMenu(mainMenu);
    }
    
    public void createComponents(Container container) {
        
        GridLayout layout = new GridLayout(4,3);
        container.setLayout(layout);
        JLabel rules = new JLabel("Rules: KILL THE OTHER PLAYER!", JLabel.CENTER);
        
        JButton backToMainMenu = new JButton("Back to Main Menu");
        backToMainMenu.setFont(new Font("Button", Font.ITALIC, 34));
        backToMainMenu.addActionListener(rules_BackToMainMenu);
        
        container.add(new JLabel());
        container.add(new JLabel());
        container.add(new JLabel());
        container.add(new JLabel());
        container.add(rules);
        container.add(new JLabel());

        container.add(new JLabel());
        container.add(backToMainMenu);
        container.add(new JLabel());
  }
}