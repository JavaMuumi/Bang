/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.Setup;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */

public class UserInterface implements Runnable {
  
    private Setup setup;
    private JFrame frame;
    private MainMenu mainMenu;
    
    public UserInterface(Setup setup) {
        this.setup = setup;
    }
    
    @Override
    public void run() {
        
        frame = new JFrame("BANG!");
        frame.setPreferredSize(new Dimension (1365, 765));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.mainMenu = new MainMenu(frame, setup);
        mainMenu.createComponents(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
  }

  public JFrame getFrame() {
      return frame;
  }
}