/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bang.banghotseat.userInterface;

import bang.banghotseat.Setup;
import java.util.Scanner;

/**
 *
 * @author Antti Korpi
 */
public class TextInterface {
    
    private Setup setup;
    private Scanner asker = new Scanner(System.in);
    
    public void go(Setup setup) {
        
        this.setup = setup;
        
        System.out.println("Welcome to Bang!");
        System.out.println("");
        
        while(true) {
        
        System.out.println("What would you like to do?");
        System.out.println("");
        
        System.out.println("Please type:");
        System.out.println("n for new game");
        System.out.println("r for rules");
        System.out.println("x to quit");
        System.out.println("");
        
        String command = asker.nextLine();
        System.out.println("");
        
        if(command.equals("n")) {
            System.out.println("A new game it is!");
            System.out.println("");
            setup.runSetup(asker);
            break;
        }
        else if (command.equals("r")) {
            System.out.println("Here are the rules!");
            System.out.println("");
        }
        else if (command.equals("x")) {
            System.out.println("Bye, bye!");
            break;
        }
        else {
            System.out.println("Sorry, I cannot understand you");
            System.out.println("");
        }
        }
    }
}