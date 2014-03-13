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
        
        System.out.println("What would you like to do?");
        System.out.println("");
        
        System.out.println("Please type:");
        System.out.println("n for new game");
        System.out.println("r for rules");
        System.out.println("x to quit");
        
        String command = asker.nextLine();
        
        if(command.equals("n")) {
            
        }
    }
}