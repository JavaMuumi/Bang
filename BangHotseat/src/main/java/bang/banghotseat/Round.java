/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat;

import bang.banghotseat.cards.Card;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.essentials.Checker;
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
    private boolean goOn = false;
    
    public Round(Player player1, Player player2, Deck drawpile, Deck discardpile, Scanner asker) {
        
        this.asker = asker;
        playerInTurn = player1;
        playerToFollow = player2;
        Checker checker = new Checker(drawpile, discardpile);
        
        System.out.println(player1.getAvatar().getName() + ", you're up!");
        System.out.println("");
        
            checker.setPlayerTurns(playerInTurn, playerToFollow);
            checker.checkDinamite();
            checker.checkPrigione();
            
            playerInTurn.getAvatar().drawCards(drawpile, discardpile, playerInTurn, playerToFollow);
            
            while (goOn == false) {
            
            System.out.println("This is your hand:");
            checker.showHand(playerInTurn);
        
        if (playerInTurn.getFrontCards().isEmpty()) {
            System.out.println("You have no frontcards");
        }
        else {
        System.out.println("These are your frontcards");
        checker.showFront(playerInTurn);
        }
        System.out.println("");
        System.out.println("Wich card do you play? Please answer only the number of the card");
        System.out.println("If you are done, answer 0 (zero)");
        System.out.println("");

        try {
            int numberOfCard = Integer.parseInt(asker.nextLine());
            System.out.println("");
            
            if (numberOfCard == 0) {
                goOn = true;
            }
            else if (numberOfCard > playerInTurn.getHandCards().size() || numberOfCard < 0) {
                System.out.println("You have no such card");
                System.out.println("");
            }
            else if (playerInTurn.getHandCards().get(numberOfCard-1).toString().contains("Mancato!")) {
                    System.out.println("You cannot use a Mancato! on your own turn");
                    System.out.println("");
            }
            else if (playerInTurn.getHandCards().get(numberOfCard-1).toString().contains("Cat Balou")) {
                
                System.out.println(checker.checkEnemyHand(playerToFollow));
                System.out.println("");
                System.out.println(checker.checkEnemyFront(playerToFollow));
                playerToFollow.getFrontCards();
                System.out.println("");
                
                while (true) {
                    System.out.println("Are you sure you wanna use a Cat Balou? Please answer y or n");
                    System.out.println("");
                    
                    String useCat = asker.nextLine();
                    
                    if (useCat.equals("y")) {
                        playerInTurn.getHandCards().get(numberOfCard-1).function();
                        discardpile.place(playerInTurn.getHandCards().get(numberOfCard-1));
                        playerInTurn.getHandCards().remove(numberOfCard-1);
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
            }
            else {
                playerInTurn.getHandCards().get(numberOfCard-1).function();
                if (playerInTurn.getHandCards().get(numberOfCard-1).getType().equals("Brown")) {
                    drawpile.place(playerInTurn.drawSpecificHandCard(numberOfCard-1));
                }
                else if (playerInTurn.getHandCards().get(numberOfCard-1).getType().equals("Blue")) {
                    playerInTurn.getFrontCards().add(playerInTurn.drawSpecificHandCard(numberOfCard-1));
                }
                else if (playerInTurn.getHandCards().get(numberOfCard-1).getType().equals("Gun")) {
                    
                    for (Card isAGun : playerInTurn.getFrontCards()) {
                        if (isAGun.getType().equals("Gun")) {
                            discardpile.place(isAGun);
                            playerInTurn.getFrontCards().remove(playerInTurn.getFrontCards().indexOf(isAGun));
                        }
                    }
                    playerInTurn.putCardInFront(playerInTurn.drawSpecificHandCard(numberOfCard-1));
                }
                else {
                    playerToFollow.putCardInFront(playerInTurn.getHandCards().get(numberOfCard-1));
                    playerInTurn.getHandCards().remove(numberOfCard-1);
                }
            }
        }
        catch (Exception e) {
            System.out.println("I'm sorry, I cannot understand you");
            System.out.println("");
        }
        }
        goOn = false;
        
        while (playerInTurn.getHandCards().size() > playerInTurn.getCurrentHealth()) {
            
            int numberToDiscard = playerInTurn.getHandCards().size() - playerInTurn.getCurrentHealth();
            System.out.println("You have too many cards in your hand");
            System.out.println("You must discard " + numberToDiscard + " card(s)");
            System.out.println("");
            
            System.out.println("This is your hand:");
            checker.showHand(playerInTurn);
            System.out.println("");
            
            System.out.println("Choose one card to discard, give only the number of the card");
            System.out.println("");
            
            try {
            int numberOfCard = Integer.parseInt(asker.nextLine());
                System.out.println("");
                discardpile.place(playerInTurn.drawSpecificHandCard(numberOfCard-1));
                }
        catch (Exception e) {
            System.out.println("You have no such card");
            System.out.println("");
        }
        System.out.println("You have " + playerInTurn.getHandCards().size() + " cards in your hand");
        System.out.println("");
        }
    }
}