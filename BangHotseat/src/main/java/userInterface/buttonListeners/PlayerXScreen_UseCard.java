/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import userInterface.VisibleScreen;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * 
 * @author Antti Korpi
 * 
 * Luokka on ActionListener, jolla varustettu nappula
 * kayttaa pelaajaan kasikorttien luettelosta valittua
 * korttia. Kayttotapa vaihtelee kortin mukaan.
 */
public class PlayerXScreen_UseCard implements ActionListener {

    private JFrame frame;
    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
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

            } else if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnReachPlayerToFollow() == false) {

                frame.getContentPane().removeAll();

                visibleScreen.enemyIsOutOfReach();

            } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
                }

            } else {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangPlayerPleaseLookAway();
                }
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Gatling")) {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
                }

            } else {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.bangPlayerPleaseLookAway();
                }
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Panico!")) {

            if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnTouchPlayerToFollow() == false) {

                frame.getContentPane().removeAll();

                visibleScreen.enemyIsOutOfReach();

            } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty() && visibleScreen.getSetup().getRound().getPlayerToFollow().getFrontCards().isEmpty()) {

                frame.getContentPane().removeAll();

                visibleScreen.playerToFollowHasNoCardsSoPanicoOrCatBalouCannotBePlayed(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()));
            } else {

                frame.getContentPane().removeAll();

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.panicoScreen();
            }
        } else {
            frame.getContentPane().removeAll();

            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

            visibleScreen.playerXScreen();
        }
        frame.revalidate();
        frame.repaint();
    }
}