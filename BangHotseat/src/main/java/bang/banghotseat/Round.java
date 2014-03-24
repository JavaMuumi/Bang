/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Card;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.CheckerForEventsBeforeTurn;
import bang.banghotseat.essentials.Player;
import java.util.Scanner;

/**
 *
 * @author Antti Korpi
 */
public class Round {
    
    private Scanner asker;
    private Player playerInTurn;
    private Player playerToFollow;
    private Deck drawpile;
    private Deck discardpile;
    private CheckerForEventsBeforeTurn checker;
    private Player statsDepository = new Player();
    private boolean goOn = false;
    
    public Round(Player player1, Player player2, Deck drawpile, Deck discardpile, Scanner asker) {
        
        this.asker = asker;
        playerInTurn = player1;
        playerToFollow = player2;
        this.drawpile = drawpile;
        this.discardpile = discardpile;
        checker = new CheckerForEventsBeforeTurn(drawpile, discardpile);
    }
    
    public void playTheGame() {
        
//        while (playerInTurn.getCurrentHealth() > 0 && playerToFollow.getCurrentHealth() > 0) {
//        
//        System.out.println(playerInTurn.getAvatar().toString() + ", you're up!");
//        System.out.println("");
//        
//            checker.setPlayerTurns(playerInTurn, playerToFollow);
//            checker.checkDinamite();
//            checker.checkPrigione();
//            
//            playerInTurn.getAvatar().drawCards(drawpile, discardpile, playerInTurn, playerToFollow);
//            
//            while (goOn == false) {
//                
//                System.out.println("Your health is " + playerInTurn.getCurrentHealth());
//                System.out.println("This is your hand:");
//                checker.showHand(playerInTurn);
//                
//                if (playerInTurn.getFrontCards().isEmpty()) {
//                    System.out.println("You have no frontcards");
//                }
//                else {
//                    System.out.println("These are your frontcards");
//                    checker.showFront(playerInTurn);
//                }
//                System.out.println("");
//                System.out.println("Wich card do you play? Please answer only the number of the card");
//                System.out.println("If you are done, answer 0 (zero)");
//                System.out.println("");
//                
//                int numberOfCard = Integer.parseInt(asker.nextLine()) - 1;
//                System.out.println("");
//                
//                if (numberOfCard == -1) {
//                    goOn = true;
//                }
//                else if (numberOfCard > playerInTurn.getHandCards().size() - 1 || numberOfCard < 0) {
//                    System.out.println("You have no such card");
//                    System.out.println("");
//                }
//                else if (playerInTurn.getHandCards().get(numberOfCard).toString().contains("BANG!")) {
//                    playingBang(numberOfCard);
//                }
//                else if (playerInTurn.getHandCards().get(numberOfCard).toString().contains("Mancato!")) {
//                    tryingToPlayMancatoOnOnesOwnTurn();
//                }
//                else if (playerInTurn.getHandCards().get(numberOfCard).toString().contains("Cat Balou")) {
//                    playingCatBalou(numberOfCard);
//                }
//                else {
//                    playCard(numberOfCard);
//                }
//            }
//            goOn = false;
//            
//            while (playerInTurn.getHandCards().size() > playerInTurn.getCurrentHealth()) {
//                
//                int numberToDiscard = playerInTurn.getHandCards().size() - playerInTurn.getCurrentHealth();
//                System.out.println("You have too many cards in your hand");
//                System.out.println("You must discard " + numberToDiscard + " card(s)");
//                System.out.println("");
//                
//                System.out.println("This is your hand:");
//                checker.showHand(playerInTurn);
//                System.out.println("");
//                
//                System.out.println("Choose one card to discard, give only the number of the card");
//                System.out.println("");
//                
//                int numberOfCard = Integer.parseInt(asker.nextLine());
//                System.out.println("");
//                
//                if (numberOfCard >= 1 || numberOfCard <= playerInTurn.getHandCards().size()) {
//                    discardpile.place(playerInTurn.drawSpecificHandCard(numberOfCard-1));
//                }
//                else {
//                    System.out.println("You have no such card");
//                    System.out.println("");
//                }
//            }
//            System.out.println("You have " + playerInTurn.getHandCards().size() + " cards in your hand");
//            System.out.println("");
//            
//            statsDepository = playerInTurn;
//            playerInTurn = playerToFollow;
//            playerToFollow = statsDepository;
//        }
    }
    
    public void playingBang(int numberOfCard) {
        if (playerToFollow.getDistance() > playerInTurn.getReach()) {
            System.out.println("The other player is out of reach, you cannot play a BANG!");
            System.out.println("");
        }
        else {
            playCard(numberOfCard);
        }
    }
    
    public void tryingToPlayMancatoOnOnesOwnTurn() {
        System.out.println("You cannot use a Mancato! on your own turn");
        System.out.println("");
    }
    
    public void playingCatBalou(int numberOfCard) {
        
        System.out.println(checker.checkEnemyHand(playerToFollow));
        System.out.println("");
        System.out.println(checker.checkEnemyFront(playerToFollow));
        System.out.println("");
        
            System.out.println("Are you sure you wanna use a Cat Balou? Please answer y or n");
            System.out.println("");
            
            String useCat = asker.nextLine();
            
            if (useCat.equals("y")) {
                playCard(numberOfCard);
            }
            else if (useCat.equals("n")) {
                System.out.println("Fine, then  what do you do?");
                System.out.println("");
                }
            else {
                System.out.println("Sorry, I cannot understand you");
                System.out.println("");
            }
    }
    
    public void playCard(int numberOfCard) {
        
        if (playerInTurn.getHandCards().get(numberOfCard).getType().equals("Orange")) {
                    playerInTurn.getHandCards().get(numberOfCard).function(playerInTurn, playerToFollow, drawpile, discardpile, asker);
                    discardpile.place(playerInTurn.drawSpecificHandCard(numberOfCard));
                }
        else if (playerInTurn.getHandCards().get(numberOfCard).getType().equals("Blue")) {
//            
//            if (playerInTurn.getFrontCards().isEmpty()) {
                playerInTurn.getFrontCards().add(playerInTurn.drawSpecificHandCard(numberOfCard));
//            }
//            else {
//                for (Card isTheSameCardAlreadyInFront : playerInTurn.getFrontCards()) {
//                    if (isTheSameCardAlreadyInFront.getName().equals(playerInTurn.getHandCards().get(numberOfCard).getName())) {
//                        discardpile.place(playerInTurn.drawSpecificFrontCard(playerInTurn.getFrontCards().indexOf(isTheSameCardAlreadyInFront)));
//                        playerInTurn.getFrontCards().remove(playerInTurn.getFrontCards().indexOf(isTheSameCardAlreadyInFront));
//                        playerInTurn.drawSpecificHandCard(numberOfCard);
//                    }
//                    else {
//                        playerInTurn.getFrontCards().add(playerInTurn.drawSpecificHandCard(numberOfCard));
//                    }
//                }
//            }
        }
        else if (playerInTurn.getHandCards().get(numberOfCard).getType().equals("Gun")) {
//            
//            for (Card isAGun : playerInTurn.getFrontCards()) {
//                if (isAGun.getType().equals("Gun")) {
//                    discardpile.place(isAGun);
//                    playerInTurn.getFrontCards().remove(playerInTurn.getFrontCards().indexOf(isAGun));
//                }
//            }
            playerInTurn.putCardInFront(playerInTurn.drawSpecificHandCard(numberOfCard));
        }
    }
    
    public Player getPlayerInTurn() {
        return playerInTurn;
    }
    
    public Player getPlayerToFollow() {
        return playerToFollow;
    }
    
    public CheckerForEventsBeforeTurn getChecker() {
        return checker;
    }
}