/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.Setup;
import bang.banghotseat.cards.Card;
import bang.banghotseat.essentials.Player;
import bang.banghotseat.userInterface.buttonListeners.DiscardCards_Discard;
import bang.banghotseat.userInterface.buttonListeners.Exit_BackToMainMenu;
import bang.banghotseat.userInterface.buttonListeners.Exit_ReallyExit;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_Exit;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_NewGame;
import bang.banghotseat.userInterface.buttonListeners.MainMenu_Rules;
import bang.banghotseat.userInterface.buttonListeners.NewGame_Continue;
import bang.banghotseat.userInterface.buttonListeners.PlayerXScreen_UseCard;
import bang.banghotseat.userInterface.buttonListeners.PlayerXLookAwayToPlayerYTurn;
import bang.banghotseat.userInterface.buttonListeners.PlayerXScreen_EndTurn;
import bang.banghotseat.userInterface.buttonListeners.Rules_BackToMainMenu;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Antti Korpi
 */
public class VisibleScreen {
    
    private List<JRadioButton> handCards;
    private JFrame frame;
    private Container container;
    private Setup setup;
    private ActionListener mainMenu_NewGame;
    private ActionListener mainMenu_Rules;
    private ActionListener mainMenu_Exit;
    private ActionListener rules_BackToMainMenu;
    private ActionListener exit_BackToMainMenu;
    private ActionListener exit_ReallyExit;
    private ActionListener newGame_Continue;
    private ActionListener playerXLookAwayToPlayerYTurn;
    private ActionListener playerXScreen_UseCard;
    private ActionListener playerXScreen_EndTurn;
    private ActionListener discardCards_Discard;
    
    public VisibleScreen(JFrame frame, Setup setup) {
        
        this.frame = frame;
        container = frame.getContentPane();
        this.setup = setup;
        
        mainMenu_NewGame = new MainMenu_NewGame(this);
        mainMenu_Rules = new MainMenu_Rules(this);
        mainMenu_Exit = new MainMenu_Exit(this);
        rules_BackToMainMenu = new Rules_BackToMainMenu(this);
        exit_BackToMainMenu = new Exit_BackToMainMenu(this);
        exit_ReallyExit = new Exit_ReallyExit(this);
        newGame_Continue = new NewGame_Continue(this);
        playerXLookAwayToPlayerYTurn = new PlayerXLookAwayToPlayerYTurn(this);
        playerXScreen_UseCard = new PlayerXScreen_UseCard(this);
        playerXScreen_EndTurn = new PlayerXScreen_EndTurn(this);
        discardCards_Discard = new DiscardCards_Discard(this);
    }
    
    public void MainMenu() {
        
      GridLayout layout = new GridLayout(4,3);
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
    
    public void rules() {
        
        JLabel rules = new JLabel("Rules: KILL THE OTHER PLAYER!", JLabel.CENTER);
        rules.setFont(new Font("Rules", Font.BOLD, 48));
        
        JButton backToMainMenu = new JButton("Back to Main Menu");
        backToMainMenu.setFont(new Font("Button", Font.ITALIC, 34));
        backToMainMenu.addActionListener(rules_BackToMainMenu);
        
        container.add(rules);
        container.add(backToMainMenu);
    }
    
    public void exit() {
        
        JLabel exit = new JLabel("You really wanna exit BANG!?", JLabel.CENTER);
        exit.setFont(new Font("Bang", Font.BOLD, 48));
        
        JButton reallyExit = new JButton("Yes");
        reallyExit.setFont(new Font("Button", Font.ITALIC, 34));
        reallyExit.addActionListener(exit_ReallyExit);
      
        JButton backToMainMenu = new JButton("No");
        backToMainMenu.setFont(new Font("Button", Font.ITALIC, 34));
        backToMainMenu.addActionListener(exit_BackToMainMenu);
        
        container.add(exit);
        container.add(reallyExit);
        container.add(backToMainMenu);
    }
    
    public void newGameInfo() {
        
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
        next.addActionListener(newGame_Continue);
        
        container.add(player1Avatar);
        container.add(player1Speciality);
        container.add(player2Avatar);
        container.add(player2Speciality);
        container.add(next);
        }
    
    public void playerXPleaseLookAwayScreen(Player playerWhoShouldLookAway) {
        
        container.setLayout(new GridLayout(3,3));
        
        JLabel playerXPleaseLookAway = new JLabel(playerWhoShouldLookAway.getAvatar().toString() + ", please look away now", JLabel.CENTER);
        playerXPleaseLookAway.setFont(new Font("Bang", Font.BOLD, 48));
        
        JButton next = new JButton("Continue");
        next.setFont(new Font("Button", Font.ITALIC, 34));
        next.addActionListener(playerXLookAwayToPlayerYTurn);
        
        frame.add(playerXPleaseLookAway);
        frame.add(next);
    }
    
    public void playerXScreen() {
        
        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);
        
        String enemyInfo = "<html>Enemy: " + setup.getRound().getPlayerToFollow().getAvatar().toString() +
                "<br>" + setup.getRound().getPlayerToFollow().getAvatar().getSpeciality() + 
                "<br>" +
                "<br>Enemy health: " + setup.getRound().getPlayerToFollow().getCurrentHealth() +
                "<br>" + "<br></html>";
        
        String enemyFrontCards = "<html><br>Enemy front cards:";
        for(Card toBeShown : setup.getRound().getPlayerToFollow().getFrontCards()) {
            enemyFrontCards = enemyFrontCards + "<br>" + toBeShown.toString();
        }
        enemyFrontCards = enemyFrontCards + "</html>";
        
        container.add(new JLabel(enemyInfo));
        container.add(new JLabel("Enemy has " + setup.getRound().getPlayerToFollow().getHandCards().size() + " hand cards"));
        container.add(new JLabel(enemyFrontCards));
        
        String playerInfo = "<html><br>You: " + setup.getRound().getPlayerInTurn().getAvatar().toString() +
                "<br>" + setup.getRound().getPlayerInTurn().getAvatar().getSpeciality() +
                "<br>" +
                "<br>Your health: " + setup.getRound().getPlayerInTurn().getCurrentHealth() +
                "<br>" + "<br></html>";
        
        container.add(new JLabel(playerInfo));
        
        String playerFrontCards = "<html>Your front cards:";
        for(Card toBeShown : setup.getRound().getPlayerInTurn().getFrontCards()) {
            playerFrontCards = playerFrontCards + "<br>" + toBeShown.toString();
        }
        playerFrontCards = playerFrontCards + "<br>" + "<br></html>";
        container.add(new JLabel(playerFrontCards));
        
        container.add(new JLabel("Your hand cards:"));
        
        ButtonGroup playerHandCards = new ButtonGroup();
        handCards = new ArrayList<>();
        
        for (int i = 0; i < setup.getRound().getPlayerInTurn().getHandCards().size(); i++) {
            handCards.add(new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(i).toString()));
        }
        for (JRadioButton toBeAdded : handCards) {
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
    
    public void discardCards() {
        
        BoxLayout yPlane = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(yPlane);
        
        frame.add(new JLabel("You may only hold in your hand as many cards as you have health left"));
        frame.add(new JLabel("Choose a card to discard"));
        
        handCards = new ArrayList<>();
        ButtonGroup cardsToBeDiscarded = new ButtonGroup();
        
        for (int i = 0; i < setup.getRound().getPlayerInTurn().getHandCards().size(); i++) {
            handCards.add(new JRadioButton(setup.getRound().getPlayerInTurn().getHandCards().get(i).toString()));
        }
        for (JRadioButton toBeDiscarded : handCards) {
            container.add(toBeDiscarded);
            cardsToBeDiscarded.add(toBeDiscarded);
        }
        JButton discardCards = new JButton("Discard");
        discardCards.addActionListener(discardCards_Discard);
        container.add(discardCards);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Setup getSetup() {
        return setup;
    }
    
    public int getIndex() {
        for (JRadioButton isThisSelected : handCards) {
            if (isThisSelected.isSelected()) {
                return handCards.indexOf(isThisSelected);
            }
        }
        return -1;
    }
}