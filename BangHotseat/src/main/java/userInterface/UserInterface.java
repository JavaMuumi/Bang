/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import bang.banghotseat.Setup;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Antti Korpi
 *
 * Luokka luo kauttoliittyman, jolla pelaajat ohjaavat pelia.
 */
public class UserInterface implements Runnable {

    private Setup setup;
    private JFrame frame;
    private VisibleScreen visibleScreen;

    /**
     *
     */
    public UserInterface() {
        setup = new Setup();
    }

    @Override
    public void run() {

        frame = new JFrame("BANG!");
        frame.setPreferredSize(new Dimension(1365, 765));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.visibleScreen = new VisibleScreen(frame, setup);
        visibleScreen.MainMenu();

        frame.pack();
        frame.setVisible(true);
    }

    /**
     *
     * @return nakyman luova luokka
     */
    public VisibleScreen getVisibleScreen() {
        return visibleScreen;
    }

    /**
     *
     * @return kayttoliittyman raamit
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     *
     * @return peliin kaytettava alkuvalmistelija
     */
    public Setup getSetup() {
        return setup;
    }
}