/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import userInterface.VisibleScreen;

/**
 *
 * @author Antti Korpi
 *
 * Luokka on ActionListener, jolla varustettu nappula kayttaa pelaajaan
 * kasikorttien luettelosta valittua korttia. Kayttotapa vaihtelee kortin
 * mukaan.
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

        visibleScreen.getFrame().getContentPane().removeAll();

        if (visibleScreen.getIndex() == -1) {

            visibleScreen.playerXScreen();

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("BANG!")) {

            if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().bangCanBePlayed() == false) {

                visibleScreen.moreBangCardsCannotBePlayed();

            } else if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnReachPlayerToFollow() == false) {

                visibleScreen.enemyIsOutOfReach();

            } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.takingDamageAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
                }

            } else {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.attackingPlayerPleaseLookAway();
                }
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Gatling")) {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.takingDamageAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);
                }

            } else {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().thereIsABarrel()) {
                    visibleScreen.barrelScreen();
                } else {
                    visibleScreen.attackingPlayerPleaseLookAway();
                }
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Indiani!")) {

            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.takingDamageAndNoHandCards();
                visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1);

            } else {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.attackingPlayerPleaseLookAway();

            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Panico!")) {

            if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnTouchPlayerToFollow() == false) {

                visibleScreen.enemyIsOutOfReach();

            } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty() && visibleScreen.getSetup().getRound().getPlayerToFollow().getFrontCards().isEmpty()) {

                visibleScreen.playerToFollowHasNoCardsSoPanicoOrCatBalouCannotBePlayed(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()));
            } else {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.panicoScreen();
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Cat Balou")) {

            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty() && visibleScreen.getSetup().getRound().getPlayerToFollow().getFrontCards().isEmpty()) {

                visibleScreen.playerToFollowHasNoCardsSoPanicoOrCatBalouCannotBePlayed(visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()));
            } else {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.catBalouScreen();
            }
        } else {

            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

            visibleScreen.playerXScreen();
        }
        frame.revalidate();
        frame.repaint();
    }
}