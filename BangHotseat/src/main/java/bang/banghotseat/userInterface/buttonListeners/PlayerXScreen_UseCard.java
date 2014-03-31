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
public class PlayerXScreen_UseCard implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;

    public PlayerXScreen_UseCard(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
        frame = visibleScreen.getFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (visibleScreen.getIndex() == -1) {
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("BANG!")) {

            if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().bangCanBePlayed() == false) {

                frame.getContentPane().removeAll();

                visibleScreen.moreBangCardsCannotBePlayed();

                frame.revalidate();
                frame.repaint();
            } else if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnReachPlayerToFollow() == false) {

                frame.getContentPane().removeAll();

                visibleScreen.enemyIsOutOfReach();

                frame.revalidate();
                frame.repaint();

            } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsaBarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
                }
                frame.revalidate();
                frame.repaint();

            } else {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsaBarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangPlayerPleaseLookAway();
                }
                frame.revalidate();
                frame.repaint();
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Gatling")) {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsaBarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
                }
                frame.revalidate();
                frame.repaint();

            } else {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsaBarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangPlayerPleaseLookAway();
                }
                frame.revalidate();
                frame.repaint();
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Panico!")) {

            if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnTouchPlayerToFollow() == false) {

                frame.getContentPane().removeAll();

                visibleScreen.enemyIsOutOfReach();

                frame.revalidate();
                frame.repaint();
            } else {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.playerXScreen();

                frame.revalidate();
                frame.repaint();
            }
        } else {
            frame.getContentPane().removeAll();

            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

            visibleScreen.playerXScreen();

            frame.revalidate();
            frame.repaint();
        }
    }
}