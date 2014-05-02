/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import bang.banghotseat.Setup;
import bang.banghotseat.cards.Card;
import bang.banghotseat.essentials.Player;
import java.awt.BorderLayout;
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
public class VisibleScreen extends JFrame {

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
    private ActionListener toPrigioneScreen;
    private ActionListener prigione_ToNextPlayer;
    private ActionListener emporioPlayerChoseFirstCard;
    private ActionListener emporioPlayerChoseSecondCard;
    private ActionListener toBlackJackScren;
    private ActionListener toJesseJonesScreen;
    private ActionListener jesseJonesDrawsFromDrawpile;
    private ActionListener jesseJonesDrawsFromEnemyHand;
    private ActionListener pedroRamirezDrawsFromDiscardpile;
    private ActionListener toJourdonnaisScreen;
    private ActionListener toKitCarlsonScreen;
    private ActionListener kitCarlsonPutCardBack;
    private ActionListener toSidKetchumCardDiscard;
    private ActionListener sidKetchumDiscardClick;
    private ActionListener sidKetchumCancel;
    private ActionListener toPedroRamirezScreen;
    private ActionListener playerXScreen_UseCard;
    private ActionListener continueToPlayerXScreen;
    private ActionListener playerXScreen_EndTurn;
    private ActionListener discardCards_Discard;
    private ActionListener cancelCardDiscard;
    private ActionListener toAttackingPlayerPleaseLookAway;
    private ActionListener pleaseLookAwayToPlayerXScreen;
    private ActionListener toMancatoChoice;
    private ActionListener toYouDoNotHaveEnoughHandCardsAndCannotReply;
    private ActionListener distractionReply;
    private ActionListener doYouWannaRespond_No;
    private ActionListener doYouWannaRespond_Yes;
    private ActionListener toBangAsAReplyChoice;
    private ActionListener duelloChoiceForPlayerInTurn;
    private ActionListener duelloChoiceForPlayerToFollow;
    private ActionListener duelloToOtherPlayer;
    private ActionListener playerInTurnWillNotReplyToDuello;
    private ActionListener toDuelloDistractionOfPlayerInTurn;
    private ActionListener playerInTurnLostHisOwnDuelloAndAllHisHandCards;
    private ActionListener playerToFollowLostDuelloAndAllHisHandCards;
    private ActionListener panicoScreen_StealNow;
    private ActionListener catBalouScreen_RemoveNow;
    private ActionListener toRandomHandCardWasStolen;
    private ActionListener toRandomHandCardWasStolenByElGringo;
    private ActionListener toRandomHandCardCannotBeTaken;
    private ActionListener toGameOverScreen;

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
        toPrigioneScreen = new ToPrigioneScreen(this);
        prigione_ToNextPlayer = new Prigione_ToNextPlayer(this);
        emporioPlayerChoseFirstCard = new EmporioPlayerChoseFirstCard(this);
        emporioPlayerChoseSecondCard = new EmporioPlayerChoseSecondCard(this);
        toBlackJackScren = new ToBlackJackScreen(this);
        toJesseJonesScreen = new ToJesseJonesScreen(this);
        jesseJonesDrawsFromDrawpile = new PlayerInTurnDrawsCardsNormally(this);
        jesseJonesDrawsFromEnemyHand = new JesseJonesDrawsFromEnemyHand(this);
        pedroRamirezDrawsFromDiscardpile = new PedroRamirezDrawsFromDiscardpile(this);
        toJourdonnaisScreen = new ToJourdonnaisScreen(this);
        toKitCarlsonScreen = new ToKitCarlsonScreen(this);
        kitCarlsonPutCardBack = new KitCarlsonPutCardBack(this);
        toSidKetchumCardDiscard = new ToSidKetchumCardDiscard(this);
        sidKetchumDiscardClick = new SidKetchumDiscardClick(this);
        sidKetchumCancel = new SidKetchumCancel(this);
        toPedroRamirezScreen = new ToPedroRamirezScreen(this);
        continueToPlayerXScreen = new ContinueToPlayerXScreen(this);
        playerXScreen_UseCard = new PlayerXScreen_UseCard(this);
        playerXScreen_EndTurn = new PlayerXScreen_EndTurn(this);
        discardCards_Discard = new DiscardCards_Discard(this);
        cancelCardDiscard = new CancelCardDiscard(this);
        toAttackingPlayerPleaseLookAway = new ToAttackingPlayerPleaseLookAway(this);
        pleaseLookAwayToPlayerXScreen = new PleaseLookAwayToPlayerXScreen(this);
        toMancatoChoice = new ToMancatoChoice(this);
        toYouDoNotHaveEnoughHandCardsAndCannotReply = new ToYouDoNotHaveEnoughHandCardsAndCannotReply(this);
        distractionReply = new DistractionReply(this);
        doYouWannaRespond_No = new DoYouWannaRespond_No(this);
        doYouWannaRespond_Yes = new DoYouWannaRespond_Yes(this);
        toBangAsAReplyChoice = new ToBangAsAReplyChoice(this);
        duelloChoiceForPlayerInTurn = new DuelloChoiceForPlayerInTurn(this);
        duelloChoiceForPlayerToFollow = new DuelloChoiceForPlayerToFollow(this);
        duelloToOtherPlayer = new DuelloToOtherPlayer(this);
        playerInTurnWillNotReplyToDuello = new PlayerInTurnWillNotReplyToDuello(this);
        toDuelloDistractionOfPlayerInTurn = new ToDuelloDistractionOfPlayerInTurn(this);
        playerInTurnLostHisOwnDuelloAndAllHisHandCards = new PlayerInTurnLostHisOwnDuelloAndAllHisHandCards(this);
        playerToFollowLostDuelloAndAllHisHandCards = new PlayerToFollowLostDuelloAndAllHisHandCards(this);
        panicoScreen_StealNow = new PanicoScreen_StealNow(this);
        catBalouScreen_RemoveNow = new CatBalouScreen_RemoveNow(this);
        toRandomHandCardWasStolen = new ToRandomHandCardWasStolen(this);
        toRandomHandCardWasStolenByElGringo = new ToRandomHandCardWasStolenByElGringo(this);
        toRandomHandCardCannotBeTaken = new ToRandomHandCardCannotBeTaken(this);
        toGameOverScreen = new ToGameOverScreen(this);
    }

    /**
     *
     * Asettaa pelin paattymisen nakyman.
     */
    public void gameIsOver() {

        GridLayout layout = new GridLayout(4, 3);
        container.setLayout(layout);

        JLabel playerInTurnDied = new JLabel(setup.getRound().getPlayerInTurn().getAvatar().toString() + " died!", JLabel.CENTER);
        playerInTurnDied.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel playerToFollowWon = new JLabel(setup.getRound().getPlayerToFollow().getAvatar().toString() + ", congratulations!", JLabel.CENTER);
        playerToFollowWon.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel playerToFollowDied = new JLabel(setup.getRound().getPlayerToFollow().getAvatar().toString() + " died!", JLabel.CENTER);
        playerToFollowDied.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel playerInTurnWon = new JLabel(setup.getRound().getPlayerInTurn().getAvatar().toString() + ", congratulations!", JLabel.CENTER);
        playerInTurnWon.setFont(new Font("Bang", Font.BOLD, 48));

        JButton goBackToMainMenu = new JButton("Back to main menu");
        goBackToMainMenu.setFont(new Font("Bang", Font.BOLD, 48));

        if (setup.getRound().getPlayerInTurn().getCurrentHealth() <= 0) {

            container.add(playerInTurnDied);
            container.add(playerToFollowWon);

        } else if (setup.getRound().getPlayerToFollow().getCurrentHealth() <= 0) {

            container.add(playerToFollowDied);
            container.add(playerInTurnWon);
        }

        goBackToMainMenu.addActionListener(backToMainMenu);
        container.add(goBackToMainMenu);
    }

    /**
     *
     * Asettaa paavalikkonakyman.
     */
    public void MainMenu() {

        container.setLayout(new BorderLayout());

        JLabel mainMenu = new JLabel(new ImageIcon("C:\\Users\\Antti Korpi\\Bang\\MainMenuBackGround.png"));
        container.add(mainMenu);
        mainMenu.setLayout(new GridLayout(5, 1));

        JButton newGame = new JButton("New Game");
        newGame.setFont(new Font("MainMenu", Font.BOLD, 60));
        newGame.setOpaque(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);

        newGame.addActionListener(mainMenu_NewGame);

        JButton rules = new JButton("Rules");
        rules.setFont(new Font("MainMenu", Font.BOLD, 60));
        rules.setOpaque(false);
        rules.setContentAreaFilled(false);
        rules.setBorderPainted(false);

        rules.addActionListener(mainMenu_Rules);

        JButton exit = new JButton("Exit");
        exit.setFont(new Font("MainMenu", Font.BOLD, 60));
        exit.setOpaque(false);
        exit.setContentAreaFilled(false);
        exit.setBorderPainted(false);

        exit.addActionListener(mainMenu_Exit);

        for (int i = 0; i < 7; i++) {
            mainMenu.add(new JLabel());
        }

        mainMenu.add(newGame);

        for (int i = 0; i < 2; i++) {
            mainMenu.add(new JLabel());
        }

        mainMenu.add(rules);

        for (int i = 0; i < 2; i++) {
            mainMenu.add(new JLabel());
        }

        mainMenu.add(exit);
    }

    /**
     *
     * Asettaa saantonakyman.
     */
    public void rules() {

        container.setLayout(new BoxLayout(container, WIDTH));

        JLabel rules = new JLabel("Rules");
        rules.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel rulesText = new JLabel("<html>BANG! is a Wild West themed card game and this computer adaption follows the rules of the original game, but only for two players (for now...)."
                + "<br>Game is played with hotseat principle: one computer, two players. Every time the other player should play, a message is displayed for the player in turn to look away. Then he should do so, because players are not allowed to see each"
                + "<br>other's hand cards."
                + "<br>"
                + "<br>This town is not big enough for the both of you. The objective is to annihilate the other player."
                + "<br>"
                + "<br>At the beginning of the game both players are given a random character. Each of them have a special ability which is active for the whole game. Specific abilitiy of each character is visible in writing for the whole game. Character"
                + "<br>determines the maximum health points of the player, it is either 3 or 4. Player may never have more health points than this."
                + "<br>"
                + "<br>Players may have cards in their hand which cannot be seen by the other player, but their amount is shown. Players may also have cards in front of them which are visible for the other player as well."
                + "<br>"
                + "<br>There are two decks of cards in the game: drawpile and discardpile. At the beginnig of the game all the cards are in drawpile and discardpile is empty. During the game cards are discarded into discardpile (who'd have guessed!?). If"
                + "<br>drawpile is emptied, discardpile will be shuffled and become a new drawpile."
                + "<br>"
                + "<br>Both players will be dealt their maximum health of cards which will be put into their hand. After this, first round starts."
                + "<br>"
                + "<br>At the beginning of a turn player draws two cards from the deck into their hand, unless characters special ability allows otherwise. Then player can play cards."
                + "<br>"
                + "<br>Cards are either orange or blue."
                + "<br>Orange cards are used instaneously and can, for example, attack in various ways, defend or allow to draw more cards. An orange card is discarded after it is used."
                + "<br>Blue cards are put in front of the player to give benefit as long as the card remains there. They may, again for example, provide additional cover. There are also blue cards that cause harm but they will be explained in more detail"
                + "<br>later. Player cannot have two blue cards of same kind in front. If a similar card is played it will replace the old one, which will be discarded ('Dinamite' is an exeption, see later)."
                + "<br>Also, six blue cards are guns. Player may only have one gun in front. If another is played, the old one will be discarded. Guns will be explained later."
                + "<br>"
                + "<br>Players are normally at distance of one from each other."
                + "<br>Players reach is also normally one. This means, that they cannot use cards that are dependant on distance if player is further than this. Reach can be altered with guns. You may shoot to distance the gun provides."
                + "<br>In addition, players touch reach is normally one. It is not increased by guns. There are also cards dependant on this type of reach."
                + "<br>"
                + "<br>Most basic orange cards (and cards all in all) of the game are 'BANG!' and 'Mancato!'."
                + "<br>'BANG!' shoots enemy and target loses one health point if it hits. Only one 'BANG!' can be played in one turn. Other attacking cards than 'BANG!' do not forbid its use or vice versa."
                + "<br>'Mancato!' is a miss card which can be used to cancel 'BANG!' or other shooting card. Therefore, 'Mancato!' is used on other players turn, it cannot be played on player's own turn."
                + "<br>"
                + "<br>Other orange attacking cards are 'Gatling', 'Indiani!' and 'Duello'."
                + "<br>'Gatling' is basically same as 'BANG!', but it can always be played and is not dependant on attacking player's reach."
                + "<br>'Indiani' calls a tribe of indians to attack other player, who must use 'BANG!' to shoot them off or lose one health point. 'Indiani!' is not dependant on attacking player's reach."
                + "<br>'Duello', as it says, challenges other player to a duel. Challenged player must play 'BANG!' or lose one health point. If player player plays 'BANG!', the player who played 'Duello' must now play 'BANG!' or lose one health point."
                + "<br>This continues until other player can or will not play 'BANG!' and loses one health point. 'Duello' is not dependant on attacking player's reach."
                + "<br>"
                + "<br>Other orange cards are 'Cat Balou', 'Panico', 'Emporio', 'Diligenza', 'Wells Fargo', 'Saloon' and 'Birra'."
                + "<br>'Cat Balou' forces other player to discard a card. User may either select from enemy's visible front (if there are any) cards or one hand card at random. 'Cat Balou' is not dependant on reach using player."
                + "<br>'Panico' steals a card from hand of other player and puts it into using player's hand. Like when using 'Cat Balou', using player may choose from enemy's front cards or hand. Panico is dependant on touch reach of using player."
                + "<br>'Emporio' reveals two cards from the top of drawpile. Using player may choose one of them and other player gets the other one."
                + "<br>'Diligenza' instantly draws two cards from drawpile into hand of using player."
                + "<br>'Wells Fargo' is the same as 'Diligenza' but it draws three cards."
                + "<br>'Saloon' returns one health point to both players. However, neither may have more health points than their maximum."
                + "<br>'Birra' is a beer. It tastes good but does not do a thing."
                + "<br>"
                + "<br>Blue cards include 'Barrel', 'Mirino', 'Mustang', 'Dinamite', 'Prigione' and five guns: 'Schofield', 'Remington', 'Rev.Carabine', 'Winchester' and 'Volcanic'.  "
                + "<br>'Barrel' is a defensive card. If player who has 'Barrel' in front of him is shot at, the top card of drawpile is flipped. If suit of the card is 'Hearts' the shot missed, otherwise it did not. If 'Barrel' does not stop the shot"
                + "<br>the player being shot at may still use 'Mancato!' to dodge. In any case, the flipped card will be discarded. 'Barrel' only works against shots which means only 'BANG!' and 'Gatling', not 'Duello' or 'Inadiani!'."
                + "<br>'Mirino', increases player's touch reach by one."
                + "<br>'Mustang', increases player's distance from other player by one. This means that other pleyer needs longer reach against him, but the player on 'Mustang' does not need additional reach aginst other player."
                + "<br>'Dinamite' is an attacking card. When it is played, it will be placed in front of the player who uses it. When he next time begins his turn, before he draws his cards, top card of drawpile will be flipped. If suit of the card"
                + "<br>is 'Spades' and number between two and nine (two and nine are also included in this range), 'Dinamite' explodes and player loses three life points. If flipped card is anything else, 'Dinamite' will pe passed to the other player."
                + "<br>He then checks the top card before his turn and 'Dinamite' will be passed again if it does not explode. This will contiue until it does. Unlike with other blue cards, if other player already has 'Dinamite' in front and new one"
                + "<br>would be passed to him the old one will not be discarded. Both will stay put and be checked with players turns until another will explode. After that the other"
                + "<br>will start passing on normally."
                + "<br>'Prigione' is another attacking card. When a player uses it, it will be placed in front of another player. When this other player next starts his turn, before he draws his cards, top card of drawpile will be flipped. If suit of"
                + "<br>the card is 'Hearts', 'Prigione' will be discarded and player will begin his turn normally. If suit of flipped card is anything else, player will lose his turn. 'Prigione' will be discarded and turn will be passed to other player."
                + "<br>If player has both 'Dinamite' and 'Prigione' in front, 'Dinamite' will be checked first and 'Prigione' after that."
                + "<br>Five guns alter players reach."
                + "<br>'Schofield' increases reach by one, 'Remington' by two , 'Rev-Carabine' by three and 'Winchester' by four."
                + "<br>'Volcanic' is a different type of gun. It provides no additional reach but it allows player to use unlimited amount of 'BANG!' during his turn."
                + "<br>"
                + "<br>Player may use as many cards as he can in one turn (but remember: normally only one 'BANG!'). Once player has no more hand cards he cannot continue his turn."
                + "<br>When finishing a turn, player may only keep as many cards in his hand as he has health points left. If he has more than this, he must discard the excessive cards. Any card can be discarded. Player may not discard cards unless"
                + "<br>he has more than his current health points."
                + "<br>"
                + "<br>Characters special abilities affect many events of game and some cards."
                + "<br>'Bart Cassidy' draws a card from drawpile each time he loses health. If 'Dinamite' explodes on him he draws three cards."
                + "<br>'Black Jack' shows the second card he draws to other player so you must tell him what it was. If suit of card is 'Hearts' or 'Diamonds', he draws a third card. This is not shown to the other player."
                + "<br>'Calamity Janet' may use 'BANG!' as 'Mancato!' and vice versa. They are basically same card to her."
                + "<br>'El Gringo' draws a card from hand of other player when he loses health as a result from other players attack. This means 'BANG!', 'Gatling', 'Indiani!' or 'Duello'. If 'Dinamite' explodes on him he draws no cards. Also, if he"
                + "<br>himself plays 'Duello' and loses it, he draws no cards."
                + "<br>'Jesse Jones' may choose to draw his first card form other player's hand or from drawpile. Second card is always drawn from drawpile. He cannot use his ability if other player has no hand cards."
                + "<br>'Jourdonnais' flips top card of drawpile when he is shot. On 'Hearts' he is missed. Basically he always has 'Barrel' in front of him. If he actually has 'Barrel', he may check both. If either is 'Hearts' he is missed."
                + "<br>'Kit Carlson' draws three cards from drawpile. He looks all of them, returns one to the top of drawpile and keeps two others. It should be noted that the returned card really goes to drawpile. If no cards are drawn during 'Kit"
                + "<br>Carlson's' turn, the other player draws it. This applies also if other player has 'Dinamite' or 'Prigione' in front..."
                + "<br>'Lucky Duke' flips two cards instead of one whenever top card of drawpile is checked. This means for 'Barrel', 'Dinamite' and 'Prigione'. If either is desired type ('Hearts' on 'Barrel' and 'Prigione' and something other than"
                + "<br>'Spades' 2-9 on 'Dinamite') it will be considered when checking effect."
                + "<br>'Paul Regret' always has distance increased by one. Basically he always has 'Mustang' in front of him. His ability stacks with an actual 'Mustang'."
                + "<br>'Pedro Ramirez' May choose to draw his first card from discardpile or from drawpile. Second card is always drawn from drawpile. He cannot use his ability if discarpile is empty."
                + "<br>'Rose Doolan' always has touch reach increased by one. Basically she always has 'Mirino' in front of her. Her ability stacks with an actual 'Mirino' and all range providing guns."
                + "<br>'Sid Ketchum' may discard two cards from his hand during his turn to regain one health point. He may never exceed his maximum health of four. He can use his ability unlimited amount of times (also during one turn)."
                + "<br>'Slab The Killer' is an effective killer. Other player needs two misses to avoid his 'BANG!'. This only applies to 'BANG!', not 'Gatling', 'Indiani!' or 'Duello'. If player has 'Barrel', flipped 'Hearts' counts as one missed. If"
                + "<br>enemy is 'Jourdonnais' and he has 'Barrel', each flipped 'Hearts' counts as one missed."
                + "<br>'Suzy Lafayette' draws a card from drawpile as soon as she has no hand cards. The effect reamains on both her own turn as well as other player's. However, during 'Duello' she draws the card only after it is finished."
                + "<br>'Willy The Kid' may play unlimited amount of 'BANG!' during his turn. Basically he always has 'Volcanic' in front of him. An actual 'Volcanic' is usless to him."
                + "<br>"
                + "<br>Once one player is reduced to zero health points he loses the game and it is over."
                + "</html>");

        JScrollPane rulesScreen = new JScrollPane(rulesText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JButton goBackToMainMenu = new JButton("Back to Main Menu");
        goBackToMainMenu.setFont(new Font("Button", Font.ITALIC, 34));
        goBackToMainMenu.addActionListener(backToMainMenu);

        container.add(rules);
        container.add(rulesScreen);
        container.add(goBackToMainMenu);
    }

    /**
     *
     * Asettaa poistumisnakyman.
     */
    public void exit() {

        container.setLayout(new GridLayout(3, 3));

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

        GridLayout layout = new GridLayout(7, 4);
        container.setLayout(layout);

        JLabel player1Avatar = new JLabel("Player1, your character is " + setup.getPlayer1().getAvatar().toString());
        player1Avatar.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel player1Speciality = new JLabel(setup.getPlayer1().getAvatar().getSpeciality());
        player1Speciality.setFont(new Font("CharacterAbility", Font.ITALIC, 28));

        JLabel player1MaxHealth = new JLabel("Your maximum health is " + setup.getPlayer1().getAvatar().getMaxHealth());
        player1MaxHealth.setFont(new Font("CharacterAbility", Font.ITALIC, 28));

        JLabel player2Avatar = new JLabel("Player2, your character is " + setup.getPlayer2().getAvatar().toString());
        player2Avatar.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel player2Speciality = new JLabel(setup.getPlayer2().getAvatar().getSpeciality());
        player2Speciality.setFont(new Font("CharacterAbility", Font.ITALIC, 28));

        JLabel player2MaxHealth = new JLabel("Your maximum health is " + setup.getPlayer2().getAvatar().getMaxHealth());
        player2MaxHealth.setFont(new Font("CharacterAbility", Font.ITALIC, 28));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(newGame_Continue);

        container.add(player1Avatar);
        container.add(player1Speciality);
        container.add(player1MaxHealth);
        container.add(player2Avatar);
        container.add(player2Speciality);
        container.add(player2MaxHealth);
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

        if (setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") || setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Mancato!") || setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Gatling")) {

            if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer") && setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("BANG!") && setup.getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0) {
                if (setup.getRound().getCheckerForAvatarSpeciality().checkThatEnemyHasTwoMancatosAgainstSlabTheKiller()) {
                    next.addActionListener(toMancatoChoice);
                } else {
                    next.addActionListener(distractionReply);
                }
            } else if (setup.getRound().getCheckerForPlayedCard().playerHasBangOrMancato(setup.getRound().getPlayerToFollow(), "Mancato!") || (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && setup.getRound().getCheckerForAvatarSpeciality().checkCalamityJanetForBangsOrMancatos())) {
                next.addActionListener(toMancatoChoice);
            } else {
                next.addActionListener(distractionReply);
            }

        } else if (setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Indiani!")) {
            if (setup.getRound().getCheckerForPlayedCard().playerHasBangOrMancato(setup.getRound().getPlayerToFollow(), "BANG!") || (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && setup.getRound().getCheckerForAvatarSpeciality().checkCalamityJanetForBangsOrMancatos())) {
                next.addActionListener(toBangAsAReplyChoice);
            } else {
                next.addActionListener(distractionReply);
            }

        } else if (setup.getRound().getPlayerInTurn().getCardWaitingForAReply().getName().contains("Duello")) {
            if (setup.getRound().getCheckerForPlayedCard().playerHasBangOrMancato(setup.getRound().getPlayerToFollow(), "BANG!") || (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet") && setup.getRound().getCheckerForAvatarSpeciality().checkCalamityJanetForBangsOrMancatos())) {
                next.addActionListener(duelloChoiceForPlayerToFollow);
            } else {
                next.addActionListener(distractionReply);
            }
        }
        container.add(playerXPleaseLookAway);
        container.add(next);
    }

    /**
     *
     * Asettaa Prigionen infonakyman.
     */
    public void prigioneScreen() {

        JLabel thereIsAPrigione = new JLabel("You are in prigione...", JLabel.CENTER);
        thereIsAPrigione.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel prigioneHeld = new JLabel("Prigione is secure!!! You lost your turn!!!", JLabel.CENTER);
        prigioneHeld.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel prigioneFailed = new JLabel("You broke out!!!", JLabel.CENTER);
        prigioneFailed.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel and = new JLabel("and", JLabel.CENTER);
        and.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {

            container.setLayout(new GridLayout(6, 3));
            container.add(thereIsAPrigione);

            JLabel drawnCard1 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString(), JLabel.CENTER);
            drawnCard1.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard1);

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
        } else {

            container.setLayout(new GridLayout(4, 3));
            container.add(thereIsAPrigione);

            JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
            drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(drawnCard);

            if (!setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {
                container.add(prigioneHeld);
                next.addActionListener(prigione_ToNextPlayer);

            } else {
                container.add(prigioneFailed);

                if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Black Jack")) {
                    next.addActionListener(toBlackJackScren);

                } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Jesse Jones")) {
                    next.addActionListener(toJesseJonesScreen);

                } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Kit Carlson")) {
                    next.addActionListener(toKitCarlsonScreen);

                } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Pedro Ramirez")) {
                    next.addActionListener(toPedroRamirezScreen);

                } else {
                    next.addActionListener(continueToPlayerXScreen);
                }
            }

        }
        container.add(next);
    }

    /**
     *
     * Asettaa Dinamiten infonakyman.
     */
    public void dinamiteScreen() {

        JLabel thereIsADinamite = new JLabel("The dinamite is hissing...", JLabel.CENTER);
        thereIsADinamite.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel dinamiteExploded = new JLabel("The dinamite exploded!!! You lost 3 health points!!!", JLabel.CENTER);
        dinamiteExploded.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel dinamiteWasPassedOn = new JLabel("The dinamite didn't explode and was passed on", JLabel.CENTER);
        dinamiteWasPassedOn.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel bothPlayersHaveDinamite = new JLabel("Dinamite didn't explode, you both keep your own", JLabel.CENTER);
        bothPlayersHaveDinamite.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel and = new JLabel("and", JLabel.CENTER);
        and.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Lucky Duke")) {

            container.setLayout(new GridLayout(6, 3));
            container.add(thereIsADinamite);

            if (setup.getRound().getDiscardpile().getDeck().get(setup.getRound().getDiscardpile().getDeck().size() - 1).getName().contains("Prigione") && setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() > 2) {

                JLabel drawnCard1 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 4).toString(), JLabel.CENTER);
                drawnCard1.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard1);


                container.add(and);

                JLabel drawnCard2 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 3).toString(), JLabel.CENTER);
                drawnCard2.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard2);

                if (setup.getRound().getCheckerForAvatarSpeciality().checkIfDinamiteExplodedOnLuckyDukeWhenHeHasBothDinamiteAndPrigione()) {
                    container.add(dinamiteExploded);

                } else {
                    if (setup.getRound().getCheckerForPlayedCard().sameKindOfCardIsAlreadyInFrontOfPlayerInTurn("Dinamite")) {
                        container.add(bothPlayersHaveDinamite);
                    } else {
                        container.add(dinamiteWasPassedOn);
                    }
                }
                if (setup.getRound().gameIsOver()) {
                    next.addActionListener(toGameOverScreen);
                } else {
                    next.addActionListener(toPrigioneScreen);
                }

            } else {

                JLabel drawnCard1 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString(), JLabel.CENTER);
                drawnCard1.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard1);

                container.add(and);

                JLabel drawnCard2 = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 1).toString(), JLabel.CENTER);
                drawnCard2.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard2);

                if (setup.getRound().getCheckerForAvatarSpeciality().checkTwoAlreadyDrawnCardsIfTheyDetonatedDinamiteOnLuckyDuke(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2), setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 1))) {
                    container.add(dinamiteExploded);

                } else {
                    if (setup.getRound().getCheckerForPlayedCard().sameKindOfCardIsAlreadyInFrontOfPlayerInTurn("Dinamite")) {
                        container.add(bothPlayersHaveDinamite);
                    } else {
                        container.add(dinamiteWasPassedOn);
                    }
                }
                if (setup.getRound().gameIsOver()) {
                    next.addActionListener(toGameOverScreen);
                } else {
                    next.addActionListener(continueToPlayerXScreen);
                }
            }

        } else {

            container.setLayout(new GridLayout(4, 3));
            container.add(thereIsADinamite);

            if (setup.getRound().getDiscardpile().getDeck().get(setup.getRound().getDiscardpile().getDeck().size() - 1).getName().contains("Prigione") && setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() > 1) {

                JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString() + " was drawn", JLabel.CENTER);
                drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard);

                if (setup.getRound().getCheckerForEventsBeforeTurn().dinamiteBlowsUp(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2))) {
                    container.add(dinamiteExploded);

                } else {
                    if (setup.getRound().getCheckerForPlayedCard().sameKindOfCardIsAlreadyInFrontOfPlayerInTurn("Dinamite")) {
                        container.add(bothPlayersHaveDinamite);
                    } else {
                        container.add(dinamiteWasPassedOn);
                    }
                }
                if (setup.getRound().gameIsOver()) {
                    next.addActionListener(toGameOverScreen);
                } else {
                    next.addActionListener(toPrigioneScreen);
                }

            } else {

                JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
                drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard);

                if (setup.getRound().getCheckerForEventsBeforeTurn().dinamiteBlowsUp(setup.getRound().getPlayerInTurn().getLastCheckedCard())) {
                    container.add(dinamiteExploded);
                } else {
                    if (setup.getRound().getCheckerForPlayedCard().sameKindOfCardIsAlreadyInFrontOfPlayerInTurn("Dinamite")) {
                        container.add(bothPlayersHaveDinamite);
                    } else {
                        container.add(dinamiteWasPassedOn);
                    }
                }
                if (setup.getRound().gameIsOver()) {
                    next.addActionListener(toGameOverScreen);

                } else {
                    if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Black Jack")) {
                        next.addActionListener(toBlackJackScren);

                    } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Jesse Jones")) {
                        next.addActionListener(toJesseJonesScreen);

                    } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Kit Carlson")) {
                        next.addActionListener(toKitCarlsonScreen);

                    } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Pedro Ramirez")) {
                        next.addActionListener(toPedroRamirezScreen);

                    } else {
                        next.addActionListener(continueToPlayerXScreen);
                    }
                }
            }
        }
        container.add(next);
    }

    /**
     *
     * Asettaa Jourdonnaisin vaistonakyman.
     */
    public void jourdonnaisScreen() {

        container.setLayout(new GridLayout(5, 3));

        JLabel enemyIsJourdonnais = new JLabel("The enemy is Jourdonnais", JLabel.CENTER);
        enemyIsJourdonnais.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
        drawnCard.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel theShotMissed = new JLabel("The shot missed!", JLabel.CENTER);
        theShotMissed.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel barrelWorkedAgainstSlabTheKiller = new JLabel("Jourdonnais softened the shot!", JLabel.CENTER);
        barrelWorkedAgainstSlabTheKiller.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel oneMoreMissIsNeeded = new JLabel("One more miss is needed", JLabel.CENTER);
        oneMoreMissIsNeeded.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel barrelDidNotWork = new JLabel("Jourdonnais couldn't evade the shot!", JLabel.CENTER);
        barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));



        container.add(enemyIsJourdonnais);
        container.add(drawnCard);

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer")) {

            if (setup.getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 2) {

                container.add(theShotMissed);
                next.addActionListener(continueToPlayerXScreen);

            } else if (setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {

                container.add(barrelWorkedAgainstSlabTheKiller);
                container.add(oneMoreMissIsNeeded);

                if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                    next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                } else {
                    next.addActionListener(toAttackingPlayerPleaseLookAway);
                }

            } else {
                container.add(barrelDidNotWork);

                if ((setup.getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0 && setup.getRound().getPlayerToFollow().getHandCards().size() < 2) || (setup.getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 1 && setup.getRound().getPlayerToFollow().getHandCards().isEmpty())) {
                    next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                } else {
                    next.addActionListener(toAttackingPlayerPleaseLookAway);
                }
            }
        } else {
            if (setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {

                container.add(theShotMissed);
                next.addActionListener(continueToPlayerXScreen);

            } else {
                container.add(barrelDidNotWork);

                if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                    next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                } else {
                    next.addActionListener(toAttackingPlayerPleaseLookAway);
                }
            }
        }
        container.add(next);
    }

    /**
     *
     * Asettaa Barrelin vaistonakyman.
     */
    public void barrelScreen() {

        container.setLayout(new GridLayout(7, 3));

        JLabel thereIsABarrel = new JLabel("The enemy has a barrel", JLabel.CENTER);
        thereIsABarrel.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(thereIsABarrel);

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer")) {

            if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Jourdonnais")) {

                JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString() + " was drawn", JLabel.CENTER);
                drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard);

                if (setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).getSuit().equals("Hearts")) {

                    JLabel barrelWorkedAgainstSlabTheKiller = new JLabel("Barrel got in the way of the shot!", JLabel.CENTER);
                    barrelWorkedAgainstSlabTheKiller.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelWorkedAgainstSlabTheKiller);

                    JLabel oneMoreMissIsNeeded = new JLabel("One more miss is needed", JLabel.CENTER);
                    oneMoreMissIsNeeded.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(oneMoreMissIsNeeded);

                    next.addActionListener(toJourdonnaisScreen);

                } else {
                    JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                    barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelDidNotWork);

                    next.addActionListener(toJourdonnaisScreen);
                }
            } else if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Lucky Duke")) {

                JLabel firstDrawnCard = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString(), JLabel.CENTER);
                firstDrawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(firstDrawnCard);

                JLabel and = new JLabel("and", JLabel.CENTER);
                and.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(and);

                JLabel secondDrawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " were drawn", JLabel.CENTER);
                secondDrawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(secondDrawnCard);

                if (setup.getRound().getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts()) {

                    JLabel barrelWorkedAgainstSlabTheKiller = new JLabel("Barrel got in the way of the shot!", JLabel.CENTER);
                    barrelWorkedAgainstSlabTheKiller.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelWorkedAgainstSlabTheKiller);

                    JLabel oneMoreMissIsNeeded = new JLabel("One more miss is needed", JLabel.CENTER);
                    oneMoreMissIsNeeded.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(oneMoreMissIsNeeded);

                    if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                        next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                    } else {
                        next.addActionListener(toAttackingPlayerPleaseLookAway);
                    }

                } else {

                    JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                    barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelDidNotWork);

                    if (setup.getRound().getPlayerToFollow().getHandCards().size() < 2) {
                        next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                    } else {
                        next.addActionListener(toAttackingPlayerPleaseLookAway);
                    }
                }
            } else {

                JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
                drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard);

                if (setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {

                    JLabel barrelWorkedAgainstSlabTheKiller = new JLabel("Barrel got in the way of the shot!", JLabel.CENTER);
                    barrelWorkedAgainstSlabTheKiller.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelWorkedAgainstSlabTheKiller);

                    JLabel oneMoreMissIsNeeded = new JLabel("One more miss is needed", JLabel.CENTER);
                    oneMoreMissIsNeeded.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(oneMoreMissIsNeeded);

                    if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                        next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                    } else {
                        next.addActionListener(toAttackingPlayerPleaseLookAway);
                    }

                } else {
                    JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                    barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelDidNotWork);

                    if (setup.getRound().getPlayerToFollow().getHandCards().size() < 2) {
                        next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                    } else {
                        next.addActionListener(toAttackingPlayerPleaseLookAway);
                    }
                }
            }
        } else {

            if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Jourdonnais")) {

                if (setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() == 2) {

                    JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString() + " was drawn", JLabel.CENTER);
                    drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(drawnCard);

                    JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                    barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelDidNotWork);

                    next.addActionListener(toJourdonnaisScreen);

                } else {

                    JLabel barrelWorked = new JLabel("The shot missed!", JLabel.CENTER);
                    barrelWorked.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelWorked);

                    next.addActionListener(continueToPlayerXScreen);
                }

            } else if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Lucky Duke")) {

                JLabel firstDrawnCard = new JLabel(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString(), JLabel.CENTER);
                firstDrawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(firstDrawnCard);

                JLabel and = new JLabel("and", JLabel.CENTER);
                and.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(and);

                JLabel secondDrawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " were drawn", JLabel.CENTER);
                secondDrawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(secondDrawnCard);

                if (setup.getRound().getCheckerForAvatarSpeciality().checkTwoLastCheckedCardsForLuckyDukeForHearts()) {

                    JLabel barrelWorked = new JLabel("The shot missed!", JLabel.CENTER);
                    barrelWorked.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelWorked);

                    next.addActionListener(continueToPlayerXScreen);

                } else {

                    JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                    barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelDidNotWork);

                    if (setup.getRound().getPlayerToFollow().getHandCards().size() < 2) {
                        next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                    } else {
                        next.addActionListener(toAttackingPlayerPleaseLookAway);
                    }
                }
            } else {

                JLabel drawnCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was drawn", JLabel.CENTER);
                drawnCard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(drawnCard);

                if (setup.getRound().getPlayerInTurn().getLastCheckedCard().getSuit().equals("Hearts")) {

                    JLabel barrelWorked = new JLabel("The shot missed!", JLabel.CENTER);
                    barrelWorked.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelWorked);

                    next.addActionListener(continueToPlayerXScreen);

                } else {
                    JLabel barrelDidNotWork = new JLabel("Barrel didn't stop the shot!", JLabel.CENTER);
                    barrelDidNotWork.setFont(new Font("Bang", Font.BOLD, 48));
                    container.add(barrelDidNotWork);

                    if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
                        next.addActionListener(toYouDoNotHaveEnoughHandCardsAndCannotReply);
                    } else {
                        next.addActionListener(toAttackingPlayerPleaseLookAway);
                    }
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

        container.setLayout(new BoxLayout(container, WIDTH));

        JLabel whichCardWillYouSteal = new JLabel("Which card will you take?", JLabel.CENTER);
        whichCardWillYouSteal.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(whichCardWillYouSteal);
        container.add(new JLabel(" "));

        ButtonGroup panicoChoice = new ButtonGroup();
        cardList.clear();

        for (int i = 0; i < setup.getRound().getPlayerToFollow().getFrontCards().size(); i++) {
            JRadioButton frontCard = new JRadioButton(setup.getRound().getPlayerToFollow().getFrontCards().get(i).toString());
            frontCard.setFont(new Font("RadioButton", Font.PLAIN, 30));
            cardList.add(frontCard);
        }
        if (!setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
            JRadioButton randomHandCard = new JRadioButton("Random hand card (other player has " + setup.getRound().getPlayerToFollow().getHandCards().size() + ")");
            randomHandCard.setFont(new Font("RadioButton", Font.PLAIN, 30));
            cardList.add(randomHandCard);
        }
        for (JRadioButton toBeAdded : cardList) {
            panicoChoice.add(toBeAdded);
            container.add(toBeAdded);
        }
        container.add(new JLabel(" "));

        JButton steal = new JButton("Steal now!");
        steal.setFont(new Font("StalButton", Font.ITALIC, 30));
        steal.addActionListener(panicoScreen_StealNow);
        container.add(steal);
    }

    /**
     *
     * Asettaa varastetun kortin infonakyman.
     */
    public void randomHandCardWasStolen() {

        container.setLayout(new GridLayout(3, 3));

        JLabel stolenCard = new JLabel(setup.getRound().getPlayerInTurn().getLastCheckedCard().toString() + " was stolen", JLabel.CENTER);
        stolenCard.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(stolenCard);
        container.add(next);
    }

    /**
     *
     * Asettaa El Gringon erikoiskyvylla varastetun kortin infonakyman.
     */
    public void handCardWasStolenByElGringo() {

        container.setLayout(new GridLayout(3, 3));

        JLabel stolenCard = new JLabel("You stole " + setup.getRound().getPlayerInTurn().getLastCheckedCard().toString(), JLabel.CENTER);
        stolenCard.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(pleaseLookAwayToPlayerXScreen);

        container.add(stolenCard);
        container.add(next);
    }

    /**
     *
     * Asettaa Cat Balou -kortin valintanakyman.
     */
    public void catBalouScreen() {

        container.setLayout(new BoxLayout(container, WIDTH));

        JLabel whichCardWillYouRemove = new JLabel("Which card will you remove?", JLabel.CENTER);
        whichCardWillYouRemove.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(whichCardWillYouRemove);
        container.add(new JLabel(" "));

        ButtonGroup catBalouChoice = new ButtonGroup();
        cardList.clear();

        for (int i = 0; i < setup.getRound().getPlayerToFollow().getFrontCards().size(); i++) {
            JRadioButton frontCard = new JRadioButton(setup.getRound().getPlayerToFollow().getFrontCards().get(i).toString());
            frontCard.setFont(new Font("RadioButton", Font.PLAIN, 30));
            cardList.add(frontCard);
        }
        if (!setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
            JRadioButton randomHandCard = new JRadioButton("Random hand card (other player has " + setup.getRound().getPlayerToFollow().getHandCards().size() + ")");
            randomHandCard.setFont(new Font("RadioButton", Font.PLAIN, 30));
            cardList.add(randomHandCard);
        }
        for (JRadioButton toBeAdded : cardList) {
            catBalouChoice.add(toBeAdded);
            container.add(toBeAdded);
        }
        container.add(new JLabel(" "));

        JButton remove = new JButton("Remove now!");
        remove.addActionListener(catBalouScreen_RemoveNow);
        remove.setFont(new Font("RemoveButton", Font.ITALIC, 30));
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
     */
    public void targetedPlayerHasNoCardsSoTheyCannotBeTaken() {

        container.setLayout(new GridLayout(3, 3));

        JLabel enemyHasNoCards = new JLabel("The other player has no cards,", JLabel.CENTER);
        enemyHasNoCards.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel youCannotPlayThisCard = new JLabel("there are no cards to take!", JLabel.CENTER);
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
     * Asettaa Emporio-kortin valintanakyman.
     */
    public void emporioScreen() {

        container.setLayout(new GridLayout(4, 3));

        JButton drawnCard1 = new JButton(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 2).toString());
        drawnCard1.setFont(new Font("Bang", Font.BOLD, 48));
        drawnCard1.addActionListener(emporioPlayerChoseFirstCard);
        container.add(drawnCard1);

        JLabel and = new JLabel("and", JLabel.CENTER);
        and.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(and);

        JButton drawnCard2 = new JButton(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().get(setup.getRound().getPlayerInTurn().getListOfLastCheckedCards().size() - 1).toString());
        drawnCard2.setFont(new Font("Bang", Font.BOLD, 48));
        drawnCard2.addActionListener(emporioPlayerChoseSecondCard);
        container.add(drawnCard2);

        JLabel whichWillYouTake = new JLabel("Which will you take? Enemy will have the other", JLabel.CENTER);
        whichWillYouTake.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(whichWillYouTake);
    }

    /**
     *
     * Asettaa Black Jackin kortinnoston infonakyman.
     */
    public void blackJackDrawScreen() {

        container.setLayout(new GridLayout(4, 3));

        JLabel drawnCard = new JLabel("Second card was " + setup.getRound().getCheckerForAvatarSpeciality().getSecondDrawnCardOfBlackJack().toString(), JLabel.CENTER);
        drawnCard.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel getsNew = new JLabel("You get one more card", JLabel.CENTER);
        getsNew.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel doesNotGetNew = new JLabel("You don't get more cards", JLabel.CENTER);
        doesNotGetNew.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(drawnCard);

        if (setup.getRound().getCheckerForAvatarSpeciality().getSecondDrawnCardOfBlackJack().getSuit().equals("Hearts") || setup.getRound().getCheckerForAvatarSpeciality().getSecondDrawnCardOfBlackJack().getSuit().equals("Diamonds")) {
            container.add(getsNew);

        } else {
            container.add(doesNotGetNew);
        }
        container.add(next);
    }

    /**
     *
     * Asettaa Jesse Jonesin kortinnoston valintanakyman.
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
            container.add(next);

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
     * Asettaa Kit Carlsonin kortinnoston valintanakyman.
     */
    public void kitCarlsonDrawScreen() {

        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);

        container.add(new JLabel("Which of these card will you put back to the top of the drawpile?"));

        ButtonGroup choises = new ButtonGroup();
        cardList.clear();

        for (int i = 3; i > 0; i--) {
            cardList.add(new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(setup.getRound().getPlayerInTurn().getHandCards().size() - i).toString()));
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
     * Asettaa Pedro Ramirezin kortinnoston valintanakyman.
     */
    public void pedroRamirezDrawScreen() {

        container.setLayout(new GridLayout(4, 3));

        if (setup.getRound().getDiscardpile().getDeck().isEmpty()) {

            JLabel discardpileIsEmpty = new JLabel("Discardpile is empty,", JLabel.CENTER);
            discardpileIsEmpty.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(discardpileIsEmpty);

            JLabel youCannotUseSpeciality = new JLabel("you cannot use your speciality!", JLabel.CENTER);
            youCannotUseSpeciality.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(youCannotUseSpeciality);

            JButton next = new JButton("Continue");
            next.setFont(new Font("Button", Font.ITALIC, 34));
            next.addActionListener(continueToPlayerXScreen);
            container.add(next);

        } else {
            JLabel topCardOfDiscardPile = new JLabel("Top card of discardpile is " + setup.getRound().getDiscardpile().getDeck().get(setup.getRound().getDiscardpile().getDeck().size() - 1).toString() + ",", JLabel.CENTER);
            topCardOfDiscardPile.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(topCardOfDiscardPile);

            JLabel wannaDrawFromDiscardpile = new JLabel("do you want to draw your first card from discardpile?", JLabel.CENTER);
            wannaDrawFromDiscardpile.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(wannaDrawFromDiscardpile);

            JButton drawFromDiscardpile = new JButton("Draw from discardpile");
            drawFromDiscardpile.setFont(new Font("Button", Font.ITALIC, 34));
            drawFromDiscardpile.addActionListener(pedroRamirezDrawsFromDiscardpile);
            container.add(drawFromDiscardpile);


            JButton drawFromDrawpile = new JButton("Draw from drawpile");
            drawFromDrawpile.setFont(new Font("Button", Font.ITALIC, 34));
            drawFromDrawpile.addActionListener(jesseJonesDrawsFromDrawpile);
            container.add(drawFromDrawpile);
        }
    }

    /**
     *
     * Asettaa Sid Ketchumin kestojen palauttamiseksi poistettavien kasikorttien
     * valintanakyman.
     */
    public void sidKetchumCardDiscard() {

        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);

        if (setup.getRound().getCheckerForAvatarSpeciality().getSidKetchumDiscardList().size() == 2) {
            container.add(new JLabel("Are you sure?"));

            String remainingHandCards = "<html><br>Hand cards:";
            for (Card toBeShown : setup.getRound().getPlayerInTurn().getHandCards()) {
                remainingHandCards = remainingHandCards + "<br>" + toBeShown.toString();
            }
            remainingHandCards = remainingHandCards + "</html>";
            container.add(new JLabel(remainingHandCards));

        } else {
            container.add(new JLabel("Choose a card to discard"));

            container.add(new JLabel("Hand cards:"));

            ButtonGroup choises = new ButtonGroup();
            cardList.clear();

            for (int i = 0; i < setup.getRound().getPlayerInTurn().getHandCards().size(); i++) {
                cardList.add(new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(i).toString()));
            }
            for (JRadioButton toBeAdded : cardList) {
                choises.add(toBeAdded);
                container.add(toBeAdded);
            }
        }
        String cardsToBeDiscarded = "<html><br>To be discarded:";
        for (Card toBeShown : setup.getRound().getCheckerForAvatarSpeciality().getSidKetchumDiscardList()) {
            cardsToBeDiscarded = cardsToBeDiscarded + "<br>" + toBeShown.toString();
        }
        cardsToBeDiscarded = cardsToBeDiscarded + "</html>";
        container.add(new JLabel(cardsToBeDiscarded));

        JButton discard = new JButton("Discard");
        discard.addActionListener(sidKetchumDiscardClick);
        container.add(discard);

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(sidKetchumCancel);
        container.add(cancel);
    }

    /**
     *
     * Asettaa pelaajan vuoronakyman.
     */
    public void playerXScreen() {

        container.setLayout(new GridLayout());



        Container enemyFrontCards = new Container();
        enemyFrontCards.setLayout(new BoxLayout(enemyFrontCards, BoxLayout.Y_AXIS));

        enemyFrontCards.add(new JLabel("Enemy front cards:"));

        for (Card toBeShown : setup.getRound().getPlayerToFollow().getFrontCards()) {
            enemyFrontCards.add(new JLabel(toBeShown.toString()));
        }

        Container enemyInfoContainer = new Container();
        enemyInfoContainer.setLayout(new GridLayout(20, 1));

        enemyInfoContainer.add(new JLabel("Enemy: " + setup.getRound().getPlayerToFollow().getAvatar().toString()));
        enemyInfoContainer.add(new JLabel(setup.getRound().getPlayerToFollow().getAvatar().getSpeciality()));
        enemyInfoContainer.add(new JLabel(" "));

        enemyInfoContainer.add(new JLabel("Enemy health: " + setup.getRound().getPlayerToFollow().getCurrentHealth()));
        enemyInfoContainer.add(new JLabel(" "));

        enemyInfoContainer.add(new JLabel("Enemy has " + setup.getRound().getPlayerToFollow().getHandCards().size() + " hand cards"));
        enemyInfoContainer.add(new JLabel(" "));

        enemyInfoContainer.add(enemyFrontCards);

        container.add(enemyInfoContainer);

        Container playerFrontCards = new Container();
        playerFrontCards.setLayout(new BoxLayout(playerFrontCards, BoxLayout.Y_AXIS));

        playerFrontCards.add(new JLabel("Your front cards:"));

        for (Card toBeShown : setup.getRound().getPlayerInTurn().getFrontCards()) {
            playerFrontCards.add(new JLabel(toBeShown.toString()));
        }

        Container playerInfoContainer = new Container();
        playerInfoContainer.setLayout(new BoxLayout(playerInfoContainer, BoxLayout.Y_AXIS));

        playerInfoContainer.add(new JLabel("You: " + setup.getRound().getPlayerInTurn().getAvatar().toString()));
        playerInfoContainer.add(new JLabel(setup.getRound().getPlayerInTurn().getAvatar().getSpeciality()));
        playerInfoContainer.add(new JLabel(" "));

        playerInfoContainer.add(new JLabel("Your health: " + setup.getRound().getPlayerInTurn().getCurrentHealth()));
        playerInfoContainer.add(new JLabel(" "));

        playerInfoContainer.add(playerFrontCards);

        container.add(playerInfoContainer);

        Container handCardsMenu = new Container();
        handCardsMenu.setLayout(new BoxLayout(handCardsMenu, BoxLayout.Y_AXIS));

        handCardsMenu.add(new JLabel("Your hand cards:"));

        ButtonGroup playerHandCards = new ButtonGroup();
        cardList.clear();

        for (int i = 0; i < setup.getRound().getPlayerInTurn().getHandCards().size(); i++) {

            JRadioButton toBeAdded = new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(i).toString());
            cardList.add(toBeAdded);
        }

        for (JRadioButton toBeAdded : cardList) {

            playerHandCards.add(toBeAdded);
            JLabel buttonContainer = new JLabel();
            buttonContainer.add(toBeAdded);
            handCardsMenu.add(toBeAdded);
        }

        JButton useCard = new JButton("Use card");
        useCard.addActionListener(playerXScreen_UseCard);
        handCardsMenu.add(useCard);

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Sid Ketchum") && setup.getRound().getPlayerInTurn().getHandCards().size() > 1) {

            JButton healthForSidKetchum = new JButton("Regain health");
            healthForSidKetchum.addActionListener(toSidKetchumCardDiscard);
            handCardsMenu.add(healthForSidKetchum);
        }

        JButton endTurn = new JButton("End turn");
        endTurn.addActionListener(playerXScreen_EndTurn);
        handCardsMenu.add(endTurn);

        container.add(handCardsMenu, BorderLayout.EAST);
    }

    /**
     *
     * Asettaa nakyman, joka kertoo vastustajan olevan kantaman ulkopuolella.
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
     * Asettaa nakyman, joka kertoo ettei BANG!-kortteja voi pelata enaa talla
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
     * Asettaa nakyman, joka kertoo reagoijalle ettei han voi reagoida mutta
     * salaa sen hyokkaajalta.
     */
    public void clickToPretendYouCouldReply() {

        container.setLayout(new GridLayout(3, 3));

        JLabel youDoNotHaveEnoughReplyCards = new JLabel("You don't have cards to reply with and will lose health!", JLabel.CENTER);
        youDoNotHaveEnoughReplyCards.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(youDoNotHaveEnoughReplyCards);

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().gameIsOver()) {

            JLabel youDied = new JLabel("You run out of health points!", JLabel.CENTER);
            youDied.setFont(new Font("Bang", Font.BOLD, 48));

            container.add(youDied);
            next.addActionListener(toGameOverScreen);

        } else {
            JLabel clickToDistract = new JLabel("Click so it looks like you could have replied!", JLabel.CENTER);
            clickToDistract.setFont(new Font("Bang", Font.BOLD, 48));

            if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("El Gringo")) {
                if (setup.getRound().getPlayerInTurn().getHandCards().isEmpty()) {
                    next.addActionListener(toRandomHandCardCannotBeTaken);
                } else {
                    next.addActionListener(toRandomHandCardWasStolenByElGringo);
                }
            } else {
                next.addActionListener(pleaseLookAwayToPlayerXScreen);
            }
            container.add(clickToDistract);
        }
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka kertoo vuorossa olevalle pelaajalle, ettei han voi
     * reagoida Duelloon mutta salaa sen hyokkaajalta.
     */
    public void playerInTurnclickToPretendYouCouldReplyToDuello() {

        container.setLayout(new GridLayout(3, 3));

        JLabel youHaveNoReplyCard = new JLabel("You have no BANG! to reply with and lost the Duello!", JLabel.CENTER);
        youHaveNoReplyCard.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel clickToDistract = new JLabel("Click so it looks like you could have replied!", JLabel.CENTER);
        clickToDistract.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(youHaveNoReplyCard);
        container.add(clickToDistract);
        container.add(next);
    }

    /**
     *
     * Asettaa vaistokortin kayton valintaikkunan.
     */
    public void doYouWannaPlayMancato() {

        container.setLayout(new GridLayout(4, 3));

        if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {

            if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer") && setup.getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0) {
                JLabel willYouUseTwoCards = new JLabel("Will you use two BANG! / Mancato! -cards to cancel a hit?", JLabel.CENTER);
                willYouUseTwoCards.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(willYouUseTwoCards);

            } else {
                JLabel willYouUseACard = new JLabel("Will you use a BANG! / Mancato! to cancel a hit?", JLabel.CENTER);
                willYouUseACard.setFont(new Font("Bang", Font.BOLD, 48));
                container.add(willYouUseACard);
            }

        } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Slab The Killer") && setup.getRound().getCheckerForAvatarSpeciality().howManyMissesHaveBeenUsedAgainstSlabTheKiller() == 0) {
            JLabel willYouUseTwoMancatos = new JLabel("Will you use two Mancato!-cards to cancel a hit?", JLabel.CENTER);
            willYouUseTwoMancatos.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseTwoMancatos);

        } else {
            JLabel willYouUseAMancato = new JLabel("Will you use a Mancato! to cancel a hit?", JLabel.CENTER);
            willYouUseAMancato.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseAMancato);
        }
        JButton useMancato = new JButton("Yes");
        useMancato.setFont(new Font("Button", Font.ITALIC, 34));
        useMancato.addActionListener(doYouWannaRespond_Yes);

        JButton doNotUseMancato = new JButton("No");
        doNotUseMancato.setFont(new Font("Button", Font.ITALIC, 34));
        doNotUseMancato.addActionListener(doYouWannaRespond_No);

        container.add(useMancato);
        container.add(doNotUseMancato);
    }

    /**
     *
     * Asettaa BANG!-kortilla reagoimisen valintaikkunan.
     */
    public void doYouWannaReplyWithBang() {

        container.setLayout(new GridLayout(4, 3));

        if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {
            JLabel willYouUseACard = new JLabel("Will you use a BANG! / Mancato! to cancel a hit?", JLabel.CENTER);
            willYouUseACard.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseACard);
        } else {
            JLabel willYouUseABang = new JLabel("Will you use a BANG! to cancel a hit?", JLabel.CENTER);
            willYouUseABang.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseABang);
        }
        JButton useBang = new JButton("Yes");
        useBang.setFont(new Font("Button", Font.ITALIC, 34));
        useBang.addActionListener(doYouWannaRespond_Yes);

        JButton doNotUseBang = new JButton("No");
        doNotUseBang.setFont(new Font("Button", Font.ITALIC, 34));
        doNotUseBang.addActionListener(doYouWannaRespond_No);

        container.add(useBang);
        container.add(doNotUseBang);
    }

    /**
     *
     * Asettaa seuraavana vuorossa olevan pelaajan Duello-korttiin
     * reagointinakyman.
     */
    public void playerToFollowRepliesToDuello() {

        container.setLayout(new GridLayout(5, 3));

        if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("Calamity Janet")) {
            JLabel willYouUseACard = new JLabel("Will you use a BANG! or a Mancato! to reply to Duello?");
            willYouUseACard.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseACard);

        } else {
            JLabel willYouUseABang = new JLabel("Will you use a BANG! to cancel a hit?", JLabel.CENTER);
            willYouUseABang.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseABang);
        }
        JLabel enemyHandCards = new JLabel("Enemy has " + setup.getRound().getPlayerInTurn().getHandCards().size() + " hand cards", JLabel.CENTER);
        enemyHandCards.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(enemyHandCards);

        JButton useBang = new JButton("Yes");
        useBang.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getHandCards().isEmpty()) {
            useBang.addActionListener(playerInTurnLostHisOwnDuelloAndAllHisHandCards);
        } else {
            useBang.addActionListener(duelloToOtherPlayer);
        }

        JButton doNotUseBang = new JButton("No");
        doNotUseBang.setFont(new Font("Button", Font.ITALIC, 34));
        doNotUseBang.addActionListener(doYouWannaRespond_No);

        container.add(useBang);
        container.add(doNotUseBang);
    }

    /**
     *
     * Asettaa seuraavana vuorossa olevan pelaajan Duello-korttiin
     * reagointinakyman.
     */
    public void playerInTurnRepliesToDuello() {

        container.setLayout(new GridLayout(5, 3));

        if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Calamity Janet")) {
            JLabel willYouUseACard = new JLabel("Will you use a BANG! or a Mancato! to reply to Duello?");
            willYouUseACard.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseACard);

        } else {
            JLabel willYouUseABang = new JLabel("Will you use a BANG! to cancel a hit?", JLabel.CENTER);
            willYouUseABang.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(willYouUseABang);
        }
        JLabel enemyHandCards = new JLabel("Enemy has " + setup.getRound().getPlayerToFollow().getHandCards().size() + " hand cards", JLabel.CENTER);
        enemyHandCards.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(enemyHandCards);

        JButton useBang = new JButton("Yes");
        useBang.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerToFollow().getHandCards().isEmpty()) {
            useBang.addActionListener(playerToFollowLostDuelloAndAllHisHandCards);
        } else {
            useBang.addActionListener(duelloToOtherPlayer);
        }

        JButton doNotUseBang = new JButton("No");
        doNotUseBang.setFont(new Font("Button", Font.ITALIC, 34));
        doNotUseBang.addActionListener(playerInTurnWillNotReplyToDuello);

        container.add(useBang);
        container.add(doNotUseBang);
    }

    /**
     *
     * Asettaa nakyman, joka kehottaa Duelloon asken reagoinutta pelaajaa
     * katsomaan pois.
     */
    public void duelloToOtherPlayerScreen() {

        container.setLayout(new GridLayout(2, 3));

        JLabel pleaseLookAway;
        if (setup.getRound().playerInTurnIsNextToReactToDuello()) {
            pleaseLookAway = new JLabel("Please look away, " + setup.getRound().getPlayerInTurn().getAvatar().toString() + " replies to Duello", JLabel.CENTER);
        } else {
            pleaseLookAway = new JLabel("Please look away, " + setup.getRound().getPlayerToFollow().getAvatar().toString() + " replies to Duello", JLabel.CENTER);
        }
        pleaseLookAway.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(pleaseLookAway);

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().playerInTurnIsNextToReactToDuello()) {
            if (setup.getRound().getCheckerForPlayedCard().playerHasBangOrMancato(setup.getRound().getPlayerInTurn(), "BANG!")) {
                next.addActionListener(duelloChoiceForPlayerInTurn);

            } else {
                next.addActionListener(toDuelloDistractionOfPlayerInTurn);
            }
        } else {
            if (setup.getRound().getCheckerForPlayedCard().playerHasBangOrMancato(setup.getRound().getPlayerToFollow(), "BANG!")) {
                next.addActionListener(duelloChoiceForPlayerToFollow);

            } else {
                next.addActionListener(distractionReply);
            }
        }
        container.add(next);
    }

    /**
     *
     * Asettaa akyman, joka kertoo, etta vuorossa oleva pelaaja havisi Duellon,
     * koska hanella ei ole korttia, jolla vastata.
     */
    public void playerInTurnCannotReplyToDuello() {

        container.setLayout(new GridLayout(3, 3));

        JLabel youHaveNoBang = new JLabel("You have no BANG!-card to reply with and will lose health!", JLabel.CENTER);
        youHaveNoBang.setFont(new Font("Bang", Font.BOLD, 48));

        JLabel clickToDistract = new JLabel("Click so it looks like you could have replied!", JLabel.CENTER);
        clickToDistract.setFont(new Font("Bang", Font.BOLD, 48));

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(continueToPlayerXScreen);

        container.add(youHaveNoBang);
        container.add(clickToDistract);
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka kertoo vuorossa olevan pelaajan havinneen kaiken
     * Duellossa ja kumpi jatkaa pelia.
     */
    public void playerInTurnLostEverythingInDuello() {

        container.setLayout(new GridLayout(3, 3));

        JLabel enemyLostEverything = new JLabel(setup.getRound().getPlayerInTurn().getAvatar().toString() + " has no hand cards and lost Duello!", JLabel.CENTER);
        enemyLostEverything.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(enemyLostEverything);

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().gameIsOver()) {
            next.addActionListener(toGameOverScreen);

        } else if (setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Bart Cassidy") || setup.getRound().getPlayerInTurn().getAvatar().toString().equals("Suzy Lafayette")) {

            JLabel enemyContinues = new JLabel("Enemy gets one card and may continue", JLabel.CENTER);
            enemyContinues.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(enemyContinues);

            next.addActionListener(pleaseLookAwayToPlayerXScreen);


        } else {
            JLabel youContinue = new JLabel("Your turn starts now!", JLabel.CENTER);
            youContinue.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(youContinue);

            next.addActionListener(continueToNewRound);
        }
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka kertoo vuorossa seuraavna olevan pelaajan havinneen
     * kaiken Duellossa.
     */
    public void playerToFollowLostEverythingInDuello() {

        container.setLayout(new GridLayout(3, 3));

        JLabel enemyLostEverything = new JLabel(setup.getRound().getPlayerToFollow().getAvatar().toString() + " has no hand cards and lost Duello!", JLabel.CENTER);
        enemyLostEverything.setFont(new Font("Bang", Font.BOLD, 48));
        container.add(enemyLostEverything);

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().gameIsOver()) {
            next.addActionListener(toGameOverScreen);

        } else if (!setup.getRound().getPlayerInTurn().getHandCards().isEmpty()) {
            JLabel youContinue = new JLabel("You may continue your turn", JLabel.CENTER);
            youContinue.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(youContinue);
            next.addActionListener(continueToPlayerXScreen);

        } else {
            JLabel youHaveNoMoreHandCards = new JLabel("You have no more cards, your turn ended", JLabel.CENTER);
            youHaveNoMoreHandCards.setFont(new Font("Bang", Font.BOLD, 48));
            container.add(youHaveNoMoreHandCards);
            next.addActionListener(playerXScreen_EndTurn);
        }
        container.add(next);
    }

    /**
     *
     * Asettaa nakyman, joka kertoo ettei vastustaja voi reagoida, koska hanella
     * ei ole kasikortteja.
     */
    public void takingDamageAndNoHandCards() {

        container.setLayout(new GridLayout(3, 3));
        JLabel enemyHasNoHandCards;

        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));

        if (setup.getRound().getPlayerInTurn().getHandCards().size() == 1) {
            enemyHasNoHandCards = new JLabel("The other player only has one hand card,", JLabel.CENTER);
            enemyHasNoHandCards.setFont(new Font("Bang", Font.BOLD, 48));

        } else {
            enemyHasNoHandCards = new JLabel("The other player has no hand cards,", JLabel.CENTER);
            enemyHasNoHandCards.setFont(new Font("Bang", Font.BOLD, 48));
        }
        JLabel enemyCannotReply = new JLabel("the damage cannot be avoided!", JLabel.CENTER);
        enemyCannotReply.setFont(new Font("Bang", Font.BOLD, 48));

        if (setup.getRound().gameIsOver()) {
            next.addActionListener(toGameOverScreen);

        } else if (setup.getRound().getPlayerToFollow().getAvatar().toString().equals("El Gringo")) {
            next.addActionListener(toRandomHandCardWasStolen);

        } else {
            next.addActionListener(continueToPlayerXScreen);
        }
        container.add(enemyHasNoHandCards);
        container.add(enemyCannotReply);
        container.add(next);
    }

    /**
     *
     * Asettaa korttien poiston valintanakyman.
     */
    public void discardCards() {

        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);

        frame.add(new JLabel("You may only hold in your hand as many cards as you have health left"));

        if (setup.getRound().getPlayerInTurn().getHandCards().size() == setup.getRound().getPlayerInTurn().getCurrentHealth() + 1) {
            frame.add(new JLabel("You must discard 1 card"));

        } else {
            frame.add(new JLabel("You must discard " + (setup.getRound().getPlayerInTurn().getHandCards().size() - setup.getRound().getPlayerInTurn().getCurrentHealth()) + " cards"));
        }
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

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(cancelCardDiscard);
        container.add(cancel);
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
     * ja -2 jos listan viimeinen (sattumanvarainen kasikortti) on valittu.
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
