/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.buttonListeners;

import bang.banghotseat.cards.Card;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import userInterface.VisibleScreen;

/**
 *
 * @author Antti Korpi
 *
 * Luokka on ActionListener, jolla varustettu nappula vie nakymaan, joka pyytaa
 * Duelloon vastannutta pelaajaa katsomaan pois.
 */
public class DuelloToOtherPlayer implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DuelloToOtherPlayer(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        int indexOfCardToBeDiscarded = 0;

        if (visibleScreen.getSetup().getRound().playerInTurnIsNextToReactToDuello()) {
            for (Card toBeDiscarded : visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards()) {
                if (toBeDiscarded.getName().contains("BANG!") || (visibleScreen.getSetup().getRound().getPlayerInTurn().getAvatar().toString().equals("Calamity Janet") && toBeDiscarded.getName().contains("Mancato!"))) {
                    indexOfCardToBeDiscarded = visibleScreen.getSetup().getRound().getPlayerInTurn().getHandCards().indexOf(toBeDiscarded);
                }
            }
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerInTurn().drawSpecificHandCard(indexOfCardToBeDiscarded, visibleScreen.getSetup().getRound()));

            visibleScreen.getSetup().getRound().setPlayerInTurnIsNextToReactToDuello(false);

        } else {
            for (Card toBeDiscarded : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                if (toBeDiscarded.getName().contains("BANG!") || (visibleScreen.getSetup().getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && toBeDiscarded.getName().contains("Mancato!"))) {
                    indexOfCardToBeDiscarded = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(toBeDiscarded);
                }
            }
            visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(indexOfCardToBeDiscarded, visibleScreen.getSetup().getRound()));

            visibleScreen.getSetup().getRound().setPlayerInTurnIsNextToReactToDuello(true);
        }
        visibleScreen.duelloToOtherPlayerScreen();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}