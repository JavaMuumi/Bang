package bang.banghotseat;

import bang.banghotseat.avatars.LuckyDuke;
import bang.banghotseat.cards.Bang;
import bang.banghotseat.cards.Deck;
import bang.banghotseat.cards.Dinamite;
import bang.banghotseat.essentials.Player;
import javax.swing.SwingUtilities;
import userInterface.UserInterface;

/**
 *
 * @author Antti Korpi
 */
public class Main 
{
    /**
     *
     * @param args main-luokan pakollinen parametri
     */
    public static void main( String[] args )
    {    
        UserInterface userInterface = new UserInterface();
        SwingUtilities.invokeLater(userInterface);
    }
}