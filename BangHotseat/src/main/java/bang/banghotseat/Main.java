package bang.banghotseat;

import bang.banghotseat.userInterface.UserInterface;
import javax.swing.SwingUtilities;

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