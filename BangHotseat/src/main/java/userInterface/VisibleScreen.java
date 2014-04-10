/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import bang.banghotseat.Setup;
import bang.banghotseat.cards.Card;
import bang.banghotseat.essentials.Player;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import userInterface.buttonListeners.*;

/**
 *
 * @author Antti Korpi
 *
 * Luokka luo kayttoliittymaan kulloinkin tarvittavat komponentit, jotta
 * pelaajat tietavat mita on tapahtunut ja voivat ohjata pelia eteenpain.
 */
public class VisibleScreen {

    private List<JRadioButton> cardList;
    private JFrame frame;
    private Container container;
    private Setup setup;
    private ActionListener mainMenu_NewGame;
    private ActionListener mainMenu_Rules;
    private ActionListener mainMenu_Exit;
    private ActionListener backToMainMenu;
    private ActionListener exit_ReallyExit;
    private ActionListener newGame_Continue;
    private ActionListener continueToNewRound;
    private ActionListener prigione_ToNextPlayer;
    private ActionListener jesseJonesDrawsFromDrawpile;
    private ActionListener jesseJonesDrawsFromEnemyHand;
    private ActionListener toJourdonnaisScreen;
    private ActionListener toKitCarlsonScreen;
    private ActionListener kitCarlsonPutCardBack;
    private ActionListener playerXScreen_UseCard;
    private ActionListener continueToPlayerXScreen;
    private ActionListener playerXScreen_EndTurn;
    private ActionListener discardCards_Discard;
    private ActionListener pleaseLookAwayToPlayerXScreen;
    private ActionListener toMancatoChoice;
    private ActionListener toYouHaveNoMancato;
    private ActionListener distractionReply;
    private ActionListener doYouWannaRespond_No;
    private ActionListener doYouWannaRespond_Yes;
    private ActionListener toBangAsAReplyChoice;
    private ActionListener panicoScreen_StealNow;
    private ActionListener catBalouScreen_RemoveNow;

    /**
     *
     * @param frame kayttoliityman raamit
     * @param setup peliin kaytettava alkuvalmistelija
     */
    public VisibleScreen(JFrame frame, Setup setup) {

        this.frame = frame;
        container = frame.getContentPane();
        this.setup = setup;
        cardList = new ArrayList<>();

        mainMenu_NewGame = new MainMenu_NewGame(this);
        mainMenu_Rules = new MainMenu_Rules(this);
        mainMenu_Exit = new MainMenu_Exit(this);
        backToMainMenu = new BackToMainMenu(this);
        exit_ReallyExit = new Exit_ReallyExit(this);
        newGame_Continue = new NewGame_Continue(this);
        continueToNewRound = new ContinueToNewRound(this);
        prigione_ToNextPlayer = new Prigione_ToNextPlayer(this);
        jesseJonesDrawsFromDrawpile = new JesseJonesDrawsFromDrawpile(this);
        jesseJonesDrawsFromEnemyHand = new JesseJonesDrawsFromEnemyHand(this);
        toJourdonnaisScreen = new ToJourdonnaisScreen(this);
        toKitCarlsonScreen = new ToKitCarlsonScreen(this);
        kitCarlsonPutCardBack = new KitCarlsonPutCardBack(this);
        continueToPlayerXScreen = new ContinueToPlayerXScreen(this);
        playerXScreen_UseCard = new PlayerXScreen_UseCard(this);
        playerXScreen_EndTurn = new PlayerXScreen_EndTurn(this);
        discardCards_Discard = new DiscardCards_Discard(this);
        pleaseLookAwayToPlayerXScreen = new PleaseLookAwayToPlayerXScreen(this);
        toMancatoChoice = new ToMancatoChoice(this);
        toYouHaveNoMancato = new ToYouHaveNoMancato(this);
        distractionReply = new DistractionReply(this);
        doYouWannaRespond_No = new DoYouWannaRespond_No(this);
        doYouWannaRespond_Yes = new DoYouWannaRespond_Yes(this);
        toBangAsAReplyChoice = new ToBangAsAReplyChoice(this);
        panicoScreen_StealNow = new PanicoScreen_StealNow(this);
        catBalouScreen_RemoveNow = new CatBalouScreen_RemoveNow(this);
    }

    /**
     *
     * Asettaa paavalikkonakyman.
     */
    public void MainMenu() {

        GridLayout layout = new GridLayout(4, 3);
        container.setLayout(layout);

        JLabel welcome = new JLabel("Welcome to BANG!", JLabel.CENTER);
        welcome.setFont(new Font("Bang", Font.BOLD, 48));

        JButton newGame = new JButton("New Game");
        newGame.setFont(new Font("Button", Font.ITALIC, 40));
        newGame.addActionListener(mainMenu_NewGame);

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("Button", Font.ITALIC, 40));
        rules.addActionListener(mainMenu_Rules);

        JButton exit = new JButton("Exit");
        exit.setFont(new Font("Button", Font.ITALIC, 40));
        exit.addActionListener(mainMenu_Exit);

        container.add(new JLabel());
        container.add(welcome);
        container.add(new JLabel());

        container.add(new JLabel());
        container.add(newGame);
        container.add(new JLabel());

        container.add(new JLabel());
        container.add(rules);
        container.add(new JLabel());

        container.add(new JLabel());
        container.add(exit);
    }

    /**
     *
     * Asettaa saantonakyman.
     */
    public void rules() {

        JLabel rules = new JLabel("Rules: KILL THE OTHER PLAYER!", JLabel.CENTER);
        rules.setFont(new Font("Rules", Font.BOLD, 48));

        JButton goBackToMainMenu = new JButton("Back to Main Menu");
        goBackToMainMenu.setFont(new Font("Button", Font.ITALIC, 34));
        goBackToMainMenu.addActionListener(backToMainMenu);

        container.add(rules);
        container.add(goBackToMainMenu);
    }

    /**
     *
     * Asettaa poistumisnakyman.
     */
    public void exit() {

        JLabel exit = new JLabel("You really wanna exit BANG!?", JLabel.CENTER);
        exit.setFont(new Font("Bang", Font.BOLD, 48));

        JButton reallyExit = new JButton("Yes");
        reallyExit.setFont(new Font("Button", Font.ITALIC, 34));
        reallyExit.addActionListener(exit_ReallyExit);

        JButton goBackToMainMenu = new JButton("No");
        goBackToMainMenu.setFont(new Font("Button", Font.ITALIC, 34));
        goBackToMainMenu.addActionListener(backToMainMenu);

        container.add(exit);
        container.add(reallyExit);
        container.add(goBackToMainMenu);
    }

    /**
     *
     * Asettaa nakyman pelaajien erikoiskyvyista.
     */
    public void newGameInfo() {

        GridLayout layout = new GridLayout(5, 4);
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
        next.addActionListener(newGame_Continue);

        container.add(player1Avatar);
        container.add(player1Speciality);
        container.add(player2Avatar);
        container.add(player2Speciality);
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka pyytaa toista pelaajaa katsomaan pois ja jatkaa
     * uudelle kierrokselle.
     *
     * @param playerWhoShouldLookAway pelaaja, joka luovuttaa vuoronsa
     */
    public void playerXPleaseLookAwayScreen(Player playerWhoShouldLookAway) {

        container.setLayout(new GridLayout(3, 3));

        JLabel playerXPleaseLookAway = new JLabel(playerWhoShouldLookAway.getAvatar().toString() + ", please look away now", JLabel.CENTER);
        playerXPleaseLookAway.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToNewRound);

        container.add(playerXPleaseLookAway);
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka pyytaa askeista pelaajaa katsomaan muualle, jotta
     * toinen pelaaja voi jatkaa.
     *
     */
    public void pleaseLookAway() {

        container.setLayout(new GridLayout(3, 3));

        JLabel playerXPleaseLookAway = new JLabel("Please look away now, it's the other player's turn", JLabel.CENTER);
        playerXPleaseLookAway.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        next.addActionListener(continueToPlayerXScreen);

        container.add(playerXPleaseLookAway);
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka pyytaa hyokannytta pelaajaa katsomaan pois, jotta
     * toinen pelaaja voi reagoida.
     */
    public void attackingPlayerPleaseLookAway() {

        container.setLayout(new GridLayout(3, 3));

        JLabel playerXPleaseLookAway = new JLabel("Please look away now, the other player may reply", JLabel.CENTER);
        playerXPleaseLookAway.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") || setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Gatling")) {
            if (setup.getRound().getCheckerForPlayedCard().playerToFollowHasMancato()) {
                next.addActionListener(toMancatoChoice);
            } else {
                next.addActionListener(distractionReply);
            }
        } else if (setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Indiani!")) {
            if (setup.getRound().getCheckerForPlayedCard().playerToFollowHasBang()) {
                next.addActionListener(toBangAsAReplyChoice);
            } else {
                next.addActionListener(distractionReply);
            }
        }
        container.add(playerXPleaseLookAway);
        container.add(next);
    }

    /**
     *
     * Asettaa vankilakortin infonakyman.
     */
    public void prigioneScreen() {

        JLabel thereIsAPrigione = new JLabel("You are in prigione...", JLabel.CENTER);
        thereIsAPrigione.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel prigioneHeld = new JLabel("Prigione is secure!!! You lost your turn!!!", JLabel.CENTER);
        prigioneHeld.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel prigioneFailed = new JLabel("You broke out!!!", JLabel.CENTER);
        prigioneFailed.setFont(new Font("Bang", Font.BOLD, 48));


        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {

            container.setLayout(new GridLayout(6, 3));
            container.add(thereIsAPrigione);

            JLabel drawnCard1 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString(), JLabel.CENTER);
            drawnCard1.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard1);

            JLabel and = new JLabel("and", JLabel.CENTER);
            and.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(and);

            JLabel drawnCard2 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 1).toString(), JLabel.CENTER);
            drawnCard2.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard2);

            if (!setup.getRound().getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts()) {

                container.add(prigioneHeld);

                next.addActionListener(prigione_ToNextPlayer);

            } else {
                container.add(prigioneFailed);
                next.addActionListener(continueToPlayerXScreen);
            }
            container.add(next);
        } else {

            container.setLayout(new GridLayout(4, 3));
            container.add(thereIsAPrigione);

            JLabel drawnCard = new JLabel(setup.getRound().getPlayerToFollow().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
            drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard);

            if (!setup.getRound().getPlayerToFollow().getLastCheckedCard().getSuit().equals("Hearts")) {
                container.add(prigioneHeld);
                next.addActionListener(prigione_ToNextPlayer);
            } else {
                container.add(prigioneFailed);

                next.addActionListener(continueToNewRound);
            }
            container.add(next);
        }
    }

    /**
     *
     * Asettaa dynamiitin infonakyman.
     */
    public void dinamiteScreen() {

        JLabel thereIsADinamite = new JLabel("The dinamite is hissing...", JLabel.CENTER);
        thereIsADinamite.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel dinamiteExploded = new JLabel("The dinamite exploded!!! You lost 3 health points!!!", JLabel.CENTER);
        dinamiteExploded.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel dinamiteWasPassedOn = new JLabel("The dinamite didn't explode and was passed on", JLabel.CENTER);
        dinamiteWasPassedOn.setFont(new Font("Bang", Font.BOLD, 48));


        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {

            container.setLayout(new GridLayout(6, 3));
            container.add(thereIsADinamite);

            JLabel drawnCard1 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString(), JLabel.CENTER);
            drawnCard1.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard1);

            JLabel and = new JLabel("and", JLabel.CENTER);
            and.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(and);

            JLabel drawnCard2 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 1).toString(), JLabel.CENTER);
            drawnCard2.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard2);

            if (setup.getRound().getCheckerForAvatarSpeciality().checkIfDinamiteExplodesOnLuckyDuke()) {

                container.add(dinamiteExploded);

                next.addActionListener(continueToPlayerXScreen);

            } else {
                container.add(dinamiteWasPassedOn);
                next.addActionListener(continueToPlayerXScreen);
            }
            container.add(next);
        } else {

            container.setLayout(new GridLayout(4, 3));
            container.add(thereIsADinamite);

            JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
            drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard);

            if (setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Spades") && setup.getRound().getPlayerInTurn().getLastCheckedCard().getNumber() > 1 && setup.getRound().getPlayerInTurn().getLastCheckedCard().getNumber() < 10) {
                container.add(dinamiteExploded);
            } else {
                container.add(dinamiteWasPassedOn);
            }
            if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Kit Carlson")) {
                next.addActionListener(toKitCarlsonScreen);
            } else {
                next.addActionListener(continueToPlayerXScreen);
            }
            container.add(next);
        }
    }

    /**
     *
     * Asettaa Jourdonnaisin vaistonakyman.
     */
    public void jourdonnaisScreen() {

        container.setLayout(new GridLayout(4, 3));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        JLabel enemyIsJourdonnais = new JLabel("Enemy is Jourdonnais", JLabel.CENTER);
        enemyIsJourdonnais.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(enemyIsJourdonnais);

        JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
        drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(drawnCard);

        if (setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {

            JLabel jourdonnaisWorked = new JLabel("The shot missed!", JLabel.CENTER);
            jourdonnaisWorked.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(jourdonnaisWorked);

            next.setFont(new Font("Button", Font.ITALIC, 34));
            next.addActionListener(continueToPlayerXScreen);

        } else {

            JLabel jourdonnaisDidNotWork = new JLabel("Jourdonnais couldn't evade the shot!", JLabel.CENTER);
            jourdonnaisDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(jourdonnaisDidNotWork);

            next.setFont(new Font("Button", Font.ITALIC, 34));

            if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                next.addActionListener(toYouHaveNoMancato);
            } else if (setup.getRound().getCheckerForPlayedCard().playerToFollowHasMancato()) {
                next.addActionListener(toMancatoChoice);
            } else {
                next.addActionListener(distractionReply);
            }
        }
        container.add(next);
    }

    /**
     *
     * Asettaa Barrelin vaistonakyman.
     */
    public void barrelScreen() {

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Lucky Duke")) {

            container.setLayout(new GridLayout(6, 3));
            JLabel thereIsABarrel = new JLabel("The enemy has a barrel and he is Lucky Duke", JLabel.CENTER);
            thereIsABarrel.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(thereIsABarrel);

            JLabel drawnCard1 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString(), JLabel.CENTER);
            drawnCard1.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard1);

            JLabel and = new JLabel("and", JLabel.CENTER);
            and.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(and);

            JLabel drawnCard2 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 1).toString(), JLabel.CENTER);
            drawnCard2.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard2);

            if (setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).getSuit().equals("Hearts") || setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 1).getSuit().equals("Hearts")) {

                JLabel barrelWorked = new JLabel("The shot missed!", JLabel.CENTER);
                barrelWorked.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(barrelWorked);

                next.addActionListener(continueToPlayerXScreen);

            } else {

                JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(barrelDidNotWork);

                if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                    next.addActionListener(toYouHaveNoMancato);
                } else if (setup.getRound().getCheckerForPlayedCard().playerToFollowHasMancato()) {
                    next.addActionListener(toMancatoChoice);
                } else {
                    next.addActionListener(distractionReply);
                }
            }
        } else {
            container.setLayout(new GridLayout(4, 3));

            JLabel thereIsABarrel = new JLabel("The enemy has a barrel", JLabel.CENTER);
            thereIsABarrel.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(thereIsABarrel);

            JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
            drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard);

            if (setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {

                JLabel barrelWorked = new JLabel("The shot missed!", JLabel.CENTER);
                barrelWorked.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(barrelWorked);

                next.setFont(new Font("Button", Font.ITALIC, 34));
                next.addActionListener(continueToPlayerXScreen);

            } else {

                JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(barrelDidNotWork);

                if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Jourdonnais")) {
                    next.addActionListener(toJourdonnaisScreen);

                } else if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                    next.addActionListener(toYouHaveNoMancato);

                } else if (setup.getRound().getCheckerForPlayedCard().playerToFollowHasMancato()) {
                    next.addActionListener(toMancatoChoice);

                } else {
                    next.addActionListener(distractionReply);
                }
            }
        }
        container.add(next);
    }

    /**
     *
     * Asettaa Panico!-kortin valintanakyman.
     */
    public void panicoScreen() {

        JLabel wichCardWillYouSteal = new JLabel("Wich card will you take?", JLabel.CENTER);
        wichCardWillYouSteal.setFont(new Font("Bang", Font.BOLD, 48));

        ButtonGroup panicoChoice = new ButtonGroup();
        cardList.clear();

        for (int i = 0; i < setup.getRound().getPlayerToFollow().getFrontCards().size(); i++) {
            cardList.add(new JRadioButton(setup.getRound().getPlayerToFollow().getFrontCards().get(i).toString()));
        }
        if (!setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
            cardList.add(new JRadioButton("Random hand card (other player has " + setup.getRound().getPlayerToFollow().getHandCards().size() + ")"));
        }
        for (JRadioButton toBeAdded : cardList) {
            panicoChoice.add(toBeAdded);
            container.add(toBeAdded);
        }
        JButton steal = new JButton("Steal now!");
        steal.addActionListener(panicoScreen_StealNow);
        container.add(steal);
    }

    /**
     *
     * Asettaa varastetun kortin infonakyman.
     */
    public void randomHandCardWasStolen() {

        container.setLayout(new GridLayout(3, 3));

        JLabel stolenCard = new JLabel("You stole " + setup.getRound().getPlayerInTurn().getLastCheckedCard().toString(), JLabel.CENTER);
        stolenCard.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(stolenCard);
        container.add(next);
    }

    /**
     *
     * Asettaa Cat Balou -kortin valintanakyman.
     */
    public void catBalouScreen() {

        JLabel wichCardWillYouRemove = new JLabel("Wich card will you remove?", JLabel.CENTER);
        wichCardWillYouRemove.setFont(new Font("Bang", Font.BOLD, 48));

        ButtonGroup catBalouChoice = new ButtonGroup();
        cardList.clear();

        for (int i = 0; i < setup.getRound().getPlayerToFollow().getFrontCards().size(); i++) {
            cardList.add(new JRadioButton(setup.getRound().getPlayerToFollow().getFrontCards().get(i).toString()));
        }
        if (!setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
            cardList.add(new JRadioButton("Random hand card (other player has " + setup.getRound().getPlayerToFollow().getHandCards().size() + ")"));
        }
        for (JRadioButton toBeAdded : cardList) {
            catBalouChoice.add(toBeAdded);
            container.add(toBeAdded);
        }
        JButton remove = new JButton("Remove now!");
        remove.addActionListener(catBalouScreen_RemoveNow);
        container.add(remove);
    }

    /**
     *
     * Asettaa poistetun kortin infonakyman.
     */
    public void catBalouRemovedRandomHandCard() {

        container.setLayout(new GridLayout(3, 3));

        JLabel removedCard = new JLabel("You removed " + setup.getRound().getPlayerInTurn().getLastCheckedCard().toString(), JLabel.CENTER);
        removedCard.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(removedCard);
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka kertoo ettei vastustajalla ole kasikortteja joten
     * niita ei voi vieda.
     *
     * @param panicoOrCatBalou kortti, joka yritettiin pelata
     */
    public void playerToFollowHasNoCardsSoPanicoOrCatBalouCannotBePlayed(Card panicoOrCatBalou) {

        container.setLayout(new GridLayout(3, 3));

        JLabel enemyHasNoCards = new JLabel("The other player has no cards,", JLabel.CENTER);
        enemyHasNoCards.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel youCannotPlayThisCard = new JLabel("you cannot play " + panicoOrCatBalou.getName(), JLabel.CENTER);
        youCannotPlayThisCard.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(enemyHasNoCards);
        container.add(youCannotPlayThisCard);
        container.add(next);
    }

    /**
     *
     * Jesse Jonesin kortinnoston valintanakyma.
     */
    public void jesseJonesDrawScreen() {

        container.setLayout(new GridLayout(4, 3));

        if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {

            JLabel enemyHasNoHandCards = new JLabel("Enemy has no hand cards,", JLabel.CENTER);
            enemyHasNoHandCards.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(enemyHasNoHandCards);

            JLabel youCannotUseSpeciality = new JLabel("you cannot use your speciality!", JLabel.CENTER);
            youCannotUseSpeciality.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(youCannotUseSpeciality);

            JButton next = new JButton("Continue");
            next.setFont(new Font("Button", Font.ITALIC, 34));
            next.addActionListener(continueToPlayerXScreen);
        } else {
            JLabel wannaDrawFromEnemyHand = new JLabel("Do you want to draw your first card from enemy's hand?", JLabel.CENTER);
            wannaDrawFromEnemyHand.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(wannaDrawFromEnemyHand);

            JLabel enemyHandCards = new JLabel("Enemy has " + setup.getRound().getPlayerToFollow().getHandCards().size() + " hand cards", JLabel.CENTER);
            enemyHandCards.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(enemyHandCards);

            JButton drawFromEnemyHand = new JButton("Draw from enemy's hand");
            drawFromEnemyHand.setFont(new Font("Button", Font.ITALIC, 34));
            drawFromEnemyHand.addActionListener(jesseJonesDrawsFromEnemyHand);
            container.add(drawFromEnemyHand);


            JButton drawFromDrawpile = new JButton("Draw from drawpile");
            drawFromDrawpile.setFont(new Font("Button", Font.ITALIC, 34));
            drawFromDrawpile.addActionListener(jesseJonesDrawsFromDrawpile);
            container.add(drawFromDrawpile);
        }
    }

    /**
     *
     * Kit Carlsonin kortinnoston valintanakyma.
     */
    public void kitCarlsonDrawScreen() {

        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);

        container.add(new JLabel("Wich of these card will you put back to the top of the drawpile?"));

        ButtonGroup choises = new ButtonGroup();
        cardList.clear();

        for (int i = 0; i < 3; i++) {
            setup.getRound().getPlayerInTurn().putCardIntoHand(setup.getRound().getDrawpile().take(setup.getRound().getDiscardpile()));
            cardList.add(new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(setup.getRound().getPlayerInTurn().getHandCards().size() - 1).toString()));
        }
        for (JRadioButton toBeAdded : cardList) {
            choises.add(toBeAdded);
            container.add(toBeAdded);
        }
        JButton putCardBack = new JButton("Put card back");
        putCardBack.addActionListener(kitCarlsonPutCardBack);
        container.add(putCardBack);
    }

    /**
     *
     * Pelaajan vuoronakyma.
     */
    public void playerXScreen() {

        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);

        String enemyInfo = "<html>Enemy: " + setup.getRound().getPlayerToFollow().getAvatar().toString()
                + "<br>" + setup.getRound().getPlayerToFollow().getAvatar().getSpeciality()
                + "<br>"
                + "<br>Enemy health: " + setup.getRound().getPlayerToFollow().getCurrentHealth()
                + "<br>" + "<br></html>";

        String enemyFrontCards = "<html><br>Enemy front cards:";
        for (Card toBeShown : setup.getRound().getPlayerToFollow().getFrontCards()) {
            enemyFrontCards = enemyFrontCards + "<br>" + toBeShown.toString();
        }
        enemyFrontCards = enemyFrontCards + "</html>";

        container.add(new JLabel(enemyInfo));
        container.add(new JLabel("Enemy has " + setup.getRound().getPlayerToFollow().getHandCards().size() + " hand cards"));
        container.add(new JLabel(enemyFrontCards));

        String playerInfo = "<html><br>You: " + setup.getRound().getPlayerInTurn().getAvatar().toString()
                + "<br>" + setup.getRound().getPlayerInTurn().getAvatar().getSpeciality()
                + "<br>"
                + "<br>Your health: " + setup.getRound().getPlayerInTurn().getCurrentHealth()
                + "<br>" + "<br></html>";

        container.add(new JLabel(playerInfo));

        String playerFrontCards = "<html>Your front cards:";
        for (Card toBeShown : setup.getRound().getPlayerInTurn().getFrontCards()) {
            playerFrontCards = playerFrontCards + "<br>" + toBeShown.toString();
        }
        playerFrontCards = playerFrontCards + "<br>" + "<br></html>";
        container.add(new JLabel(playerFrontCards));

        container.add(new JLabel("Your hand cards:"));

        ButtonGroup playerHandCards = new ButtonGroup();
        cardList.clear();

        for (int i = 0; i < setup.getRound().getPlayerInTurn().getHandCards().size(); i++) {
            cardList.add(new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(i).toString()));
        }
        for (JRadioButton toBeAdded : cardList) {
            playerHandCards.add(toBeAdded);
            container.add(toBeAdded);
        }
        JButton useCard = new JButton("Use card");
        useCard.addActionListener(playerXScreen_UseCard);
        container.add(useCard);

        JButton endTurn = new JButton("End turn");
        endTurn.addActionListener(playerXScreen_EndTurn);
        container.add(endTurn);
    }

    /**
     *
     * Nakyma, joka kertoo vastustajan olevan kantaman ulkopuolella.
     */
    public void enemyIsOutOfReach() {

        container.setLayout(new GridLayout(3, 3));

        JLabel enemyIsOutOfReach = new JLabel("The other player is too far away!", JLabel.CENTER);
        enemyIsOutOfReach.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(enemyIsOutOfReach);
        container.add(next);
    }

    /**
     *
     * Nakyma, joka kertoo ettei BANG!-kortteja voi pelata enaa talla
     * kierroksella.
     */
    public void moreBangCardsCannotBePlayed() {

        container.setLayout(new GridLayout(3, 3));

        JLabel moreBangCardsCannotBePlayed = new JLabel("More BANG! cards cannot be played!", JLabel.CENTER);
        moreBangCardsCannotBePlayed.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(moreBangCardsCannotBePlayed);
        container.add(next);
    }

    /**
     *
     * Nakyma, joka kertoo reagoijalle ettei han voi reagoida mutta salaa sen
     * hyokkaajalta.
     */
    public void clickToPretendYouCouldReply() {

        container.setLayout(new GridLayout(3, 3));

        JLabel youHaveNoMancato = new JLabel("You have no cards to reply with and will lose health!", JLabel.CENTER);
        youHaveNoMancato.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel clickToDistract = new JLabel("Click so it looks like you could have replied!", JLabel.CENTER);
        clickToDistract.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(pleaseLookAwayToPlayerXScreen);

        container.add(youHaveNoMancato);
        container.add(clickToDistract);
        container.add(next);
    }

    /**
     *
     * Vaistokortin kayton valintaikkuna.
     */
    public void doYouWannaPlayMancato() {

        container.setLayout(new GridLayout(4, 3));

        JLabel willYouUseAMancato = new JLabel("Will you use a Mancato! to cancel a hit?", JLabel.CENTER);
        willYouUseAMancato.setFont(new Font("Bang", Font.BOLD, 48));

        JButton useMancato = new JButton("Yes");
        useMancato.setFont(new Font("Button", Font.ITALIC, 34));
        useMancato.addActionListener(doYouWannaRespond_Yes);

        JButton doNotUseMancato = new JButton("No");
        doNotUseMancato.setFont(new Font("Button", Font.ITALIC, 34));
        doNotUseMancato.addActionListener(doYouWannaRespond_No);

        container.add(willYouUseAMancato);
        container.add(useMancato);
        container.add(doNotUseMancato);
    }

    /**
     *
     * BANG!-kortilla reagoimisen valintaikkuna.
     */
    public void doYouWannaReplyWithBang() {

        JLabel willYouUseABang = new JLabel("Will you use a Bang! to cancel a hit?", JLabel.CENTER);
        willYouUseABang.setFont(new Font("Bang", Font.BOLD, 48));

        JButton useBang = new JButton("Yes");
        useBang.setFont(new Font("Button", Font.ITALIC, 34));
        useBang.addActionListener(doYouWannaRespond_Yes);

        JButton doNotUseBang = new JButton("No");
        doNotUseBang.setFont(new Font("Button", Font.ITALIC, 34));
        doNotUseBang.addActionListener(doYouWannaRespond_No);

        container.add(willYouUseABang);
        container.add(useBang);
        container.add(doNotUseBang);
    }

    /**
     *
     * Nakyma, joka kertoo ettei vastustaja voi reagoida, koska hanella ei ole
     * kasikortteja.
     */
    public void takingDamageAndNoHandCards() {

        container.setLayout(new GridLayout(3, 3));

        JLabel enemyHasNoHandCards = new JLabel("The other player has no hand cards,", JLabel.CENTER);
        enemyHasNoHandCards.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel enemyCannotReply = new JLabel("the damage cannot be avoided!", JLabel.CENTER);
        enemyCannotReply.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(enemyHasNoHandCards);
        container.add(enemyCannotReply);
        container.add(next);
    }

    /**
     *
     * Korttien poiston valintanakyma.
     */
    public void discardCards() {

        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);

        frame.add(new JLabel("You may only hold in your hand as many cards as you have health left"));
        frame.add(new JLabel("Choose a card to discard"));

        cardList = new ArrayList<>();
        ButtonGroup cardsToBeDiscarded = new ButtonGroup();

        for (int i = 0; i < setup.getRound().getPlayerInTurn().getHandCards().size(); i++) {
            cardList.add(new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(i).toString()));
        }
        for (JRadioButton toBeDiscarded : cardList) {
            container.add(toBeDiscarded);
            cardsToBeDiscarded.add(toBeDiscarded);
        }
        JButton discardCards = new JButton("Discard");
        discardCards.addActionListener(discardCards_Discard);
        container.add(discardCards);
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
     * @return peliin kaytetty esivalmistelija
     */
    public Setup getSetup() {
        return setup;
    }

    /**
     *
     * Palauttaa valikosta valitun kortin indeksin ja -1 jos mitaan ei ole
     * valittu.
     *
     * @return listasta valitun kortin indeksi tai merkki, etta mitaan ei ole
     * valittu
     */
    public int getIndex() {
        for (JRadioButton isThisSelected : cardList) {
            if (isThisSelected.isSelected()) {
                return cardList.indexOf(isThisSelected);
            }
        }
        return -1;
    }

    /**
     *
     * Palauttaa valikosta valitun kortin indeksin, -1 jos mitaan ei ole valittu
     * ja -2 jos listan viimeinen on valittu.
     *
     * @return listasta valitun kortin indeksi tai -1 jos mitaan ei ole valittu
     * ja -2 jos viimeinen kortti on valittu.
     */
    public int getPanicoOrCatBalouIndex() {
        for (JRadioButton isThisSelected : cardList) {
            if (isThisSelected.isSelected() && cardList.indexOf(isThisSelected) == cardList.size() - 1) {
                return -2;
            } else if (isThisSelected.isSelected()) {
                return cardList.indexOf(isThisSelected);
            }
        }
        return -1;
    }
}