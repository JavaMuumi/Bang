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
            checkForProblemsInUsingBang();

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Gatling")) {

            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                usingGatlingAgainstEnemyWithNoHandCards();

            } else {
                usingGatling();
            }

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Indiani!")) {

            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                usingIndianiOrDuelloAgainstEnemyWithNoHandCards();

            } else {
                usingIndiani();
            }

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Duello")) {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                usingIndianiOrDuelloAgainstEnemyWithNoHandCards();

            } else {
                usingDuello();
            }

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Panico!")) {
            usingPanico();

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().contains("Cat Balou")) {
            usingCatBalou();

        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().get(visibleScreen.getIndex()).getName().equals("Emporio")) {
            usingEmporio();

        } else {
            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
            visibleScreen.playerXScreen();
        }
        frame.revalidate();
        frame.repaint();
    }

    /**
     *
     * Tarkastaa onko BANG!-kortin kayttamiselle estetta ja asettaa sen mukaan
     * oikean nakyman.
     */
    public void checkForProblemsInUsingBang() {

        if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().bangCanBePlayed() == false) {
            visibleScreen.moreBangCardsCannotBePlayed();

        } else if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnReachPlayerToFollow() == false) {
            visibleScreen.enemyIsOutOfReach();

        } else {
            if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                usingBangAgainstEnemyWithNoHandCards();
            } else {
                usingBang();
            }
        }
    }

    /**
     *
     * Pelaa valitun BANG!-kortin tai Calamity Janetin sita vastaavan
     * Mancato!-kortin pelaajaa vastaan, jolla ei ole tarpeeksi vaistokortteja
     * valtaakseen osuman.
     */
    public void usingBangAgainstEnemyWithNoHandCards() {

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
    }

    /**
     *
     * Pelaa valitun BANG!-kortin tai Calamity Janetin sita vastaavan
     * Mancato!-kortin.
     */
    public void usingBang() {

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

    /**
     *
     * Pelaa valitun Gatling-kortin pelaajaa vastaan, jolla ei ole yhtakaan
     * vaistokorttia.
     */
    public void usingGatlingAgainstEnemyWithNoHandCards() {

        visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

        if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().checkBarrel()) {
            visibleScreen.barrelScreen();
        } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
            visibleScreen.jourdonnaisScreen();
        } else {
            visibleScreen.takingDamageAndNoHandCards();
            visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1, visibleScreen.getSetup().getRound());
        }
    }

    /**
     *
     * Pelaa valitun Gatling-kortin.
     */
    public void usingGatling() {

        visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

        if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().checkBarrel()) {
            visibleScreen.barrelScreen();
        } else if (visibleScreen.getSetup().getRound().getCheckerForAvatarSpeciality().checkJourdonnais()) {
            visibleScreen.jourdonnaisScreen();
        } else {
            visibleScreen.attackingPlayerPleaseLookAway();
        }
    }

    /**
     *
     * Pelaa valitun Indiani!-kortin pelaajaa vastaan, jolla ei ole yhtakaan
     * vaistokorttia.
     */
    public void usingIndianiOrDuelloAgainstEnemyWithNoHandCards() {

        visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());

        visibleScreen.takingDamageAndNoHandCards();
        visibleScreen.getSetup().getRound().getPlayerToFollow().loseHealth(1, visibleScreen.getSetup().getRound());

    }

    /**
     *
     * Pelaa valitun Indiani!-kortin.
     */
    public void usingIndiani() {
        visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
        visibleScreen.attackingPlayerPleaseLookAway();
    }

    /**
     *
     * Pelaa valitun Duello-kortin.
     */
    public void usingDuello() {
        visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
        visibleScreen.duelloToOtherPlayerScreen();
    }

    /**
     *
     * Pelaa valitun Panico!-kortin.
     */
    public void usingPanico() {

        if (visibleScreen.getSetup().getRound().getCheckerForPlayedCard().canPlayerInTurnTouchPlayerToFollow() == false) {
            visibleScreen.enemyIsOutOfReach();

        } else if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty() && visibleScreen.getSetup().getRound().getPlayerToFollow().getFrontCards().isEmpty()) {
            visibleScreen.targetedPlayerHasNoCardsSoTheyCannotBeTaken();

        } else {
            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
            visibleScreen.panicoScreen();
        }
    }

    /**
     *
     * Pelaa valitun Cat Balou -kortin
     */
    public void usingCatBalou() {
        if (visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().isEmpty() && visibleScreen.getSetup().getRound().getPlayerToFollow().getFrontCards().isEmpty()) {
            visibleScreen.targetedPlayerHasNoCardsSoTheyCannotBeTaken();
        } else {
            visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
            visibleScreen.catBalouScreen();
        }
    }

    /**
     *
     * Pelaa valitun Emporio-kortin
     */
    public void usingEmporio() {
        visibleScreen.getSetup().getRound().getCheckerForPlayedCard().playingCard(visibleScreen.getIndex());
        visibleScreen.emporioScreen();
    }
}