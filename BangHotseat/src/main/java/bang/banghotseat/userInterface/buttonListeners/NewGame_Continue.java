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
 * 
 * Luokka on ActionListener, jolla varustettu nappula
 * vie ruutuun, joka kehottaa toista pelaajaa katsomaan
 * poispain ja uuden vuoron aloitustoimet suoritetaan.
 */
public class NewGame_Continue implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public NewGame_Continue(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        frame.getContentPane().removeAll();

        visibleScreen.playerXPleaseLookAwayScreen(visibleScreen.getSetup().getPlayer2());

        frame.revalidate();
        frame.repaint();
    }
}