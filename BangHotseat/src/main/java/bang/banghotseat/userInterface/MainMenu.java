/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.Setup;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_NewGame;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_Rules;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_Exit;
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

public class MainMenu {
    
    private ActionListener mainMenu_NewGame;
    private ActionListener mainMenu_Rules;
    private ActionListener mainMenu_Exit;
    private JFrame frame;
    
    public MainMenu(JFrame frame, Setup setup) {
        this.frame = frame;
        this.mainMenu_NewGame = new MainMenu_NewGame(frame, setup);
        this.mainMenu_Rules = new MainMenu_Rules(frame, this);
        this.mainMenu_Exit = new MainMenu_Exit(frame, this);
    }
    
  public void createComponents(Container container) {
      
      GridLayout layout = new GridLayout(4,3);
      container.setLayout(layout);
      
      JLabel welcome = new JLabel("Welcome to BANG!", JLabel.CENTER);
      welcome.setFont(new Font("Bang", Font.BOLD, 48));
      
      JButton newGame = new JButton("New Game");
      newGame.setFont(new Font("Button", Font.ITALIC, 40));
      newGame.addActionListener(mainMenu_NewGame);
      
      JButton rules = new JButton("Rules");
      rules.setFont(new Font("Button", Font.ITALIC, 40));
      rules.addActionListener(mainMenu_Rules);
      
      JButton exit = new JButton("Exit");
      exit.setFont(new Font("Button", Font.ITALIC, 40));
      exit.addActionListener(mainMenu_Exit);
      
      container.add(new JLabel());
      container.add(welcome);
      container.add(new JLabel());

      container.add(new JLabel());
      container.add(newGame);
      container.add(new JLabel());

      container.add(new JLabel());
      container.add(rules);
      container.add(new JLabel());
      
      container.add(new JLabel());
      container.add(exit);
  }
  
  public JFrame getFrame() {
      return frame;
  }
}