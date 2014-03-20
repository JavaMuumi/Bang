/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface.buttonListeners;

import bang.banghotseat.userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 */
public class MainMenu_Exit implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;
    
    public MainMenu_Exit(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent rulesButton) {
        
        frame.getContentPane().removeAll();
        
        visibleScreen.exit();
        frame.revalidate();
        frame.repaint();
    }
}