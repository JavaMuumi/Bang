/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.Setup;
import bang.banghotseat.userInterface.buttonListeners.NewGame_Continue;
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
public class InfoScreen {
    
    private JFrame frame;
    private Setup setup;
    private ActionListener newGame_Continue;
    
    public InfoScreen(JFrame frame, Setup setup) {
        this.frame = frame;
        this.setup = setup;
    }
    
    public void newGameInfo(Container container, Setup setup) {
        
        GridLayout layout = new GridLayout(5,4);
        container.setLayout(layout);

        JLabel player1Avatar = new JLabel("Player1, your character is " + setup.getPlayer1().getAvatar().toString());
        player1Avatar.setFont(new Font("Bang", Font.BOLD, 48));
        JLabel player1Speciality = new JLabel(setup.getPlayer1().getAvatar().getSpeciality());
        player1Speciality.setFont(new Font("CharacterAbility", Font.ITALIC, 28));
        JLabel player2Avatar = new JLabel("Player2, your character is " + setup.getPlayer2().getAvatar().toString());
        player2Avatar.setFont(new Font("Bang", Font.BOLD, 48));
        JLabel player2Speciality = new JLabel(setup.getPlayer2().getAvatar().getSpeciality());
        player2Speciality.setFont(new Font("CharacterAbility", Font.ITALIC, 28));
        
        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        newGame_Continue = new NewGame_Continue(frame, setup);
        next.addActionListener(newGame_Continue);
        
        container.add(player1Avatar);
        container.add(player1Speciality);
        container.add(player2Avatar);
        container.add(player2Speciality);
        container.add(next);
        }
    
    public void player2PleaseLookAwayScreen(Container container) {
        
        JLabel player2PleaseLookAway = new JLabel("Player2, please look away now", JLabel.CENTER);
        player2PleaseLookAway.setFont(new Font("Bang", Font.BOLD, 48));
        
        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        
        frame.add(player2PleaseLookAway);
        frame.add(next);
    }
    
    public JFrame getFrame() {
        return frame;
    }
}