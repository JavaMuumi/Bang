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

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("BANG!") || (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Calamity Janet") && visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Mancato!"))) {

            if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().bangCanBePlayed() == false) {
                visibleScreen.moreBangCardsCannotBePlayed();

            } else if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnReachPlayerToFollow() == false) {
                visibleScreen.enemyIsOutOfReach();

            } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().checkBarrel()) {

                    if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer")) {
                        if (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Lucky Duke") && visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts()) {
                        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {
                            visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais();
                        }
                    } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
                    }
                    visibleScreen.barrelScreen();

                } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
                    visibleScreen.jourdonnaisScreen();

                } else {
                    visibleScreen.takingDamageAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1, visibleScreen.getSetup().getRound());
                }
            } else {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().checkBarrel()) {

                    if (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer")) {
                        if (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Lucky Duke") && visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkTwoTopCardsForLuckyDukeForHearts()) {
                        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {
                            visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais();

                        } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
                        }
                    }
                    visibleScreen.barrelScreen();
                } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
                    visibleScreen.jourdonnaisScreen();
                } else {
                    visibleScreen.attackingPlayerPleaseLookAway();
                }
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Gatling")) {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().checkBarrel()) {
                    visibleScreen.barrelScreen();
                } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
                    visibleScreen.jourdonnaisScreen();
                } else {
                    visibleScreen.takingDamageAndNoHandCards();
                    visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1, visibleScreen.getSetup().getRound());
                }

            } else {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().checkBarrel()) {
                    visibleScreen.barrelScreen();
                } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
                    visibleScreen.jourdonnaisScreen();
                } else {
                    visibleScreen.attackingPlayerPleaseLookAway();
                }
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Indiani!")) {

            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.takingDamageAndNoHandCards();
                visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1, visibleScreen.getSetup().getRound());

            } else {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
                visibleScreen.attackingPlayerPleaseLookAway();
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Duello")) {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {

                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

                visibleScreen.takingDamageAndNoHandCards();
                visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1, visibleScreen.getSetup().getRound());

            } else {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
                visibleScreen.duelloToOtherPlayerScreen();
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Panico!")) {
            if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnTouchPlayerToFollow() == false) {
                visibleScreen.enemyIsOutOfReach();

            } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty() && visibleScreen.getSetup().getRound().getPlayerToFollow().getFrontCards().isEmpty()) {
                visibleScreen.targetedPlayerHasNoCardsSoTheyCannotBeTaken();

            } else {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
                visibleScreen.panicoScreen();
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Cat Balou")) {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty() && visibleScreen.getSetup().getRound().getPlayerToFollow().getFrontCards().isEmpty()) {
                visibleScreen.targetedPlayerHasNoCardsSoTheyCannotBeTaken();

            } else {
                visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
                visibleScreen.catBalouScreen();
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().equals("Emporio")) {
            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
            visibleScreen.emporioScreen();

        } else {
            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
            visibleScreen.playerXScreen();
        }
        frame.revalidate();
        frame.repaint();

    }
}