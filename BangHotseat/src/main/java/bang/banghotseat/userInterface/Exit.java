/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.userInterface.buttonListeners.Exit_BackToMainMenu;
import bang.banghotseat.userInterface.buttonListeners.Exit_ReallyExit;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Antti Korpi
 */
public class Exit {
    
    private ActionListener exit_BackToMainMenu;
    private ActionListener exit_ReallyExit;
    
    public Exit(MainMenu mainMenu) {
        exit_BackToMainMenu = new Exit_BackToMainMenu(mainMenu);
        exit_ReallyExit = new Exit_ReallyExit(mainMenu);
    }
    
    public void createComponents(Container container) {
      
      JLabel exit = new JLabel("You really wanna exit BANG!?", JLabel.CENTER);
      exit.setFont(new Font("Bang", Font.BOLD, 48));
      
      JButton reallyExit = new JButton("Yes");
      reallyExit.setFont(new Font("Button", Font.ITALIC, 34));
      reallyExit.addActionListener(exit_ReallyExit);
      
      JButton backToMainMenu = new JButton("No");
      backToMainMenu.setFont(new Font("Button", Font.ITALIC, 34));
      backToMainMenu.addActionListener(exit_BackToMainMenu);
      
      container.add(exit);
      container.add(reallyExit);
      container.add(backToMainMenu);
  }
}