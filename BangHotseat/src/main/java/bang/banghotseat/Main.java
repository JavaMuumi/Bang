package bang.banghotseat;

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