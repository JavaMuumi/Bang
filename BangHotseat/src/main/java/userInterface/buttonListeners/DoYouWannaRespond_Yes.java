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
 * Luokka on ActionListener, jolla varustettu nappula suostuu kauttamaan
 * vaistokortin, jolloin pelaaja ei meneta kestoja.
 */
public class DoYouWannaRespond_Yes implements ActionListener {

    private VisibleScreen visibleScreen;

    /**
     *
     * @param visibleScreen nakyman luova luokka
     */
    public DoYouWannaRespond_Yes(VisibleScreen visibleScreen) {
        this.visibleScreen = visibleScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        visibleScreen.getFrame().getContentPane().removeAll();

        int indexOfReplyCard = 0;

        if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") || visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Gatling!")) {
            for (Card thisIsAMancato : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                if (thisIsAMancato.getName().contains("Mancato!")) {
                    indexOfReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsAMancato);
                }
            }
        } else if (visibleScreen.getSetup().getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Indiani!")) {
            for (Card thisIsABang : visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards()) {
                if (thisIsABang.getName().contains("Mancato!")) {
                    indexOfReplyCard = visibleScreen.getSetup().getRound().getPlayerToFollow().getHandCards().indexOf(thisIsABang);
                }
            }
        }
        visibleScreen.getSetup().getRound().getDiscardpile().place(visibleScreen.getSetup().getRound().getPlayerToFollow().drawSpecificHandCard(indexOfReplyCard));

        visibleScreen.pleaseLookAway();

        visibleScreen.getFrame().revalidate();
        visibleScreen.getFrame().repaint();
    }
}
